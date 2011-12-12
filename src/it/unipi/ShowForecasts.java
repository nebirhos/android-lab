package it.unipi;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;
import it.unipi.db.*;
import it.unipi.models.*;
import it.unipi.ForecastAdapter;


public class ShowForecasts extends ListActivity implements View.OnClickListener {
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

        setListAdapter(new ForecastAdapter(this,
				results) {
			@Override
			public View getView(int position, View convertView,
					ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				view.setTag(Integer.valueOf(position));
				view.setOnClickListener(ShowForecasts.this);
				return view;
			}
        });
    }


	@Override
	public void onClick(View arg) {
		Intent i = new Intent(ShowForecasts.this,ExtraInfos.class);
		int position = ((Integer)arg.getTag()).intValue();
		Forecast obj = (Forecast)this.getListAdapter().getItem(position);
        String info =obj.getDescriptionString() + " , " + obj.getTemperatureString();
		i.putExtra("infos",info); //all in one string
		startActivity(i);
	}
	
	
}
