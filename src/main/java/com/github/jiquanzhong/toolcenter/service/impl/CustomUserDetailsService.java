package com.github.jiquanzhong.toolcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.jiquanzhong.toolcenter.model.ToolUser;
import com.github.jiquanzhong.toolcenter.repository.mapper.ToolUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final ToolUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ToolUser user = userMapper.selectOne(new QueryWrapper<>(ToolUser.builder().username(username).build()));
//        if (user == null) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//
//        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
        return User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .disabled(false)
                .accountExpired(false)
                .credentialsExpired(false)
                .accountLocked(false)
                .authorities("admin")
                .build();
    }
}
