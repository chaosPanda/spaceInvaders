package com.badlogic.gamedev;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gamedev.spaceinvaders.SpaceInvaders;
import com.badlogic.gamedev.tools.GameActivity;

public class Main extends ListActivity 
{
	// onCreate - if app starts, startActivity SpaceInvaders.class
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState); 
		
		Intent intent = null;
		
		intent = new Intent( this, SpaceInvaders.class );
		startActivity( intent );        
	}
}