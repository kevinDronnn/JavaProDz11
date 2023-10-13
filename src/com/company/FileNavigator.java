package com.company;

import java.io.IOException;
import java.util.*;

public class FileNavigator {

    private HashMap<String, List<FileData>> list;

    public FileNavigator(HashMap<String, List<FileData>> list) {
        this.list = list;
    }

    public void addFile(FileData fileData, String path) throws IOException {
        if (!fileData.getFilePath().equals(path)) {
            System.out.println("Wrong path");
        }
        list.putIfAbsent(path, new ArrayList<>());
        list.get(path).add(fileData);
    }

    public List<FileData> find(String path) {
        List<FileData> list2 = new ArrayList<>();
        return list.getOrDefault(path, list2);
    }

    public List<FileData> filterBySize(byte size) {

        List<FileData> resultList = new ArrayList<>();
        for (List<FileData> fileList : list.values()) {
            for (FileData file : fileList) {
                if (file.getFileSize() <= size) {
                    resultList.add(file);
                }
            }
        }
        return resultList;
    }

    public void remove(String path) {
        list.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortedList = new ArrayList<>();
        for (List<FileData> fileList : list.values()) {
            sortedList.addAll(fileList);
        }
        sortedList.sort(Comparator.comparing(num -> num.getFileSize()));
        return sortedList;
    }
}
