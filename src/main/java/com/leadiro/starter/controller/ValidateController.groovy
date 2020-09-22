package com.leadiro.starter.controller

import com.leadiro.starter.service.ValidateService
import com.leadiro.starter.service.validate.dto.ErrorMessage
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

@CrossOrigin
@RestController
@RequestMapping("/validate/")
@CompileStatic
class ValidateController {

    @Autowired
    private ValidateService service;

    @GetMapping("email")
    def validateEmail(@RequestParam String email) {
        return service.validateEmailFormat(email)
    }

    @GetMapping("postcode")
    def validateUkPostCode(@RequestParam String postcode) {
        return service.validateUKPostCode(postcode)
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    ErrorMessage missingParameterHandler(Exception exception) {
        return ErrorMessage.builder()
                .error("Missing Parameter")
                .message(exception.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(HttpClientErrorException.class)
    ErrorMessage clientErrorHandler(Exception exception) {
        return ErrorMessage.builder()
                .error("Client Error")
                .message(exception.getMessage())
                .build();
    }
}


