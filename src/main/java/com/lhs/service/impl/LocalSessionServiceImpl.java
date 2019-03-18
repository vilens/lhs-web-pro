package com.lhs.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lhs.entity.LocalSession;
import com.lhs.mapper.LocalSessionMapper;
import com.lhs.service.LocalSessionService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Leonid on 2018/7/3.
 */
@Service
public class LocalSessionServiceImpl extends ServiceImpl<LocalSessionMapper, LocalSession> implements LocalSessionService {

    @Override
    public LocalSession login(String username, String password, long timeout) throws Exception {
        // 通过用户名密码进行用户认证

        // 认证成功后

        LocalSession session = LocalSession.create(timeout);
        session.setContextJson("{}");
        session.setUserId(1L);
        if (this.insert(session)) {
            return session;
        }
        return null;
    }


    @Override
    public boolean checkSessionState(String token) throws Exception {
        if (StrUtil.isBlank(token))
            return false;
        Date now = new Date();
        LocalSession localSession = localSessionByToken(token);
        if (localSession != null && localSession.getStatus().equals(LocalSession.VALID)) {
            if (localSession.getExpiryTime().after(now)) {
                return true;
            }
            this.deleteById(localSession.getId());
        }
        return false;
    }

    @Override
    public LocalSession getLocalSessionByToken(String token) throws Exception {
        LocalSession localSession = localSessionByToken(token);
        Date now = new Date();
        if (localSession != null && localSession.getStatus().equals(LocalSession.VALID)) {
            if (localSession.getExpiryTime().after(now)) {
                return localSession;
            }
            this.deleteById(localSession.getId());
        }
        return null;
    }

    private LocalSession localSessionByToken(String token) throws Exception {
        LocalSession localSession = new LocalSession();
        localSession.setToken(token);
        EntityWrapper<LocalSession> wrapper = new EntityWrapper<>();
        wrapper.setEntity(localSession);
        return this.selectOne(wrapper);
    }

}
