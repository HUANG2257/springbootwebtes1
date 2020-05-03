package com.youmo.huang.controller;

import com.youmo.huang.bean.User;
import com.youmo.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author 2257
 * @date 2020/4/25 - 14:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User user, Map<String,Object> map, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        User one = userService.getUser(username);
        if(username == null || "".equals(username)){
            map.put("errorMsg","用户名不能为空");
            return "login";
        }
        if(password == null || "".equals(password)){
            map.put("errorMsg","密码吗不能为空");
            return "login";
        }
        if(one != null){
                if(!password.equals(one.getPassword())){
                    map.put("errorMsg","账号或密码不正确");
                    return "login";
                }
                session.setAttribute("user",one);
                return "redirect:/index";
            }

        map.put("errorMsg", "账号不存在");
        return "login";
    }
       /* if(username == null || "".equals(username.trim())){
            session.setAttribute("errorMsg","用户名不能为空");
            return "redirect:/login";
        }
        if(password == null || "".equals(password.trim())){
            session.setAttribute("errorMsg", "用户名或密码不正确");
            return "redirect:/login";
        }*/
       /* List<ObjectError> allErrors = bindingResult.getAllErrors();

            session.setAttribute("errorMsg",allError.get(0).getDefaultMessage());
            return "redirect:/login";

*/
       @GetMapping("/username")
       @ResponseBody
        public User getUserName(String username){
           User user = userService.getUser(username);
           return user;
       }

}
