/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Low Zi Qing
 */
public class MyFolder {

    private String folderName;
    private String folderDate;
    private String folderUploadDirectory;
    private String folderJSONDirectory;
    

    public MyFolder(String folderName, String folderDate, String folderUploadDirectory, String folderJSONDirectory) {
        this.folderName = folderName;
        this.folderDate = folderDate;
        this.folderUploadDirectory = folderUploadDirectory;
        this.folderJSONDirectory = folderJSONDirectory;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderDate() {
        return folderDate;
    }

    public void setFolderDate(String folderDate) {
        this.folderDate = folderDate;
    }

    public String getFolderUploadDirectory() {
        return folderUploadDirectory;
    }

    public void setFolderUploadDirectory(String folderUploadDirectory) {
        this.folderUploadDirectory = folderUploadDirectory;
    }

    public String getFolderJSONDirectory() {
        return folderJSONDirectory;
    }

    public void setFolderJSONDirectory(String folderJSONDirectory) {
        this.folderJSONDirectory = folderJSONDirectory;
    }

   
}
