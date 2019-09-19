package br.com.cldelias.enums;

public enum TextTypes {

	INIT_GAME("InitGame"),
	PLAYER_CONNECT("ClientUserinfoChanged"),
	KILL("Kill"),
	END_GAME("ShutdownGame"),
	WORLD("<world>"),
	;
	
	private TextTypes(String text) {
		this.text = text;
	}
	
	private String text;

	public String getText() {
		return text;
	}
	
	
}
