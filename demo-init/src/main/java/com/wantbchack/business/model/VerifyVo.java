package com.wantbchack.business.model;


import javax.validation.constraints.*;


/**
 * Create by  fanxiaobin
 * Date 2022/6/20  14:18
 * Description
 */
public class VerifyVo {

    @NotBlank(message = "名称不能为空!")
    private String name;

    private Integer sex;

    @Min(value = 1 ,message = "年龄不能小于1")
    private Integer  age;

    @NotBlank(message = "手机号码不能为空!")
    private String mobile;

    @NotEmpty(message = "电子邮箱不能为空!")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "VerifyVo{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
