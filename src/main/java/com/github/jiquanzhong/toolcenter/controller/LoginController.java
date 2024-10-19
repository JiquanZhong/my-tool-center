package com.github.jiquanzhong.toolcenter.controller;

import com.github.jiquanzhong.toolcenter.model.Captcha;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Tag(name = "LoginController", description = "登录相关接口")
public class LoginController {

    @Value("${kaptcha.expired}")
    private Integer expired;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private static final String PICTURE_CONTENT_TYPE_JPEG = "image/jpeg";
    private static final String SESSION_KEY_CAPTCHA = "SESSION_KEY_CAPTCHA";

    @Autowired
    Producer producer;

    @GetMapping("/captcha")
    @Operation(summary = "获取验证码", description = "获取验证码")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = producer.createText();
        BufferedImage image = producer.createImage(code);

        // 添加验证码至 session 中，用于校验时取出
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_CAPTCHA, code);

        response.setContentType(PICTURE_CONTENT_TYPE_JPEG);
//        Files.copy(image, response.getOutputStream());

        ImageIO.write(image, "JPEG", response.getOutputStream());

    }
}
