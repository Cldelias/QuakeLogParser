package br.com.cldelias.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cldelias.dto.GameDTO;
import br.com.cldelias.dto.GameInfoKillDTO;
import br.com.cldelias.model.Game;
import br.com.cldelias.services.GameLogService;

@RestController
@RequestMapping(value="/games")
public class GameLogResource {
	
	@Autowired
	private GameLogService gameLogService;
	
	@RequestMapping(value = "/files", method=RequestMethod.GET)
	public ResponseEntity<List<String>> findFiles() {
		List<String> list = this.gameLogService.getListFiles();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/kill/{fileName}", method=RequestMethod.GET)
	public ResponseEntity<List<GameInfoKillDTO>> findInfoKill(@PathVariable(name = "fileName") String fileName) {
		List<Game> list = this.gameLogService.getListInfoGame(fileName);
		List<GameInfoKillDTO> listaDto = list.stream().map(c -> new GameInfoKillDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	@RequestMapping(value = "/{fileName}", method=RequestMethod.GET)
	public ResponseEntity<List<GameDTO>> find(@PathVariable(name = "fileName") String fileName) {
		List<Game> list = this.gameLogService.getListInfoGame(fileName);
		List<GameDTO> listaDto = list.stream().map(c -> new GameDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

}
