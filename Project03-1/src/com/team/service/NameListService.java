package com.team.service;

import com.team.domain.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:07
 */
public class NameListService {
    private Employee[] employees;//所有员工

    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
//            System.out.println(Data.EMPLOYEES[i][0]);
            //获取data中员工的类别
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment eq;
            int bonus;
            switch (type) {
                case Data.EMPLOYEE:
                    Employee employee = new Employee(id, name, age, salary);
                    employees[i] = employee;
                    break;
                case Data.PROGRAMMER:
                    eq = createEquiment(i);
                    Programmer programmer = new Programmer(id, name, age, salary, eq);
                    employees[i] = programmer;
                    break;
                case Data.DESIGNER:
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    eq = createEquiment(i);
                    Designer designer = new Designer(id, name, age, salary, eq, bonus);
                    employees[i] = designer;
                    break;
                case Data.ARCHITECT:
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    eq = createEquiment(i);
                    Architect architect = new Architect(id, name, age, salary, eq, bonus, stock);
                    employees[i] = architect;
                    break;
            }
        }
    }

    public Equipment createEquiment(int id){
        int type = Integer.parseInt(Data.EQUIPMENTS[id][0]);
        String model = Data.EQUIPMENTS[id][1];
        switch (type) {
            case Data.PC:
                String display = Data.EQUIPMENTS[id][2];
                PC pc = new PC(model, display);
                return pc;
            case Data.NOTEBOOK:
                int price = Integer.parseInt(Data.EQUIPMENTS[id][2]);
                NoteBook noteBook = new NoteBook(model, price);
                return noteBook;
            case Data.PRINTER:
                String tp = Data.EQUIPMENTS[id][2];
                Printer printer = new Printer(model, tp);
                return printer;
        }
        return null;
    }

    /**
     * 返回指定员工
     * @param id
     * @return
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException{
        if (id >= employees.length || id < 0) {
            throw new TeamException("输入的id不存在");
        }
        return employees[id];
    }

    /**
     * 返回所有员工列表
     * @return
     */
    public Employee[] getAllEmployees() {
        return employees;
    }
}
