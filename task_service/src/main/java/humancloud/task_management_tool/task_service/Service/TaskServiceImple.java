package humancloud.task_management_tool.task_service.Service;

import humancloud.task_management_tool.task_service.Exception.TaskNotFoundException;
import humancloud.task_management_tool.task_service.Repository.Taskrepository;
import humancloud.task_management_tool.task_service.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImple implements TaskService{

    @Autowired
    Taskrepository taskrepository;


    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
         return taskrepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        Optional<Task> task=taskrepository.findById(id);
        if(task.isEmpty())
        {
            throw new TaskNotFoundException("Task is Not Exist...!");
        }
        else
        {
            return task;
        }
    }

    @Override
    public Task updateTaskById(Long id, Task updatedtask) {
        Optional<Task> task = this.taskrepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = (Task)task.get();
            existingTask.setTitle(updatedtask.getTitle());
            existingTask.setDescription(updatedtask.getDescription());
            existingTask.setCreatedAt(updatedtask.getCreatedAt());
            existingTask.setUpdatedAt(LocalDateTime.now());
            return (Task)this.taskrepository.save(existingTask);
        } else {
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }
    }

    @Override
    public void deleteTaskById(Long id) {
        Optional<Task> task = this.taskrepository.findById(id);
        if (task.isPresent()) {
            taskrepository.deleteById(id);
        }
        else {
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }
    }

    @Override
    public List<Task> getTasksByuserid(Long userid) {
        return taskrepository.findByuserid(userid); // Directly return the List<Task>
    }





}
