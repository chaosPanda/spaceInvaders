package com.badlogic.gamedev.spaceinvaders;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gamedev.tools.GameActivity;

public interface GameScreen 
{
	public void update( GameActivity activity );			// update GameScreen
	public void render( GL10 gl, GameActivity activity );	// render GameScreen
	public boolean isDone( );								// check if done
	public void dispose( );				
}
