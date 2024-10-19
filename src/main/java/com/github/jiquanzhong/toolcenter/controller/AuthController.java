package com.github.jiquanzhong.toolcenter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "AuthController", description = "认证相关测试接口")
@RequiredArgsConstructor
public class AuthController {

    @Operation(summary = "hello", description = "hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
