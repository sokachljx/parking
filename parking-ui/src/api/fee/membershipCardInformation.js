import request from '@/utils/request'

// 查询会员卡信息列表
export function listInformation(query) {
  return request({
    url: '/fee/membershipCardInformation/list',
    method: 'get',
    params: query
  })
}

// 查询会员卡信息详细
export function getInformation(membershipCardInformationId) {
  return request({
    url: '/fee/membershipCardInformation/' + membershipCardInformationId,
    method: 'get'
  })
}

// 新增会员卡信息
export function addInformation(data) {
  return request({
    url: '/fee/membershipCardInformation',
    method: 'post',
    data: data
  })
}

// 修改会员卡信息
export function updateInformation(data) {
  return request({
    url: '/fee/membershipCardInformation',
    method: 'put',
    data: data
  })
}

// 删除会员卡信息
export function delInformation(membershipCardInformationId) {
  return request({
    url: '/fee/membershipCardInformation/' + membershipCardInformationId,
    method: 'delete'
  })
}
