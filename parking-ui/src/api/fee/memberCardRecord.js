import request from '@/utils/request'

// 查询会员购买记录列表
export function listRecord(query) {
  return request({
    url: '/fee/record/list',
    method: 'get',
    params: query
  })
}

// 查询会员购买记录详细
export function getRecord(memberPurchaseRecordId) {
  return request({
    url: '/fee/record/' + memberPurchaseRecordId,
    method: 'get'
  })
}

// 新增会员购买记录
export function addRecord(data) {
  return request({
    url: '/fee/record',
    method: 'post',
    data: data
  })
}

// 修改会员购买记录
export function updateRecord(data) {
  return request({
    url: '/fee/record',
    method: 'put',
    data: data
  })
}

// 删除会员购买记录
export function delRecord(memberPurchaseRecordId) {
  return request({
    url: '/fee/record/' + memberPurchaseRecordId,
    method: 'delete'
  })
}
