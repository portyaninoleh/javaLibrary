package process.filter;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 04.08.16.
 */
public interface Filter {
    ArrayList<Hashtable<String, String>> filter(ArrayList<Hashtable<String, String>> books);
}
