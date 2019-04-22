package com.lhs.service.impl;

import com.lhs.entity.User;
import com.lhs.mapper.UserMapper;
import com.lhs.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lhs.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int createUser(User user) {
        return baseMapper.addUser(user);
    }

    @Override
    public User findUser(User user) {
        User result = null;
//        if (user != null && user.getId() != null) {
//            result = baseMapper.selectById(user.getId());
//        }
        if (result == null && user != null && StringUtils.notEmpty(user.getWxOpenid())) {
            List<User> userList = baseMapper.selectByOpenid(user.getWxOpenid());
            if (userList != null && userList.size() > 0) {
                result = userList.get(0);
            }
        }
//        if (result == null && user != null && StringUtils.notEmpty(user.getMobile())) {
//            List<User> userList = baseMapper.selectByPhone(user.getMobile());
//            if (userList != null && userList.size() > 0) {
//                result = userList.get(0);
//            }
//        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        if (user != null && StringUtils.notEmpty(user.getWxOpenid())) {
            if (StringUtils.notEmpty(user.getMobile())) {
                baseMapper.clearMobileByPhone(user.getMobile());
            }
            return baseMapper.updateUserByOpenid(user);
        } else {
            return 0;
        }
    }
}
