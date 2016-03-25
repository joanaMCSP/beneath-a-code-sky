package peixotas;

import peixotas.terminal.Parser;

import java.util.List;

/**
 * Created by gouveia on 25/03/16.
 */
public class TesterMain {


    public static void main(String[] args) {

        Parser parser = new Parser();

        List<String[]> parsingResult = parser.parse("     tester.print1  \n print.this \n and.this \ntester.print2");

        System.out.println("PARSING RESULT : " + parsingResult.get(1)[0]);

    }

}
