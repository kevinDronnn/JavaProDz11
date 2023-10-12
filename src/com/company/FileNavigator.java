package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileNavigator {

    private HashMap<String, FileData> list;

    public FileNavigator(HashMap<String, FileData> list) {
        this.list = list;
    }

    public void addFile(HashMap<String, FileData> list , File file) throws IOException {
        if(!file.createNewFile()){
            FileData fileData = new FileData(file.getName() , (byte) file.length() , file.getPath());
            list.put(file.getPath() , fileData);
        }
    }

    public List<FileData> find(String path, HashMap<String, FileData> list) {


        List<FileData> fileData = new ArrayList<>();
        for (Map.Entry<String, FileData> entry : list.entrySet()) {
            if (entry.getKey().equals(path)) {
                fileData.add(entry.getValue());
            }
        }
        return fileData;
    }

    public List<FileData> filterBySize(byte size, HashMap<String,FileData> list) {
        List<FileData> fileData = new ArrayList<>();
        for (Map.Entry<String, FileData> entry : list.entrySet()) {
            if (entry.getValue().getFileSize() <= size) {
                fileData.add(entry.getValue());
            }
        }
        return fileData;
    }

    public void remove(String path, HashMap<String, FileData> list) {
        File file = new File(path);
        for (Map.Entry<String, FileData> entry : list.entrySet()) {
            if (entry.getKey().equals(path)) {
                list.remove(path);
                file.delete();
            }
        }
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "list=" + list +
                '}';
    }


}
