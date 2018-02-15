package com.chenna.mvpexample.View;

import com.chenna.mvpexample.DTO.ActorGetDataArray;
import com.chenna.mvpexample.DTO.ActorGetDataDTO;

import java.util.ArrayList;

/**
 * Created by chinn on 02/12/18.
 */

public interface ActorView {

    void getDataError();

    void hideprogressDialog();

    void getData(ArrayList<ActorGetDataDTO> actorGetDataDTO);


    void showArrayData(ActorGetDataArray array);
}
