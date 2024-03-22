<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品介绍" prop="introduction">
        <el-input
          v-model="queryParams.introduction"
          placeholder="请输入商品介绍"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品类型" prop="type">
        <el-select v-model="queryParams.type" clearable placeholder="请选择商品类型">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-row>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="prizeList" @selection-change="handleSelectionChange">
      <el-table-column label="商品图片" align="center" prop="picture" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.picture" :width="100" :height="100"/>
        </template>
      </el-table-column>
      <el-table-column label="商品名称" align="center" prop="name" sortable/>
      <el-table-column label="商品类型" align="center" prop="type" />
      <el-table-column label="商品介绍" align="center" prop="introduction" />
      <el-table-column label="兑换积分" align="center" prop="point" sortable/>
      <el-table-column label="选择数量" align="center" label-width="50px">
        <template slot-scope="scope">
          <el-input-number size="small" :min="1" :max="10" v-model="scope.row.buyNumber" ></el-input-number>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-goods"
            @click="handleBuy(scope.row)"
            v-hasPermi="['dream:prize:buy']"
          >兑换</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改奖品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品图片" prop="picture">
          <image-upload v-model="form.picture"/>
        </el-form-item>
        <el-form-item label="商品介绍" prop="introduction">
          <el-input v-model="form.introduction" placeholder="请输入商品介绍" />
        </el-form-item>
        <el-form-item label="商品类型" prop="type">
          <el-input v-model="form.type" placeholder="请输入商品类型" />
        </el-form-item>
        <el-form-item label="商品名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="兑换积分" prop="point">
          <el-input v-model="form.point" placeholder="请输入兑换积分" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listPrize,
  getPrize,
  delPrize,
  addPrize,
  updatePrize,
  getChild,
} from "@/api/dream/prize";
import {updateChild} from "@/api/dream/child";
import {addChild_prize} from "@/api/dream/child_prize"

export default {
  name: "Prize",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 奖品表格数据
      prizeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        introduction: null,
        type: null,
        name: null,
        point: null,
        buyNumber: 1
      },

      child_prize:{
        id: null,
        childId: null,
        prizeId: null,
        buyNumber: null,
        time: null
      },

      childInfo:{
        id: null,
        name: null,
        introduction: null,
        address: null,
        totalPoint: null,
        leftPoint: null,
        age: null,
        grade: null,
        telephone: null,
        picture: null,
        top: null
      },

      points:{
        id:null,
        targetId:null,
        childId:null,
        type:null,
        number:null,
        time:null
      },

      options:[{
          value: '文具',
          label: '文具'
        },{
          value: '食品',
          label: '食品'
        },{
          value: '书籍',
          label: '书籍'
        },{
          value: '日用',
          label: '日用'
      }],

      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 获取当前时间 */
    getCurrentTime(){
    let now = new Date();
    let year = now.getFullYear();
    let month = now.getMonth();
    let day = now.getDate();
    return year + "-" + month + "-" + day;
    },

    /** 查询奖品列表 */
    getList() {
      this.loading = true;
      listPrize(this.queryParams).then(response => {
        this.prizeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        picture: null,
        introduction: null,
        type: null,
        name: null,
        point: null,
        buyNumber: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 多选框选中数据 */
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加奖品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPrize(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改奖品";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePrize(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPrize(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除奖品编号为"' + ids + '"的数据项？').then(function() {
        return delPrize(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },

    /** 商品兑换操作 */
    handleBuy(row){
      const buyNumber = row.buyNumber
      const cost_point = row.point * buyNumber
      getChild().then(response =>{
        this.childInfo = response.data
      })
      this.$modal.confirm('是否确认兑换奖品？').then(() => {

        if(this.childInfo.leftPoint < cost_point){
          /** 积分不够 */
          this.$modal.msgError("您的积分不够");
        }else {
          /** 积分足够，进行兑换 */
          /** 修改积分 */
          this.childInfo.leftPoint = this.childInfo.leftPoint - cost_point;
          /** 修改儿童数据 */
          updateChild(this.childInfo);
          /** 兑换信息写入儿童兑换奖品信息表中 */
          this.child_prize.childId = this.childInfo.id
          this.child_prize.prizeId = row.id
          this.child_prize.buyNumber = buyNumber
          this.child_prize.time = this.getCurrentTime();
          addChild_prize(this.child_prize);

          // /** 兑换信息写入积分明细表中 */
          // this.points.childId = this.childInfo.id
          // this.points.targetId = row.id
          // this.points.type = '奖品兑换'
          // this.points.number = cost_point
          // this.points.time = this.getCurrentTime();
          // addPoints(this.points);

          this.$modal.msgSuccess("兑换成功");
        }

      }).catch(() => {});

    },

    /** 导出按钮操作 */
    handleExport() {
      this.download('dream/prize/export', {
        ...this.queryParams
      }, `prize_${new Date().getTime()}.xlsx`)
    }


  }
};
</script>
