package converters;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 03.08.16.
 */
public abstract class Converter {
    public String convert(ArrayList<Hashtable<String, String>> args){
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template template = ve.getTemplate(getVelocityTemplate());
        VelocityContext context = new VelocityContext();
        context.put("books", args);
        StringWriter stringWriter = new StringWriter();
        template.merge(context, stringWriter);
        return stringWriter.toString();
    }

    public abstract String getVelocityTemplate();
}
