package com.cycloneboy.springmvc.controller;

import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
@Controller
@RequestMapping(value = "items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {

        //调用service查找数据库，查询商品列表
        //这里传入进去一个null表示没有附加条件，查询所有的。因为service中接收的是一个ItemsQueryVo对象
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("/items/itemsList");

        return modelAndView;
    }
}
