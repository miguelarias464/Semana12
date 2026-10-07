package co.edu.cesde.todo.application.service.impl;

import co.edu.cesde.todo.application.service.TaskService;
import co.edu.cesde.todo.domain.model.TaskModel;
import co.edu.cesde.todo.domain.port.out.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public TaskModel createTask(TaskModel task) {
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TaskModel getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> taskNotFound(id));
    }

    @Override
    @Transactional
    public TaskModel updateTask(Long id, TaskModel task) {
        TaskModel existingTask = getTaskById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        if (task.getCompleted() != null) {
            existingTask.setCompleted(task.getCompleted());
        }
        return taskRepository.save(existingTask);
    }

    @Override
    @Transactional
    public TaskModel markAsCompleted(Long id) {
        TaskModel task = getTaskById(id);
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        TaskModel task = getTaskById(id);
        taskRepository.delete(task);
    }

    private ResponseStatusException taskNotFound(Long id) {
        String message = "No se encontró la tarea con id " + id;
        System.out.println(message);
        return new ResponseStatusException(HttpStatus.NOT_FOUND, message);
    }
}
