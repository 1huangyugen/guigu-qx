package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @date 2023/4/4-20:04
 */
@Api(tags= "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("获取用户的角色数据")
    @GetMapping("toAssign/{userId}")
    public Result toAssign(@PathVariable String userId){
        Map<String,Object> roleMap=sysRoleService.getRolesByUserId(userId);
        return Result.ok(roleMap);
    }



    @ApiOperation("用户分配角色")
    @PostMapping("doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo){
            sysRoleService.doAssign(assginRoleVo);
            return Result.ok();
        }



    //    7批量删除
    //多个id值[1,2,3]
        //json数组格式--------java的list集合
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids){
        boolean byIds = sysRoleService.removeByIds(ids);
        return Result.ok();
    }





//    6修改 最终修改
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean save = sysRoleService.updateById(sysRole);
        if (save){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

//    5修改 根据id查询
@ApiOperation("根据id查询")
@PostMapping("findRoleById/{id}")
public Result findRoleById(@PathVariable Long id){
    SysRole byId = sysRoleService.getById(id);
    return Result.ok(byId);
}






//4添加
//@RequestBody不能使用get提交方式
//传递josn格式数据，把json格式数据封装到对象里面{。。。}
@ApiOperation("添加角色")
@PostMapping("save")
//把传过来的jon数据封装到SysRole对象中，然后把对象中的内容加到数据库中去
public Result saveRole(@RequestBody SysRole sysRole){
    boolean save = sysRoleService.save(sysRole);
    if (save){
        return Result.ok();
    }else {
        return Result.fail();
    }
}



//    3条件分页查询
//    page当前页 limit每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo){
        //创建page对象
        Page<SysRole> pageParam = new Page<>(page,limit);
        //调用service方法
        IPage<SysRole> sysRoleIPage= sysRoleService.selectPage(pageParam,sysRoleQueryVo);
        //返回
        return  Result.ok(sysRoleIPage);
    }


//    2逻辑删除接口
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id){
        //调用方法删除
        boolean b = sysRoleService.removeById(id);
        if (b){
            return Result.ok();
        }else {
            return Result.fail();
        }

    }

    //1查询所有记录
    @ApiOperation("查询所有记录")
    @GetMapping("findAll")
    public Result findAll(){

    //TODO模拟异常处理 ArithmeticException
        try {
            int i = 9/0;
        }catch (Exception e){
            //手动抛出异常
            throw new GuiguException(20001,"执行自定义异常处理");
        }
        //调用servi
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }
}
