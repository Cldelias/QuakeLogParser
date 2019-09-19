package br.com.cldelias.converters;

import br.com.cldelias.enums.DeathType;
import br.com.cldelias.services.exceptions.ConversionException;

public class ConverterKill implements Conversion<InfoKill> {
	
	public InfoKill converter(String line) {
		InfoKill info = null;
		try {
			String[] lineKill = line.split("(: | killed)");
			if (lineKill != null && lineKill.length > 2) {
				info = new InfoKill();
				String[] lineIdsKill = lineKill[1].split("\\s");
				String[] lineKilled = lineKill[3].split("by");
				/** Informacoes player killer **/
				info.setKillerId(Integer.parseInt(lineIdsKill[0]));
				info.setKillerName(lineKill[2].trim());
				/** Informacoes player killed**/
				if (lineKilled.length > 0) {
					info.setKilledId(Integer.parseInt(lineIdsKill[1]));
					info.setKilledName(lineKilled[0].trim());
				}
				/** Death Type**/
				info.setDeathType(DeathType.getDeathType(Integer.parseInt(lineIdsKill[2])));
			}
		} catch (Exception e) {
			info = null;
			throw new ConversionException("Error ConverterKill " + e.getMessage());			
		}
		return info;
	}
	
	

}
