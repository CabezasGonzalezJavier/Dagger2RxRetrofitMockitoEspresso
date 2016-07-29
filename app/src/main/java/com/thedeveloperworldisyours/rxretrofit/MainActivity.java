package com.thedeveloperworldisyours.rxretrofit;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.thedeveloperworldisyours.rxretrofit.adapter.GeoNamesAdapter;
import com.thedeveloperworldisyours.rxretrofit.model.GeoNames;
import com.thedeveloperworldisyours.rxretrofit.rest.ApiClient;


import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getName();

    private Subscription mSubscription;

    @Inject
    ApiClient mApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).appComponent().inject(this);

        FloatingActionButton floatingAction = (FloatingActionButton)
                findViewById(R.id.activity_main_floating_action);

        floatingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callServerFetchGeoNamesList();
            }
        });

        final Snackbar snackbar = Snackbar
                .make(findViewById(R.id.coordinatorLayout),
                        getString(R.string.server_call), Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Do nothing, just dismiss snackbar
                    }
                });

        snackbar.show();
    }

    private void callServerFetchGeoNamesList() {
        mSubscription = mApiClient.getAllCountriesGeoNames("en", "antriksh")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver);
    }

    Observer<GeoNames> myObserver = new Observer<GeoNames>() {

        @Override
        public void onCompleted() {
            mSubscription.unsubscribe();
        }

        @Override
        public void onError(Throwable e) {
            // Called when the observable encounters an error
            Log.d(TAG, ">>>> onError gets called : " + e.getMessage());
        }

        @Override
        public void onNext(GeoNames geoNamesApi) {
            findViewAndSetAdapter(geoNamesApi);
        }
    };

    private void findViewAndSetAdapter(GeoNames geoNamesApi) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        GeoNamesAdapter geoNamesAdapter = new GeoNamesAdapter(geoNamesApi.getGeonames());
        recyclerView.setAdapter(geoNamesAdapter);
        geoNamesAdapter.notifyDataSetChanged();
    }
}
