package process.slicer;

import process.ProcessBooks;
import process.ProcessWithParams;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by oleh on 04.08.16.
 */
public class Slicer extends ProcessBooks {
    private int min;
    private int max;

    public ArrayList<Hashtable<String, String>> process(ArrayList<Hashtable<String, String>> books){
        return new ArrayList<Hashtable<String,String>>(books.subList(min, max));
    }

    public Slicer(){}

    public void setParams(String params){
        this.min = Integer.parseInt(params.split(",")[0]);
        this.max = Integer.parseInt(params.split(",")[1]);
    }

    public Slicer(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
