package main;

import converters.Converter;
import converters.ConvertersFactory;
import org.apache.commons.cli.*;
import printer.Printer;
import printer.PrinterImpl;
import process.ProcessBooks;
import process.ProcessFactory;
import reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleh on 03.08.16.
 */
public class Application {

    public static void main(String... args){
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Options options = (Options) context.getBean("options");
        CommandLineParser parser = (DefaultParser) context.getBean("defaultParser");
        options.addOption("f", true, "csv file");
        options.addOption("fy", true, "Filter by Year");
        options.addOption("st", false, "Sort by title");
        options.addOption("sa", false, "Sort by author");
        options.addOption("sy", false, "Sort by year");
        options.addOption("l", true, "Limit");
        options.addOption("o", true, "Output format");
        ProcessFactory processFactory = (ProcessFactory) context.getBean("processFactory");
        Reader reader = (Reader) context.getBean("reader");
        try {
            CommandLine line = parser.parse(options, args);
            ArrayList<Hashtable<String, String>> data = reader.read(line.getOptionValue("f"));
            for(Option op:options.getOptions()){
                ProcessBooks processObj = processFactory.getProcessObj(op.getOpt(), op.hasArgs()?line.
                        getOptionValue(op.getOpt()): "");
                if(line.hasOption(op.getOpt())){
                    if(op.hasArg()) {
                        processObj.setParams(line.getOptionValue(op.getOpt()));
                    }
                    data = processObj.process(data);
                }
            }
            ConvertersFactory convertersFactory = (ConvertersFactory) context.getBean("convertersFactory");
            Converter converter = convertersFactory.getConverter(line.getOptionValue("o"));
            Printer printer = (PrinterImpl) context.getBean("printer");
            printer.print(converter.convert(data));
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
