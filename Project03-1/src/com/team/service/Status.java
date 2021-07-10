package com.team.service;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:21
 */
//public class Status {
//    private String name;
//    public static final Status FREE = new Status("FREE");
//    public static final Status BUSY = new Status("BUSY");
//    public static final Status VOCATION = new Status("VOCATION");
//
//    private Status(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "Status{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
public enum Status{
    FREE("FREE"),
    BUSY("BUSY"),
    VOCATION("VOCATION");

    private final String name;
    private Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "name='" + name + '\'' +
                '}';
    }
}