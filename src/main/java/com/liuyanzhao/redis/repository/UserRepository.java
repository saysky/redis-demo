package com.liuyanzhao.redis.repository;

import com.liuyanzhao.redis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 言曌
 * @date 2020-01-29 15:24
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
