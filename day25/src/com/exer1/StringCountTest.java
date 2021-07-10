package com.exer1;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-16 16:47
 */
public class StringCountTest {

    /**
     * 统计文档中每个字符出现的次数
     * @param args
     */
    public static void main(String[] args) {
        String txtFile = "day25\\dbcp.txt";

        StringCountTest sct = new StringCountTest();
        sct.strCount(txtFile, "day25\\newFile.txt");
    }

    public void strCount(String srcFile,String newFileName){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建一个无序的，不可重复的Map数组存放数据
            HashMap<Character, Integer> strCou = new HashMap<>();

            br = new BufferedReader(new FileReader(srcFile));

            int len;
            while ((len = br.read()) != -1) {
//                将字符转换成char
                char c = (char) len;
//                如果字符存在map中，则valu就+1，不存在就将value设置为1
                if (strCou.containsKey(c)) {
                    strCou.put(c, strCou.get(c) + 1);
                }else{
                    strCou.put(c, 1);
                }
            }
            //创建保存内容的文件
            bw = new BufferedWriter(new FileWriter(newFileName));
//            将map转换成entry
            Set set = strCou.entrySet();
            Iterator iterator = set.iterator();
//            遍历map，将map的数据写入到文档中
            while (iterator.hasNext()) {
                Map.Entry<Character,Integer> entry = (Map.Entry) iterator.next();
                //获取key和value
                Character key = entry.getKey();
                Integer value = entry.getValue();
                switch (key) {
                    case ' ':
                        bw.write("空格---->" + value);
                        break;
                    case '\t':
                        bw.write("制表符---->" + value);
                        break;
                    case '\n':
                        bw.write("换行---->" + value);
                        break;
                    case '\r':
                        bw.write("回车---->" + value);
                        break;
                    default:
                        bw.write(key + "---->" + value);
                        break;
                }
                bw.newLine();
            }
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
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void mapWriteFile(Map map,String newFileName){

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(newFileName,true));

            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character,Integer> entry = (Map.Entry) iterator.next();
                Character key = entry.getKey();
                Integer value = entry.getValue();
                switch (key) {
                    case ' ':
                        bw.write("空格---->" + value);
                        break;
                    case '\t':
                        bw.write("制表符---->" + value);
                        break;
                    case '\n':
                        bw.write("换行---->" + value);
                        break;
                    case '\r':
                        bw.write("回车---->" + value);
                        break;
                    default:
                        bw.write(key + "---->" + value);
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
