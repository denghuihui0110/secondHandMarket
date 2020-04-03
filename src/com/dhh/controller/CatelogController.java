package com.dhh.controller;

import org.springframework.stereotype.Controller;

import com.dhh.service.CatelogService;

import javax.annotation.Resource;

@Controller
public class CatelogController {
	
    @Resource
    private CatelogService catelogService;

}
