package com.liuyanzhao.redis.service;

import com.liuyanzhao.redis.entity.User;

/**
 * @author 言曌
 * @date 2020-01-29 14:22
 */
public interface UserService {

    /**
     * 根据用户ID获得用户
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 添加
     * @param user
     */
    void insert(User user);

    /**
     * 添加
     * @param user
     */
    void update(User user);


    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(Long id);
}
