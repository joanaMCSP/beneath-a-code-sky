package org.bootcamp.hackathon.beneaththecodesky.terminal;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Paulo Pereira on 24/03/16.
 */
public class Parser {

    /**
     * @author Filipe Jorge.
     * At <Academia de Código_> on 24/03/16.
     * <p/>
     * <p/>
     * isolates Object and Method from a String
     */

    public static void main(String[] args) {
        Parser parser = new Parser();
        String[] resultingParse;
        resultingParse = parser.parseLine("    door.open  \n");
        System.out.println("obj " + resultingParse[0]);
        System.out.println("method " + resultingParse[1]);
    }


    public String[] parseLine(String input) {
        String[] result = new String[2];

        //clean begin and end whitespaces
        input = input.trim();

        Scanner inputReader = new Scanner(input);
        //put '.' as token delimiter to this Scanner
        inputReader.useDelimiter("\\.");

        result[0] = getObject(inputReader);
        result[1] = getMethod(inputReader);

        return result;
    }


    private String getObject(Scanner inputReader) {
        String result = null;

        Pattern pattern = Pattern.compile("\\w*");

        //catch object name
        if (inputReader.hasNext(pattern)) {
            result = inputReader.next("\\w*");
        }
        return result;
    }


    private String getMethod(Scanner inputReader) {
        String method = inputReader.next("\\w*");
        //execute method
        return method;
        // throw new RuntimeException("should not be here (TM)");
    }

}

