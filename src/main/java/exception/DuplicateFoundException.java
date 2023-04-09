package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class DuplicateFoundException extends RuntimeException {

    public DuplicateFoundException(String message){
        super(message);
    }
}
