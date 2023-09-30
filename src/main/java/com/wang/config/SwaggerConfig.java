package com.wang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启swagger,此时可以进入swagger-ui的页面
// http://localhost:8771/swagger-ui.html可以访问swagger-ui的控制页，面这个是2.0版本
public class SwaggerConfig {
    //配置了swagger的 docket实例，想多配置几个组时，多配置几个docket就可以了
    @Value("${swagger.isenable}")//获取配置环境中的参数，来控制swagger-ui是否要启用
    private boolean isEnable;
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profile=Profiles.of("dev");
        //environment.acceptsProfiles(profile)判断当前环境是否是profiles设定的环境中
        //是的话会返回true,否则为false,这个也可以用来开启和关闭swagger-ui
        boolean isflag=environment.acceptsProfiles(profile);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("firstGroup")
                //enable是否开启swagger-ui界面
                .enable(isEnable)
                .select()
                //basePackage配置要扫描swagger信息的包
                //any()全部扫描
                //none()不扫描
                //withMethodAnnotation()扫描方法上的注解
                //withClassAnnotation()扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.wang.controller"))
                //paths过滤什么路径
                //ant()里面接要扫描的路径
                .paths(PathSelectors.any())
                .build();
    }

    //配置页面信息，比如title，名称 ，邮箱等
    public ApiInfo apiInfo(){
        return new ApiInfo("MySwagger", "MyFirstSwagger", "1.0", "urn:tos",
                new Contact("汪鹏程", "http://localhost:8087/hellpSwagger", "389376976@qq.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    }

    //配置多个分组，只需要配置多个docket就可以
    @Bean
    public Docket docket2(Environment environment){
        //设置要显示的swagger环境
        Profiles profile=Profiles.of("dev");
        //environment.acceptsProfiles(profile)判断当前环境是否是profiles设定的环境中
        //是的话会返回true,否则为false,这个也可以用来开启和关闭swagger-ui
        boolean isflag=environment.acceptsProfiles(profile);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("twoGroup")
                //enable是否开启swagger-ui界面
                .enable(isEnable)
                .select()
                //basePackage配置要扫描swagger信息的包
                //any()全部扫描
                //none()不扫描
                //withMethodAnnotation()扫描方法上的注解
                //withClassAnnotation()扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.java.controller"))
                //paths过滤什么路径
                //ant()里面接要扫描的路径
                .paths(PathSelectors.any())
                .build();
    }

}
