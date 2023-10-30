package lk.easycar.rent.advisor;

import lk.easycar.rent.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//set status to 500
    @ExceptionHandler({RuntimeException.class})//handle the runtime exception through the below method
    public ResponseUtil handleAllRuntimeExceptions(RuntimeException e){
        return new ResponseUtil("Error",e.getMessage(),null);
    }
}
