package com.liuyanzhao.redis.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.liuyanzhao.redis.entity.User;
import com.liuyanzhao.redis.repository.UserRepository;
import com.liuyanzhao.redis.service.UserService;
import com.liuyanzhao.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * Redis缓存方法一：通过 redisTemplate 操作
 *
 * @author 言曌
 * @date 2020-01-29 14:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisUtil redisUtil;

    public static final String REDIS_USER_ID_KEY_PREFIX = "user::id-";

    @Override
    public User findById(Long id) {
        // 从 redis 查询
        String value = redisUtil.get(REDIS_USER_ID_KEY_PREFIX + id);
        if (!StringUtils.isEmpty(value)) {
            User user = JSON.parseObject(value, User.class);
            if (user != null) {
                return user;
            }
        }

        // redis 没有，从数据库查询
        Optional<User> optional = userRepository.findById(id);
        User user = optional.isPresent() ? optional.get() : null;

        // 将对象存储到 redis
        redisUtil.set(REDIS_USER_ID_KEY_PREFIX + id, JSON.toJSONString(user, SerializerFeature.WriteClassName));
        return user;
    }

    @Override
    public void insert(User user) {
        // 新增
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        // 更新
        userRepository.save(user);

        // 删除 redis 的
        redisUtil.del(REDIS_USER_ID_KEY_PREFIX + user.getId());
    }

    @Override
    public void deleteById(Long id) {
        //注意：必须先删除数据库的，再删除 redis 的
        // 删除数据库的
        userRepository.deleteById(id);

        //删除 redis 的
        redisUtil.del(REDIS_USER_ID_KEY_PREFIX + id);
    }
}
