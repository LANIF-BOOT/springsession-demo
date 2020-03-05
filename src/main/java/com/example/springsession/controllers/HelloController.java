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
        if (browser1 == null) {
            session.setAttribute("browser", browser);
            System.out.println("session is not browser, store it " + browser);
        } else {
            System.out.println("session has broswer " + browser1);
        }

        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookies[i].getName();
        }
        return browser;
    }
}
