package org.bootcamp.hackathon.beneaththecodesky.model.level_objects;

import org.bootcamp.hackathon.beneaththecodesky.view.representations.Representation;

/**
 * Created by codecadet on 24/03/16.
 */
public abstract class LevelObject {

    private Representation representation;
    private LevelObjectType levelObjectType;

    public LevelObject(LevelObjectType type, Representation representation){
        this.representation = representation;
        this.levelObjectType = levelObjectType;
    }

    public Representation getRepresentation() {
        return representation;
    }


}
