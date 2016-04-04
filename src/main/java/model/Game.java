package model;

import model.Player;


/**
 * Created by codecadet on 24/03/16.
 */
public /*not abstract */class Game {

    // CONSTANTS

    //private Level[] levels;
   // private LinkedList<Level> levels;
    private Player player;

    public Game(){
        //levels = new LinkedList<>();
        player = new Player(50, 400);
    }
/*
    public LinkedList<Level> getLevels() {
        return levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }*/

    public Player getPlayer() {
        return player;
    }

    /*public void run(){
        Level level = levels.get(0);
        level.run();
    }*/



}
