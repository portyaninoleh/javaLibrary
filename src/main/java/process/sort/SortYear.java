package process.sort;

import process.ProcessBooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

/**
 * Created by oleh on 04.08.16.
 */
public class SortYear extends ProcessBooks {

    public ArrayList<Hashtable<String, String>> process(ArrayList<Hashtable<String, String>> books){
        Collections.sort(books, new Comparator<Hashtable<String, String>>() {
            public int compare(Hashtable<String, String> o1, Hashtable<String, String> o2) {
                return o1.get("year").compareTo(o2.get("year"));
            }
        });
        return books;
    }
}
