package com.ravenshell.dagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ravenshell.dagger2demo.data.weather.WeatherData;
import com.ravenshell.dagger2demo.network.OpenWeatherInterface;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    OpenWeatherInterface openWeatherInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        injectDependencies();

        fetchWeatherData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext -> {
                    Toast.makeText(this, "Data was fetch successfully", Toast.LENGTH_SHORT).show();
                }, onError ->{
                    Toast.makeText(this, "Data could not be fetched "+onError.getMessage(), Toast.LENGTH_LONG).show();
                });
    }


    private void injectDependencies(){
        ((App) getApplication()).getWeatherComponent().inject(this);
    }

    private Observable<WeatherData> fetchWeatherData(){
        return openWeatherInterface
                .getWeatherData(4.5, 4.2);

    }


    void  displayMsg(String msg){
       Toast.makeText(getApplication(), msg, Toast.LENGTH_LONG).show();
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
