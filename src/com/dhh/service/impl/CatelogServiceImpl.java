package com.dhh.service.impl;

import com.dhh.dao.CatelogMapper;
import com.dhh.pojo.Catelog;
import com.dhh.service.CatelogService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("catelogService")
public class CatelogServiceImpl implements CatelogService {

    @Resource
    private CatelogMapper ct;

    public int getCount(Catelog catelog) {
        int count = ct.getCount(catelog);
        return count;
    }
    
    public List<Catelog> getAllCatelog() {
        List<Catelog> catelogs = ct.getAllCatelog();
        return catelogs;
    }
    
    public Catelog selectByPrimaryKey(Integer id){
        Catelog catelog = ct.selectByPrimaryKey(id);
        return catelog;
    }
    
    public int updateByPrimaryKey(Catelog catelog) {
        return  ct.updateByPrimaryKey(catelog);
    }
    
    public int updateCatelogNum(Integer id,Integer number) {
        return ct.updateCatelogNum(id,number);
    }
    
}
