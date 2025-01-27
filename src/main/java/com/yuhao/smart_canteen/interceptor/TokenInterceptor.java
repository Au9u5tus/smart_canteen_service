package com.yuhao.smart_canteen.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            //String username = JwtUtil.validateTokenAndGetUsername(token);
            String username="";
            if (username != null) {
                // 验证成功，允许请求继续处理
                return true;
            }
        }
        // 验证失败，返回 401 未授权状态码
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
