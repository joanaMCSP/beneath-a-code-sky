package peixotas.model.interactable_objects;

/**
 * Created by JSouza on 24/03/16 Academia de Codigo.
 */
public abstract class InteractableObject {


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

    public String getFileName() {
        return fileName;
    }

}
