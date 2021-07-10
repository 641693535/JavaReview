package com.team.view;

import com.team.domain.Employee;
import com.team.domain.Programmer;
import com.team.service.NameListService;
import com.team.service.TeamException;
import com.team.service.TeamService;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:07
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    /**
     * 主界面显示和方法控制
     */
    public void enterMainMenu() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            listAllEmployees();
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.print("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择(1-4)：");
            char c = TSUtility.readMenuSelection();
            switch (c) {
                case '1':
                    getTeam();
                    TSUtility.readReturn();
                    break;
                case '2':
                    try {
                        addMember();
                    } catch (TeamException e) {
                        System.out.println("添加失败，原因：" + e.getMessage());
                    }
                    TSUtility.readReturn();
                    break;
                case '3':
                    deleteMember();
                    TSUtility.readReturn();
                    break;
                case '4':
                    System.out.print("请确认是否退出(Y/N)：");
                    char isEx = TSUtility.readConfirmSelection();
                    if (isEx == 'Y') {
                        isExit = false;
                        System.out.println("退出成功！~");
                    }
                    break;
            }

        }


    }

    /**
     * 以表格形式列出公司所有员工
     */
    private void listAllEmployees() {
        Employee[] all = listSvc.getAllEmployees();
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }

    }

    /**
     * 显示团队成员列表
     */
    private void getTeam(){
        System.out.println("--------------------团队成员列表---------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team.length <= 0) {
            System.out.println("暂无团队成员");
        }else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println("  " + team[i].getMemberId() + "/" + team[i].getDetailsForTeam());
            }
        }
        System.out.println("-----------------------------------------------------");

    }

    /**
     * 实现添加成员操作
     */
    private void addMember() throws TeamException {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        Employee e = listSvc.getEmployee(id - 1);
        teamSvc.addMember(e);
        System.out.println("添加成功");
    }

    /**
     * 实现删除成员操作
     */
    private void deleteMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int tid = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char isNo = TSUtility.readConfirmSelection();
        if (isNo == 'N') {
            return;
        }
        try {
            teamSvc.removeMember(tid);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }


    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
