package io.github.lorimedeiros.Arquitetura.Spring.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> { }