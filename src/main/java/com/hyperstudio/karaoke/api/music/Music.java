package com.hyperstudio.karaoke.api.music;

import java.awt.Image;

/**
 * Music 객체 : 음악을 나타내는 클래스
 * 노래방 : Tj 태진미디어
 * @author Hyper4j
 *
 */
public class Music implements MusicAdapter {
	
	private Image image;
	private int number;
	private String title;
	private String[] singer;
	private String[] composer;
	private String[] lyricist;
	private String lyrics;
	
	/**
	 * 객체 생성으로, 변수에 더해준다.
	 * @param image
	 * @param number
	 * @param title
	 * @param singer
	 * @param composer
	 * @param lyricist
	 * @param lyrics
	 */
	public Music(Image image, int number, String title
			, String[] singer, String[] composer
			, String[] lyricist, String lyrics) {
		
		this.image = image;
		this.number = number;
		this.title = title;
		this.singer = singer;
		this.composer = composer;
		this.lyricist = lyricist;
		this.lyrics = lyrics;
		
	}
	
	
	/**
	 * 앨범 이미지를 가져온다.
	 * @apiNote : Coming Soon...
	 */
	@Override
	public Image getImage() {
		return this.image;
	}
	
	
	/**
	 * 노래방 번호를 가져온다.
	 */
	@Override
	public int getNumber() {
		return this.number;
	}
	
	
	/**
	 * 제목을 가져온다.
	 */
	@Override
	public String getTitle() {
		return this.title;
	}
	
	
	/**
	 * 가수들을 가져온다.
	 */
	@Override
	public String[] getSinger() {
		return this.singer;
	}

	
	/**
	 * 작곡가를 가져온다.
	 */
	@Override
	public String[] getComposer() {
		return this.composer;
	}
	
	
	/**
	 * 작사자를 가져온다.
	 */
	@Override
	public String[] getLyricist() {
		return this.lyricist;
	}
	
	
	/**
	 * 가사를 가져온다.
	 * @apiNote : Coming Soon...
	 */
	@Override
	public String getLyrics() {
		return this.lyrics;
	}
	
	/**
	 * Music 객체를 Json 객체 형태의 String 으로 변환.
	 */
	@Override
	public String toString() {
		
		String[] singerObj = getSinger();
		String singer = "";
		for(int i=0; i<singerObj.length; i++) {
			if(i==0) {
				singer = singerObj[i];
				continue;
			}
			else {
				singer = singer + ", " + singerObj[i];
				continue;
			}
		}
		
		String[] composerObj = getComposer();
		String composer = "";
		for(int i=0; i<composerObj.length; i++) {
			if(i==0) {
				composer = composerObj[i];
				continue;
			}
			else {
				composer = composer + ", " + composerObj[i];
				continue;
			}
		}
		
		String[] lyricistObj = getLyricist();
		String lyricist = "";
		for(int i=0; i<lyricistObj.length; i++) {
			if(i==0) {
				lyricist = lyricistObj[i];
				continue;
			}
			else {
				lyricist = lyricist + ", " + lyricistObj[i];
				continue;
			}
		}
		
		
		String result = "{\"노래방\":\"tj\",\"번호\":\""+getNumber()+"\""
				+ ",\"제목\":\""+getTitle()+"\""
				+ ",\"가수\":\""+singer+"\""
				+ ",\"작곡가\":\""+composer+"\""
				+ ",\"lyricist\":\""+lyricist+"\"}";
		return result;
	}
}