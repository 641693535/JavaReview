package com.exer;

import java.util.List;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-13 18:55
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> DAO = new DAO<>();

        DAO.save("1001", new User(1001, 18, "小明"));
        DAO.save("1002", new User(1002, 34, "张三"));
        DAO.save("1003", new User(1003, 18, "小红"));

        User user = DAO.get("1003");
        System.out.println(user);

        DAO.update("1003", new User(1003, 29, "张强"));

        System.out.println("**********************");
        List<User> list = DAO.list();
        for (User u : list) {
            System.out.println(u);
        }

        System.out.println("**********************");
        DAO.delete("1002");
        list = DAO.list();
        for (User u : list) {
            System.out.println(u);
        }
    }

}
