package com.hyperstudio.karaoke.api.music;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;

import com.hyperstudio.karaoke.api.music.exception.MusicNotValidException.MusicNameNotValidException;
import com.hyperstudio.karaoke.api.music.exception.MusicNotValidException.MusicNumberNotValidException;
import com.hyperstudio.karaoke.api.music.exception.MusicNotValidException.MusicSingerNotValidException;
import com.hyperstudio.karaoke.api.utils.JsonAPI;
import com.hyperstudio.karaoke.api.utils.RestfulAPI;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * MusicBuilder : 결과적으로 Music 리스트를 가져오기위해, 여러 메소드들의 총집합.
 * @author Hyper4j
 *
 */
public class MusicBuilder {
	
	/**
	 * MusicType 과 injectObject 로, 그에 맞는 Music 을 불러온다.
	 * @param musicType : TITLE = 제목, SINGER = 가수, NUMBER = 번호
	 * @param injectObject : 텍스트 인수
	 * @return
	 * @throws MusicSingerNotValidException : 가수를 불러오지 못했는가?
	 * @throws MusicNameNotValidException : 노래제목을 불러오지 못했는가?
	 * @throws MusicNumberNotValidException : 노래번호로 불러오지 못했는가?
	 */
	@SuppressWarnings("unchecked")
	public Music[] build(MusicType musicType, Object[] injectObject) throws MusicSingerNotValidException, MusicNameNotValidException, MusicNumberNotValidException {
		
		Music[] result = null;
		switch(musicType) {
			// 입력받은것이 제목이라면?
			case TITLE:
				result = func_build(musicType, injectObject);
				break;
			
			// 입력받은것이 가수라면?
			case SINGER:
				result = func_build(musicType, injectObject);
				break;
			
			// 입력받은것이 노래방 번호라면?
			case NUMBER:
				result = func_build(musicType, injectObject);
				break;
			
			// 일반
			default: break;
		}
		return result;
	}
	
	/**
	 * PopularType 으로, 그에 맞는 인기순위를 1순위부터 100순위까지의 Music 리스트를 가져온다.
	 * @param popularType : DAILY = 매일, WEEKLY = 주일, MONTHLY = 한달
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Music[] build(PopularType popularType) {
		Music[] result = null;
		switch(popularType) {
			// 입력받은것이 매일 이라면?
			case DAILY:
				result = func_Popular(popularType);
				break;
			
			// 입력받은것이 1주일 이라면?
			case WEEKLY:
				result = func_Popular(popularType);
				break;
			
			// 입력받은것이 1달 이라면?
			case MONTHLY:
				result = func_Popular(popularType);
				break;
			
			// 기본
			default: break;
		}
		return result;
	}
	
	// Music[] 을 빌드하기위한 수행 세분화 메소드
	private Music[] func_build(MusicType musicType, Object[] injectObject) {
		RestfulAPI restfulAPI = new RestfulAPI(musicType, injectObject);
		JSONArray musicListArray = JsonAPI.parse(restfulAPI.GET());
		
		Music[] musicArray = new Music[musicListArray.size()];
		int size = 0;
		
		Iterator<Object> iterator = musicListArray.iterator();
		while(iterator.hasNext()) {
			JSONObject musicObject = (JSONObject) iterator.next();
			
			Image image = null;
			int number = Integer.parseInt(((String) musicObject.get("no")));
			String title = (String) musicObject.get("title");
			String[] singer, composer, lyricist;
			
			try {
				singer = (String[]) ((List<String>) musicObject.get("singer")).toArray();
			} catch(ClassCastException e) {
				singer = (String[]) new String[] {(String)musicObject.get("singer")};
			}
			
			try {
				composer = (String[]) ((List<String>) musicObject.get("composer")).toArray();
			} catch(ClassCastException e) {
				composer = (String[]) new String[] {(String)musicObject.get("composer")};
			}
			
			try {
				lyricist = (String[]) ((List<String>) musicObject.get("lyricist")).toArray();
			} catch(ClassCastException e) {
				lyricist = (String[]) new String[] {(String)musicObject.get("lyricist")};
			}
			String lyrics = null;
			
			Music music = new Music(image, number, title, singer, composer, lyricist, lyrics);
			musicArray[size] = music;
			size++;
		}
		return musicArray;
	}
	
	// Music[] 을 빌드하기위한 수행 세분화 메소드
	private Music[] func_Popular(PopularType popularType) {
		RestfulAPI restfulAPI = new RestfulAPI(popularType);
		JSONArray musicListArray = JsonAPI.parse(restfulAPI.GET());
		
		Music[] musicArray = new Music[musicListArray.size()];
		int size = 0;
		
		Iterator<Object> iterator = musicListArray.iterator();
		while(iterator.hasNext()) {
			JSONObject musicObject = (JSONObject) iterator.next();
			
			Image image = null;
			int number = Integer.parseInt(((String) musicObject.get("no")));
			String title = (String) musicObject.get("title");
			String[] singer, composer, lyricist;
			
			try {
				singer = (String[]) ((List<String>) musicObject.get("singer")).toArray();
			} catch(ClassCastException e) {
				singer = (String[]) new String[] {(String)musicObject.get("singer")};
			}
			
			try {
				composer = (String[]) ((List<String>) musicObject.get("composer")).toArray();
			} catch(ClassCastException e) {
				composer = (String[]) new String[] {(String)musicObject.get("composer")};
			}
			
			try {
				lyricist = (String[]) ((List<String>) musicObject.get("lyricist")).toArray();
			} catch(ClassCastException e) {
				lyricist = (String[]) new String[] {(String)musicObject.get("lyricist")};
			}
			String lyrics = null;
			
			Music music = new Music(image, number, title, singer, composer, lyricist, lyrics);
			musicArray[size] = music;
			size++;
		}
		return musicArray;
	}
	
}
