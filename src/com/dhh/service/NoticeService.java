package com.dhh.service;

import java.util.List;

import com.dhh.pojo.Notice;

public interface NoticeService {

	List<Notice> getNoticeList();
	
	public void insertSelective(Notice notice);
	
}
