package com.startup.apidemo.service.impl;

/**
 * Service implementation class to handle all file related operations.
 * 
 * @author MBalakrishnan
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.startup.apidemo.model.File;
import com.startup.apidemo.service.IFileService;
import com.startup.apidemo.util.TemplateUtil;

@Service
public class FileServiceImpl implements IFileService {
    
    private final List<String> fileNames = Arrays.asList("Alpha.gif", "Beta.jpg", "Gamma.png");
   
    /**
     * Method to fetch the graphic file information based on the extension and first letter of the file name
     * @param fileNameStartsWith
     * @param fileExtension
     * @return String
     */
    @Override
    public String getGraphicFileNames(final String fileNameStartsWith, final String fileExtension) {
        List<File> graphicFilesList = new ArrayList<>();
        for(final String fileName : fileNames) {
            if(fileName.startsWith(fileNameStartsWith)) {
                for(File file : graphicFilesList) {
                    graphicFilesList.add(new File(file.getFileName(), file.getFileExtension(), file.getFileContent()));
                }
            }
        }
        return buildJson(graphicFilesList);
    }

    /**
     * Method to convert Java objects into Json using Free marker template.
     *  
     * @param graphicFilesList
     * @return json string
     */
    private String buildJson(List<File> graphicFilesList) {
        Map<String, Object> graphicFileNamesModel = new HashMap<>();
        graphicFileNamesModel.put("graphicFilesList", graphicFilesList);
        return TemplateUtil.processTemplate("graphicFileDetails.ftl", graphicFileNamesModel);
    }
}
