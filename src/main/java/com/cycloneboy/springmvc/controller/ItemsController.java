package com.cycloneboy.springmvc.controller;

import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.entity.vo.ItemsQueryVo;
import com.cycloneboy.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/editItems",method = RequestMethod.GET)
    public String editItems(Model model,Integer id) throws  Exception{

        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        model.addAttribute("itemsCustom",itemsCustom);
        return "items/editItems";
    }

    @RequestMapping(value = "/editItems",method = RequestMethod.POST)
    public String editItemsSubmit(ItemsCustom itemsCustom) throws  Exception{
        itemsService.updateItems(itemsCustom);

        return "redirect:/items/queryItems";
    }

    @RequestMapping(value = "/deleteItems",method = RequestMethod.GET)
    public String deleteItems(Integer[] items_id) throws  Exception{

        System.out.println("删除记录: " + items_id);

        return "redirect:/items/queryItems";
    }

    @RequestMapping(value = "/editItemsQuery",method = RequestMethod.GET)
    public  ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo ) throws  Exception{

        List<ItemsCustom> itemsList = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("items/editItemsQuery");
        return modelAndView;
    }

    @RequestMapping(value = "/editItemsQuery",method = RequestMethod.POST)
    public  String editItemsQueryResult(ItemsQueryVo itemsQueryVo ) throws  Exception {
        System.out.println("批量修改: " + itemsQueryVo.getItemsList().size());
        return "redirect:/items/queryItems";
    }


}
