package process;

import process.filter.FilterYear;
import process.slicer.Slicer;
import process.sort.SortAuthor;
import process.sort.SortTitle;
import process.sort.SortYear;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleh on 07.08.16.
 */
public class ProcessFactory {
    private final HashMap<String, ? extends ProcessBooks> map = new HashMap<String, ProcessBooks>(){{
        put("f", new EmptyProcess());
        put("fy", new FilterYear());
        put("st", new SortTitle());
        put("sa", new SortAuthor());
        put("sy", new SortYear());
        put("l", new Slicer());
        put("o", new EmptyProcess());
    }};

    public ProcessFactory(){}

    public ProcessBooks getProcessObj(String objType, String params){
        ProcessBooks obj = map.get(objType);
        System.out.print(params + "\n");
        if(!params.equals("")){
            obj.setParams(params);
        }
        return obj;
    }
}
