package com.example.davalert;


import org.osmdroid.events.MapListener;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.events.ZoomEvent;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.util.GeoPoint;

//import org.osmdroid.views.overlay.ScaleBarOverlay;

import custommapview.CustomMapView;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final CustomMapView mapView = new CustomMapView(this, 256);
        //MapView mapView = new MapView(this, 256); //constructor
        //mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setTileSource(new XYTileSource("MapQuest", null, 11, 17, 256, ".jpg", ""));
        mapView.setBuiltInZoomControls(true); 
        mapView.setMultiTouchControls(true);
        
        double north = 7.280741;
        double east  = 125.667801;
        double south = 6.959144;
        double west  = 125.430222;
        BoundingBoxE6 boundingBox = new BoundingBoxE6(north, east, south, west);
        
        mapView.setScrollableAreaLimit(boundingBox);
        
        //setContentView(mapView);
        //start
        final TextView myTextView = new TextView(this);
        myTextView.setTextAppearance(this, android.R.style.TextAppearance_Large_Inverse);
        //myTextView.setText("Davao City");
        myTextView.setTextColor(Color.parseColor("#000000"));
        //Button btnOk = new Button(this);
        //btnOk.setText("Zoom Level");
        //btnOk.setTextColor(Color.parseColor("#000000"));
        
        final RelativeLayout relativeLayout = new RelativeLayout(this);
		final RelativeLayout.LayoutParams mapViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
        final RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        relativeLayout.addView(mapView, mapViewLayoutParams);
        relativeLayout.addView(myTextView, textViewLayoutParams);
        //relativeLayout.addView(btnOk, buttonLayoutParams);
        setContentView(relativeLayout);
        //end
        
        
        mapView.getController().setZoom(17); //set initial zoom-level, depends on your need
        //debug
        myTextView.setText("Zoom Level: "+ String.valueOf(mapView.getZoomLevel()));
        mapView.getController().setCenter(new GeoPoint(7.063985, 125.60831)); //This point is in Enschede, Netherlands. You should select a point in your map or get it from user's location.
        mapView.setUseDataConnection(true); //keeps the mapView from loading online tiles using network connection.
        //ScaleBarOverlay myScaleBarOverlay = new ScaleBarOverlay(this);
        //mapView.getOverlays().add(myScaleBarOverlay);
        
        //debug
        mapView.setMapListener(new MapListener() {    

        	public boolean onZoom(ZoomEvent arg0) {
	              // TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), zoomLevel, Toast.LENGTH_LONG).show();
        		myTextView.setText("Zoom Level: "+ String.valueOf(mapView.getZoomLevel()));
        		return false;
	        }
	         
	        public boolean onScroll(ScrollEvent arg0) {
	              // TODO Auto-generated method stub
	        	return false;
	        }
        } );
        //debug
    }
}
