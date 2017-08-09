package com.hwangfantasy.beautify.impl;

import de.hunsicker.jalopy.Jalopy;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by hwangfantasy on 2017/8/9.
 * 采用jalopy进行java格式化
 */
public class BeautifyJava {
    private static final String PATH = System.getProperty("user.dir") + File.separator + "beautifyJava.txt";


    public static String beautifyJava(String sourceJava) {
        Jalopy jalopy = new Jalopy();

        File file = new File(PATH);

        // specify input and output target
        jalopy.setInput(sourceJava, PATH);
        jalopy.setOutput(file);

        // format and overwrite the given input file
        jalopy.format();

        if (jalopy.getState() == Jalopy.State.OK)
            System.out.println(file + " successfully formatted");
        else if (jalopy.getState() == Jalopy.State.WARN)
            System.out.println(file + " formatted with warnings");
        else if (jalopy.getState() == Jalopy.State.ERROR)
            System.out.println(file + " could not be formatted");

        if (jalopy.getState() == Jalopy.State.OK || jalopy.getState() == Jalopy.State.WARN) {
            try {
                String outPut = FileUtils.readFileToString(new File(PATH));
                return outPut;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("exception:" + e.getMessage());
            }
        }
        return "";
    }
}
