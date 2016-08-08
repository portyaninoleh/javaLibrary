package reader;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 03.08.16.
 */
public class ReaderImpl implements Reader {
    public ArrayList<Hashtable<String, String>> read(String filePath) throws IOException{
        CSVReader reader = null;
        ArrayList<Hashtable<String, String>> data = new ArrayList<Hashtable< String, String>>();
        try{
            reader = new CSVReader(new FileReader(filePath));
            String[] res;
            while ((res = reader.readNext()) != null){
                Hashtable<String, String> book = new Hashtable<String, String>();
                book.put("id", res[0]);
                book.put("udc", res[1]);
                book.put("isbn", res[2]);
                book.put("name", res[3]);
                book.put("author", res[4]);
                book.put("year", res[5]);
                data.add(book);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
