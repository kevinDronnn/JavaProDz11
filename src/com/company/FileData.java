package com.company;

public class FileData {
    private String fileName;
    private byte fileSize;
    private String filePath;

    public FileData(String fileName, byte fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public byte getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
