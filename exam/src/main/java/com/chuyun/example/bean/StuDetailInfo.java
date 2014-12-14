package com.chuyun.example.bean;

/**
 * Author:彭亮
 * Date:14-12-13
 * Time:下午2:34
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 */
public class StuDetailInfo {
    private int age;
    private Sex sex;
    private float height;
    private float weight;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public enum Sex {
       MALE,FEMALE
    }

}
