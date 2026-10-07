package co.edu.cesde.todo.domain.port.out;

import co.edu.cesde.todo.domain.model.TaskModel;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    TaskModel save(TaskModel task);
    List<TaskModel> findAll();
    Optional<TaskModel> findById(Long id);
    void delete(TaskModel task);
}
