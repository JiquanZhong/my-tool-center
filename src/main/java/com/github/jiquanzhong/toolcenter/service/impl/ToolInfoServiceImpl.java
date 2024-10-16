package com.github.jiquanzhong.toolcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.jiquanzhong.toolcenter.repository.mapper.ToolInfoMapper;
import com.github.jiquanzhong.toolcenter.model.ToolInfo;
import com.github.jiquanzhong.toolcenter.service.ToolInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToolInfoServiceImpl implements ToolInfoService {
    private final ToolInfoMapper toolInfoMapper;


    public ToolInfo createToolInfo(ToolInfo toolInfo) {
        return toolInfoMapper.insert(toolInfo) > 0 ? toolInfo : null;
    }

    public ToolInfo getToolInfoById(String id) {
        Optional<ToolInfo> toolInfo = Optional.ofNullable(toolInfoMapper.selectById(id));
        return toolInfo.orElse(null);
    }

    public List<ToolInfo> getAllToolInfos() {
        return toolInfoMapper.selectList(null);
    }

    public ToolInfo updateToolInfo(String id, ToolInfo toolInfo) {
        toolInfo.setId(id);
        return toolInfoMapper.updateById(toolInfo) > 0 ? toolInfo : null;
    }

    public void deleteToolInfo(String id) {
        toolInfoMapper.deleteById(id);
    }
}
