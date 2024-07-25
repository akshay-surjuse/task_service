package humancloud.task_management_tool.task_service.Service;

import humancloud.task_management_tool.task_service.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);
    Optional<Task> getTaskById(Long id);
    Task updateTaskById(Long id, Task task);
    void deleteTaskById(Long id);
    List<Task> getTasksByuserid(Long userid);

}
