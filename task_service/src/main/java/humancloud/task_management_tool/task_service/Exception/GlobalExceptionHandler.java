package humancloud.task_management_tool.task_service.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({TaskNotFoundException.class})
    public ResponseEntity<Object> TaskNotFoundException(TaskNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }


}
