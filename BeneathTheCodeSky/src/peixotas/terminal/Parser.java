package peixotas.terminal;

import java.util.*;
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

    public static List<String[]> parse(String inputText) {
        Scanner inputTextScanner = new Scanner(inputText);


        List<String[]> result = new ArrayList<>();


        while (inputTextScanner.hasNext()) {
            result.add(parseLine(inputTextScanner.nextLine()));

        }
        System.out.println(result.size());
        return result;
        //TODO: checkar se é preciso fazer Scanner.close

    }


    private static String[] parseLine(String line) {
       // Map<String, String> result = new HashMap<String, String>();
        String[] result = new String[2];

        //clean begin and end whitespaces
        line = line.trim();

        Scanner inputReader = new Scanner(line);
        //put '.' as token delimiter to this Scanner
        inputReader.useDelimiter("\\.");

//        result.put("Object", getObject(inputReader));
//        result.put("Method", getMethod(inputReader));

        result[0] = getObject(inputReader);
        result[1] = getMethod(inputReader);
        //System.out.println(result.size());

        return result;
    }


    private static String getObject(Scanner inputReader) {
        String result = null;

        Pattern pattern = Pattern.compile("\\w*");

        //catch object name
        if (inputReader.hasNext(pattern)) {
            result = inputReader.next("\\w*");
        }
        return result;
    }


    private static String getMethod(Scanner inputReader) {
        String method = inputReader.next("\\w*");
        //execute method
        return method;
        // throw new RuntimeException("should not be here (TM)");
    }

}

