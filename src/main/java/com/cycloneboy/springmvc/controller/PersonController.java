package com.cycloneboy.springmvc.controller;

import com.cycloneboy.springmvc.entity.User;
import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.entity.vo.Person;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.validator.spi.valuehandling.ValidatedValueUnwrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by CycloneBoy on 2017/7/28.
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String loginFrom(Model model){
        Person person = new Person();
        person.setLoginname("测试");
        person.setImage(null);
        model.addAttribute("person",person);
        return  "person/registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute Person person,
                        Errors errors, Model model, HttpServletRequest request,
                        MultipartFile person_pic
                        ) throws IOException {
        System.out.println(person);
        if(errors.hasErrors()){
            return  "person/registerForm";
        }
        if (!person.getImage().isEmpty()){
            String path = request.getServletContext().getRealPath("/image/");
            String filename = person.getImage().getOriginalFilename();
            File filepath = new File(path,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdir();
            }
            person.getImage().transferTo(new File(path + File.separator + filename));
        }else{
            System.out.println("没有选择用户图像");
        }

//        // 处理上传的单个图片
        String originalFileName = person_pic.getOriginalFilename();// 原始名称
        // 上传图片
        if (person_pic != null && originalFileName != null && originalFileName.length() > 0) {
            // 存储图片的物理路径，实际中是要写到配置文件中的，不能在这写死
            String pic_path = "D:\\java\\cgj\\upload\\";
            // 新的图片名称
            String newFileName = UUID.randomUUID() +"_"+ originalFileName;
            File newFile = new File(pic_path + newFileName);//新图片
            person_pic.transferTo(newFile);// 将内存中的数据写入磁盘
            person.setPic(newFileName);// 将新图片名称写到itemsCustom中
        } else {
            System.out.println("如果用户没有选择图片就上传了，还用原来的图");
        }

        model.addAttribute("person",person);
        return  "person/success";
    }

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model) throws  Exception{
        String path = request.getServletContext().getRealPath("/image/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/registerFrom",method = RequestMethod.GET)
    public String registerForm(Model model){
        return "person/registerForm";
    }

    @RequestMapping(value = "/loginForm",method = RequestMethod.GET)
    public String loginForm(Model model){
        Person person = new Person();
        model.addAttribute("person",person);
        return "person/loginForm";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(String loginname, String password, ModelAndView mv,
                              HttpSession session){
        if(loginname != null && loginname.equals("root")
                && password!=null && password.equals("123456")){
            Person person = new Person();
            person.setLoginname(loginname);
            person.setPassword(password);
            person.setUsername("管理员");
            session.setAttribute("user",person);
            mv.setViewName("redirect:/json/main");
        }else{
            mv.addObject("message","登录名或密码错误，请重新输入!");
            mv.setViewName("person/loginForm");
        }
        return  mv;
    }
}
