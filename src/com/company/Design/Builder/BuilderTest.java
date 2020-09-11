package com.company.Design.Builder;

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new Builder().setName("lxh").setSex(1).setAge(18);
        System.out.println(builder);
    }
}

class Builder {
    String name;
    int age;
    int sex;

    public Builder setName(String name){
        this.name = name;
        return this;
    }
    public Builder setAge(int age){
        this.age = age;
        return this;
    }
    public Builder setSex(int sex){
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
