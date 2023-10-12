package com.company;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("test1.txt");
        HashMap<String,FileData> list = new HashMap<>();
        FileNavigator fileNavigator = new FileNavigator(list);
        fileNavigator.addFile(list, file);
        System.out.println(fileNavigator.find("test1.txt",list));
        System.out.println(fileNavigator.filterBySize((byte) 60,list));
        fileNavigator.remove("test1.txt",list);
    }
}
