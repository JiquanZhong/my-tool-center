package com.github.jiquanzhong.toolcenter.controller;

import com.github.jiquanzhong.toolcenter.model.ToolInfo;
import com.github.jiquanzhong.toolcenter.service.ToolInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/toolInfo")
@Api("工具信息管理")
@Slf4j
@RequiredArgsConstructor
public class ToolInfoController {
    private final ToolInfoService toolInfoService;

    @ApiOperation("创建工具信息")
    @PostMapping
    public ResponseEntity<ToolInfo> createToolInfo(@RequestBody ToolInfo toolInfo) {
        ToolInfo createdToolInfo = toolInfoService.createToolInfo(toolInfo);
        return ResponseEntity.ok(createdToolInfo);
    }

    @ApiOperation("根据id获取工具信息")
    @GetMapping("/{id}")
    public ResponseEntity<ToolInfo> getToolInfoById(@PathVariable String id) {
        ToolInfo toolInfo = toolInfoService.getToolInfoById(id);
        if (toolInfo != null) {
            return ResponseEntity.ok(toolInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation("获取所有工具信息")
    @GetMapping
    public ResponseEntity<List<ToolInfo>> getAllToolInfos() {
        List<ToolInfo> toolInfos = toolInfoService.getAllToolInfos();
        return ResponseEntity.ok(toolInfos);
    }

    @ApiOperation("更新工具信息")
    @PutMapping("/{id}")
    public ResponseEntity<ToolInfo> updateToolInfo(@PathVariable String id, @RequestBody ToolInfo toolInfo) {
        ToolInfo updatedToolInfo = toolInfoService.updateToolInfo(id, toolInfo);
        if (updatedToolInfo != null) {
            return ResponseEntity.ok(updatedToolInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation("删除工具信息")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToolInfo(@PathVariable String id) {
        toolInfoService.deleteToolInfo(id);
        return ResponseEntity.noContent().build();
    }
}
