package com.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-20 15:34
 */
public class Item implements Serializable {

    String tiMu;
    String[] xuanxiang;
    char daAn;

    public Item(String tiMu, String[] xuanxiang, char daAn) {
        this.tiMu = tiMu;
        this.xuanxiang = xuanxiang;
        this.daAn = daAn;
    }

    public String getTiMu() {
        return tiMu;
    }

    public void setTiMu(String tiMu) {
        this.tiMu = tiMu;
    }

    public String[] getXuanxiang() {
        return xuanxiang;
    }

    public void setXuanxiang(String[] xuanxiang) {
        this.xuanxiang = xuanxiang;
    }

    public char getDaAn() {
        return daAn;
    }

    public void setDaAn(char daAn) {
        this.daAn = daAn;
    }

    @Override
    public String toString() {
        return "Item{" +
                "tiMu='" + tiMu + '\'' +
                ", xuanxiang=" + Arrays.toString(xuanxiang) +
                ", daAn=" + daAn +
                '}';
    }
}
