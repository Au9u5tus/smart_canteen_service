package com.yuhao.canteen.interceptor;

import com.yuhao.canteen.common.SpringContextUtil;
import com.yuhao.canteen.service.JwtService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            JwtService jwtService=SpringContextUtil.getBean(JwtService.class);
            String username=jwtService.validateTokenAndGetUsername(token);
            if(username!=null){
                String newToken=jwtService.refreshToken(token);
                response.setHeader("Authorization",newToken);
                return true;
            }
        }
        // 验证失败，返回 401 未授权状态码
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        return false;
    }
}
