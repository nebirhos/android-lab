package it.unipi;

import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import it.unipi.db.ForecastOpenHelper;
import java.util.*;

public class ShowForecast extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
        ForecastOpenHelper dbHelper = new ForecastOpenHelper(this);
        dbHelper.insertRow( new Date(2011,11,30, 11,00), "Snowy" );
        dbHelper.insertRow( new Date(2011,11,30, 12,00), "Rainy" );

        List<String> results = dbHelper.getForecasts();
        ArrayAdapter <String> adapter = new ArrayAdapter<String>( this,
        		R.layout.rowlayout, R.id.label,
                results ) ;
        
        setListAdapter( adapter);

        
        
    }/*
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2" };
		// Use your own layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.rowlayout, R.id.label, values);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}*/
}
