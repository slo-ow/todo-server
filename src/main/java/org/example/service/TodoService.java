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

    /**
     * Todo 아이템 추가 ・　アイテムを追加する
     * @param request 추가될 Todo 아이템 요청　・　追加される Todoアイテムを要請
     * @return 추가된 Todo 엔티티　・　追加された Todo Entity
     */
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoEntity);
    }

    /**
     * 특정 Todo 아이템 조회　・　特定 Todoアイテムを検索
     * @param id 조회랑 아이템 아이디　・　検索とアイテムのID
     * @return 조회된 Todo 엔티티　・　検索された Todo Entity
     *          해당 아이디가 존재하지 않을 경우 ResponseStatusException 발생
     *          IDが存在しない場合ResponseStatusException発生
     */
    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * 전체 Todo 아이템 목록 조회　・　全体 Todo アイテムのリストを検索
     * @return 전체 Todo 엔티티 목록　・　全体 Todo Entity　リスト
     */
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    /**
     * Todo 아이템 수정　・　Todo　アイテムを直す
     * @param id 수정할 Todo 아이템 아이디　・　直す Todo　アイテムのID
     * @param request 수정할 내용　・　直す内容
     * @return 수정된 Todo 엔티티　・　直した Todo Entity
     */
    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }

        if (request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }

        if (request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }

        return this.todoRepository.save(todoEntity);
    }

    /**
     * 특정 Todo 아이템 삭제　・　特定　Todo アイテムを消す
     * @param id 삭제할 Todo 아이템 아이디　・　消す Todo アイテムのID
     */
    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    /**
     * 전체 Todo 아이템 목록 삭제　・　Todo　アイテムのリストを消す
     */
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
