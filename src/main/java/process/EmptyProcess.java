package process;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 07.08.16.
 */
public class EmptyProcess extends ProcessBooks {
    public ArrayList<Hashtable<String, String>> process(ArrayList<Hashtable<String, String>> books){
        return books;
    }
}
