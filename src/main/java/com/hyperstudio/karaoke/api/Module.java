package com.hyperstudio.karaoke.api;

/**
 * KaraokeAPI : 노래방 API 정보
 * @author Hyper4j
 *
 */
public class Module {
	
	private String name = "KarokeAPI";
	private String version = "1.0.0";
	private String author = "Hyper4j";
	private String supported = "https://api.manana.kr/karaoke";
	private String supportedAuthor = "PureANI";
	private String license = "MIT License";
	private String copyright = "오픈소스로 배포된 API, 이를 이용하여 프로그램 개발에 동의하지만, 그 프로그램에 API 사용 출처를 명시해야한다.";
	
	
	public String[] getInfo() {
		String[] message = new String[9];
		message[0] = "==============================";
		message[1] = "이름: " + name;
		message[2] = "버전: " + version;
		message[3] = "제작자: " + author;
		message[4] = "지원: " + supported;
		message[5] = "지원제작자: " + supportedAuthor;
		message[6] = "라이센스: " + license;
		message[7] = "ㄴ " + copyright;
		message[8] = "==============================";
		return message;
	}
	
}
