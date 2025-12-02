Documentação trabalho terça-feira (projeto banco)

1.Foi feito como trabalho final um sistema de bancos em java que tinha como propósito poder gerenciar um sistema de banco dentro do mesmo. Foram implementadas regras de negócio que tinham como objetivo:
-Não deixar que um usuário com o mesmo CPF criasse duas contas inserindo o mesmo.
-Ter as contas corrente, crédito e corrente.Utilizando as regras de negócio que o professor passou na atividade proposta.

1.1- foi criado o framework de pastas, utilizando o Spring Initializr com as dependências necessárias para iniciar o projeto

1-Foram criadas as classes dentro da pasta exception que servem diretamente como regras de negócio para o projeto em geral , que auxiliarão para verificar se oque foi informado existe ou não.

1.1 -CountNotFoundException = serve como um intermediador para descobrir se a conta constatada existe ou não.

1.2 -UsuarioNotFoundException = Verifica se o usuário existe ou não

1.3 -SaldoInsuficienteException = Serve para verificar se o saldo em questão é suficiente para executar a transação.

2- Dentro da pasta models foi criado classes distintas para que seja possível realizar as operações essenciais do programa:

2.1 -Conta = Serve diretamente como uma classe abstrata , que vai dar as regras de negócio principais para a realização das operações restantes nos outros tipos de contas , seja na Crédito , poupança ou corrente.

2.2 -Usuário = É onde irá ficar os dados primários do usuário como: CPF , Nome , sobrenome .

2.3 -Transação =  Classe onde ficará disponível tudo o que será necessário para verificar se a conta em questão na qual será realizada esta operação existe ou não. Isso acontece pois dentro dela encontram-se as informações de:Conta de Origem e Conta de destino.

2.4 - Conta corrente = Tipo de conta na qual será a conta do tipo corrente onde possui as regras de negócio da mesma.

2.5 - Conta crédito = Tipo de conta que possui um limite de crédito estabelecido e não pode ser excedido.

2.6 - Conta poupança = Tipo de conta onde pode-se ser depositado e possui a regra do acúmulo de dinheiro conforme determinado período de tempo.

3 - Repositórios é a parte na qual ficarão as operações de CRUD : ler , atualizar , deletar , criar e atualizar.

3.1 - ContaRepository = Onde ficará as operações de CRUD da parte de contas.

3.2 - UsuarioRepository =  Onde ficará as operações de CRUD da parte de Usuários.

4- Foram criados os Services onde é a lógica do programa e as regras de negócio

5- Foram implementados os DTO Data Transfer Objects para transportar os dados entre o Cliente (BRUNO) e a API sendo que o request apenas recebe o'que o cliente pode mandar e o Response só devolve oque o cliente pode ver






Tecnologias Usadas:

Java 17+
Spring boot 
SpringWeb
Persistência em memória(Banco de dados em memória)
Maven

Estrutura do projeto:
Controller/Endpoint da API (Entrada da API)
Dto/ Objetos Request e Response
Exception/ Exceções personalizadas(Base do projeto)
Model/ Entidades de domínio(base do projeto)
Service/ Regras de negócio + 
Repository/ Armazenamento em memória - LISTAS

COMO RODAR O PROJETO:

1.Clone o repositório - git clone <URL>
2.cd nome-do-projeto
3.mvn spring-boot:run
4.http://localhost:8080

ENDPOINT DA API (BRUNO)

USUÁRIOS

Criar usuário : POST /Usuários

Listar usuários: GET / Usuários

Buscar usuário por ID: GET /usuarios(id)

Deletar usuário: DELETE / Usuario (id)

CONTA

Criar conta : POST /contas

Listar contas: GET /contas

Buscar conta por ID: GET /contas/{id}

 Deletar conta : DELETE /contas/{id}



TRANSAÇÕES

Criar transação:POST /transacoes

COMPRAS

Registrar compra:POST /compras

Listar compras:GET /compras
