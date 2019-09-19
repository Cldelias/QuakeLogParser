package br.com.cldelias.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cldelias.model.Game;
import lombok.Getter;
import lombok.Setter;

public class GameDTO {
	
	@Getter 
	@Setter 
	private String nameGame;
	@Getter 
	@Setter 
	private Integer amountKills;
	@Getter 
	@Setter 
	private List<String> players;

	@Getter 
	@Setter 
	private List<String> kills;
	
	public GameDTO(Game game) {
		this.nameGame = game.getName();
		this.amountKills = game.getAmountKills();
		this.players = game.getPlayers().stream().map(g -> g.getName()).collect(Collectors.toList());
		this.kills = game.getInfoKillsPlayers();
	}

}
