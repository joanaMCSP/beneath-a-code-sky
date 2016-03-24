package org.bootcamp.hackathon.beneaththecodesky.model;

import org.bootcamp.hackathon.beneaththecodesky.model.levels.Level;
import org.bootcamp.hackathon.beneaththecodesky.model.levels.Level1;
import org.bootcamp.hackathon.beneaththecodesky.model.levels.Level2;

import java.util.LinkedList;
import java.util.List;

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
