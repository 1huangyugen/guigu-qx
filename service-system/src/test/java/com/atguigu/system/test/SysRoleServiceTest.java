package com.atguigu.system.test;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author shkstart
 * @date 2023/4/3-14:08
 */
@SpringBootTest
public class SysRoleServiceTest {

        @Autowired
        private SysRoleService sysRoleService;

        //查询所有
        @Test
        public void findAll(){
            //service方法实现
            List<SysRole> list = sysRoleService.list();
            System.out.println(list);
        }
        //添加
    @Test
    public void add(){
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("角色管理员atguigu");
            sysRole.setRoleCode("role");
            sysRole.setDescription("角色管理员");
            sysRoleService.save(sysRole);
    }

    //修改
    @Test
    public void update(){
            SysRole sysRole = sysRoleService.getById(1);
            sysRole.setDescription("test");
            sysRoleService.updateById(sysRole);
    }

    //删除
    @Test
    public void remove(){
            sysRoleService.removeById(1);
    }

    //条件查询
    @Test
    public void select(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_code","SYSTEM");
        List<SysRole> list = sysRoleService.list(wrapper);
        System.out.println(list);
    }
}

