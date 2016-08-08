package process.sort;

import process.ProcessBooks;

import java.util.*;

/**
 * Created by oleh on 04.08.16.
 */
public class SortTitle extends ProcessBooks {

    public ArrayList<Hashtable<String, String>> process(ArrayList<Hashtable<String, String>> books){
        Collections.sort(books, new Comparator<Hashtable<String, String>>() {
            public int compare(Hashtable<String, String> o1, Hashtable<String, String> o2) {
                return o1.get("name").compareTo(o2.get("name"));
            }
        });
        return books;
    }
}
