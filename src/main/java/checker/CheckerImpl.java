package checker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by oleh on 04.08.16.
 */
public class CheckerImpl implements Checker {
    private final String[] consoleArgs = {"-f", "-fy", "-st", "-sa", "-sy", "-l", "-o"};
    private ArrayList<String> resArgs = new ArrayList<String>();

    public ArrayList<String> checkInputParams(String[] args) throws IOException{
        for(String arg:args){
            if(arg.charAt(0) == '-' && !Arrays.asList(consoleArgs).contains(arg)){
                throw new IOException();
            }
            resArgs.add(arg);
        }
        return resArgs;
    }
}
