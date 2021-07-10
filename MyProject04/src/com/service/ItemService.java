package com.service;

import com.domain.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-20 15:16
 */
public class ItemService {

    Item[] items;
    private final int ITEMTOTAL = 6;//每一个题目占用的行数
    public final int TOTAL;//题目的数量

    /**
     * 将加载到内存中的题，每一题创建一个类，保存在items中。
     */
    public ItemService() {

        List<String> allTiMu = readTextFile("MyProject04\\Items.txt");
        TOTAL = allTiMu.size() / ITEMTOTAL;
        items = new Item[TOTAL];

        for (int i = 0; i < TOTAL; i++) {

            String tiMu = allTiMu.get(i * ITEMTOTAL);
            String[] xuanXiang = {
                    allTiMu.get(i * ITEMTOTAL + 1),
                    allTiMu.get(i * ITEMTOTAL + 2),
                    allTiMu.get(i * ITEMTOTAL + 3),
                    allTiMu.get(i * ITEMTOTAL + 4)
            };
            char daAn = allTiMu.get(i * ITEMTOTAL + 5).charAt(0);

            items[i] = new Item(tiMu, xuanXiang, daAn);

        }

    }

    /**
     * 将题目加载到内存中
     * @param filename
     * @return
     */
    private List<String> readTextFile(String filename) {

        BufferedReader br = null;
        ArrayList<String> arr = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(filename));

            String str;
            while ((str = br.readLine()) != null) {
                if(!"".equals(str.trim()))
                    arr.add(str);
            }
//            while ((len = br.read(cbuf)) != -1) {
////                System.out.println(new String(cbuf,0,len));
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arr;
    }

    /**
     * 返回指定Item对象
     * @param no
     * @return
     */
    public Item getItem(int no) {
        if (no <= 0 || no > TOTAL) {
            return null;
        }
        return items[no - 1];
    }

    /**
     * 保存用户答案到本地文件中
     */
    public void saveAnswer(char[] answer){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("MyProject04\\answer.dat"));

            oos.writeObject(answer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public char[] readAnswer() {
        ObjectInputStream ois = null;
        char[] c = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("MyProject04\\answer.dat"));

            c = (char[]) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return c;

    }
}
