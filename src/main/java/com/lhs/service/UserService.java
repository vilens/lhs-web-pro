package com.lhs.service;

import com.lhs.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface UserService extends IService<User> {
    int createUser(User user);

    User findUser(User user);

    int updateUser(User user);
}
