package it.unipi;

import android.app.ListActivity;
import android.os.Bundle;
import it.unipi.db.ForecastOpenHelper;
import java.util.*;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ShowForecast extends ListActivity
{
	private ForecastOpenHelper dbHelper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new ForecastOpenHelper(this);
        
        
        /* Le cazzo di insert vanno messe qua. Vengono cancellate con la onDestroy()
          */
       dbHelper.insertRow( new Date(2011,6,7,17,00), "Snowy" );
       dbHelper.insertRow( new Date(2011,11,30, 11,00), "Snowy" );
       dbHelper.insertRow( new Date(2011,11,30, 12,00), "Rainy" );
       dbHelper.insertRow( new Date(2011,11,30, 15,00), "Sunny" );
       dbHelper.insertRow( new Date(2011,11,30, 17,00), "Cloudy" );
       
       
        List<Model> results = dbHelper.getForecasts();
        
        /*A custom adapter to represent a different picture for different condition time*/
        ForecastAdapter adapter = new ForecastAdapter(this, results); 
        setListAdapter( adapter); 
        
    }

    @Override
    public void onDestroy() {
    	super.onDestroy();
      dbHelper.tDestroy();
    }
    
    /*This method launch a message on screen*/
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast hNotify = Toast.makeText(getApplicationContext(), "Put other infos here", Toast.LENGTH_SHORT);
		hNotify.setGravity(0 , 0 , 0 );
		hNotify.show();
	}
    
}
