package com.hyperstudio.karaoke.api.music.exception;

import com.hyperstudio.karaoke.api.music.MusicType;

/**
 * 음악을 검색할 수 없을때, 해당 예외들을 발생시킨다.
 * MusicNotValidException : 예외처리들을 가지고있는 부모 클래스
 * @author Hyper4j
 *
 */
public class MusicNotValidException {
	
	// 예외처리문 시작.
	public MusicNotValidException(MusicType musicExamples) throws MusicSingerNotValidException, MusicNameNotValidException, MusicNumberNotValidException {
		switch(musicExamples) {
			// 가수라면?
			case SINGER: throw new MusicSingerNotValidException("해당 가수 이름으로, 찾을 수 없습니다.");
			
			// 제목이라면?
			case TITLE: throw new MusicNameNotValidException("해당 제목으로 찾을 수 없습니다.");
			
			// 노래방 번호라면?
			case NUMBER: throw new MusicNumberNotValidException("해당 번호로 찾을 수 없습니다.");
			
			// 기본
			default: break;
		}
		
	}
	
	/**
	 * 음악 제목을 검색할 수 없을때 해당 예외를 발생시킨다.
	 * @author Hyper4j
	 *
	 */
	public static class MusicNameNotValidException extends Exception {
		
		public MusicNameNotValidException(String exception) {
			super(exception);
		}
		
	}
	
	/**
	 * 음악 가수를 검색할 수 없을때 해당 예외를 발생시킨다.
	 * @author Hyper4j
	 *
	 */
	public static class MusicSingerNotValidException extends Exception {
		
		public MusicSingerNotValidException(String exception) {
			super(exception);
			
		}
		
	}
	
	/**
	 * 노래방 번호로 검색할 수 없을때 해당 예외를 발생시킨다.
	 * @author Hyper4j
	 *
	 */
	public static class MusicNumberNotValidException extends Exception {
		
		public MusicNumberNotValidException(String exception) {
			super(exception);
		}
		
	}
	
}