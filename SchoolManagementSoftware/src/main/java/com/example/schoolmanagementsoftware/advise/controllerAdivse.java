package com.example.schoolmanagementsoftware.advise;
import com.example.schoolmanagementsoftware.dto.ApiResponse;
import com.example.schoolmanagementsoftware.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class controllerAdivse {

    @ExceptionHandler(value= ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        String msg=apiException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg,400));
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("SERVER ERROR!",500));
    }

}
