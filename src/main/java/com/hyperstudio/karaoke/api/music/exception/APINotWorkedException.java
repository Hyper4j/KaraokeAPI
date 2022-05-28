package com.hyperstudio.karaoke.api.music.exception;

/**
 * API 를 사용중이지 않을때, 해당 예외처리를 발생시킨다.
 * @author Hyper4j
 *
 */
public class APINotWorkedException extends Exception {
	
	
	public APINotWorkedException() {
		super("API 를 제대로 사용해주십시오.");
	}
	
}
