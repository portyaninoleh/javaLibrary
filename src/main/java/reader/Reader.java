package reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 03.08.16.
 */
public interface Reader {
    ArrayList<Hashtable<String, String>> read(String filePath) throws IOException;
}
