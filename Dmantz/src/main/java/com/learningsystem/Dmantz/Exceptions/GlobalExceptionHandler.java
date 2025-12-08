package com.learningsystem.Dmantz.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.learningsystem.Dmantz.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> ResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest webrequest) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), webrequest.getDescription(false),
				"RESOURCE NOT FOUND");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateValuesException.class)
	public ResponseEntity<ErrorResponse> DuplicateValuesException(DuplicateValuesException ex, WebRequest webrequest) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), webrequest.getDescription(false),
				"DUPLICATE VALUE EXCEPTION");
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

//	@ExceptionHandler
//	public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
//		Map<String, String> errors = new HashMap<>();
//
//		ex.getBindingResult().getFieldErrors()
//				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
//
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleInvalidEnum(HttpMessageNotReadableException ex, WebRequest webRequest) {

		String message = ex.getMessage();
		System.out.println(message);

		if (message.contains("SubjectAreaNames")) {

			ErrorResponse error = new ErrorResponse(
					"Invalid subject area value. Allowed values:JAVA,WEBDEVELOPMENT,PYTHON,CLOUDCOMPUTING",
					webRequest.getDescription(false), "INVALID_ENUM_VALUE");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

		// For all other JSON errors
		ErrorResponse error = new ErrorResponse("Invalid JSON Input", webRequest.getDescription(false),
				"JSON_PARSE_ERROR");

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
