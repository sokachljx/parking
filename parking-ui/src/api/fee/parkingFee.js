import request from '@/utils/request'

// 查询停车缴费列表
export function listFee(query) {
  return request({
    url: '/fee/parkingFee/list',
    method: 'get',
    params: query
  })
}

// 查询停车缴费详细
export function getFee(parkingFeeId) {
  return request({
    url: '/fee/parkingFee/' + parkingFeeId,
    method: 'get'
  })
}

// 新增停车缴费
export function addFee(data) {
  return request({
    url: '/fee/parkingFee',
    method: 'post',
    data: data
  })
}

// 修改停车缴费
export function updateFee(data) {
  return request({
    url: '/fee/parkingFee',
    method: 'put',
    data: data
  })
}

// 删除停车缴费
export function delFee(parkingFeeId) {
  return request({
    url: '/fee/parkingFee/' + parkingFeeId,
    method: 'delete'
  })
}
