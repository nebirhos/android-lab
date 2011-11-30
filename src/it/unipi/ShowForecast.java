package it.unipi;

import android.app.ListActivity;
//import android.widget.ArrayAdapter;
import android.os.Bundle;
import it.unipi.db.ForecastOpenHelper;
import java.util.*;

public class ShowForecast extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ForecastOpenHelper dbHelper = new ForecastOpenHelper(this);
        
        
        dbHelper.insertRow( new Date(2011,11,30, 11,00), "Snowy" );
        dbHelper.insertRow( new Date(2011,11,30, 12,00), "Rainy" );
        dbHelper.insertRow( new Date(2011,11,30, 15,00), "Sunny" );
        dbHelper.insertRow( new Date(2011,11,30, 17,00), "Cloudy" );

        List<String> results = dbHelper.getForecasts();
        ForecastAdapter adapter = new ForecastAdapter(this, results);
        
        setListAdapter( adapter); 
        
    }

	/*@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}*/
    
}
