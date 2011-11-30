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
        
        
        /**/
       dbHelper.insertRow( new Date(2011,11,30, 11,00), "Snowy" );
        List<String> results = dbHelper.getForecasts();
        ForecastAdapter adapter = new ForecastAdapter(this, results);
        
        setListAdapter( adapter); 
        
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast hNotify = Toast.makeText(getApplicationContext(), "Qui ci vanno le info aggiuntive", Toast.LENGTH_SHORT);
		hNotify.setGravity(0 , 0 , 0 );
		hNotify.show();
		/*this wirite on screen addictive information*/
		//Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}
    
}
