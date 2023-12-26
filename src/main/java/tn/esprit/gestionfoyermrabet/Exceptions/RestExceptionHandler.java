package tn.esprit.gestionfoyermrabet.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class RestExceptionHandler {
    //aamalna l class hedhy bech les erreurs  y'affichihom lil client

    //ecoute aala ay methode t7ot fiha @exceptionhandler
    //key howa error w value howa message
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,String> IllegalArgumentExceptionHandle(IllegalArgumentException e){
        Map<String,String> map = new HashMap<>();
        map.put("error",e.getMessage());
        return map;
    }


}
