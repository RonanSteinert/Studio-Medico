package com.studiomedico.exception.advice;

import com.studiomedico.controllers.DTO.BaseResponseDTO;
import com.studiomedico.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponseDTO handlerUserNotFound(UserNotFoundException e){
        BaseResponseDTO br = new BaseResponseDTO();
        br.setStatus(BaseResponseDTO.Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("USER_NOT_FOUND");
        }
        return br;
    }
}
