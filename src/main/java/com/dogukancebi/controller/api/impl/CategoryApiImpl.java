import com.dogukancebi.business.dto.TodoDto;
import com.dogukancebi.business.services.IToDoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
public class ToDoApiImpl implements IToDoApi {

    private final IToDoServices toDoServices;

    @Autowired
    public ToDoApiImpl(IToDoServices toDoServices) {
        this.toDoServices = toDoServices;
    }

    @Override
    public ResponseEntity<TodoDto> createToDoItem(@Valid @RequestBody TodoDto todoDto) {
        TodoDto createdTodo = toDoServices.createTodo(todoDto);
        return ResponseEntity.ok(createdTodo);
    }

    @Override
    public ResponseEntity<List<TodoDto>> getAllToDoItems() {
        List<TodoDto> todos = toDoServices.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @Override
    public ResponseEntity<TodoDto> getToDoItemById(Long id) {
        Optional<TodoDto> todo = toDoServices.getTodoById(id);
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteToDoItemById(Long id) {
        toDoServices.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}
