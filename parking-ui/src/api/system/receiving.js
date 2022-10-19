import request from '@/utils/request'

// 查询样品列表
export function listReceiving(query) {
    return request({
        url: '/business/sample/list',
        method: 'get',
        params: query
    })
}

// 查询样品详细
export function getReceiving(srId) {
    return request({
        url: '/business/sample/' + srId,
        method: 'get'
    })
}

// 新增样品
export function addReceiving(data) {
    return request({
        url: '/business/sample',
        method: 'post',
        data: data
    })
}

// 修改样品
export function updateReceiving(data) {
    return request({
        url: '/business/sample',
        method: 'put',
        data: data
    })
}

// 删除样品
export function delReceiving(srId) {
    return request({
        url: '/business/sample/' + srId,
        method: 'delete'
    })
}
