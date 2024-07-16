package humancloud.task_management_tool.task_service.Exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message) {
        super(message);
    }


}
