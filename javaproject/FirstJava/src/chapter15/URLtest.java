package chapter15;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLtest {

	public static void main(String[] args) {

		String urlStr = "https://news.naver.com/main/read.nhn?mode=LS2D&mid=sec&sid1=105&sid2=228&oid=584&aid=0000008620";
		
		try {
			
			URL url = new URL(urlStr);
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			System.out.println(url.getAuthority());
			try {
				System.out.println(url.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(url.getFile());
			System.out.println(url.getUserInfo());
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		

	}

}
