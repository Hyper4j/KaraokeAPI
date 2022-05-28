package com.hyperstudio.karaoke.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Formatter + 클래스 로써 쓰임.
 * @author Hyper4j
 *
 */
public class Log extends Formatter {
	
	// Logger 를 가져옴.
	public static Logger LOG = Logger.getLogger("KaraokeAPI");
	
	// Logger 를 포멧하기위한 메소드.
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		buf.append(calcDate(rec.getMillis()));
		
		buf.append(" [");
		buf.append(rec.getLevel());
		buf.append("] ");
		
		buf.append(rec.getMessage());
		buf.append("\n");
		return buf.toString();
	}
	
	// 현재 시각을 나타내기 위한 메소드
	private String calcDate(long millisecs) {
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date resultdate = new Date(millisecs);
		return date_format.format(resultdate);
	}
	
	// KaraokeAPI 에서 해당 변수를 설정할 수 있다.
	protected static boolean useAPI = false;
	
	public static boolean getUse() {
		return useAPI;
	}
}
