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

        Vector<String[]> results = dbHelper.getForecasts();

        setListAdapter( new ArrayAdapter<String>( this,
                                                  android.R.layout.simple_list_item_1,
                                                  results.firstElement() ) );
    }
}
