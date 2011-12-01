package it.unipi;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.*;

import it.unipi.db.*;
import it.unipi.models.*;
import it.unipi.ForecastAdapter;


public class ShowForecasts extends ListActivity {
    private DatabaseHelper dbHelper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(this);
       
        // Inserting some random data for a day, just for example
        Date now = new Date();
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours(),   0), -3, "Snowy") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+1, 0), -2, "Snowy") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+2, 0),  0, "Rainy") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+3, 0),  5, "Rainy") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+4, 0),  6, "Cloudy") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+5, 0),  6, "Cloudy") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+6, 0),  6, "Sunny") );
        dbHelper.insertRow( new Forecast(new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours()+7, 0),  5, "Cloudy") );

        // Get weather forecasts
        List<Forecast> results = dbHelper.getForecasts( now );

        // A custom adapter to represent a different picture for different condition time
        ForecastAdapter adapter = new ForecastAdapter(this, results); 
        setListAdapter( adapter); 
    }

    @Override
    public void onDestroy() {
    	super.onDestroy();
      // Delete previously inserted data
      dbHelper.resetDatabase();
    }

    /** This method launch a message on screen */
    @Override
    protected void onListItemClick( ListView list, View view, int position, long id ) {
        Toast hNotify = Toast.makeText( getApplicationContext(), "Put other infos here", Toast.LENGTH_SHORT );
        hNotify.setGravity( 0, 0, 0 );
        hNotify.show();
    }
}
