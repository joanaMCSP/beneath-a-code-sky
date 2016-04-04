package model;

/**
 * Created by joana on 4/4/16.
 */
public class Door extends InteractableObject{
    public static final int COLUMNS = 8;
    public static final int COUNT = 8;
    public static final int OFFSET_X = 0;
    public static final int OFFSET_Y = 0;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 181;

    private Key key;



    private String fileName;



    public Door(float x, float y) {
        super(x, y, "interactables/door.png");

       //fileName = "interactables/door.png";
    }

    public void open(){
        System.out.println("this door is being very opened");
        fileName = "interactables/doorAnimation.png";
        setX(getX());
        setY(getY());
    }



}
