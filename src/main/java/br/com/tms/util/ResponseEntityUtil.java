package br.com.tms.util;


import br.com.tms.controller.domain.model.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseEntityUtil {

    public static ResponseEntity<?> defaultResponse(Object obj, boolean isNew) {

        ResponseDTO response = null;

        if (obj == null || obj.toString().equals("[]")) {
            response = new ResponseDTO(HttpStatus.NOT_FOUND, "No record found");
        } else if(isNew){
            response = new ResponseDTO(HttpStatus.CREATED, obj);
        }else{
            response = new ResponseDTO(HttpStatus.OK, obj);
        }

        return new ResponseEntity<>(response, response.getMsg());
    }

}
