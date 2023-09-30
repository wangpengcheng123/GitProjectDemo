package com.wang.controller;

import com.wang.exception.MyException;
import com.wang.po.TSubject;
import com.wang.po.TUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Api(tags = {"这是FirstGitController类的信息"})
public class FirstGitController {

    @GetMapping("/showGitData")
    @ApiOperation(value = "这是一个get请求，根据传入的参数来返回指定的字符串",notes = "名称")
    @ApiImplicitParams(
            value = {@ApiImplicitParam(name = "name",value = "用户名称",dataType = "String",required = true,defaultValue = "哈哈")}
    )
    public String showGitData(@RequestParam(value = "name",required = true,defaultValue = "哈哈") String name){
        System.out.println("aa");
        ArrayList<Integer> list = new ArrayList<>();
        if(list.size()==0){
            throw new MyException("出现了MyException异常","500");
        }
        return "这是一个get请求"+name;
    }



    @PostMapping("/showUser")
    @ApiOperation(value = "这是一个post请求，返回user信息",notes = "请求参数TSubject（这个是用来备注的）")
    @ApiImplicitParams(
            value = {@ApiImplicitParam(name = "subject",value = "学科实体",dataType = "TSubject")}
    )
    public TUser showUser(@RequestBody TSubject subject){
        TUser user=new TUser();
        user.setUserName("张三");
        user.setPassword("123456");
        return user;
    }


}
