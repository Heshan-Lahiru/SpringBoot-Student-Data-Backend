package lk.iuhs.crm.exception;


import lk.iuhs.crm.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingStudent {


    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorModel> error(StudentException ex){

        ErrorModel build = ErrorModel.builder().msgerror(ex.getMessage()).build();

        return ResponseEntity.ok().body(build);
    }

}

