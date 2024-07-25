package humancloud.task_management_tool.task_service.Repository;

import humancloud.task_management_tool.task_service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Taskrepository extends JpaRepository<Task,Long> {
    List<Task> findByuserid(Long userid);
}
