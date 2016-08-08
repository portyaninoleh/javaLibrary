package process.filter;

import process.ProcessBooks;
import process.ProcessWithParams;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 04.08.16.
 */
public class FilterYear extends ProcessBooks{
    private ArrayList<Hashtable<String, String>> filtered = new ArrayList<Hashtable<String, String>>();
    private String year;

    public FilterYear(){}

    public FilterYear(String year){
        this.year = year;
    }

    public FilterYear(int year){
        this.year = "" + year;
    }

    public void setParams(String params){
        this.year = params;
    }

    public ArrayList<Hashtable<String, String>> process(ArrayList<Hashtable<String, String>> books){
        for(Hashtable<String, String> book:books){
            if(book.get("year").replaceAll(" ", "").equals(year)){
                filtered.add(book);
            }
        }
        return filtered;
    }
}
