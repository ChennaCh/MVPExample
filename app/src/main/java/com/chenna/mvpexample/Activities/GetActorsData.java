package com.chenna.mvpexample.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chenna.mvpexample.Adapter.ActorsAdapter;
import com.chenna.mvpexample.DTO.ActorGetDataArray;
import com.chenna.mvpexample.DTO.ActorGetDataDTO;
import com.chenna.mvpexample.Model.ActorPresenterImpl;
import com.chenna.mvpexample.Presenter.ActorPresenter;
import com.chenna.mvpexample.R;
import com.chenna.mvpexample.View.ActorView;

import java.util.ArrayList;

public class GetActorsData extends Activity implements ActorView{

    private ActorGetDataArray mgetactorsdata;
    private ActorPresenter mactorspresenter;
    private ActorsAdapter actorsAdapter;

    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_actors_data);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mgetactorsdata = new ActorGetDataArray();
        mactorspresenter = new ActorPresenterImpl(GetActorsData.this);
        mactorspresenter.getData();

    }

    @Override
    public void getDataError() {

    }

    @Override
    public void hideprogressDialog() {

    }

    @Override
    public void getData(ArrayList<ActorGetDataDTO> actorGetDataDTO) {
        actorsAdapter = new ActorsAdapter(actorGetDataDTO,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(GetActorsData.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(actorsAdapter);
    }

    @Override
    public void showArrayData(ActorGetDataArray array) {
    }
}
