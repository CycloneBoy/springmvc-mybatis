package com.cycloneboy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CycloneBoy on 2017/7/26.
 */
@Controller
public class DemoController {
    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable("name") String name) {
        System.out.println( "hello, " + name);
        return "hello";
    }
}
