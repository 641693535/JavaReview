package com.view;


/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @Date 2021-05-26 16:49
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(3);

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

    /**
     * 显示主菜单
     */
    public void enterMainMenu() {
        boolean loopFlag = true;
        while (loopFlag) {
            System.out.println("-----------------客户信息管理软件-----------------\n");
            System.out.println("\t\t1 添 加 客 户");
            System.out.println("\t\t2 修 改 客 户");
            System.out.println("\t\t3 删 除 客 户");
            System.out.println("\t\t4 客 户 列 表");
            System.out.println("\t\t5 退       出\n");
            System.out.print("请选择(1-5):");
            char c = CMUtility.readMenuSelection();
            switch (c) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCusomers();
                    break;
                case '5':
                    System.out.print("请确认是否退出(Y/N)：");
                    char c1 = CMUtility.readConfirmSelection();
                    if (c1 == 'Y') {
                        loopFlag = false;
                        System.out.println("退出成功~！");
                    }
                    break;
            }
        }
    }

    /**
     * 添加客户
     */
    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(5);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);
        Customer customer = new Customer(name, age, gender, phone, email);
        if (customerList.addCustomer(customer)) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("---------------------添加失败---------------------");
        }

    }

    /**
     * 修改客户
     */
    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出):");
        int replaceNum = CMUtility.readInt();
        if (replaceNum == -1) {
            return;
        } else if (replaceNum > customerList.getTotal()) {
            System.out.println("无法找到指定客户！");
            return;
        }
        Customer customer = customerList.getCustomer(replaceNum - 1);
        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(5, customer.getName());
        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(15, customer.getPhone());
        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(30, customer.getEmail());
        Customer newCustomer = new Customer(name, age, gender, phone, email);
        if (customerList.replaceCustomer(replaceNum - 1, newCustomer)) {
            System.out.println("---------------------修改完成---------------------\n");
        }else{
            System.out.println("---------------------修改失败---------------------\n");
        }

    }

    /**
     * 删除客户
     */
    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待删除客户编号(-1退出):");
        int i = CMUtility.readInt();
        if (i == -1) {
            return;
        } else if (i > customerList.getTotal()) {
            System.out.println("无法找到指定客户！");
            return;
        }
        System.out.print("确认是否删除(Y/N):");
        if (CMUtility.readConfirmSelection() == 'N') {
            return;
        }
        if (customerList.deleteCustomer(i - 1)) {
            System.out.println("---------------------删除完成---------------------");
        } else {
            System.out.println("---------------------删除失败---------------------");
        }
    }

    /**
     * 展示客户列表
     */
    private void listAllCusomers() {
        System.out.println("---------------------------客户列表---------------------------");
        if (customerList.getTotal() <= 0) {
            System.out.println("没有客户信息！");
        }else {
            System.out.println("编号\t姓名\t\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] allCustomers = customerList.getAllCustomers();
            for (int i = 0; i < customerList.getTotal(); i++) {
                System.out.print(i + 1 + "\t\t");
                System.out.print(allCustomers[i].getName() + "\t\t");
                System.out.print(allCustomers[i].getGender() + "\t\t");
                System.out.print(allCustomers[i].getAge() + "\t\t");
                System.out.print(allCustomers[i].getPhone() + "\t\t");
                System.out.println(allCustomers[i].getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------\n");
    }
}
