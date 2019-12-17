package com.taide.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestDemo01 {
   /* 使用递归方法，遍历D盘(也可以更换成别的目录，效果达到即可)下全部的文件（包括子文件夹下的文件），
    输出文件路径，文件修改时间，文件按修改时间倒序排列。*/
    public static void main(String[] args) {
        String roots = Arrays.toString(File.listRoots());
        if (roots.contains("D:\\")) {
            System.out.println("有D盘，正在执行遍历操作");
        }
        File file = new File("D:\\");
        digui(file);
    }
     public static void digui(File file){
        //判断该文件是否存在
        if (file.exists()){
            //返回该文件下的所有文件对象
            File[] listFiles = file.listFiles();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (listFiles==null){
                System.out.println("文件夹下无目录!");
            }else {
                //排序降序
                Arrays.sort(listFiles, new Comparator<File>() {
                    //排序的方法
                    public int compare(File f1, File f2) {
                        long time = f1.lastModified() - f2.lastModified();
                        if (time < -1) {
                            //控制排序规则
                            return 1;
                        } else if (time == 0) {
                            return 0;
                        } else {
                            //控制排序规则
                            return -1;
                        }

                    }
                    public boolean equals(Object obj) {
                        return true;
                    }
                });
                for (File file1 : listFiles) {
                    String fileDate1 = date.format(file1.lastModified());
                    //判断该文件是否是一个文件夹
                    if (file1.isDirectory()) {
                        System.out.println("文件夹:" + file1.getAbsolutePath());
                        System.out.println("文件夹修改时间" + fileDate1);
                        digui(file1);
                    } else {
                        System.out.println("文件:" + file1.getAbsolutePath());
                        System.out.println("文件修改时间" + fileDate1);
                    }
                }
            }
        }else{
            System.out.println("文件不存在！");
        }


     }
}
