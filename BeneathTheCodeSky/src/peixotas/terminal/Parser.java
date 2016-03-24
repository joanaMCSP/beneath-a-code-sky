package peixotas.terminal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Paulo Pereira on 24/03/16.
 */
public class Parser {

    /**
     * @author Filipe Jorge.
     * At <Academia de Código_> on 24/03/16.
     * <p>
     * <p>
     * isolates Object and Method from a String
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        Map<Integer, Map<String, String>> parsingResult = parser.parse(" door.open\ntree.cut\n");
        for (Map<String, String> instruction : parsingResult.values()) {
            for (String text : instruction.values()) {
                System.out.print(text + " ");
            }
            System.out.println();
        }


    }
    public Map<Integer, Map<String, String>> parse(String inputText) {
        Scanner inputTextScanner = new Scanner(inputText);
        Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String, String>>();
        Integer countLine = 0;
        while (inputTextScanner.hasNext()) {
            result.put(countLine++, parseLine(inputTextScanner.nextLine()));
        }
        return result;
        //TODO: checkar se é preciso fazer Scanner.close

    }


    private Map<String, String> parseLine(String line) {
        Map<String, String> result = new HashMap<String, String>();

        //clean begin and end whitespaces
        line = line.trim();

        Scanner inputReader = new Scanner(line);
        //put '.' as token delimiter to this Scanner
        inputReader.useDelimiter("\\.");

        result.put("Object", getObject(inputReader));
        result.put("Method", getMethod(inputReader));

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

