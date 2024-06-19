package com.kwok.spring.sms.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@Slf4j
public class CaptchaController {
    public final static String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";

    @GetMapping("/captcha")
    public void createCode(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(100, 38, 4, 20);
        request.getSession().setAttribute(SESSION_KEY_IMAGE_CODE, captcha.getCode());
        log.info("本次生成的验证码为：" + captcha.getCode() );

        try (OutputStream out = response.getOutputStream()) {
            captcha.write(out);
        } catch (IOException e) {
            log.error("Error in writing captcha to output stream", e);
        }
    }
}
