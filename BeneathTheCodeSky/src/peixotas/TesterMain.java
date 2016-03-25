package peixotas;

import peixotas.model.levels.Level1;
import peixotas.terminal.Parser;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by gouveia on 25/03/16.
 */
public class TesterMain {


    public static void main(String[] args) {


        Level1 level1 = new Level1();
        List<String[]> parsingResult = Parser.parse("     tester.print1  \n print.this \n and.this \ntester.print2");


        Method[] methods = level1.getClass().getDeclaredMethods();

        for(Method method : methods){
            System.out.println(method);
        }

    }

}
