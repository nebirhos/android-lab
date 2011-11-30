package it.unipi;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*Custom adapter object*/
public class ForecastAdapter extends ArrayAdapter<Model> {
	private final Context context;
	private final List<Model> values;

	public ForecastAdapter(Context context, List<Model> values) {
		super(context, R.layout.rowlayout, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		
		/*This instruction writes the basic info about each day*/
		textView.setText(values.get(position).getTime() +'\n'+ values.get(position).getCondition() );
		
		/*Connects pictures to condition time*/
		String s = values.get(position).getCondition();
		if (s.equals("Rainy"))
			imageView.setImageResource(R.drawable.rainy);
		
		else if (s.equals("Snowy")) 
			imageView.setImageResource(R.drawable.snowy);
		
		else if (s.equals("Sunny")) 
			imageView.setImageResource(R.drawable.sunny);
		
		else if (s.equals("Cloudy")) 
			imageView.setImageResource(R.drawable.cloudy);
		
		else imageView.setImageResource(R.drawable.asd);
		
		
		return rowView;
	}
}
