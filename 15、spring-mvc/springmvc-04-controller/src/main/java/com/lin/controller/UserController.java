package com.lin.controller;

import com.lin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //localhost:8080/user/t1 ? name=xxx
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1、接收前端的参数
        System.out.println("接收到的前端参数为："+name);
        //2、将返回结果传递给前端--Model
        model.addAttribute("msg",name);
        //3、视图跳转
        return "test";
    }

    /**
     *1、接收到的前端用户传递参数，判断参数的名字，假设名字直接在方法上，可以直接使用
     *2、假设传递的是一个对象user，就会匹配user对象的字段名；如果字段一致则OK，否则匹配不到
     */

    //前端接收的是一个对象；表单--id，name，age
    @GetMapping("/t2")
    public String test2(Model model, User user){
        System.out.println(user);
        return "test";
    }

    /**
     * Model
     * ModelAndView
     * ModelMap
     */

    @GetMapping("/t3")
    public String test3(ModelMap map){

        return "test";
    }

}
