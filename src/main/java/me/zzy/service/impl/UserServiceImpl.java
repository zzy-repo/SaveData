package me.zzy.service.impl;

import me.zzy.entity.User;
import me.zzy.mapper.UserMapper;
import me.zzy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zzy
 * @since 2024-09-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
