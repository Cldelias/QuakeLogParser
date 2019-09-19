package br.com.cldelias.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.cldelias.converters.Conversion;
import br.com.cldelias.converters.ConverterKill;
import br.com.cldelias.converters.InfoKill;
import br.com.cldelias.enums.TextTypes;
import lombok.Getter;
import lombok.Setter;

public class Game {

	@Getter @Setter
	private String name;
	@Getter @Setter
	private Integer amountKills;
	@Getter @Setter
	private List<Player> players;
	@Getter @Setter
	private List<Kill> kills;
	
	public Game() {
		this.name = "";
		this.amountKills = 0;
		this.players = new ArrayList<Player>();
		this.kills = new ArrayList<Kill>();
	}
	
	public void addEventKill(String line) {
		if (line.contains(TextTypes.KILL.getText())) {
			Conversion<InfoKill> conInfoKill = new ConverterKill();
			InfoKill infoKill = conInfoKill.converter(line);
			if (infoKill != null) {
				Player pKiller = this.getPlayer(infoKill.getKillerId(), infoKill.getKillerName());
				Player pKilled = this.getPlayer(infoKill.getKilledId(), infoKill.getKilledName());
				if (pKiller.isPlayer()) {
					pKiller.addKills();
					kills.add(new Kill(pKiller, pKilled, infoKill.getDeathType()));
				} else {
					pKilled.reduceKills();
				}
				this.amountKills++;
			}
		}
	}
	
	private Player getPlayer(Integer id, String name) {
		/** verifica se o Player ja esta lista de Players **/
		Optional<Player> opPlayer = this.players.stream().filter(p -> p.getId().equals(id)).findFirst();
		if (opPlayer.isPresent()) {
			return opPlayer.get();
		}
		/** nao encontrou na lista criar novo Player **/
		Player p = new Player();
		p.setId(id);
		p.setName(name);
		if (p.isPlayer()) {
			players.add(p);
		}

		return p;
	}
	
	public boolean isEndGame(String line) {
		if (line.contains(TextTypes.END_GAME.getText())) {
			return this.amountKills > 0;
		}
		return false;
	}
	
	public static boolean isInitGame(String line) {
		if (line.contains(TextTypes.INIT_GAME.getText())) {
			return true;
		}
		return false;
	}
	
	public Map<String, Integer> getTotalKillsPlayers() {
		return this.players
				.stream()
				.collect(Collectors.groupingBy(Player::getName, Collectors.reducing(0, Player::getAmountKills, Integer::sum)));
	}
	
	public Map<String, Integer> getTotalDeathsPlayers() {
		return this.players
				.stream()
				.collect(Collectors.groupingBy(Player::getName, Collectors.reducing(0, Player::getAmountDeaths, Integer::sum)));
	}

	public List<String> getInfoKillsPlayers() {
		return this.kills.stream().map(c -> getInfoKillGame(c)).collect(Collectors.toList());
	}
	
	private String getInfoKillGame(Kill kill) {
		StringBuffer sb = new StringBuffer();
		sb.append(kill.getPlayerKiller().getName());
		sb.append(" Killed ");
		sb.append(kill.getPlayerKilled().getName());
		sb.append(" with ");
		sb.append(kill.getDeathType());
		return sb.toString();
	}
	
}
