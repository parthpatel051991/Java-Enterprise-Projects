package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException pe) {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), pe.getMessage(), "404-Not Found");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleOtherException(Exception e) {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem Occured-Internal Server Error");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
