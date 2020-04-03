package com.dhh.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.dhh.dao.NoticeMapper;
import com.dhh.pojo.Notice;
import com.dhh.service.NoticeService;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Resource
	private NoticeMapper nt;

	@Override
	public List<Notice> getNoticeList() {
		return nt.getNoticeList();
	}

	@Override
	public void insertSelective(Notice notice) {
		nt.insertSelective(notice);
	}
	
}
