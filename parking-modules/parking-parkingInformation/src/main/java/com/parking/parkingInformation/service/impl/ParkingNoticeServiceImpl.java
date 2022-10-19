package com.parking.parkingInformation.service.impl;

import com.parking.parkingInformation.entity.ParkingNotice;
import com.parking.parkingInformation.mapper.ParkingNoticeMapper;
import com.parking.parkingInformation.service.ParkingNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingNoticeServiceImpl implements ParkingNoticeService {

    @Autowired
    private ParkingNoticeMapper parkingNoticeMapper;
    @Override
    public ParkingNotice selectNoticeById(Long noticeId) {
        return parkingNoticeMapper.selectNoticeById(noticeId);
    }

    @Override
    public List<ParkingNotice> selectNoticeList(ParkingNotice notice) {
        return parkingNoticeMapper.selectNoticeList(notice);
    }

    @Override
    public int addNotice(ParkingNotice notice) {
        return parkingNoticeMapper.addNotice(notice);
    }

    @Override
    public int updateNotice(ParkingNotice notice) {
        return parkingNoticeMapper.updateNotice(notice);
    }

    @Override
    public int deleteNoticeById(Long noticeId) {
        return parkingNoticeMapper.deleteNoticeById(noticeId);
    }

    @Override
    public int deleteNoticeByIds(Long[] noticeIds) {
        return parkingNoticeMapper.deleteNoticeByIds(noticeIds);
    }

    
}
