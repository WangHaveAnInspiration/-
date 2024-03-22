import request from '@/utils/request'

// 查询儿童列表
export function listChild(query) {
  return request({
    url: '/dream/child/list',
    method: 'get',
    params: query
  })
}

// 查询儿童详细
export function getChild(id) {
  return request({
    url: '/dream/child/' + id,
    method: 'get'
  })
}

// 新增儿童
export function addChild(data) {
  return request({
    url: '/dream/child',
    method: 'post',
    data: data
  })
}

// 修改儿童
export function updateChild(data) {
  return request({
    url: '/dream/child',
    method: 'put',
    data: data
  })
}

// 删除儿童
export function delChild(id) {
  return request({
    url: '/dream/child/' + id,
    method: 'delete'
  })
}
