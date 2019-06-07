package com.controller;


import com.common.Const;
import com.common.ServerResponse;
import com.domain.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/header")
    public String header(){
        return "header";
    }
    //跳转到登录表单
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "LoginPage";
    }
    //跳转到注册表单
    @RequestMapping("/registForm")
    public String registForm(Model model){
        model.addAttribute("user", new User());
        return "registPage";
    }
    /**
     * 用户登录
     *
     * @param email
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/verifyLoginInfo", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> verifyLoginInfo(@RequestParam("email") String email,
                                                @RequestParam("password") String password,
                                                HttpSession session, HttpServletRequest request) {
            ServerResponse<User> response = userService.Login(email,password);
        System.out.println("message:"+response.getMsg()+","+response.getStatus());
        if (response.isSuccess()){
            //x_forwarded_for客户端真实IP
            String ip = request.getHeader("x_forwarded_for");
            System.out.println(ip);
                session.setAttribute(Const.CURRENT_USER,response.getData());
                //指定转发的页面
//                modelAndView.setViewName("loginInfo");
            }
//            else{
//            modelAndView.setViewName("LoginPage");
//        }
//        modelAndView.addObject("message",response.getMsg());
//        modelAndView.addObject("status",response.getStatus());
        return response;
    }
    //用户注销
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        //移出属性但是session仍然存在
        session.removeAttribute(Const.CURRENT_USER);
        //销毁当前用户的session
        session.invalidate();
        return "redirect:/product/main";
    }

    //注册
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String regist(@ModelAttribute("user") User user, HttpServletRequest request,
                         HttpSession session){

        userService.register(user);
        //x_forwarded_for客户端真实IP
        String ip = request.getHeader("x_forwarded_for");
        System.out.println(ip);
        ServerResponse<User> response = userService.Login(user.getEmail(),user.getPassword());
        session.setAttribute(Const.CURRENT_USER,response.getData());

        return "redirect:/product/main";
    }
}
