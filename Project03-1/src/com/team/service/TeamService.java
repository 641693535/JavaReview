package com.team.service;

import com.team.domain.Architect;
import com.team.domain.Designer;
import com.team.domain.Employee;
import com.team.domain.Programmer;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:07
 */
public class TeamService {
    private static int counter = 1;//团队成员id
    private final int MAX_MEMBER = 5;//开发团队最大成员
    private Programmer[] team = new Programmer[MAX_MEMBER];//团队
    private int total = 0;//实际成员人数

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 添加指定的成员
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("添加失败,成员已满!");
        } else if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        Programmer p = (Programmer) e;
        if (isInThere(p)) {
            throw new TeamException("该成员已在本开发团队中！");
        } else if ("BUSY".equals(p.getStatus().getName())) {
            throw new TeamException("该成员已存在其他团队中!");
        } else if ("VOCATION".equals(p.getStatus().getName())) {
            throw new TeamException("该成员正在休假中！");
        }
        int programmerTotal = 0;//工程师人数
        int designerTotal = 0;//设计师人数
        int architectTotal = 0;//架构师人数
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect) {
                architectTotal++;
            }else if(team[i] instanceof Designer) {
                designerTotal++;
            }else if(team[i] instanceof Programmer){
                programmerTotal++;}
        }

        if (p instanceof Architect) {
            if(architectTotal >= 1) throw new TeamException("架构师已存在一名！");
        } else if (p instanceof Designer) {
            if(designerTotal >= 2) throw new TeamException("设计师已存在两名！");
        } else if (p instanceof Programmer) {
            if (programmerTotal >= 3) throw new TeamException("程序员已存在三名！");
        }

        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * 返回成员是否存在于本团队中
     * @param p
     * @return
     */
    public boolean isInThere(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除指定Memberid的成员
     * @param memberId
     * @throws TeamException
     */
    public void removeMember(int memberId) throws TeamException {
        int temp = 0;
        //查找是否存在于团队中
        for (int i = 0; i < total; i++) {
            System.out.println(team[i].getMemberId());
            if (team[i].getMemberId() == memberId) {
                temp = i;
                break;
            }
        }
        if (temp == 0) {
            throw new TeamException("MemberId不存在！");
        }

        //设置成员为FREE
        team[temp].setStatus(Status.FREE);
        //遍历前移成员
        for (int i = temp; i < total - 1; i++) {
            team[i] = team[i + 1];
        }
        //删除成员
        team[--total] = null;
    }
}
