package peixotas.model.level_objects;

/**
 * Created by codecadet on 24/03/16.
 */
public class LevelObjectFactory {


    public static LevelObject createNewLevelObject(LevelObjectType type){

        LevelObject levelObject = null;

        switch (type){
            case FLOOR:
                levelObject = new Floor(LevelObjectType.FLOOR);
                break;
            case PLATFORM:
                levelObject = new Platform(LevelObjectType.PLATFORM);
                break;

        }

        return levelObject;
    }
}
