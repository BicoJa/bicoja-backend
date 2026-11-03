# Bico Já — API REST

Projeto Java 17 + Spring Boot 3 + Maven, baseado no diagrama enviado.

## Requisitos
- JDK 17 (ou superior compatível)
- IntelliJ IDEA
- Maven (o IntelliJ pode importar pelo `pom.xml`)

## Como abrir
1. Extraia o ZIP.
2. No IntelliJ, selecione **File > Open** e escolha a pasta `bicoja`.
3. Aguarde o Maven baixar as dependências.
4. Configure o Project SDK como Java 17.
5. Execute `BicojaApplication`.

A API ficará disponível em `http://localhost:8080`.

## Documentação e banco
- Swagger: http://localhost:8080/swagger-ui.html
- Console H2: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:file:./data/bicoja`
- Usuário: `sa`
- Senha: (vazia)

O banco H2 é criado automaticamente. Para reiniciar os dados, pare a aplicação e apague a pasta `data/`.

## Endpoints CRUD
Todos os recursos possuem `GET`, `GET /{id}`, `POST`, `PUT /{id}` e `DELETE /{id}`:

| Recurso | Endpoint |
|---|---|
| Usuário | `/api/usuario` |
| Profissional | `/api/profissional` |
| Contratante | `/api/contratante` |
| Habilidade | `/api/habilidade` |
| Habilidade do profissional | `/api/profissionalhabilidade` |
| Vaga | `/api/vaga` |
| Foto de trabalho | `/api/fototrabalho` |
| Notificação | `/api/notificacao` |
| Candidatura | `/api/candidatura` |
| Contratação | `/api/contratacao` |
| Avaliação | `/api/avaliacao` |

## Exemplo: cadastrar usuário
`POST http://localhost:8080/api/usuario`

```json
{
  "nome": "Maria da Silva",
  "email": "maria@email.com",
  "senha": "senha123",
  "telefone": "83999990000",
  "tipoUsuario": "PROFISSIONAL"
}
```

## Exemplo: cadastrar profissional
A propriedade `usuario` recebe o objeto de referência com o ID já cadastrado:

```json
{
  "usuario": { "idUsuario": 1 },
  "descricao": "Eletricista residencial",
  "telefoneContato": "83999990000"
}
```

Para os demais relacionamentos, use o mesmo padrão: `{ "id": 1 }`, `{ "idContratante": 1 }`, `{ "idProfissional": 1 }`, etc.

## Observações sobre o diagrama
O diagrama apresenta referências circulares na tabela USUARIO para PROFISSIONAL, VAGA e CONTRATACAO, além de `id_profissional` em HABILIDADE e uma tabela associativa PROFISSIONAL_HABILIDADE. Para evitar duplicidade e ciclos de inserção, o projeto aplica a modelagem relacional usual:
- PROFISSIONAL e CONTRATANTE apontam para USUARIO.
- PROFISSIONAL_HABILIDADE liga PROFISSIONAL e HABILIDADE.
- VAGA aponta para CONTRATANTE e HABILIDADE.
- USUARIO mantém `tipoUsuario` como texto (`PROFISSIONAL` ou `CONTRATANTE`), sem FKs de retorno.
Se o professor exigir reprodução literal do DER, ajuste essas três decisões antes da entrega.

## Estrutura
Os pacotes seguem o padrão da imagem: `usuario`, `profissional`, `contratante`, `vaga`, `candidatura`, `contratacao`, `habilidade`, `profissionalhabilidade`, `fototrabalho`, `notificacao` e `avaliacao`. Cada módulo contém Entity, Repository, Service e Controller.
