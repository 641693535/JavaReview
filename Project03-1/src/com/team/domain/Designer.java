package com.team.domain;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:08
 */
public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getDetailsForTeam() {
        return getDetails() + "设计师\t" + getBonus();
    }

    @Override
    public String toString() {
        return super.getDetails() + "设计师\t" + getStatus().getName() + "\t" +
                bonus + "\t\t\t" + getEquipment().getDescription();
    }
}
