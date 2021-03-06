package com.example.springsession.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

    @RequestMapping("/cookie")
    public String testCookie(String browser, HttpSession session, HttpServletRequest request) {
        Object browser1 = session.getAttribute("browser");
        System.out.println("request session:" + request.getRequestedSessionId());
        if (browser1 == null) {
            session.setAttribute("browser", browser);
            System.out.println("session id:" + session.getId());
        } else {
            System.out.println("existed id:" + session.getId());
        }

        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            cookies[i].getName();
            System.out.println("cookie name:" + cookies[i].getName() + "; cookie value:" + cookies[i].getValue());
        }
        return browser;
    }
}
