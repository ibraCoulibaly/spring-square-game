package com.square.game;

import com.square.game.controller.user.DbAccess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GameApplication implements CommandLineRunner {
	public static void main(String[] args) {

		SpringApplication.run(GameApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception{
		DbAccess dbAccess = DbAccess.getInstance();
		if (dbAccess.getCon() != null){
			System.out.println("It worked");
		} else {
			System.out.println("NOOO");
		}
	}

}
