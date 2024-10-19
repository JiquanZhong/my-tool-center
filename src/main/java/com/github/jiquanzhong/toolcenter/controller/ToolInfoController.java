package com.github.jiquanzhong.toolcenter.controller;

import com.github.jiquanzhong.toolcenter.model.ToolInfo;
import com.github.jiquanzhong.toolcenter.service.ToolInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toolInfo")
@Tag(name = "ToolInfoController", description = "工具信息接口")
@Slf4j
@RequiredArgsConstructor
public class ToolInfoController {
    private final ToolInfoService toolInfoService;

    @Operation(summary = "创建工具信息", description = "创建工具信息")
    @PostMapping
    public ResponseEntity<ToolInfo> createToolInfo(@RequestBody ToolInfo toolInfo) {
        ToolInfo createdToolInfo = toolInfoService.createToolInfo(toolInfo);
        return ResponseEntity.ok(createdToolInfo);
    }

    @Operation(summary = "根据id获取工具信息", description = "根据id获取工具信息")
    @GetMapping("/{id}")
    public ResponseEntity<ToolInfo> getToolInfoById(@PathVariable String id) {
        ToolInfo toolInfo = toolInfoService.getToolInfoById(id);
        if (toolInfo != null) {
            return ResponseEntity.ok(toolInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "获取所有工具信息", description = "获取所有工具信息")
    @GetMapping
    public ResponseEntity<List<ToolInfo>> getAllToolInfos() {
        List<ToolInfo> toolInfos = toolInfoService.getAllToolInfos();
        return ResponseEntity.ok(toolInfos);
    }

    @Operation(summary = "更新工具信息", description = "更新工具信息")
    @PutMapping("/{id}")
    public ResponseEntity<ToolInfo> updateToolInfo(@PathVariable String id, @RequestBody ToolInfo toolInfo) {
        ToolInfo updatedToolInfo = toolInfoService.updateToolInfo(id, toolInfo);
        if (updatedToolInfo != null) {
            return ResponseEntity.ok(updatedToolInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "删除工具信息", description = "删除工具信息")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToolInfo(@PathVariable String id) {
        toolInfoService.deleteToolInfo(id);
        return ResponseEntity.noContent().build();
    }
}
