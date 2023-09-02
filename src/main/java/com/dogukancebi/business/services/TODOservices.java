package com.dogukancebi.business.services;

import com.dogukancebi.business.dto.TodoDto;
import com.dogukancebi.data.entity.TodoEntity;

import java.util.List;
import java.util.Optional;

public interface IToDoServices {

    TodoDto createTodo(TodoDto todoDto);

    TodoDto updateTodo(Long id, TodoDto todoDto);

    void deleteTodo(Long id);

    List<TodoDto> getAllTodos();

    Optional<TodoDto> getTodoById(Long id);
}
