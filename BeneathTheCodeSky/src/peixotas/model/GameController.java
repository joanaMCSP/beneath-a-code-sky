package peixotas.model;

import peixotas.model.levels.Level;
import peixotas.model.levels.Level1;
import peixotas.model.levels.Level2;

/**
 * Created by codecadet on 24/03/16.
 */
public /*not abstract */class GameController {

    private Level[] levels;
    private Player player;
    private Field field;
    private Level currentLevel;
    private final int HEIGHT = 720;
    //private final int WIDTH = !!!!!!!;



    public GameController(){
        levels = new Level[]{new Level1() , new Level2()};

    }


    /**
     * main game loop
     * @param levels
     */
    public void run(Level[] levels){

        for(Level level:levels){
            while(!level.isComplete()){
                level.run();
            }
        }
        System.out.println("GameOver!!!!");
    }



}
