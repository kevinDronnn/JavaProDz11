package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<String, List<FileData>> list = new HashMap<>();
        FileNavigator fileNavigator = new FileNavigator(list);
        FileData file1 = new FileData("test1.txt", (byte)100, "/path/to/file");
        FileData file2 = new FileData("test2.txt", (byte)50, "/path/to/file");

        fileNavigator.addFile(file1, "/path/to/file");
        fileNavigator.addFile(file2, "/path/to/file");

        List<FileData> files = fileNavigator.find("/path/to/file");
        System.out.println(files);
        System.out.println(fileNavigator.filterBySize((byte)60));
        System.out.println(files = fileNavigator.sortBySize());


        FileData file3 = new FileData("test3.txt", (byte)50, "/another/path");
        fileNavigator.addFile(file3, "/path/to/file");

        fileNavigator.remove("/another/path");


    }
}
