package model;


/**
 * Created by codecadet on 24/03/16.
 */
public class Box extends InteractableObject {

    public Box(float x, float y) {
        super(x, y, "interactables/box.png");
    }

    public void push() {
        System.out.println("this box is being very pushed by 100px");
        setX(getX() + 100);
    }

    public void pull() {
        System.out.println("this box is being very pulled by 100px");
        setX(getX() - 100);

    }

}
