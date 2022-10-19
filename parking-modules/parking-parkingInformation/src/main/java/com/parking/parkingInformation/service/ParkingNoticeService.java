package com.parking.parkingInformation.service;


import com.parking.parkingInformation.entity.ParkingNotice;

import java.util.List;

/**
 * 公告 服务层
 *
 * @author ljx
 */
public interface ParkingNoticeService {
    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public ParkingNotice selectNoticeById(Long noticeId);
    /**
     * 查询公告信息列表
     *
     * @param notice 公告信息
     * @return 公告信息列表
     */
    public List<ParkingNotice> selectNoticeList(ParkingNotice notice);
    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    public int addNotice(ParkingNotice notice);
    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(ParkingNotice notice);
    /**
     * 删除公告
     *
     * @param noticeId 公告ID
     * @return 结果
     */
    public int deleteNoticeById(Long noticeId);
    /**
     * 批量删除公告
     *
     * @param noticeIds 公告ID
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] noticeIds);

}
