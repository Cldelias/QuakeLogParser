package br.com.cldelias.enums;

public enum DeathType {
	
	MOD_SHOTGUN(1),
	MOD_MACHINEGUN(3),
	MOD_ROCKET(6),
	MOD_ROCKET_SPLASH(7),
	MOD_RAILGUN(10),
	MOD_BFG(12),
	MOD_BFG_SPLASH(13),
	MOD_CRUSH(17),
	MOD_TELEFRAG(18),
	MOD_FALLING(19),
	MOD_TRIGGER_HURT(22),
	;
	
	private DeathType(Integer id) {
		this.id = id;
	}
	
	private Integer id;

	public Integer getId() {
		return id;
	}
	
}
