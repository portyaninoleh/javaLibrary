package converters;

import java.util.HashMap;

/**
 * Created by oleh on 07.08.16.
 */
public class ConvertersFactory {
    private final HashMap<String, ? extends Converter> map = new HashMap<String, Converter>() {{
        put("xml", new ConverterXML());
        put("html", new ConverterHTML());
        put("txt", new ConverterTxt());
    }};

    public Converter getConverter(String type){
        return map.get(type);
    }
}
