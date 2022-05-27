package com.hyperstudio.karaoke.api.music;

import java.awt.Image;

/**
 * Music 객체를 구현하는 MusicAdapter
 * @author Hyper4j
 *
 */
public interface MusicAdapter {
	
	
	public Image getImage();
	
	
	public int getNumber();
	
	
	public String getTitle();
	
	
	public String[] getSinger();
	
	
	public String[] getComposer();
	
	
	public String[] getLyricist();
	
	
	public String getLyrics();
}
