package com.taide.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDemo02 {
    public static void main(String[] args) {
        //String s1 = “1,2,3,4,5,6,7,8.9,10,11,12,13,14,15”;//代表全部参与抽奖的人员编号
        //    String s2 =”2,5,6”;//代表已经中奖的人员编号
        //    int number = 3;
        //    写一个函数，从s1中随机筛选出number个数字，且此数字不在s2中。返回一个字符串。
        //    请理解好需求，假设s1是全公司人员编号，s2是一等奖中奖人员，现在是要抽取n个二等奖。
        //代表全部参与抽奖的人员编号
        String s1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        //代表已经中奖的人员编号
        String s2 = "2,5,6";
        String[] str1 = s1.split(",");
        String[] str2 = s2.split(",");
        int number = (int) (Math.random() * 10) + 1;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length; i++) {
            list.add(str1[i]);
            for (int j = 0; j < str2.length; j++) {
                if (str1[i].equals(str2[j])) {
                    list.remove(str1[i]);
                }
            }
        }
        System.out.println("一等奖中奖人员："+s2);
        System.out.println("二等奖在下面的人中抽："+list.toString());
        System.out.println("二等奖人数："+number);
        System.out.println("二等奖的人：");
        while (number >= 0) {
            Random r = new Random();
            int suiji = r.nextInt(number);
            System.out.print(list.get(suiji) + ",");
            list.remove(suiji);
            number--;
            if (number <= 0) {
                break;
            }
        }
    }

}
