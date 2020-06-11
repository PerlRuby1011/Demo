package com.startup.apidemo.util;

/**
 * Util to convert Map to json sting util the passed the free marker template
 * 
 * @author MBalakrishnan
 */
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class TemplateUtil {

    private TemplateUtil() {
    }

    public static String processTemplate(final String templateName, final Map<String, Object> data) {
        final StringWriter writer = new StringWriter();
        if (data == null) {
            data = new HashMap<>();
        }
        try {
            Type.REST_RESPONSE.config.getTemplate(templateName).process(data, writer);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return writer.toString();
    }

    public enum Type {
        REST_RESPONSE("/template");
        private Configuration config = new Configuration(Configuration.VERSION_2_3_23);

        private Type(final String templateFolder) {
            config.setDefaultEncoding("UTF-8");
            config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            config.setClassForTemplateLoading(TemplateUtil.class, templateFolder);
            config.setLocale(Locale.US);
        }
    }
}
