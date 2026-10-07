package co.edu.cesde.todo.infrastructure.persistence;

import co.edu.cesde.todo.domain.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<TaskModel, Long> { }
