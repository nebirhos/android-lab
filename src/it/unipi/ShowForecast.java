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
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ForecastOpenHelper dbHelper = new ForecastOpenHelper(this);
        
        
        /*This instruction has used just for test. Once the db has been created it is saved
         * on the device permanently.
         * For this reason the initial List of condition time is in ForecastOpenHelper class 
         * (in the onCreate() method).
          */
       dbHelper.insertRow( new Date(2011,6,7,17,00), "Snowy" );
       
       
        List<Model> results = dbHelper.getForecasts();
        
        /*A custom adapter to represent a different picture for different condition time*/
        ForecastAdapter adapter = new ForecastAdapter(this, results); 
        setListAdapter( adapter); 
        
    }

    /*This method launch a message on screen*/
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast hNotify = Toast.makeText(getApplicationContext(), "Put other infos here", Toast.LENGTH_SHORT);
		hNotify.setGravity(0 , 0 , 0 );
		hNotify.show();
	}
    
}
