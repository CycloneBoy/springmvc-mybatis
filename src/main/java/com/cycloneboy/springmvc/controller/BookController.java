package com.cycloneboy.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cycloneboy.springmvc.entity.vo.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.scene.layout.region.LayeredBackgroundSizeConverter;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/29.
 */
@Controller
@RequestMapping("/json")
public class BookController {

    private static Logger logger = Logger.getLogger(BookController.class);

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return "book/index";
    }

    @RequestMapping(value = "/testRequestBody" )
    public void setJson(@RequestBody Book book, HttpServletResponse response) throws  Exception{
        /* 采用jackson
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(book));
        book.setAuthor("肖文吉");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(book));*/
        //使用fastjson
        logger.info(JSONObject.toJSON(book));
        book.setAuthor("肖文吉");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSONObject.toJSONString(book));
    }

    @RequestMapping(value = "/testRequestBodyTwo")
    @ResponseBody
    public Object getJson(){
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"spring mvc 企业级实战","肖文吉"));
        list.add(new Book(2,"轻量级JavaEE企业应用实战","李刚"));
        return  list;
    }

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName, Model model){
        return  "book/" + formName;
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(Model model){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1,"spring mvc 企业级实战","肖文吉"));
        bookList.add(new Book(2,"轻量级JavaEE企业应用实战","李刚"));
        bookList.add(new Book(3,"疯狂Android讲义","李刚"));
        bookList.add(new Book(4,"疯狂Ajax讲义","李刚"));
        model.addAttribute("bookList",bookList);
        return "book/main";
    }
}
