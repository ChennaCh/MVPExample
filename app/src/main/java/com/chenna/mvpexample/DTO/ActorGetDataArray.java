package com.chenna.mvpexample.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chinn on 02/12/18.
 */

public class ActorGetDataArray {

    @SerializedName("actors")
    @Expose
    private List<ActorGetDataDTO> actors = null;

    public List<ActorGetDataDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorGetDataDTO> actors) {
        this.actors = actors;
    }

}
