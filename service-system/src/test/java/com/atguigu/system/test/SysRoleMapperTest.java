package com.atguigu.system.test;

import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @date 2023/4/3-14:08
 */
@SpringBootTest
public class SysRoleMapperTest {
    @Autowired
    private SysRoleMapper syRoleMapper;

//    7条件删除
    @Test
    public void testDelete(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        //条件删除
        queryWrapper.eq("role_name","用户管理员");
        syRoleMapper.delete(queryWrapper);
    }

//    6条件查询
    @Test
    public void testSelect(){
        //创建条件构造器对象
        QueryWrapper<SysRole> Wrapper = new QueryWrapper<>();
        //设置条件
        Wrapper.like("role_name","管理员");
        //调用方法查询
        List<SysRole> list = syRoleMapper.selectList(Wrapper);
        System.out.println(list);
    }


//    5批量删除
    @Test
    public void testBatchDelete(){
        syRoleMapper.deleteBatchIds(Arrays.asList(1, 9));
    }


//    4删除操作(这里用的是逻辑删除，被删除的数据会显示1，查询只能查询0的数据)
    @Test
    public void deleteId(){
        int i = syRoleMapper.deleteById(2);
    }



//    3修改操作
    @Test
    public void update(){

        //根据id查询
        SysRole sysRole = syRoleMapper.selectById(1);

        //设置修改值
        sysRole.setDescription("系统管理员尚硅谷");

        //调用方法实现修改
        syRoleMapper.updateById(sysRole);
    }

//    2添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("测试角色");
        sysRole.setRoleCode("testMannagen");
        sysRole.setDescription("测试角色");
        int insert = syRoleMapper.insert(sysRole);
        System.out.println(insert);
    }
//    1查询所有语句
    @Test
    public void findAll(){
        List<SysRole> list = syRoleMapper.selectList(null);
        for (SysRole sysRole:list){
            System.out.println(sysRole);
        }
    }
}
