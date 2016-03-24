package org.bootcamp.hackathon.beneaththecodesky.model.levels;

import java.util.List;
import java.util.Objects;

/**
 * Created by codecadet on 24/03/16.
 */
public abstract class Level {

    private List<Objects> levelObjects;
    private boolean complete;


    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public abstract void validate();



}
