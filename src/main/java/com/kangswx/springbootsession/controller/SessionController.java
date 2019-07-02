package com.kangswx.springbootsession.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/setSession")
    public String setSession(HttpServletRequest request, String key, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
        String rs = "setSession  Server Port:" + port + " Value:" + value;
        System.out.println(rs);
        return rs;
    }

    @GetMapping("/getSession")
    public String getSession(HttpServletRequest request, String key) {
        HttpSession session = null;
        String value = null;
        try {
            session = request.getSession(false);
            if (session != null)
                value = (String)session.getAttribute(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String rs = "getSession  Server Port:" + port + " Value:" + value;
        System.out.println(rs);
        return rs;
    }

}
