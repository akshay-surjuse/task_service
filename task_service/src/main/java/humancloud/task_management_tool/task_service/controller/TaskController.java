package humancloud.task_management_tool.task_service.controller;

import humancloud.task_management_tool.task_service.Exception.TaskNotFoundException;
import humancloud.task_management_tool.task_service.Service.TaskService;
import humancloud.task_management_tool.task_service.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id)
    {
        Optional<Task> task= taskService.getTaskById(id);
        return task;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task updatedTaskResult = taskService.updateTaskById(id, updatedTask); // Update the task using the service

        if (updatedTaskResult != null) {
            return ResponseEntity.ok(updatedTaskResult); // Return 200 OK with the updated task
        } else {
            throw new TaskNotFoundException("Task not Present//!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/getAllTasks/{userid}")
    public List<Task> getTasksByUserId(@PathVariable Long userid) {
        return taskService.getTasksByuserid(userid); // Delegate to service method
    }





}
