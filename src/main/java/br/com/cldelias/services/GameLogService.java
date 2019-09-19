package br.com.cldelias.services;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cldelias.model.Game;
import br.com.cldelias.services.exceptions.ConversionException;
import br.com.cldelias.services.exceptions.FileIntegrityException;
import br.com.cldelias.utils.DirApp;

@Service
public class GameLogService {

	@Autowired
	private DirApp dirApp;
	
	private Game game;
	
	private Integer numberGame;
	
	public List<Game> getListInfoGame(String nameFile) {
		List<Game> lista = new ArrayList<>();
		this.numberGame = 1;
		Path path = Paths.get(dirApp.getDirFile() + dirApp.getFileSeparator() + nameFile.toString());
		if (!path.toFile().exists()) {
			throw new FileIntegrityException("File not exists " + path.toFile().getAbsolutePath());
		}
		try (Stream<String> s = Files.lines(path)) {
			s.forEach(l -> generateInfoGame(l, lista));
		} catch (IOException e) {
			throw new FileIntegrityException("File error read " + e.getMessage());
		} catch (ConversionException e) {
			throw e;
		}
		if (lista.isEmpty()) {
			throw new FileIntegrityException("File is clear");
		}
		return lista;
	}

	private void generateInfoGame(String line, List<Game> lista) {
		try {
			if (Game.isInitGame(line)) {
				this.game = new Game();
				this.game.setName("Game " + numberGame++);
			}
			if (this.game != null) {
				this.game.addEventKill(line);
			}
			if (this.game != null && this.game.isEndGame(line)) {
				lista.add(this.game);
			}
		} catch (ConversionException e) {
			throw e;
		}
	}

	public List<String> getListFiles()  {
		List<String> lista = new ArrayList<String>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirApp.getDirFile(), "*{log}")) {
			stream.forEach(f->{
				lista.add(f.getFileName().toString());
			});
		} catch (IOException e) {
			throw new FileIntegrityException("Error list files " + e.getMessage());
		}
		return lista;
	}
}
