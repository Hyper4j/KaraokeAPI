package com.hyperstudio.karaoke.api;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 노래방 API : Ver 1.0.0
 * 
 * @author Hyper4j
 *
 */
public class KaraokeAPI extends API {
	
	public KaraokeAPI() throws SecurityException, IOException {
		Log.useAPI = true;
		
		// INFO 로그를 깔끔하게 만들어줌.
		Log.LOG.addHandler(getHandler());
		
		Log.LOG.log(Level.INFO, "API 를 불러오는중입니다...");
		
		// 로그 실행
		run();
		Log.LOG.log(Level.INFO, "API 를 불러오기 성공..!");
	}
	
	private void run() {
		Module module = new Module();
		for(int i=0; i<module.getInfo().length; i++) {
			Log.LOG.log(Level.INFO, module.getInfo()[i]);
		}
		
	}
	
	/**
	 * Logger 를 Formmatter 하기위해, 생성.
	 * @return
	 */
	private Handler getHandler() {
		Logger rootLogger = Logger.getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		if (handlers[0] instanceof ConsoleHandler) {
			rootLogger.removeHandler(handlers[0]);
		}
		
		Log.LOG.setLevel(Level.INFO);
		
		Handler handler = new ConsoleHandler();
		
		Log formatter = new Log();
		handler.setFormatter(formatter);
		return handler;
	}
	
}
