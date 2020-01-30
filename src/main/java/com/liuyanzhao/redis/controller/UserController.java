package com.liuyanzhao.redis.controller;

import com.liuyanzhao.redis.entity.User;
import com.liuyanzhao.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author 言曌
 * @date 2020-01-29 14:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
//    @Qualifier(value = "userServiceImpl")
    @Qualifier(value = "userServiceImpl2")
    private UserService userService;


    /**
     * 根据用户ID获得用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @PostMapping
    public void insert(@RequestBody User user) {
        userService.insert(user);
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @PutMapping
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
