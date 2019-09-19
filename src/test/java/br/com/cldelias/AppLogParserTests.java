package br.com.cldelias;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cldelias.model.Game;
import br.com.cldelias.services.GameLogService;
import br.com.cldelias.services.exceptions.FileIntegrityException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppLogParserTests {
	
	@Autowired
	GameLogService gameLogService;

	/**
	 * Verifica se retorna FileIntegrityException quando o arquivo nao existe
	 * @throws Exception
	 */
	@Test(expected = FileIntegrityException.class)
	public void getListInfoGameNoSuchFileException() throws Exception {
		gameLogService.getListInfoGame("gm.log");
	}
	
	/**
	 * Verifica se retorna a lista preenchida 
	 * @throws Exception
	 */
	@Test()
	public void getListInfoGame() {
		List<Game> lista = this.gameLogService.getListInfoGame("games.log");
		assertTrue(lista.size() > 0);
	}
	
	/**
	 * Verifica se retorna a FileIntegrityException quando o arquivo estiver vazio
	 * @throws Exception
	 */
	@Test(expected = FileIntegrityException.class)
	public void getListInfoGameFileClear() throws Exception {
		List<Game> lista = this.gameLogService.getListInfoGame("games1.log");
		assertTrue(lista.size() == 0);
	}

	/**
	 * Lista o diretorio para capturar os arquivos de LOGs disponiveis
	 */
	@Test()
	public void getListFiles() {
		List<String> lista = this.gameLogService.getListFiles();
		assertTrue(lista.size() > 0);
	}

}
