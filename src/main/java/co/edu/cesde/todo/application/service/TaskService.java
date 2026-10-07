package co.edu.cesde.todo.application.service;

import co.edu.cesde.todo.domain.model.TaskModel;
import java.util.List;

public interface TaskService {
    TaskModel createTask(TaskModel task);
    List<TaskModel> getAllTasks();
    TaskModel getTaskById(Long id);
    TaskModel updateTask(Long id, TaskModel task);
    TaskModel markAsCompleted(Long id);
    void deleteTask(Long id);
}
