package com.github.jiquanzhong.toolcenter.model;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Captcha implements Serializable {
    private static final long serialVersionUID = -2921955681067719313L;

    private static final int DEFAULT_EXPIRED = 60;

    private Integer expireIn;

    private transient BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public Captcha(String code, BufferedImage image, Integer expireIn) {
        this.expireIn = expireIn == null ? DEFAULT_EXPIRED : expireIn;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
        this.code = code;
        this.image = image;
    }

    public Captcha(String code, BufferedImage image, LocalDateTime expireTime) {
        this.expireTime = expireTime == null ? LocalDateTime.now().plusSeconds(DEFAULT_EXPIRED) : expireTime;
        this.code = code;
        this.image = image;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
