package com.team.domain;

import com.team.service.Status;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:08
 */
public class Programmer extends Employee{
    private int memberId;//成员加入开发团队后在团队中的ID
    private Status status = Status.FREE;
    private Equipment equipment;//表示该成员领用的设备

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getDetailsForTeam() {
        return getDetails() + "程序员";
    }

    @Override
    public String toString() {
        return super.toString() + "程序员\t" + status.getName() + "\t\t\t\t\t" + equipment.getDescription();
    }
}
