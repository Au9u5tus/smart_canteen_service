package com.yuhao.canteen.common;

import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {

    public static User getCurrentUser(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String userName=(String)request.getAttribute("username");
            UserService userService=SpringContextUtil.getBean(UserService.class);
            User user=userService.findUserByUserName(userName);
            return user;
        }
        return null;
    }
}
