package com.chenna.mvpexample.Model;

import android.content.Context;

import com.chenna.mvpexample.DTO.ActorGetDataArray;
import com.chenna.mvpexample.DTO.ActorGetDataDTO;
import com.chenna.mvpexample.Presenter.ActorPresenter;
import com.chenna.mvpexample.View.ActorView;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by chinn on 02/12/18.
 */

public class ActorPresenterImpl implements ActorPresenter {

    ActorView mactorView;

    public ActorPresenterImpl(ActorView actorView1){

        this.mactorView = actorView1;
    }

    @Override
    public void getData() {

        Ion.with((Context) mactorView)
                .load("http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors")
                .as(new TypeToken<ActorGetDataArray>(){})
                .setCallback(new FutureCallback<ActorGetDataArray>() {
                    @Override
                    public void onCompleted(Exception e, ActorGetDataArray result) {
                        if (result.getActors() != null){
                            mactorView.getData((ArrayList<ActorGetDataDTO>) result.getActors());
                        }
                    }
                });

    }
}
