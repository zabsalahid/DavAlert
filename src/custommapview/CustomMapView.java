package custommapview;

import org.osmdroid.views.MapView;

import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("ViewConstructor") public class CustomMapView extends MapView{
	/* constructors */  

	public CustomMapView(Context context, int tileSizePixels) {
		super(context, tileSizePixels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMaxZoomLevel() {
	    return 17;
	}

	@Override
	public int getMinZoomLevel() {
	    return 0;
	}
}
