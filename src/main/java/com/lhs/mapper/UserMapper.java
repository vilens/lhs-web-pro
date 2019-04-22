package com.lhs.mapper;

import com.lhs.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface UserMapper extends BaseMapper<User> {
    int addUser(User user);
    int updateUserByOpenid(User user);
    int clearMobileByPhone(String mobile);

    List<User> selectByOpenid(String openid);
}
