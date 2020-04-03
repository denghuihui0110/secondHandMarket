package com.dhh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhh.dao.FocusMapper;
import com.dhh.pojo.Focus;
import com.dhh.service.FocusService;

@Service("focusService")
public class FocusServiceImpl implements FocusService {
	
	@Resource
	private FocusMapper fo;

	public List<Focus> getFocusByUserId(Integer user_id) {
		List<Focus> focusList = fo.getFocusByUserId(user_id);
        return focusList;
	}

	public void deleteFocusByUserIdAndGoodsId(Integer goods_id, Integer user_id) {
		fo.deleteFocusByUserIdAndGoodsId(goods_id, user_id);
	}

	public void addFocusByUserIdAndId(Integer goods_id, Integer user_id) {
		fo.addFocusByUserIdAndGoodsId(goods_id,user_id);
	}

}
