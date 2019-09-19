package br.com.cldelias.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
public class DirApp {
	
	
	@Getter
	@Setter
	private Path dirBase;
	@Getter
	@Setter
	private Path dirConf;
	@Getter
	@Setter
	private Path dirFile;
	
	@Getter
	@Setter
	private String fileSeparator;
	
	public void configurar() {
		this.fileSeparator = System.getProperty("file.separator");
		this.dirBase = Paths.get(System.getProperty("user.dir"));
		try {
			this.dirConf = this.dirBase.resolve("config");
			this.createDir(this.dirConf);
		} catch (Exception e) {
		}
		try {
			this.dirFile = this.dirBase.resolve("file");
			this.createDir(this.dirFile);
		} catch (Exception e) {
		}
	}
		
	private void createDir(Path p) throws Exception {
		if (!Files.exists(p) ) {
			Files.createDirectories(p);
		}
	}

}
