package it.unipi.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.*;

public class ForecastOpenHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "forescastdb";
	private static final String ID = "id";
	private static final String TIMESTAMP = "timestamp";
	private static final String FORECAST = "forecast";

	private static final int DATABASE_VERSION = 1;
	private static final String FORECAST_TABLE_NAME = "forecasts";
	private static final String FORECAST_TABLE_CREATE =
				"CREATE TABLE " + FORECAST_TABLE_NAME + " (" +
        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				TIMESTAMP + " TEXT UNIQUE, " +
				FORECAST + " TEXT);";

	public ForecastOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(FORECAST_TABLE_CREATE);
		Log.d(DATABASE_NAME, "Created!");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DATABASE_NAME, "Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + FORECAST_TABLE_NAME + "; ");
		db.execSQL(FORECAST_TABLE_CREATE);
	}

	public long insertRow(Date timestamp, String forecast) {
		long rowId = 0;
		ContentValues val = new ContentValues();
		SQLiteDatabase db = getWritableDatabase();

		if (timestamp == null || forecast == null)
			throw new IllegalArgumentException("insertRow() No null args here!");

    String timestamp_text = timestamp.toString();
		val.put(TIMESTAMP, timestamp_text);
		val.put(FORECAST, forecast);

		rowId = db.insertWithOnConflict(FORECAST_TABLE_NAME, null, val,
							SQLiteDatabase.CONFLICT_REPLACE);

		if (rowId <= 0)
			Log.e(DATABASE_NAME, "Row not created for " + timestamp_text);

		db.close();
		return rowId;
	}

	public Vector getForecasts() {
		SQLiteDatabase db = getReadableDatabase();

		String[] PROJECTION_D = {TIMESTAMP, FORECAST};
    String SELECTION_W = "";
		String DEFAULT_SORT_ORDER = TIMESTAMP + " ASC";

		Cursor c = db.query(FORECAST_TABLE_NAME, PROJECTION_D, SELECTION_W,
					null, null, null,  DEFAULT_SORT_ORDER);
		Log.d(DATABASE_NAME, "Selection gave " + c.getCount() + " rows");

		Vector<String[]> aResults = new Vector<String[]>();
		if (!c.moveToFirst()) {
			c.close();
			return null;
		}
		do {
        String[] row = new String[]{ c.getString(c.getColumnIndexOrThrow(TIMESTAMP)),
                                     c.getString(c.getColumnIndexOrThrow(FORECAST))};
        aResults.add( row );
		} while(c.moveToNext());
		c.close();
		db.close();

		return aResults;
	}
}
