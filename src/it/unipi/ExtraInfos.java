package it.unipi;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExtraInfos extends Activity {
	
	/**
	 * Called when the activity is first created.
	 * Setup programmatically the UI
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* LinearLayout is the simpler container of UI objects (Views) */
		Bundle extras = getIntent().getExtras();
		LinearLayout container = new LinearLayout(this);
		container.setOrientation(LinearLayout.VERTICAL);
		String value1 = extras.getString("infos");
		/* TextView shows text within the UI */
		TextView text= new TextView(this);
			
		text.setText(value1);
		

		container.addView(text);

		/* Use the created LinearLayout as the default UI container to show */
		setContentView(container);	
	}
	
}
