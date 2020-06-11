package com.startup.apidemo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RestController;

import com.startup.apidemo.service.IFileService;

/**
 * Entry point for all the Web service calls accessing File related operations
 * 
 * @author MBalakrishnan
 *
 */
@RestController
@Path("/file")
public class FileResource {

    private IFileService fileService;

    /**
     * End point to fetch file names based on the following params passed in. Extension is an optional param and handled via regular expression.

     * @param fileNameStartsWith
     * @param fileExtension
     * @return
     */
    @Path("/fileNameStartsWith/{fileNameStartsWith}{extension:(/extension/[^/]+?)?}")
    @GET
    public String getGraphicFile(@PathParam("fileNameStartsWith") final String fileNameStartsWith,
            @PathParam("extension") final String fileExtension) {
        return fileService.getGraphicFileNames(fileNameStartsWith, fileExtension);
    }
}
