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
    public static void main(String[] args) {
        Parser parser = new Parser();
        List<String[]> parsingResult = parser.parse("     tester.print1  \n print.this \n and.this \ntester.print2");
//        //Map<Integer, Map<String, String>> parsingResult = parser.parse("     tester.print1  \n print.this \n and.this \ntester.print2");
//        for (Map<String, String> instruction : parsingResult.values()) {
//            for (String text : instruction.values()) {
//                System.out.print(text + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < parsingResult.size(); i++) {
            System.out.print(parsingResult.get(i)[0] + " ");
            System.out.println(parsingResult.get(i)[1]);
        }



    }

    public List<String[]> parse(String inputText) {
        Scanner inputTextScanner = new Scanner(inputText);


        List<String[]> result = new ArrayList<>();

        //Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String, String>>();
        //Integer countLine = 0;
        while (inputTextScanner.hasNext()) {
            result.add(parseLine(inputTextScanner.nextLine()));
            //result.put(countLine++, parseLine(inputTextScanner.nextLine()));
        }
        System.out.println(result.size());
        return result;
        //TODO: checkar se é preciso fazer Scanner.close

    }


    public String[] parseLine(String line) {
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
        result[1] = getObject(inputReader);
        //System.out.println(result.size());

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

