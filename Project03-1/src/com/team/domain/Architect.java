package com.team.domain;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 18:08
 */
public class Architect extends Designer {
    private int stock;//股票数量

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetailsForTeam() {
        return getDetails() + "架构师\t" + getBonus() + "\t" + stock;
    }

    @Override
    public String toString() {
        return super.getDetails() + "架构师\t" + getStatus().getName() + "\t" + getBonus() +
                "\t" + stock + "\t" + getEquipment().getDescription();
    }
}
