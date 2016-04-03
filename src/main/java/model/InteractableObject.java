package model;


/**
 * Created by JSouza on 24/03/16 Academia de Codigo.
 */
public abstract class InteractableObject {


    //TODO: this calls for an Enum..
    private float x;
    private float y;
    private String fileName;


    public InteractableObject(float x, float y, String fileName) {
        this.x = x;
        this.y = y;
        this.fileName = fileName;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getFileName() {
        return fileName;
    }

}
