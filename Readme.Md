Esta API foi desenvolvida utilizando Java + Spring Boot com o de gerenciar usuários e suas tarefas.
cada usuário pode possuir várias tarefas, criando um relacionamento 1:N (Um para muitos) no banco de dados

Relacionamento 1:N

No sistema, um usuário pode ter várias tarefas, mas cada Tarefa pertence a apenas um Usuário.
Esse relacionamento foi implementado utilizando JPA/Hibernate

UsuárioEntity
@OneToMany(mappedBy = "usuario")
private List<Tarefa> tarefas = new
ArrayList<>();


Um usuário possui uma lista de tarefas

TarefasEntity
@ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;

Cada tarefa possui apenas um usuário, o campo usuario_id é a chave estrangeira

Endpoits da API

Criar Usuário 

Post /usuarios

{
"nome": "String",
"email": "String@email.com",
"senha": "Int"
}

<img height="100" src="C:\Users\Luiz Miguel\OneDrive\Imagens\Screenshots\Captura de tela 2026-03-05 194834.png" width="100"/>
  


Listar Usuários
Get /Usuarios

Buscar Usuarios por ID
Get /usuarios/{id}

Deletar Usuarios

Delete /usuarios/{id}

Endpoints de tarefas 


Criar Tarefa
Post /usuarios/{id}/tarefas
{
"nome": "String",
"descricao": "String",
"dtInicio": "2026-03-05",
"dtFim": "2026-03-10"
}
            
<img height="100" src="C:\Users\Luiz Miguel\OneDrive\Imagens\Screenshots\Captura de tela 2026-03-05 195112.png" width="100"/>

Listar Tarefas do Usuario

Get /usuarios/{id}/tarefas
                            
<img height="100" src="C:\Users\Luiz Miguel\OneDrive\Imagens\Screenshots\Captura de tela 2026-03-05 195227.png" width="100"/>


Atualizar Tarefas do Usuario
Put /usuarios/{usuarioid}/tarefas
{
"nome": "String",
"descricao": "String",
"dtInicio": "2026-03-05",
"dtFim": "2026-03-10"
}

Deletar tarefa

Delete /usuarios/{usuarioid}/tarefas
{
"nome": "String",
"descricao": "String",
"dtInicio": "2026-03-05",
"dtFim": "2026-03-10"
}