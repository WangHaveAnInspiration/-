import request from '@/utils/request'

// 查询奖品兑换信息表列表
export function listChild_prize(query) {
  return request({
    url: '/dream/child_prize/list',
    method: 'get',
    params: query
  })
}

// 查询奖品兑换信息表详细
export function getChild_prize(id) {
  return request({
    url: '/dream/child_prize/' + id,
    method: 'get'
  })
}

// 新增奖品兑换信息表
export function addChild_prize(data) {
  return request({
    url: '/dream/child_prize',
    method: 'post',
    data: data
  })
}

// 修改奖品兑换信息表
export function updateChild_prize(data) {
  return request({
    url: '/dream/child_prize',
    method: 'put',
    data: data
  })
}

// 删除奖品兑换信息表
export function delChild_prize(id) {
  return request({
    url: '/dream/child_prize/' + id,
    method: 'delete'
  })
}
