package com.cycloneboy.springmvc.entity.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/28.
 */
public class Person implements Serializable{
    @NotBlank(message = "登录名不能为空")
    private String loginname;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Length(min = 6,max = 9,message ="密码长度必须在6位到9位之间" )
    private String password;

    private String sex;
    @Range(min = 15,max = 60,message = "年龄必须在15岁到60岁之间")
    private Integer age;
    @Email(message = "必须是合法的邮箱地址")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Past(message = "生日必须是过去的日期")
    private Date birthday;
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$",message = "无效的电话号码")
    private String phone;

    private MultipartFile image;
    private String pic;

    public Person() {
        super();
    }

    public Person(String loginname, String username, String password, String sex, Integer age, String email, Date
            birthday, String phone,String pic) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", pic'" + pic + '\'' +
                '}';
    }
}
