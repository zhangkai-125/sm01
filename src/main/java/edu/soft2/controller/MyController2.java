package edu.soft2.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.soft2.pojo.User;

@Component
@RequestMapping("param2")
public class MyController2 {
    @RequestMapping(value = "Test3")
    public String Test3(){
        System.out.println("");
        return "hello";
    }
    @RequestMapping(value = "reg")
    public String reg(User user){
        System.out.println("用户名"+user.getUsername());
        System.out.println("密码："+user.getPwd());
        System.out.println("年龄："+user.getAge());
        return "hello";
    }
    @RequestMapping(value = "login")
    public String login(){
        System.out.println("------login------");
        return "hello";
    }
}
