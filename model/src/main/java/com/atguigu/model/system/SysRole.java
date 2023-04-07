package com.atguigu.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.atguigu.model.base.BaseEntity;
import lombok.Data;


@Data
@TableName("sys_role")//对应的表的名称
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//对应的字段名称
	@TableField("role_name")
	private String roleName;

	@TableField("role_code")
	private String roleCode;

	@TableField("description")
	private String description;

}

