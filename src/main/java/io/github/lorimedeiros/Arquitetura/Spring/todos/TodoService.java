package io.github.lorimedeiros.Arquitetura.Spring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    //não é necessário autowired para injetar dependencia, services e repositorys já são reconhecidas pelo spring
    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender sender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender sender) {
        this.repository = repository;
        this.validator = validator;
        this.sender = sender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        //funcionamento do save: tem id? se sim, pega e atualiza o todo com aquele id
        //veio sem id? salva como novo registro.
        String status= todo.getConcluido() == Boolean.TRUE ? "concluído" : "não concluído";
        sender.enviar("TODO " + todo.getDescricao() + "foi atualizado para" + status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

}
