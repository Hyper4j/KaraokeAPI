package com.hyperstudio.karaoke.api.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.hyperstudio.karaoke.api.Log;
import com.hyperstudio.karaoke.api.music.MusicType;
import com.hyperstudio.karaoke.api.music.PopularType;

/**
 * 노래방 공용 검색 API Manana
 * GET 파라미터로, 노래 검색
 * @author Hyper4j
 *
 */
public class RestfulAPI implements Restful {
	
	// 기본 소스 URL
	private static String url = "https://api.manana.kr/karaoke";
	
	// GET 파라미터 전용 주입 URL
	private static String injectUrl = "";
	
	/**
	 * 음악 타입과 검색값으로, URL 빌드
	 * @param musicType
	 * @param InjectObject
	 */
	public RestfulAPI(MusicType musicType, Object[] InjectObject) {
		
		switch(musicType) {
			case TITLE:
				
				String title = (String) ((String[]) InjectObject)[0];
				injectUrl = url + "/song/" + title.replace(" ", "") + "/tj.json";
				break;
				
			case SINGER:
				
				String singer = (String) ((String[]) InjectObject)[0];
				injectUrl = url + "/singer/" + singer.replace(" ", "") + "/tj.json";
				break;
				
			case NUMBER:
				
				int number = Integer.parseInt(((String[]) InjectObject)[0]);
				injectUrl = url + "/no/" + number + "/tj.json";
				break;
				
			default: break;
		}
		
	}
	
	/**
	 * 인기타입으로, URL 빌드
	 * @param popularType
	 */
	public RestfulAPI(PopularType popularType) {
		injectUrl = url + "/popular/tj/" + popularType.name().toLowerCase() + ".json";
	}
	
	/**
	 * GET 파라미터
	 * HttpUrlConnection 으로, InjectURL 로 접속하여, JSON 을 가져온다.
	 */
	@Override
	public String GET() {
		if(injectUrl.equals("")) return null;
		String result = "";
		InputStream is = null;
		try {

			URL url = new URL(injectUrl);
			URLConnection urlConnection = url.openConnection();
			try {
				is = urlConnection.getInputStream();
			}
			catch(ConnectException e) {
				Log.LOG.warning("API 와 연결이 되지않아, 소프트웨어를 종료합니다.");
				System.exit(0);
			}
			byte[] buffer = new byte[1024];
			int readBytes;
			while ((readBytes = is.read(buffer)) != -1) {
				result = result + new String(buffer, 0, readBytes);
			}
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// POST 파라미터
	@Override
	public void POST() {}
	
	// DELETE 파라미터
	@Override
	public void DELETE(Object object) {}
	
	// PUT 파라미터
	@Override
	public void PUT(Object object) {}
	
	
}

/**
 * RestfulAPI 객체를 구현시켜주기 위해 존재.
 * @author Hyper4j
 *
 */
interface Restful {
	public String GET();
	public void POST();
	public void DELETE(Object object);
	public void PUT(Object object);
}
