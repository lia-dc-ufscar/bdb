package com.liaufscar.bdb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
*** This code is based on the Mobiletuts+ tutorial
*** Android SDK: Create a Drawing App, by Sue Smith
**/

public class DrawingView extends View {

	// Drawing path
	private Path drawPath;
	
	// Drawing and canvas paint
	private Paint drawPaint, canvasPaint;
	
	// Initial color
	private int paintColor = 0xFF0000FF; // KKCCMMYY
	
	// Canvas
	private Canvas drawCanvas;
	
	// Canvas bitmap
	private Bitmap canvasBitmap;
	
	// Brush sizes
	private float brushSize;
	
	// Dash effect
	private PathEffect effects;
	
	// Start point for ball kicking
	private float startX, startY;
	
	// Ball kicking
	private boolean ballKick;
	
	// Player representation
	private boolean playerRepr;

	public DrawingView(Context context, AttributeSet attrs){
		super(context, attrs);
		setupDrawing();
	}

	//setup drawing
	private void setupDrawing(){

		//prepare for drawing and setup paint stroke properties
		brushSize = getResources().getInteger(R.integer.medium_size);
		drawPath = new Path();
		drawPaint = new Paint();
		drawPaint.setColor(paintColor);
		drawPaint.setAntiAlias(true);
		drawPaint.setStrokeWidth(brushSize);
		drawPaint.setStyle(Paint.Style.STROKE);
		drawPaint.setStrokeJoin(Paint.Join.ROUND);
		drawPaint.setStrokeCap(Paint.Cap.ROUND);
		canvasPaint = new Paint(Paint.DITHER_FLAG);
		
		// Start effect with solid line
		effects = new DashPathEffect(new float[] {1, 1}, 0);
		
		// Start ball kicking at off
		ballKick = false;
	}

	// Size assigned to view
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		drawCanvas = new Canvas(canvasBitmap);
	}

	// Draw the view - will be called after touch event
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
		canvas.drawPath(drawPath, drawPaint);
	}

	// Register user touches as drawing action
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float touchX = event.getX();
		float touchY = event.getY();
		drawPaint.setPathEffect(effects);
		// Respond to down, move and up events
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			drawPath.moveTo(touchX, touchY);
			if (playerRepr) {
				drawPath.lineTo(touchX+1, touchY+1);
				drawCanvas.drawPath(drawPath, drawPaint);
				drawPath.reset();
			}
			startX = touchX;
			startY = touchY;
			break;
		case MotionEvent.ACTION_MOVE:
			if (playerRepr) {
				break;
			} else if (ballKick) {
				if (this.distance(touchX, touchY, startX, startY) >= 5) {
					drawPaint.setColor(0x000000FF);
					drawPath.lineTo(touchX, touchY);
				}
			} else
				drawPath.lineTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_UP:
			if (playerRepr)
				break;
			else {
				drawPath.lineTo(touchX, touchY);
				drawCanvas.drawPath(drawPath, drawPaint);
				drawPath.reset();
				break;
			}
		default:
			return false;
		}
		// Redraw
		invalidate();
		return true;

	}

	// Update color
	public void setColor(int newColor){
		invalidate();
		paintColor = newColor;
		drawPaint.setColor(newColor);
	}

	// Set brush size
	public void setBrushSize(float newSize){
		float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, newSize, getResources().getDisplayMetrics());
		brushSize = pixelAmount;
		drawPaint.setStrokeWidth(brushSize);
	}

	// Set erase true or false
	public void setErase(boolean isErase){
		if (isErase)
			drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
		else
			drawPaint.setXfermode(null);
	}

	// Set dashed line on/off
	public void setDash(boolean dash) {
		if (dash) {
			ballKick = false;
			effects = new DashPathEffect(new float[] {30, 25}, 0);
		} else {
			ballKick = false;
			effects = new DashPathEffect(new float[] {1, 1}, 0);
		}
	}
	
	// Set ball kick on/off
	public void setKick() {
		effects = new DashPathEffect(new float[] {1, 1}, 0);
		ballKick = true;
	}
	
	// Set player representation on/off
	public void setPlayer(boolean pl) {
		playerRepr = pl;
	}
	
	// Start new drawing
	public void startNew() {
		drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
		invalidate();
	}
	
	// Calculate distance between points
	public double distance(float x, float y, float x0, float y0) {
		double a, b, result;
		a = x - x0;
		a = Math.pow(a, 2);
		b = y - y0;
		b = Math.pow(b, 2);
		result = Math.sqrt(a + b);
		return result;
	}
}
