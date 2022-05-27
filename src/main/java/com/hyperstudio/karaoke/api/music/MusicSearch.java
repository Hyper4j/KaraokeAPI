package com.hyperstudio.karaoke.api.music;

import com.hyperstudio.karaoke.api.Log;
import com.hyperstudio.karaoke.api.music.exception.APINotWorkedException;
import com.hyperstudio.karaoke.api.music.exception.MusicNotValidException.MusicNameNotValidException;
import com.hyperstudio.karaoke.api.music.exception.MusicNotValidException.MusicNumberNotValidException;
import com.hyperstudio.karaoke.api.music.exception.MusicNotValidException.MusicSingerNotValidException;

/**
 * 음악을 검색할 수 있도록 도와주는 객체이다.
 * @author Hyper4j
 *
 */
public class MusicSearch {
	
	
	// 음악 빌더 객체를 가져온다.
	public MusicBuilder musicBuilder = new MusicBuilder();
	
	/**
	 * 노래 가수로, 노래를 찾아본다.
	 * @param singer
	 * @return
	 * @throws APINotWorkedException : API 를 사용중이지 않는가?
	 */
	public Music[] getMusicSinger(String singer) throws APINotWorkedException {
		if(!Log.getUse()) throw new APINotWorkedException();
		try {
			return musicBuilder.build(MusicType.SINGER, new String[] {singer});
		} catch (MusicSingerNotValidException | MusicNameNotValidException | MusicNumberNotValidException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 노래 제목으로, 노래를 찾아본다.
	 * @param title
	 * @return
	 * @throws APINotWorkedException : API 를 사용중이지 않는가?
	 */
	public Music[] getMusicTitle(String title) throws APINotWorkedException {
		if(!Log.getUse()) throw new APINotWorkedException();
		try {
			return musicBuilder.build(MusicType.TITLE, new String[] {title});
		} catch (MusicSingerNotValidException | MusicNameNotValidException | MusicNumberNotValidException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 노래방 번호로, 노래를 찾아본다.
	 * @param number
	 * @return
	 * @throws APINotWorkedException : API 를 사용중이지 않는가?
	 */
	public Music[] getMusic(int musicNumber) throws APINotWorkedException {
		if(!Log.getUse()) throw new APINotWorkedException();
		try {
			return musicBuilder.build(MusicType.NUMBER, new String[] {""+musicNumber});
		} catch (MusicSingerNotValidException | MusicNameNotValidException | MusicNumberNotValidException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 노래방 인기 순위 타입으로, 노래순위를 찾아본다.
	 * @param popularType
	 * @return
	 * @throws APINotWorkedException : API 를 사용중이지 않는가?
	 */
	public Music[] getMusicPopular(PopularType popularType) throws APINotWorkedException {
		if(!Log.getUse()) throw new APINotWorkedException();
		return musicBuilder.build(popularType);
	}
	
}
