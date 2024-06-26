# API Cadastro RH
Esta é a documentação da API Cadastro RH, desenvolvida em Java Spring Boot, utilizando um banco de dados MySQL. A Api oferece funcionalidades para cadastro e administração de candidatos.

## Rotas

### Admin

#### Cadastro de Responsável
- **Método:** POST
- **Rota:** /admin/cadastro
- **Descrição:** Esta rota permite cadastrar o responsável pelas consultas.

#### Login do Administrador
- **Método:** POST
- **Rota:** /admin/login
- **Descrição:** Esta rota permite que o administrador faça login na plataforma. Retorna um token de autenticação.

### Candidato

#### Listar Todos os Candidatos
- **Método:** GET
- **Rota:** /candidato/all
- **Descrição:** Retorna uma lista de candidatos cadastrados. Para acessar este endpoint, é necessário fornecer um token de autenticação recebido no login.

#### Busca Candidatos por Nome
- **Método:** GET
- **Rota:** /candidato/nome/{nome}
- **Descrição:** Este endpoint retorna uma lista de candidatos que correspondem a um determinado nome. Se nenhum candidato for encontrado, o endpoint retorna um array vazio. Para acessar este endpoint, é necessário fornecer um token de autenticação recebido no login.

#### Cadastrar Candidato
- **Método:** POST
- **Rota:** /candidato
- **Descrição:** Esta rota permite cadastrar um novo candidato.

#### Cadastrar Experiência do Candidato
- **Método:** POST
- **Rota:** /candidato/experiencia/{cpf}
- **Descrição:** Esta rota permite cadastrar a experiência de um candidato através do CPF.

#### Cadastrar Escolaridade do Candidato
- **Método:** POST
- **Rota:** /candidato/ensino/{cpf}
- **Descrição:** Esta rota permite cadastrar a escolaridade e cursos de um candidato através do CPF.

#### Demonstração da API no Swagger UI
- **Rota:** /swagger-ui/index.html
- **Descrição:** Exibe a documentação interativa da API utilizando o Swagger UI.
