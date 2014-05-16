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
	// Erase flag
//	private boolean isErase = false;
	// Effects (to set dash on/off)
	private PathEffect effects;

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
	}

	//size assigned to view
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		drawCanvas = new Canvas(canvasBitmap);
	}

	//draw the view - will be called after touch event
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
		//respond to down, move and up events
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			drawPath.moveTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_MOVE:
			drawPath.lineTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_UP:
			drawPath.lineTo(touchX, touchY);
			drawCanvas.drawPath(drawPath, drawPaint);
			drawPath.reset();
			break;
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
		float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 
				newSize, getResources().getDisplayMetrics());
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
		if (dash)
			effects = new DashPathEffect(new float[] {30, 25}, 0);
		else
			effects = new DashPathEffect(new float[] {1, 1}, 0);
	}
	
	// Start new drawing
	public void startNew() {
		drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
		invalidate();
	}
	
	// Calculate distance between points
	public double distance(int x, int y, int x0, int y0) {
		double a, b, result;
		a = x - x0;
		a = Math.pow(a, 2);
		b = y - y0;
		b = Math.pow(b, 2);
		result = Math.sqrt(a + b);
		return result;
	}
}
