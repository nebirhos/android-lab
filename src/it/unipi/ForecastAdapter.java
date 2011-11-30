package it.unipi;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ForecastAdapter extends ArrayAdapter<List<String>> {
	private final Context context;
	private final List<String> values;

	public ForecastAdapter(Context context, List values) {
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
		textView.setText(values.get(position));
		

		String s = values.get(position);
		if (s.contains("Rainy"))
			imageView.setImageResource(R.drawable.rainy);
		
		else if (s.contains("Snowy")) 
			imageView.setImageResource(R.drawable.snowy);
		
		else if (s.contains("Sunny")) 
			imageView.setImageResource(R.drawable.sunny);
		
		else if (s.contains("Cloudy")) 
			imageView.setImageResource(R.drawable.cloudy);
		
		else imageView.setImageResource(R.drawable.asd);
		
		
		return rowView;
	}
}
