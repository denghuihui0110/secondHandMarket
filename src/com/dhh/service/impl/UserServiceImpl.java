package com.dhh.service.impl;

import com.dhh.dao.UserMapper;
import com.dhh.pojo.User;
import com.dhh.service.UserService;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
    }

    public User getUserByPhone(String phone) {
        User user  = userMapper.getUserByPhone(phone);
        return  user;
    }

    public void updateUserName(User  user) {
        userMapper.updateByPrimaryKey(user);
    }

    public int updateGoodsNum(Integer id,Integer goodsNum) {
        return userMapper.updateGoodsNum(id,goodsNum);
    }

    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public List<User> getPageUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);//分页核心代码
        List<User> list= userMapper.getUserList();
        return list;
    }

    public int getUserNum() {
        List<User> users = userMapper.getUserList();
        return users.size();
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

	public int getUserNum(String username) {
		return 0;
	}

	public InputStream getInputStream1SS() throws Exception {
		return null;
	}

	public List<User> getPageUser(int pageNum, int pageSize, String username) {
		return null;
	}

	@Override
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}

	@Override
	public void deleteUserById(String ids) {
		userMapper.deleteByPrimaryKey(Integer.parseInt(ids));
		
	}

	@Override
	public List<User> getPageUserByUser(String phone, String username, String qq, int pageNum, int pageSize) {
	 PageHelper.startPage(pageNum,pageSize);//分页核心代码
	 List<User> list= userMapper.getUserListByUser(phone,username,qq);
	 return list;
	
	}

	@Override
	public List<User> getUserOrderByDate(int size) {
		PageHelper.startPage(1, size);
		 List<User> list = userMapper.getUserListOrderByCreateAt();
		return list;
	}

}