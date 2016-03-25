package peixotas.model;

import peixotas.model.levels.Level;
import peixotas.model.levels.Level1;
import peixotas.model.levels.Level2;
import peixotas.terminal.Interpreter;
import peixotas.terminal.Parser;

import java.util.LinkedList;

/**
 * Created by codecadet on 24/03/16.
 */
public /*not abstract */class Game {

    //private Level[] levels;
    private LinkedList<Level> levels;
    private Player player;

    private Parser parser;
    private Interpreter interpreter;

    //private Field field;
    //private Level currentLevel;

    public Game(){
        //levels = new Level[]{new Level1(), new Level2()};
        levels = new LinkedList<>();

        //levels[0].setController();
        player = new Player();
        parser = new Parser();
        interpreter = new Interpreter();
    }

    public LinkedList<Level> getLevels() {
        return levels;
    }

/*    public void nextLevel(){
        Level level = new Level
    }*/

    public void addLevel(Level level) {

        levels.add(level);
    }

    /**
     * main game loop
     */
    public void run(){

        Level level = levels.get(0);

        level.run();

    }



}
