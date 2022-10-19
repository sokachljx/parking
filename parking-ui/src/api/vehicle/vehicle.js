import request from '@/utils/request'

// 查询车辆信息列表
export function listInformation(query) {
  return request({
    url: '/vehicle/information/list',
    method: 'get',
    params: query
  })
}

// 查询车辆信息详细
export function getInformation(vehicleInformationId) {
  return request({
    url: '/vehicle/information/' + vehicleInformationId,
    method: 'get'
  })
}

// 新增车辆信息
export function addInformation(data) {
  return request({
    url: '/vehicle/information',
    method: 'post',
    data: data
  })
}

// 修改车辆信息
export function updateInformation(data) {
  return request({
    url: '/vehicle/information',
    method: 'put',
    data: data
  })
}

// 删除车辆信息
export function delInformation(vehicleInformationId) {
  return request({
    url: '/vehicle/information/' + vehicleInformationId,
    method: 'delete'
  })
}
