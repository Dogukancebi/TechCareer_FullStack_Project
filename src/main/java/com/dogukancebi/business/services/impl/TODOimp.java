import com.dogukancebi.business.dto.TodoDto;
import com.dogukancebi.business.services.IToDoServices;
import com.dogukancebi.data.entity.;
import com.dogukancebi.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServices implements IToDoServices {

    private final TodoRepository todoRepository;

    @Autowired
    public ToDoServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        // TodoDto'dan TodoEntity'ye dönüşüm yapabilir ve todoRepository kullanarak kaydedebilirsiniz.
        TodoEntity todoEntity = mapToTodoEntity(todoDto);
        TodoEntity savedTodo = todoRepository.save(todoEntity);
        return mapToTodoDto(savedTodo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<TodoEntity> todoEntities = todoRepository.findAll();
        return todoEntities.stream()
                .map(this::mapToTodoDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TodoDto> getTodoById(Long id) {
        Optional<TodoEntity> todoEntity = todoRepository.findById(id);
        return todoEntity.map(this::mapToTodoDto);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    // TodoDto'dan TodoEntity'ye dönüşüm
    private TodoEntity mapToTodoEntity(TodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoDto.getTitle());
        todoEntity.setContent(todoDto.getContent());
        return todoEntity;
    }

    // TodoEntity'den TodoDto'ya dönüşüm
    private TodoDto mapToTodoDto(TodoEntity todoEntity) {
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle(todoEntity.getTitle());
        todoDto.setContent(todoEntity.getContent());
        return todoDto;
    }
}
