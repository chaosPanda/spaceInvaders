package com.badlogic.gamedev.spaceinvaders;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;

import com.badlogic.gamedev.tools.GameActivity;

public class SoundManager 
{
	SoundPool soundPool;
	AudioManager audioManager;
	MediaPlayer mediaPlayer;
	int shotId;
	int explosionId;
	
	public SoundManager( GameActivity activity )
	{
		soundPool = new SoundPool( 5, AudioManager.STREAM_MUSIC, 0);						// stream music
		audioManager = (AudioManager)activity.getSystemService(Context.AUDIO_SERVICE);
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		 
		try
		{
			AssetFileDescriptor descriptor = activity.getAssets().openFd( "shot.ogg" );		// shot.ogg
			shotId = soundPool.load( descriptor, 1 );
			descriptor = activity.getAssets().openFd( "explosion.ogg" );					// explosion.ogg
			explosionId = soundPool.load( descriptor, 1 );
		}
		catch( Exception ex )
		{
			Log.d( "Sound Sample", "couldn't load sound 'shot.ogg'" );						// exception for shot.ogg not found
			throw new RuntimeException( ex );
		}
		
		mediaPlayer = new MediaPlayer();
		try
		{
			AssetFileDescriptor descriptor = activity.getAssets().openFd( "8.12.mp3" );		// background music
			mediaPlayer.setDataSource( descriptor.getFileDescriptor() );
			mediaPlayer.prepare();
			mediaPlayer.setLooping(true);
			mediaPlayer.start();			
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			Log.d( "Sound Sample", "couldn't load music 'music.mp3'" );						// exception if music.mp3 not found
			throw new RuntimeException( ex );
		}
	}
	
	public void playShotSound( )
	{
		int volume = audioManager.getStreamVolume( AudioManager.STREAM_MUSIC );				// stream shot sound
		soundPool.play(shotId, volume, volume, 1, 0, 1);
	}
	
	public void playExplosionSound( )
	{
		int volume = audioManager.getStreamVolume( AudioManager.STREAM_MUSIC );				// stream explosion sound
		soundPool.play(explosionId, volume, volume, 1, 0, 1);
	}
	
	public void dispose( )
	{
		soundPool.release();
		mediaPlayer.stop();
		mediaPlayer.release();
	}
}
