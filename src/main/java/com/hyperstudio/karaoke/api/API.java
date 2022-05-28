package com.hyperstudio.karaoke.api;

import com.hyperstudio.karaoke.api.music.MusicSearch;

/**
 * API : KaraokeAPI 객체에 넣어주기 위해 만들었다.
 * @author Hyper4j
 *
 */
public class API implements ApplicationProgrammingInterface {
	
	
	/**
	 * MusicSearch 라는 클래스를 불러온다.
	 */
	@Override
	public MusicSearch getMusicSearch() {
		
		return new MusicSearch();
	}
	
	
	
}

/**
 * ApplicationProgrammingInterface : API 가 구현하기 위해 존재한다.
 * @author Hyper4j
 *
 */
interface ApplicationProgrammingInterface {
	
	public MusicSearch getMusicSearch();
	
}