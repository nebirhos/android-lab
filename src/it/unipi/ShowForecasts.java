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
       
        // Inserting some random data, just for example
        dbHelper.insertRow( new Date(2011,6,7,17,00), "Snowy" );
        dbHelper.insertRow( new Date(2011,11,30, 11,00), "Snowy" );
        dbHelper.insertRow( new Date(2011,11,30, 12,00), "Rainy" );
        dbHelper.insertRow( new Date(2011,11,30, 15,00), "Sunny" );
        dbHelper.insertRow( new Date(2011,11,30, 17,00), "Cloudy" );

        // Get weather forecasts
        List<Forecast> results = dbHelper.getForecasts();

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
