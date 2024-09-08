package me.zzy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import me.zzy.entity.User;
import me.zzy.response.Resp;
import me.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zzy
 * @since 2024-09-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/UpdateOrInsert")
    @ApiOperation("更新或插入")
    public Resp<?> UpdateOrInsert(@RequestBody User user) {
        boolean isInsert = user.getId() == null || user.getId() == 0;
        String message = isInsert ? "插入成功" : "更新成功";

        userService.saveOrUpdate(user);
        return Resp.success(message,user);
    }

    @PostMapping("/DelByIds")
    @ApiOperation("批量删除")
    public Resp<?> DelByIds(@RequestBody List<Integer> ids) {
        userService.removeByIds(ids);
        return  Resp.success("删除成功",null);
    }

}
