package br.com.cldelias.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class Player {
	
	private Integer id;
	private String name;
	private Integer amountKills;
	private Integer amountDeaths;
	
	public void addKills() {
		this.amountKills++;
	}
	
	public void addDeaths() {
		this.amountDeaths++;
	}
	

}
