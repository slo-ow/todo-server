package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

//    1. Todo Listにアイテムを追加
public TodoEntity add(TodoRequest request){
    TodoEntity todoEntity = new TodoEntity();
    todoEntity.setTitle(request.getTitle());
    todoEntity.setOrder(request.getOrder());
    todoEntity.setCompleted(request.getCompleted());
    return this.todoRepository.save(todoEntity);
}

//    2. Todo Listの中で特定のアイテムを検索
public TodoEntity searchById(Long id){
    return todoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
}

//    3. Todo Listの全体目録を検索
public List<TodoEntity> searchAll(){return this.todoRepository.findAll();}

//    4. Todo Listの中で特定アイテムを直す
public TodoEntity updateById(Long id, TodoRequest request) {
    TodoEntity todoEntity = this.searchById(id);
    if(request.getTitle() != null){
        todoEntity.setTitle(request.getTitle());
    }
    if(request.getOrder() != null){
        todoEntity.setOrder(request.getOrder());
    }
    if(request.getCompleted() != null){
        todoEntity.setCompleted(request.getCompleted());
    }
    return this.todoRepository.save(todoEntity);
}

//    5. Todo Listの中で特定アイテムを消す
public void deleteById(Long id){this.todoRepository.deleteById(id);}

//    6. Todo Listを全部消す
public void deleteAll(){this.todoRepository.deleteAll();}



}
