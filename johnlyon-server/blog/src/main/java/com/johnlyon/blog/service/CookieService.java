package com.johnlyon.blog.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

@Service
public class CookieService {
    public Cookie addCookie(String username) {
        UUID uuid = UUID.randomUUID();
        String cookie = uuid.toString();
        cookie = username + cookie;
        Cookie token = new Cookie("userToken", cookie);
        token.setMaxAge(3600);
        return token;
    }

    public String getCookie(Cookie[] cookies) {
        String userToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userToken")) {
                    userToken = cookie.getValue();
                }
            }
        }
        return userToken;
    }
}
