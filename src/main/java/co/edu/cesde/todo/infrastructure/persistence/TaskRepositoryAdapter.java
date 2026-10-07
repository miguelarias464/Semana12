package co.edu.cesde.todo.infrastructure.persistence;

import co.edu.cesde.todo.domain.model.TaskModel;
import co.edu.cesde.todo.domain.port.out.TaskRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryAdapter implements TaskRepository {
    private final TaskJpaRepository jpaRepository;

    public TaskRepositoryAdapter(TaskJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override public TaskModel save(TaskModel task) { return jpaRepository.save(task); }
    @Override public List<TaskModel> findAll() { return jpaRepository.findAll(); }
    @Override public Optional<TaskModel> findById(Long id) { return jpaRepository.findById(id); }
    @Override public void delete(TaskModel task) { jpaRepository.delete(task); }
}
