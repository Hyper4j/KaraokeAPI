package com.hyperstudio.karaoke.api.music.exception;

/**
 * 어떠한 문제라도 발생했을 시, 해당 예외를 발생시킨다.
 * @author Hyper4j
 *
 */
public class ErrorOccurredException extends Exception {
	
	
	public ErrorOccurredException() {
		super("알 수 없는 오류가 발생했습니다.");
	}
	
}
