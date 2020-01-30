package com.liuyanzhao.redis.service.impl;

import com.liuyanzhao.redis.entity.User;
import com.liuyanzhao.redis.repository.UserRepository;
import com.liuyanzhao.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Redis缓存方法二：通过 @Cacheable、@CacheEvict 注解实现 操作，需要开启缓存 @EnableCaching
 *
 * @author 言曌
 * @date 2020-01-29 14:23
 */
@Service
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "user", key = "'id-'+#id")
    public User findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = optional.isPresent() ? optional.get() : null;
        return user;
    }

    @Override
    public void insert(User user) {
        // 新增
        userRepository.save(user);
    }

    @Override
    @CacheEvict(value = "user", key = "'id-'+#user.id")
    public void update(User user) {
        // 更新
        userRepository.save(user);
    }

    @Override
    @CacheEvict(value = "user", key = "'id-'+#id")
    public void deleteById(Long id) {
        // 删除数据库的
        userRepository.deleteById(id);
    }
}
