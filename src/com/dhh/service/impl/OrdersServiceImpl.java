package com.dhh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhh.dao.OrdersMapper;
import com.dhh.pojo.Orders;
import com.dhh.service.OrdersService;
import com.github.pagehelper.PageHelper;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	
	@Resource
	private OrdersMapper od;

	public List<Orders> getOrdersByUserId(Integer user_id) {
		List<Orders> orders=od.selectOrdersByUserId(user_id);
		return orders;
	}

	@Override
	public List<Orders> getOrdersByUserAndGoods(Integer user_id) {
		List<Orders> ordersOfSell=od.selectOrdersByUserAndGoods(user_id);
		return ordersOfSell;
	}

	@Override
	public void addOrders(Orders orders) {
		od.addOrders(orders);
	}

	@Override
	public void deliverByOrderNum(Integer orderNum) {
		od.deliverByOrderNum(orderNum);
	}

	@Override
	public void receiptByOrderNum(Integer orderNum) {
		od.receiptByOrderNum(orderNum);
	}

	@Override
	public int getOrdersNum() {
		List<Orders> orders = od.getOrdersList();
	    return orders.size();
	}

	@Override
	public List<Orders> getPageOrders(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Orders> list =od.getOrdersList();
		return list;
	}

	@Override
	public Orders getOrdersById(int ordersId) {
		Orders orders = od.selectById(ordersId);
	    return orders;
	}

	@Override
	public void updateByPrimaryKey(Integer id, Orders orders) {
	    orders.setId(id);
	    od.updateByPrimaryKey(orders);
	}

	@Override
	public void deleteOrdersByPrimaryKeys(int id) {
		od.deleteByPrimaryKeys(id);
	}

	@Override
	public List<Orders> getPageOrdersByOrders(Long orderNum, String orderInformation, Integer orderState, int pageNum,
			int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Orders> orders = od.getPageOrdersByOrders(orderNum,orderInformation,orderState);
		return orders;
	}

}
