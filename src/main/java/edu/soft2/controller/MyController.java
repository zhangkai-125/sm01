package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("param1")
public class MyController {

    @RequestMapping("testMaV")
    public ModelAndView testMaV(){
        ModelAndView MaV = new ModelAndView();
        System.out.println("MyController.testMaV()");
        MaV.setViewName("hello");
        User user = new User();
        user.setUsername("peter");
        MaV.addObject("user",user);//添加数据到request
        return MaV;
    }


    @RequestMapping("testForwars")
    public String testForwars(){
        System.out.println("----------testForwars()---------");
        return "forward:/hello";
    }


    @RequestMapping(value = "/param1",method = {RequestMethod.GET,RequestMethod.POST})
    public String param1(HttpServletRequest request){
        System.out.println("-----param1-------");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username="+username+",age="+age);
        request.setAttribute("username",username);
        request.setAttribute("age",age);
//        return "hello";//转发 默认用转发的方式跳转 url不变
        return "redirect:hello";//重定向 url变化
    }

    @RequestMapping(value = "/param3")
    public String param3(HttpServletRequest request,HttpSession session){
        System.out.println("-----param3-------");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username="+username+",age="+age);
        session.setAttribute("username",username);//将数据放入session
        session.setAttribute("age",age);
//        return "hello";//转发 默认用转发的方式跳转 url不变
        return "redirect:hello";//重定向 url变化
    }

    @RequestMapping(value = "/param4")
    public String param4(String username,int age){
        System.out.println("-----param4()-------");
        System.out.println("username="+username+",age="+age);
//        return "hello";//转发 默认用转发的方式跳转 url不变
        return "redirect:hello";//重定向 url变化
    }

    @RequestMapping(value = "/param5")
    public String param5(@RequestParam(value = "username",required = false) String u, @RequestParam(value = "age",required = true,defaultValue = "20")int a){//参数绑定
        System.out.println("-----param5()-------");
        System.out.println("username="+u+",age="+a);
//        return "hello";//转发 默认用转发的方式跳转 url不变
        return "hello";//重定向 url变化
    }

    @RequestMapping(value = "/param6")
    public String param6(@RequestParam(value = "username",required = false) String u, @RequestParam(value = "age",required = true,defaultValue = "20")int a){//参数绑定
        System.out.println("-----param6()-------");
        System.out.println("username="+u+",age="+a);
//        return "hello";//转发 默认用转发的方式跳转 url不变
        return "hello";//重定向 url变化
    }

    @RequestMapping(value = "/test1")
    public String test1(){
        System.out.println("-----test1()-------");
        return "forward:param1/test2";//return "hello";//转发 默认用转发的方式跳转 url不变
    }

    @RequestMapping(value = "/test2")
    public String test2(){
        System.out.println("-----test2()-------");
//        return "hello";//转发 默认用转发的方式跳转 url不变
        return "hello";//重定向 url变化
    }

    @RequestMapping(value = "/Hello")
    public String Hello(){
        System.out.println("hello");
        return "hello";
    }



}
