package com.liuyanzhao.redis.controller;

import com.liuyanzhao.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 言曌
 * @date 2020-01-29 14:13
 */
@RestController
public class MainController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 测试添加
     * 访问 http://localhost:8080/testSet?key=name&value=zhangsan
      * @param key
     * @param value
     */
    @GetMapping("/testSet")
    public void testGet(@RequestParam("key") String key,
                        @RequestParam("value") String value) {
        redisUtil.set(key, value);
    }

    /**
     * 测试查询
     * 访问 http://localhost:8080/testGet?key=name
     * @param key
     */
    @GetMapping("/testGet")
    public String testGet(@RequestParam("key") String key) {
        return redisUtil.get(key);
    }
}
