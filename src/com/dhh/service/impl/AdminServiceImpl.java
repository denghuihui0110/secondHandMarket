package com.dhh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhh.dao.AdminMapper;
import com.dhh.pojo.Admin;
import com.dhh.service.AdminService;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper am;

	@Override
	public Admin findAdmin(Long phone, String password) {
		return am.findAdmin(phone,password);
	}
	
	@Override
	public Admin findAdminById(Integer id) {
		return am.findAdminById(id);
	}

	@Override
	public void updateAdmin(Admin admins) {
		 am.updateAdmin(admins);
	}

	@Override
	public Admin findAdminByName(String userName, String password) {
		return am.findAdminByName(userName,password);
	}
	
}
