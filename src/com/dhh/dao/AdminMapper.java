package com.dhh.dao;

import com.dhh.pojo.Admin;

public interface AdminMapper {
	
	public Admin findAdmin(Long phone, String password);
	
	public Admin findAdminByName(String userName, String password);

	public Admin findAdminById(Integer id);

	public void updateAdmin(Admin admins);

}
