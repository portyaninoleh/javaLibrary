package process;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 04.08.16.
 */
public abstract class ProcessBooks {
    public abstract ArrayList<Hashtable<String, String>> process(ArrayList<Hashtable<String, String>> books);

    public void setParams(String params){};
}
