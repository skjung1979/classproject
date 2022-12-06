package com.first.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.first.app.mapper") // 여기를 스캔하도록 한다.
public class FirstBootAppApplication {

	// 이 메인 메소드가 시작점(WAS 구동되는 곳)이다!
	public static void main(String[] args) {
		SpringApplication.run(FirstBootAppApplication.class, args);
	}

}
