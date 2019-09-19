package br.com.cldelias.converters;

import br.com.cldelias.enums.DeathType;
import lombok.Getter;
import lombok.Setter;

public class InfoKill {
	
	@Getter
	@Setter
	private String killerName;
	@Getter
	@Setter
	private Integer killerId;
	@Getter
	@Setter
	private String killedName;
	@Getter
	@Setter
	private Integer killedId;
	@Getter
	@Setter
	private DeathType deathType;

}
