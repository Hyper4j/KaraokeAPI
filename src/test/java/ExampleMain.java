import java.io.IOException;

import com.hyperstudio.karaoke.api.KaraokeAPI;
import com.hyperstudio.karaoke.api.music.Music;
import com.hyperstudio.karaoke.api.music.PopularType;
import com.hyperstudio.karaoke.api.music.exception.APINotWorkedException;

/**
 * 노래방 API 자바 코드 예제
 * @author Hyper4j
 *
 */
public class ExampleMain {
	
	// 메인 메소드
	public static void main(String[] args) {
		try {
			
			// 모든 노래들은 Tj 노래방에서 가져옵니다.
			
			// API 객체를 가져옵니다.
			KaraokeAPI api = new KaraokeAPI();
			
			/**
			 * 12345 번 노래곡 이름을 가져옵니다.
			 */
			Music[] musicList1 = api.getMusicSearch().getMusic(12345);
			System.out.println(musicList1[0].getTitle());
			
			/**
			 * 황인욱 가수님의 노래들을 가져와서, 첫번째로 가져온 곡의 이름을 불러옵니다.
			 */
			Music[] musicList2 = api.getMusicSearch().getMusicSinger("황인욱");
			System.out.println(musicList2[0].getTitle());
			
			
			/**
			 * 포장마차 라는 노래제목의 가수 이름을 가져옵니다.
			 */
			Music[] musicList3 = api.getMusicSearch().getMusicTitle("포장마차");
			System.out.println(musicList3[4].getSinger()[0]);
			
			
			/**
			 * 한달 동안의 인기 노래를 1순위부터 100순위까지 구하기.
			 */
			Music[] musicList = api.getMusicSearch().getMusicPopular(PopularType.DAILY);
			for(int i=0; i<musicList.length; i++) {
				System.out.println(musicList[i].toString());
			}
			
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APINotWorkedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
