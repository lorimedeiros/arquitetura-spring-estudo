package io.github.lorimedeiros.Arquitetura.Spring.todos;

import org.springframework.stereotype.Component;

@Component //quando não se usa controller, service,repository... se usa component (é o pai de todos os outros, superclasse)
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com essa descrição!");
        }

    }

    private boolean existeTodoComDescricao(String descricao){
        return repository.existsByDescricao(descricao);
    }

}
