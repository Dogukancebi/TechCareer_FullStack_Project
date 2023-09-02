import com.dogukancebi.business.dto.TodoDto;
import com.dogukancebi.business.services.IToDoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class ToDoItemController {

    private final IToDoServices toDoServices;

    @Autowired
    public ToDoItemController(IToDoServices toDoServices) {
        this.toDoServices = toDoServices;
    }

    @PostMapping
    public ResponseEntity<TodoDto> createToDoItem(@Valid @RequestBody TodoDto todoDto) {
        TodoDto createdTodo = toDoServices.createTodo(todoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllToDoItems() {
        List<TodoDto> todos = toDoServices.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getToDoItemById(@PathVariable Long id) {
        Optional<TodoDto> todo = toDoServices.getTodoById(id);
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoItemById(@PathVariable Long id) {
        toDoServices.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}
