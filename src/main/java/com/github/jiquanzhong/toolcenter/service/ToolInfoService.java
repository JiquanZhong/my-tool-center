package com.github.jiquanzhong.toolcenter.service;

import com.github.jiquanzhong.toolcenter.model.ToolInfo;

import java.util.List;

public interface ToolInfoService {
    ToolInfo createToolInfo(ToolInfo toolInfo);
    ToolInfo getToolInfoById(String id);
    List<ToolInfo> getAllToolInfos();
    ToolInfo updateToolInfo(String id, ToolInfo toolInfo);
    void deleteToolInfo(String id);
}
