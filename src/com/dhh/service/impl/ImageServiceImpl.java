package com.dhh.service.impl;

import com.dhh.dao.ImageMapper;
import com.dhh.pojo.Image;
import com.dhh.service.ImageService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
    @Resource
    private ImageMapper ig;
    
    public int insert(Image record) {
        return ig.insert(record);
    }
    
    public List<Image> getImagesByGoodsPrimaryKey(Integer goodsId) {
        List<Image> image = ig.selectByGoodsPrimaryKey(goodsId);
        return image;
    }
    
    public int deleteImagesByGoodsPrimaryKey(Integer goodsId) {
        return ig.deleteImagesByGoodsPrimaryKey(goodsId);
    }
    
}
