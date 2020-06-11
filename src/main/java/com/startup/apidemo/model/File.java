package com.startup.apidemo.model;

/**
 * Model to hold File related attributes 
 * 
 * @author MBalakrishnan
 *
 */
public class File {

    private String fileName;
    private String fileExtension;
    private String fileContent;

    public File(final String fileName, final String fileExtension, final String fileContent) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileContent = fileContent;
    }
    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
    /**
     * @return the fileExtension
     */
    public String getFileExtension() {
        return fileExtension;
    }
    /**
     * @param fileExtension the fileExtension to set
     */
    public void setFileExtension(final String fileExtension) {
        this.fileExtension = fileExtension;
    }
    /**
     * @return the fileContent
     */
    public String getFileContent() {
        return fileContent;
    }
    /**
     * @param fileContent the fileContent to set
     */
    public void setFileContent(final String fileContent) {
        this.fileContent = fileContent;
    }
    
    
}
