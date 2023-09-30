package com.wang.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ApiModel("用户TUser")//给model添加信息
public class TUser implements Serializable {

    private static final long serialVersionUID = 7815979386063271686L;
    @ApiModelProperty("用户名")//给类中的属性添加注释
    private String userName;
    @ApiModelProperty("密码")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
