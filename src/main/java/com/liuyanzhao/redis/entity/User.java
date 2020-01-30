package com.liuyanzhao.redis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 言曌
 * @date 2020-01-29 14:23
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 6147345506206285446L;


    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    private Long id;

    private String username;

    private String nickname;

    private String email;

    @JsonIgnore
    private String password;
}
