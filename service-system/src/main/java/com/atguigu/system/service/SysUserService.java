package com.atguigu.system.service;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-06
 */
public interface SysUserService extends IService<SysUser> {

    //用户列表
    IPage<SysUser> selectPage(Page<SysUser> pagePaem, SysUserQueryVo sysUserQueryVo);
    //更改用户状态
    void updateStatus(String id, Integer status);
}
