<p align="center">
  <img src="./assets/banner.svg" alt="F1 Manager 2026" width="100%" />
</p>

<p align="center">
  <strong>Um projeto de estudos que transforma o conteúdo de Java + Banco de Dados + Spring em um sistema inspirado na temporada 2026 de Fórmula 1.</strong>
</p>

<p align="center">
  🟥 <strong>STATUS:</strong> EM CONSTRUÇÃO &nbsp;&nbsp;•&nbsp;&nbsp;
  🏁 <strong>FASE ATUAL:</strong> FUNDAMENTOS DE POO &nbsp;&nbsp;•&nbsp;&nbsp;
  🎓 <strong>CONTEXTO:</strong> ADS — 2º SEMESTRE
</p>

<p align="center">
  <code>POO</code> • <code>JDBC</code> • <code>DAO</code> • <code>CRUD</code> • <code>ORACLE</code> • <code>SPRING BOOT</code> • <code>SERVICE</code> • <code>CONTROLLER</code> • <code>REST</code>
</p>

<p align="center">
  <a href="#-o-projeto">Projeto</a> •
  <a href="#-tech-garage">Tecnologias</a> •
  <a href="#-circuito-de-aprendizado">Trilha</a> •
  <a href="#-arquitetura-final">Arquitetura</a> •
  <a href="#-grid-2026">Grid 2026</a> •
  <a href="#-roadmap">Roadmap</a>
</p>

<p align="center">
  <img src="./assets/divider.svg" alt="divisor" width="100%" />
</p>

🏎️ O Projeto

O F1 Manager 2026 nasce com um objetivo simples: aprender, de verdade, como uma aplicação Java sai de uma classe comum e evolui até conversar com banco de dados e receber requisições HTTP.

Em vez de estudar cada assunto isoladamente, o projeto cresce junto com os conceitos vistos em aula. Cada nova etapa adiciona uma peça ao sistema e responde uma pergunta diferente:

Pergunta

Conceito que resolve

Como represento um piloto dentro do Java?

Classe, objeto, atributos e encapsulamento

Como salvo esse piloto de forma permanente?

Oracle + JDBC

Quem fica responsável pelos comandos SQL?

DAO

Como cadastrar, buscar, alterar e excluir?

CRUD

Como ligo um piloto à sua equipe?

Relacionamento entre objetos + FK

Como aplico regras antes de acessar o banco?

Service

Como o sistema recebe GET, POST, PUT e DELETE?

Controller + Spring Boot

Como uma tela conversa com tudo isso?

API REST + front-end

Meta do projeto: chegar ao ponto em que seja possível olhar para Controller → Service → DAO → Banco e saber exatamente o motivo de cada camada existir.

🏁 Domínio do sistema

O sistema será construído em torno de quatro entidades principais:

