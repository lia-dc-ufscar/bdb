package com.liaufscar.bdb;

import com.liaufscar.bdb.DrawingView;
import com.liaufscar.bdb.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
*** This code is based on the Mobiletuts+ tutorial
*** Android SDK: Create a Drawing App, by Sue Smith
**/

public class MainActivity extends Activity implements OnClickListener {

	// Custom Drawing View
	private DrawingView drawView;

	// Buttons
	private ImageButton blueMarker, redMarker, greenMarker, eraseBtn, clearBtn, solidBtn, dashedBtn, kickBtn;
	
	// Local variables
	private int brushSize = 6;
	private int eraserSize = 70;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//
		// Drawing view initialization
		//
		
		// Get drawing view
		drawView = (DrawingView) findViewById(R.id.drawing);

		// Set initial size
		drawView.setBrushSize(brushSize);
		
		//
		// Button Listeners
		//
		
		// Blue Marker
		blueMarker = (ImageButton) findViewById(R.id.blue_marker);
		blueMarker.setOnClickListener(this);
		
		// Red Marker
		redMarker = (ImageButton)findViewById(R.id.red_marker);
		redMarker.setOnClickListener(this);
		
		// Green Marker
		greenMarker = (ImageButton)findViewById(R.id.green_marker);
		greenMarker.setOnClickListener(this);

		// Erase button
		eraseBtn = (ImageButton) findViewById(R.id.erase_btn);
		eraseBtn.setOnClickListener(this);
		
		// Clear button
		clearBtn = (ImageButton) findViewById(R.id.clear_btn);
		clearBtn.setOnClickListener(this);
		
		// Solid line button
		solidBtn = (ImageButton) findViewById(R.id.solid_line);
		solidBtn.setOnClickListener(this);
		
		// Dashed line button
		dashedBtn = (ImageButton) findViewById(R.id.dashed_line);
		dashedBtn.setOnClickListener(this);
		
		// Ball kick button
		kickBtn = (ImageButton) findViewById(R.id.ball_kick);
		kickBtn.setOnClickListener(this);
		
		// Set blueMarker as active because it is the starting color
		blueMarker.setBackgroundResource(R.drawable.button_active);
		
		// Set solidBtn as active because it is the starting line type
		solidBtn.setBackgroundResource(R.drawable.button_active);
	}

	@Override
	public void onClick(View view){
		if (view.getId() == R.id.blue_marker) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFF0000FF);
			
			// Set blueBtn as active and others as inactive
			blueMarker.setBackgroundResource(R.drawable.button_active);
			redMarker.setBackgroundResource(R.drawable.button);
			greenMarker.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.red_marker) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFFFF0000);
			
			// Set redMarker as active and others as inactive
			blueMarker.setBackgroundResource(R.drawable.button);
			redMarker.setBackgroundResource(R.drawable.button_active);
			greenMarker.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.green_marker) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFF00FF00);
			
			// Set greenMarker as active and others as inactive
			blueMarker.setBackgroundResource(R.drawable.button);
			redMarker.setBackgroundResource(R.drawable.button);
			greenMarker.setBackgroundResource(R.drawable.button_active);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.erase_btn) {
			// Set eraser as true
			drawView.setErase(true);
			
			// Change brush size
			drawView.setBrushSize(eraserSize);
			
			// Set eraseBtn as active and others as inactive
			blueMarker.setBackgroundResource(R.drawable.button);
			redMarker.setBackgroundResource(R.drawable.button);
			greenMarker.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button_active);
		} else if (view.getId() == R.id.dashed_line) {
			// Set dash as true
			drawView.setDash(true);
			
			// Set dashedBtn as active and others as inactive
			dashedBtn.setBackgroundResource(R.drawable.button_active);
			solidBtn.setBackgroundResource(R.drawable.button);
			kickBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.solid_line) {
			// Set dash as false
			drawView.setDash(false);
			
			// Set solidBtn as active and others as inactive
			dashedBtn.setBackgroundResource(R.drawable.button);
			solidBtn.setBackgroundResource(R.drawable.button_active);
			kickBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.ball_kick) {
			// Set kick as true
			drawView.setKick();
			
			// Set kickBtn as active and others as inactive
			dashedBtn.setBackgroundResource(R.drawable.button);
			solidBtn.setBackgroundResource(R.drawable.button);
			kickBtn.setBackgroundResource(R.drawable.button_active);
		} else if (view.getId() == R.id.clear_btn) {
			// Clear canvas
			drawView.startNew();
		}
	}

}
