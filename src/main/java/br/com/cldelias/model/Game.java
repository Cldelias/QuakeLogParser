package br.com.cldelias.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
public class Game {

	private String name;
	private Integer amountKills;
	private List<Player> players;
	private List<Kill> kills;
}
