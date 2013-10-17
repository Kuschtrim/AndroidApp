package com.da;

import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

public class MapPane extends Activity {
	private TextView latituteField;
	private TextView longitudeField;
	private LocationManager locationManager;
	private String provider;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// latituteField = (TextView) findViewById(R.id.TextView02);
		// longitudeField = (TextView) findViewById(R.id.TextView04);
		//
		// // Get the location manager
		// locationManager = (LocationManager)
		// getSystemService(Context.LOCATION_SERVICE);
		// // Define the criteria how to select the locatioin provider -> use
		// // default
		// Criteria criteria = new Criteria();
		// provider = locationManager.getBestProvider(criteria, false);
		// Location location = locationManager.getLastKnownLocation(provider);
		//
		// // Initialize the location fields
		// if (location != null) {
		// System.out.println("Provider " + provider + " has been selected.");
		// onLocationChanged(location);
		// } else {
		// latituteField.setText("Location not available");
		// longitudeField.setText("Location not available");
		// }
		// }
		//
		// /* Request updates at startup */
		// @Override
		// protected void onResume() {
		// super.onResume();
		// locationManager.requestLocationUpdates(provider, 400, 1, this);
		// }
		//
		// /* Remove the locationlistener updates when Activity is paused */
		// @Override
		// protected void onPause() {
		// super.onPause();
		// locationManager.removeUpdates(this);
		// }
		//
		// @Override
		// public void onLocationChanged(Location location) {
		// int lat = (int) (location.getLatitude());
		// int lng = (int) (location.getLongitude());
		// latituteField.setText(String.valueOf(lat));
		// longitudeField.setText(String.valueOf(lng));
		// }
		//
		// @Override
		// public void onStatusChanged(String provider, int status, Bundle
		// extras) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onProviderEnabled(String provider) {
		// Toast.makeText(this, "Enabled new provider " + provider,
		// Toast.LENGTH_SHORT).show();
		//
		// }
		//
		// @Override
		// public void onProviderDisabled(String provider) {
		// Toast.makeText(this, "Disabled provider " + provider,
		// Toast.LENGTH_SHORT).show();
		// }

		// if gps is enabled and network location is disabled
		// note, GPS can be slow to obtain location data but is more accurate
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener ll = new mylocationlistener();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
	}

	private class mylocationlistener implements LocationListener {
		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				Log.d("LOCATION CHANGED", location.getLatitude() + "");
				Log.d("LOCATION CHANGED", location.getLongitude() + "");
				Toast.makeText(MapPane.this,
						location.getLatitude() + "" + location.getLongitude(),
						Toast.LENGTH_LONG).show();
			}
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}
}