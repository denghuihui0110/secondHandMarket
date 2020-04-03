package com.dhh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhh.dao.GoodsMapper;
import com.dhh.pojo.CommentExtend;
import com.dhh.pojo.Comments;
import com.dhh.pojo.Goods;
import com.dhh.service.GoodsService;
import com.dhh.util.DateUtil;
import com.github.pagehelper.PageHelper;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper gd;

	public int addGood(Goods goods, Integer duration) {
		String startTime = DateUtil.getNowDay();
		String endTime = DateUtil.getLastTime(startTime, duration);
		String polishTime = startTime;
		// 添加上架时间，下架时间，擦亮时间
		goods.setPolishTime(polishTime);
		goods.setEndTime(endTime);
		goods.setStartTime(startTime);
		return gd.insert(goods);
	}

	public Goods getGoodsByPrimaryKey(Integer goodsId) {
		Goods goods = gd.selectByPrimaryKey(goodsId);
		return goods;
	}

	public Goods getGoodsById(Integer goodsId) {
		Goods goods = gd.selectById(goodsId);
		return goods;
	}

	public void deleteGoodsByPrimaryKey(Integer id) {
		gd.deleteByPrimaryKey(id);
	}

	public void deleteGoodsByPrimaryKeys(Integer id) {
		gd.deleteByPrimaryKeys(id);
	}

	public List<Goods> getAllGoods() {
		List<Goods> goods = gd.selectAllGoods();
		return goods;
	}

	public List<Goods> searchGoods(String name, String describle) {
		List<Goods> goods = gd.searchGoods(name, describle);
		return goods;
	}

	public List<Goods> getGoodsByStr(Integer limit, String name, String describle) {
		List<Goods> goods = gd.selectByStr(limit, name, describle);
		return goods;
	}

	public List<Goods> getGoodsByCatelog(Integer id, String name, String describle) {
		List<Goods> goods = gd.selectByCatelog(id, name, describle);
		return goods;
	}

	public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId, Goods goods) {
		goods.setId(goodsId);
		this.gd.updateByPrimaryKeyWithBLOBs(goods);
	}

	public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId, Integer limit) {
		List<Goods> goodsList = gd.selectByCatelogOrderByDate(catelogId, limit);
		return goodsList;
	}

	public List<Goods> getGoodsOrderByDate(Integer limit) {
		List<Goods> goodsList = gd.selectOrderByDate(limit);
		return goodsList;
	}

	public List<Goods> getGoodsByUserId(Integer user_id) {
		List<Goods> goodsList = gd.getGoodsByUserId(user_id);
		return goodsList;
	}

	public void updateGoodsByGoodsId(Goods goods) {
		gd.updateGoodsByGoodsId(goods);
	}

	@Override
	public int getGoodsNum() {
		// 获取出商品的数量
		List<Goods> goods = gd.getGoodsList();
		return goods.size();
	}

	@Override
	public List<Goods> getPageGoods(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = gd.getGoodsList();
		return list;
	}

	@Override
	public List<Goods> getPageGoodsByGoods(Integer id, String name, Integer status, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = gd.getPageGoodsByGoods(id, name, status);
		return list;
	}

	@Override
	public CommentExtend selectCommentsByGoodsId(Integer id) {
		return gd.selectCommentsByGoodsId(id);
	}

	@Override
	public void addComments(Comments comments) {
		gd.addComments(comments);
	}

}
