package com.youmo.huang.bean;



import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author 2257
 * @date 2020/4/25 - 14:53
 */
public class User {

    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    @Length(min = 2,max = 6, message = "密码长度必须为2-6个字符")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
