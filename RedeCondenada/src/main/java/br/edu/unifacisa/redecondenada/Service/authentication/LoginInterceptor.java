package br.edu.unifacisa.redecondenada.Service.authentication;

import jakarta.servlet.http.*;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import br.edu.unifacisa.redecondenada.Service.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try{
            if(CookieService.getCookie(request, "userId") != null){
                return true;
            }
        }
        catch(Exception error) {
            response.sendRedirect("/login");
        }
        response.sendRedirect("/login");
        return false;
    }

}