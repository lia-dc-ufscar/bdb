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
	private ImageButton redSolid, redDashed, redKick, redPlayer, blueSolid, blueDashed, blueKick, bluePlayer, eraseBtn, clearBtn;
	
	// Local variables
	private int brushSize = 6,
				eraserSize = 70,
				playerSize = 50;

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
		
		// Red solid line
		redSolid = (ImageButton) findViewById(R.id.red_solid);
		redSolid.setOnClickListener(this);
		
		// Red dashed line
		redDashed = (ImageButton) findViewById(R.id.red_dashed);
		redDashed.setOnClickListener(this);
		
		// Red ball kicking line
		redKick = (ImageButton) findViewById(R.id.red_kick);
		redKick.setOnClickListener(this);

		// Red player
		redPlayer = (ImageButton) findViewById(R.id.red_player);
		redPlayer.setOnClickListener(this);
		
		// Blue solid line
		blueSolid = (ImageButton) findViewById(R.id.blue_solid);
		blueSolid.setOnClickListener(this);

		// Blue dashed line
		blueDashed = (ImageButton) findViewById(R.id.blue_dashed);
		blueDashed.setOnClickListener(this);

		// Blue ball kicking line
		blueKick = (ImageButton) findViewById(R.id.blue_kick);
		blueKick.setOnClickListener(this);

		// Blue player
		bluePlayer = (ImageButton) findViewById(R.id.blue_player);
		bluePlayer.setOnClickListener(this);
		
		// Erase button
		eraseBtn = (ImageButton) findViewById(R.id.erase_btn);
		eraseBtn.setOnClickListener(this);
		
		// Clear button
		clearBtn = (ImageButton) findViewById(R.id.clear_btn);
		clearBtn.setOnClickListener(this);
		
		// Set blueSolid as active
		blueSolid.setBackgroundResource(R.drawable.button_active);
	}

	@Override
	public void onClick(View view){
		if (view.getId() == R.id.red_solid) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFFFF0000);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button_active);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.red_dashed) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFFFF0000);
			
			// Set dash as true
			drawView.setDash(true);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button_active);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.red_kick) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFFFF0000);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set kick as true
			// drawView.setKick(); // Turned off because it's not working and would cause app to crash
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button_active);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.red_player) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(playerSize);
			
			// Set brush color
			drawView.setColor(0xFFFF0000);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation on
			drawView.setPlayer(true);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button_active);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.blue_solid) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFF0000FF);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button_active);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.blue_dashed) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFF0000FF);
			
			// Set dash as true
			drawView.setDash(true);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button_active);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.blue_kick) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(brushSize);
			
			// Set brush color
			drawView.setColor(0xFF0000FF);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set kick as true
			// drawView.setKick(); // Turned off because it's not working and would cause app to crash
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button_active);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.blue_player) {
			// Set eraser as false
			drawView.setErase(false);
			
			// Change brush size
			drawView.setBrushSize(playerSize);
			
			// Set brush color
			drawView.setColor(0xFF0000FF);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation on
			drawView.setPlayer(true);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button_active);
			eraseBtn.setBackgroundResource(R.drawable.button);
		} else if (view.getId() == R.id.erase_btn) {
			// Set eraser as true
			drawView.setErase(true);
			
			// Change brush size
			drawView.setBrushSize(eraserSize);
			
			// Set brush color
			drawView.setColor(0xFF0000FF);
			
			// Set dash as false
			drawView.setDash(false);
			
			// Set player representation off
			drawView.setPlayer(false);
			
			// Set current button as active and others as inactive
			redSolid.setBackgroundResource(R.drawable.button);
			redDashed.setBackgroundResource(R.drawable.button);
			redKick.setBackgroundResource(R.drawable.button);
			redPlayer.setBackgroundResource(R.drawable.button);
			blueSolid.setBackgroundResource(R.drawable.button);
			blueDashed.setBackgroundResource(R.drawable.button);
			blueKick.setBackgroundResource(R.drawable.button);
			bluePlayer.setBackgroundResource(R.drawable.button);
			eraseBtn.setBackgroundResource(R.drawable.button_active);
		} else if (view.getId() == R.id.clear_btn) {
			// Clear canvas
			drawView.startNew();
		}
	}

}
