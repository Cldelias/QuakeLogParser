package br.com.cldelias.model;

import br.com.cldelias.enums.DeathType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
@NoArgsConstructor 
public class Kill {
	
	@Getter @Setter
	private Player playerKiller;
	@Getter @Setter
	private Player playerKilled;
	@Getter @Setter
	private DeathType deathType;
	
	public Kill(Player playerKiller, Player playerKilled, DeathType deathType) {
		super();
		this.playerKiller = playerKiller;
		this.playerKilled = playerKilled;
		this.deathType = deathType;
	}

}
