import request from '@/utils/request'

// 查询车位列表
export function listInformation(query) {
    return request({
        url: '/parkingInformation/information/list',
        method: 'get',
        params: query
    })
}

// 查询车位信息详细
export function getInformation(parkingSpaceInformationId) {
  return request({
    url: '/parkingInformation/information/' + parkingSpaceInformationId,
    method: 'get'
  })
}


// 新增车位
export function addInformation(data) {
    return request({
        url: '/parkingInformation/information',
        method: 'post',
        data: data
    })
}

// 修改车位
export function updateInformation(data) {
    return request({
        url: '/parkingInformation/information',
        method: 'put',
        data: data
    })
}

// 删除车位
export function delInformation(srId) {
    return request({
        url: '/parkingInformation/information' + parkingSpaceInformationId,
        method: 'delete'
    })
}
