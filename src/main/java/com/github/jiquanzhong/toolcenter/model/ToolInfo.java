package com.github.jiquanzhong.toolcenter.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jiquanzhong.toolcenter.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

/**
 * 工具信息表
 * @TableName tool_info
 */
@Data
@Builder
@TableName("tool_info")
public class ToolInfo extends BaseEntity implements Serializable {

    /**
     * 工具id
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 工具名称
     */
    private String toolName;
    /**
     * 工具分类
     */
    private String toolClass;
    /**
     * 工具类型
     */
    private String toolType;

    /**
     * 工具介绍
     */
    private String toolIntroduce;

}