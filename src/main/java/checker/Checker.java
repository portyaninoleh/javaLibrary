package checker;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by oleh on 04.08.16.
 */
public interface Checker {
    ArrayList<String> checkInputParams(String[] args) throws IOException;
}
