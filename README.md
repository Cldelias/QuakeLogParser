PARSER LOG QUAKE

Autor: Clodoaldo Elias
Contato: clodoaldoelias@gmail.com

- Este aplicativo escrito em Java com Spring Boot disponibilizando APIs do parser do Log gerado por um servidor de Quake III.

Como rodar o aplicativo - Back-end

- Com o Java devidamente configurado na maquina, abra o prompt de Comando e entre no diretorio onde se encontra o arquivo
ParserLogQuake.jar
- Rode ele com o comando 'java -jar ParserLogQuake.jar
- Apos a execucao serao criados dois diretorios config e file.
- Faça a copia do(s) aruqivo(s) de log gerado por um servidor de Quaker III para o diretorio file.

Como rodar o aplicativo - Front-end

- Baixar os arquivo do GIT  https://github.com/Cldelias/FrontEndQuakeLog.git
- Com o Node devidamente configurado na maquina, abra o prompt de Comando e entre no diretorio onde se encontra os arquivos
e executar ng serve

Algoritmo utilizado no Programa

- Analizado o Log gerado pelo servidor de Quake, e constatado então as palavras de cada evento:
	A partida inicia com "InitGame";
		0:00 InitGame: \sv_floodProtect\1\sv_maxPing...
	
	O evento de morte de algum Jogador é reconhecido através de "Kill", neste evento obtemos os numeros 
identificadores do player que realizou a kill, do player que foi morto e também do tipo de morte ocorrido;
		22:06 Kill: 2 3 7: Isgalamido killed Mocinha by MOD_ROCKET_SPLASH

- Logo após foi elaborada a estrutura de como o programa iria salvar as informações, para isso foram criadas os 
seguintes classes:
	Player: contem o id, nome, quantidade de veze que matou outro player (kill) e quantidade de mortes do player
    KIll: contem o player que matou , o player morto e tipo de morte
	Game: contem o nome do Game, total de mortes, lista de players e lista de mortes (classe Kill)
	DeathType: Uma Enum com todos os tipos de morte presentes no jogo e seus ID.
    GameDTO: contem as informacoes para retornar na API de relatorio do jogo
    GameInfoKillDTO: contem as informacoes para retornar na API de informações:
        game_1: {
        total_kills: 45;
        players: ["Dono da bola", "Isgalamido", "Zeh"]
        kills: {
          "Dono da bola": 5,
          "Isgalamido": 18,
          "Zeh": 20
        }
      }

- Para realizar o Parser do Log nessas informações foram criadas as seguintes Classes: 
	InfoKill: contem as informacoes do nome e id do player que matou e nome e id do player que morreu e o tipo de morte
	Conversion: Interface com tipo contendo um metodo converter recebendo a linha para converter a texto do log que contém a informacao
    para converte. Essa interface poderá ser extendida para converter outras linhas do jogo quando necessario
    ConverterKill: Implementação da Interface para converter a linha do log que contem a informação da mortes
        22:06 Kill: 2 3 7: Isgalamido killed Mocinha by MOD_ROCKET_SPLASH
    Game: Nessa classe contém os metodos:
        addEventKill: recebe a linha do log, verifica se é a linha de informação de morte e converte utilizando a classe ConverterKill
        getPlayer: retorna um Player pesquisando se ja está lista de players da classe ou retorna um novo, validando se o player não é
        o <world>
        isEndGame : recebe a linha do log e identifica se é a linha de informação de fim de jogo
        isInitGame: recebe a linha do log e identifica se é a linha de informação de inicio do jogo
        getTotalKillsPlayers: retorna um map com o nome e quantidade de vezes que matou outro player
        getTotalDeathsPlayers:  retorna um map com o nome e quantidade de vezes que morreu

- Para disponibilizar as informações via API Rest foram criada as Classes:
    GameLogResource: contem as APIS:
       http://localhost:8080/games/kill/games.log
       http://localhost:8080/games/games.log
       http://localhost:8080/games/files

    GameLogService: contem a regra de negócio de leitura das linhas do arquivo e conversão:

- Para disponibilizar a documentação da API Rest com Swagger acessar:
       http://localhost:8080/swagger-ui.html

- Os fontes do Front-End estão disponiveis no caminho https://github.com/Cldelias/FrontEndQuakeLog.git
- Os fontes do Back-End estão disponiveis no caminho https://github.com/Cldelias/QuakeLogParser.git