erDiagram
EQUIPE ||--o{ PILOTO : possui
PILOTO ||--o{ RESULTADO : conquista
GRANDE_PREMIO ||--o{ RESULTADO : gera

    EQUIPE {
        int id
        string nome
        string pais
    }

    PILOTO {
        int id
        string nome
        int numero
        string nacionalidade
        double pontos
        Equipe equipe
    }

    GRANDE_PREMIO {
        int id
        string nome
        string pais
        string circuito
        date data
    }

    RESULTADO {
        int id
        int posicao
        double pontosGanhos
        boolean voltaMaisRapida
    }

Relação mais importante no começo

Equipe 1 ───────────── N Pilotos

Um piloto pertence a uma equipe, portanto o objeto Java não ficará apenas com um número solto de equipe. Quando chegarmos aos relacionamentos, queremos algo como:

public class Piloto {

    private int id;
    private String nome;
    private int numero;
    private String nacionalidade;
    private double pontos;
    private Equipe equipe;

}

Isso permite pensar em objetos de verdade:

piloto.getEquipe().getNome();

em vez de tratar tudo como valores desconectados.

<p align="center">
  <img src="./assets/divider.svg" alt="divisor" width="100%" />
</p>

🧰 Tech Garage

<p align="center">
  <img src="./assets/tech-strip.svg" alt="Tecnologias do projeto" width="100%" />
</p>

Tecnologia

Papel no projeto

Java

POO, models, regras, DAO, Service e Controller

IntelliJ IDEA

Ambiente principal de desenvolvimento

Oracle Database

Persistência das informações

SQL

Criação das tabelas e operações CRUD

JDBC / OJDBC

Ponte entre Java e Oracle

Spring Boot

Aplicação web e API REST

HTML / CSS / JavaScript

Interface que consumirá a API

Git + GitHub

Versionamento e registro da evolução do estudo

As ferramentas entram no projeto apenas quando o conteúdo exige. A ideia não é esconder o funcionamento atrás de frameworks antes de entender o básico.

🛣️ Circuito de aprendizado

O projeto segue a mesma linha de evolução utilizada nas aulas, adaptando a aplicação de agenda para o universo da Fórmula 1.

Etapa

Conteúdo

Implementação no F1 Manager

01

Classes, objetos, atributos, encapsulamento

Piloto e Equipe

02

Oracle + JDBC + ConnectionFactory

Java estabelece conexão com o banco

03

PreparedStatement + INSERT

cadastrar piloto

04

ResultSet + SELECT

buscar piloto por ID

05

UPDATE + DELETE + List

CRUD completo

06

Relacionamento 1

Equipe → Pilotos

07

Relacionamento N

Piloto ↔ GP através de Resultado

08

Transações

commit() e rollback()

09

Spring Boot

transformar o sistema em aplicação web

10

Controller

endpoints GET / POST / PUT / DELETE

11

Service

regras de negócio entre Controller e DAO

12

Front-end

tela consumindo a API

Racing line das aulas

A evolução utilizada como referência de estudo é:

14/08  → acesso ao banco de dados
20/08  → cadastrar + buscar por ID
21/08  → alterar + excluir + listar
27/08  → relacionamento 1:N
03/09  → relacionamento N:N
10/09  → integração web + banco
11/09  → PUT + DELETE no Controller
17/09  → Service + Controller

A proposta é não pular etapas: cada parte do F1 Manager deve existir porque um conceito novo passou a ser necessário.

🧱 Arquitetura final

Quando o projeto estiver completo, uma requisição deverá percorrer este caminho:

flowchart LR
USER["🏁 Usuário"] --> FRONT["Front-end"]
FRONT -->|HTTP / JSON| CTRL["Controller"]
CTRL --> SERVICE["Service"]
SERVICE --> DAO["DAO"]
DAO -->|JDBC| DB[("Oracle")]
DB --> DAO
DAO --> SERVICE
SERVICE --> CTRL
CTRL -->|JSON| FRONT

    style CTRL fill:#e10600,color:#ffffff,stroke:#ff4b45,stroke-width:2px
    style SERVICE fill:#151515,color:#ffffff,stroke:#e10600,stroke-width:2px
    style DAO fill:#151515,color:#ffffff,stroke:#e10600,stroke-width:2px
    style DB fill:#e10600,color:#ffffff,stroke:#ff4b45,stroke-width:2px

Quem faz o quê?

CONTROLLER
│  recebe a requisição HTTP
│  lê @PathVariable e @RequestBody
│
▼
SERVICE
│  verifica regras de negócio
│  decide se a operação pode acontecer
│
▼
DAO
│  monta e executa SQL
│  usa Connection / PreparedStatement / ResultSet
│
▼
ORACLE
guarda e devolve os dados

Essa separação é o coração da fase mais importante do projeto.

🌐 API planejada

Quando a etapa Spring Boot chegar, a aplicação deverá oferecer rotas semelhantes a estas:

Método

Endpoint

Função

GET

/pilotos

listar pilotos

GET

/pilotos/{id}

buscar piloto

POST

/pilotos

cadastrar piloto

PUT

/pilotos/{id}

alterar piloto

DELETE

/pilotos/{id}

excluir piloto

GET

/equipes

listar equipes

GET

/grandes-premios

listar GPs

GET

/classificacao

visualizar classificação

Exemplo do caminho de uma atualização:

PUT /pilotos/44
│
▼
PilotoController
│
▼
PilotoService.atualizar(...)
│
▼
PilotoDAO.alterar(...)
│
▼
UPDATE TBL_PILOTO ...

🗃️ Banco de dados

Modelagem inicial planejada:

TBL_EQUIPE
├── ID_EQUIPE        PK
├── NOME
└── PAIS

TBL_PILOTO
├── ID_PILOTO        PK
├── NOME
├── NUMERO
├── NACIONALIDADE
├── PONTOS
└── ID_EQUIPE        FK → TBL_EQUIPE

TBL_GRANDE_PREMIO
├── ID_GP            PK
├── NOME
├── PAIS
├── CIRCUITO
└── DATA_GP

TBL_RESULTADO
├── ID_RESULTADO     PK
├── ID_PILOTO        FK
├── ID_GP            FK
├── POSICAO
├── PONTOS_GANHOS
└── VOLTA_MAIS_RAPIDA

A tabela TBL_RESULTADO será especialmente importante porque transforma uma relação N em uma entidade capaz de armazenar informações da participação do piloto em cada corrida.

🏎️ Grid 2026

<p align="center">
  <img src="./assets/grid-2026.svg" alt="Grid de equipes e pilotos de 2026" width="100%" />
</p>

O grid serve como referência temática para popular o banco durante os estudos.

Equipe

Pilotos

Mercedes

George Russell • Kimi Antonelli

Ferrari

Charles Leclerc • Lewis Hamilton

McLaren

Lando Norris • Oscar Piastri

Red Bull Racing

Max Verstappen • Isack Hadjar

Racing Bulls

Liam Lawson • Arvid Lindblad

Alpine

Pierre Gasly • Franco Colapinto

Haas F1 Team

Esteban Ocon • Oliver Bearman

Audi

Nico Hulkenberg • Gabriel Bortoleto

Williams

Carlos Sainz • Alexander Albon

Aston Martin

Fernando Alonso • Lance Stroll

Cadillac

Sergio Perez • Valtteri Bottas

Grid temático atualizado para a temporada 2026. Os dados esportivos são usados apenas como contexto educacional do projeto.

📁 Estrutura do repositório

A estrutura cresce conforme novas camadas forem estudadas:

f1-manager-2026/
│
├── README.md
├── assets/
│   ├── banner.svg
│   ├── divider.svg
│   ├── grid-2026.svg
│   └── tech-strip.svg
│
├── database/
│   ├── create-tables.sql
│   ├── inserts.sql
│   └── queries.sql
│
├── docs/
│   ├── 01-poo.md
│   ├── 02-jdbc-connection.md
│   ├── 03-dao-crud.md
│   ├── 04-relacionamentos.md
│   ├── 05-spring.md
│   └── 06-service-controller.md
│
└── src/
└── br/com/fiap/f1/
├── models/
│   ├── Piloto.java
│   ├── Equipe.java
│   ├── GrandePremio.java
│   └── Resultado.java
│
├── dao/
│   ├── ConnectionFactory.java
│   ├── PilotoDAO.java
│   ├── EquipeDAO.java
│   └── ResultadoDAO.java
│
├── service/
│   ├── PilotoService.java
│   └── EquipeService.java
│
├── controller/
│   ├── PilotoController.java
│   └── EquipeController.java
│
└── tests/

Nem todas essas pastas existirão desde o primeiro commit. Elas aparecem conforme a arquitetura evolui.

🏁 Roadmap

SETOR 1 — Fundamentos

Definir o domínio F1 Manager 2026

Modelar Piloto

Incluir relacionamento conceitual com Equipe

Criar Equipe

Revisar classe, objeto, atributo, método, new, private, getters e setters

SETOR 2 — Persistência

Criar tabelas Oracle

Configurar OJDBC

Criar ConnectionFactory

Testar conexão Java → Oracle

Criar PilotoDAO

Implementar INSERT

Implementar SELECT por ID

Implementar UPDATE

Implementar DELETE

Implementar LISTAR

SETOR 3 — Relacionamentos

Implementar Equipe 1 Piloto

Criar GrandePremio

Criar Resultado

Trabalhar relação N

Implementar transações com commit e rollback

SETOR 4 — Web / prova

Criar projeto Spring Boot

Entender @RestController

Entender @RequestMapping

Implementar @GetMapping

Implementar @PostMapping

Implementar @PutMapping

Implementar @DeleteMapping

Entender @PathVariable

Entender @RequestBody

Criar PilotoService

Separar regra de negócio do Controller

Fechar fluxo Controller → Service → DAO

SETOR 5 — Front-end

Criar dashboard

Consumir API com fetch()

Listar pilotos e equipes

Criar formulários de cadastro e edição

Exibir resultados e classificação

🧠 Pit Board — conceitos que eu preciso dominar

Antes de considerar uma etapa concluída, preciso conseguir explicar sem decorar:

[ POO ]
□ diferença entre classe e objeto
□ o que é um atributo
□ por que usamos private
□ o que getters e setters fazem
□ o que new faz

[ JDBC / DAO ]
□ o que é JDBC
□ para que serve o driver OJDBC
□ o que Connection representa
□ o que ConnectionFactory resolve
□ o que PreparedStatement faz
□ diferença entre executeUpdate e executeQuery
□ o que ResultSet contém
□ por que SQL fica no DAO

[ SERVICE / CONTROLLER ]
□ responsabilidade do Controller
□ responsabilidade do Service
□ responsabilidade do DAO
□ diferença entre @RequestBody e @PathVariable
□ diferença entre GET, POST, PUT e DELETE
□ por que uma regra de negócio não deveria ficar no Controller
□ explicar o fluxo completo de uma requisição

🔧 Estratégia de commits

O histórico do GitHub também faz parte do estudo. A ideia é registrar a evolução sem esconder as etapas intermediárias.

feat: cria modelo inicial de piloto
feat: adiciona entidade equipe
feat: configura conexao JDBC com Oracle
feat: implementa cadastro de pilotos
feat: implementa busca de piloto por id
feat: completa CRUD de pilotos
feat: adiciona relacionamento entre equipe e piloto
feat: adiciona grandes premios e resultados
feat: implementa transacoes de resultado
feat: inicia aplicacao Spring Boot
feat: adiciona controller de pilotos
feat: adiciona service e regras de negocio
feat: integra front-end com API

🎓 Objetivo acadêmico

Este não é um projeto feito para esconder complexidade ou parecer mais avançado do que o conteúdo estudado.

A prioridade é conseguir justificar cada linha importante:

Não basta saber que funciona.
Quero saber por que funciona.

O código acompanha os conteúdos de Domain Driven Design / Java estudados no segundo semestre de ADS, com o domínio da aplicação adaptado para Fórmula 1.

⚠️ Nota

F1 Manager 2026 é um projeto acadêmico e não oficial, criado exclusivamente para estudo de desenvolvimento de software. Fórmula 1, equipes, montadoras e demais marcas citadas pertencem aos seus respectivos proprietários.

<p align="center">
  <img src="./assets/divider.svg" alt="divisor" width="100%" />
</p>

<h3 align="center">FROM THE GARAGE TO THE GRID.</h3>

<p align="center">
  <strong>Java → Banco → API → Front-end</strong><br/>
  <sub>um conceito por volta, uma camada por vez.</sub>
</p>

<p align="center">
  <strong>Guilherme Almeida</strong><br/>
  <code>guimmalmd</code>
</p>********