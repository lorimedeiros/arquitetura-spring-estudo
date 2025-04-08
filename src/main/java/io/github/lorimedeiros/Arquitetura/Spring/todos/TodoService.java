package io.github.lorimedeiros.Arquitetura.Spring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    //não é necessário autowired para injetar dependencia, services e repositorys já são reconhecidas pelo spring
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        return repository.save(novoTodo);
    }

}
