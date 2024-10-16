package com.github.jiquanzhong.toolcenter.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jiquanzhong.toolcenter.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 工具信息表
 * @TableName tool_info
 */
@Data
@Builder
@TableName("tool_user")
public class ToolUser extends BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}