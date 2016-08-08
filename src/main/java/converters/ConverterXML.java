package converters;

import java.io.StringWriter;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.util.Hashtable;

/**
 * Created by oleh on 03.08.16.
 */
public class ConverterXML extends Converter {
    public String getVelocityTemplate(){
        return "src/main/resources/templates/converterXml.ve";
    }
}
