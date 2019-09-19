package br.com.cldelias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cldelias.utils.DirApp;

@SpringBootApplication
public class AppLogParser implements CommandLineRunner {
	
	@Autowired
	private DirApp dirApp;

	public static void main(String[] args) {
		SpringApplication.run(AppLogParser.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.dirApp.configurar();
	}


}
