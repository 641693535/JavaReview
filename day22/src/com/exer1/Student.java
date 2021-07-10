package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-10 22:16
 */
public class Student implements Comparable{
    private String name;
    private int score;
    private int id;
    private int count = 1001;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            return -(this.getScore() - s.getScore());
        }
        throw new RuntimeException("传入的类型不匹配！");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                ", count=" + count +
                '}';
    }
}
