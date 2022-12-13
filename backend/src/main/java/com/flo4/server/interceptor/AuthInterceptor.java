package com.flo4.server.interceptor;

import com.flo4.server.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final UserService userService;

   public AuthInterceptor(UserService userService) {
      this.userService = userService;
   }

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
      String authHeader = request.getHeader("Authorization");

      if (authHeader == null || !authHeader.startsWith("Bearer "))
         System.out.println("No bearer token");

      request.setAttribute("user", userService.getUserFromToken(authHeader.substring(7)));
      return true;
   }
}
