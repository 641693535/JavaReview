package com.view;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description Customer为实体对象，用来封装客户信息
 * @Date 2021-05-26 16:49
 */
public class Customer {
    private String name;//姓名
    private int age;//年龄
    private char gender;//性别
    private String phone;//电话
    private String email;//邮箱

    public Customer() {
    }

    public Customer(String name, int age, char gender, String phone, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
