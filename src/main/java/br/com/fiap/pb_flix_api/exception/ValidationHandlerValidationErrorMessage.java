package br.com.fiap.pb_flix_api.exception;

import org.springframework.validation.FieldError;

record ValidationHandlerValidationErrorMessage(String field, String message) {
   ValidationHandlerValidationErrorMessage(String field, String message) {
      this.field = field;
      this.message = message;
   }

   public ValidationHandlerValidationErrorMessage(FieldError fieldError) {
      this(fieldError.getField(), fieldError.getDefaultMessage());
   }

   public String field() {
      return this.field;
   }

   public String message() {
      return this.message;
   }
}
