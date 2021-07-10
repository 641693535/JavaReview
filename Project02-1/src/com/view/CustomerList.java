package com.view;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 *              并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 * @Date 2021-05-26 16:49
 */
public class CustomerList {
    private Customer[] customers;//保存客户对象
    private int total = 0;//记录客户的数量

    public CustomerList(int totalCustomer) {//用来初始化Customers数组
        this.total = total;
        customers = new Customer[totalCustomer];
    }

    /**
     * @param customer
     * @return 添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer) {
        if (customer != null && total < this.customers.length) {
            this.customers[total++] = customer;
            return true;
        }
        return false;
    }

    /**
     * 用参数customer替换数组中由index指定的对象
     * @param index 指定所替换对象在数组中的位置，从0开始
     * @param cust 指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        }
        this.customers[index] = cust;
        return true;
    }

    /**
     * 从数组中删除参数index指定索引位置的客户对象记录
     * @param index 指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        this.total--;
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
        this.customers[total] = null;
        return true;
    }

    /**
     * 返回数组中记录的所有客户对象
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     */
    public Customer[] getAllCustomers() {
        return this.customers;
    }

    /**
     * 返回参数index指定索引位置的客户对象记录
     * @param index 指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index) {
        if (index >= 0 && index < total) {
            return this.customers[index];
        }
        else{
            return null;
        }
    }

    /**
     * @return 返回数组长度
     */
    public int getTotal() {
        return this.total;
    }
}
