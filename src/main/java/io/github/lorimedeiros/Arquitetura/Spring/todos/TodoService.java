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

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        //funcionamento do save: tem id? se sim, pega e atualiza o todo com aquele id
        //veio sem id? salva como novo registro.
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

}
