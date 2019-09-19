package br.com.cldelias.model;

import br.com.cldelias.enums.TextTypes;
import lombok.Getter;
import lombok.Setter;

public class Player {
	
	@Getter @Setter 
	private Integer id;
	@Getter @Setter 
	private String name;
	@Getter @Setter 
	private Integer amountKills;
	@Getter @Setter 
	private Integer amountDeaths;
	
	public Player() {
		this.id = 0;
		this.name = "";
		this.amountKills = 0;
		this.amountDeaths = 0;
	}
	
	public void addKills() {
		this.amountKills++;
	}
	
	public void addDeaths() {
		this.amountDeaths++;
	}
	
	public void reduceDeaths() {
		if (this.amountDeaths > 0) {
			this.amountDeaths--;
		}
	}
	
	public void reduceKills() {
		if (this.amountKills > 0) {
			this.amountKills--;
		}
	}
	
	public boolean isPlayer() {
		return !this.name.contains(TextTypes.WORLD.getText());
	}
	
}
