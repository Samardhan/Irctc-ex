package in.samar.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e){
		
		String exMsg=e.getMessage();
		
		ErrorInfo ei=new ErrorInfo();
		
		ei.setCode("IRCTC00400");
		ei.setMsg(exMsg);
		ei.setWhen(LocalDateTime.now());
		return new ResponseEntity<>(ei,HttpStatus.BAD_REQUEST);
	}

}
