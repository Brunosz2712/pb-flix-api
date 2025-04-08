package br.com.fiap.pb_flix_api.exception;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationHandler {
   public ValidationHandler() {
   }

   @ExceptionHandler(
      exception = {MethodArgumentNotValidException.class}
   )
   @ResponseStatus(
      code = HttpStatus.BAD_REQUEST
   )
   public List<ValidationHandlerValidationErrorMessage> handler(MethodArgumentNotValidException exception) {
      return exception.getFieldErrors().stream().map(ValidationHandlerValidationErrorMessage::new).toList();
   }
}
