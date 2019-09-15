package br.com.cldelias.model;

import br.com.cldelias.enums.DeathType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
public class Kill {
	
	private Player playerKiller;
	private Player playerKilled;
	private DeathType deathType;

}
