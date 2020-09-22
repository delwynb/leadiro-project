package com.leadiro.starter.controller

import com.leadiro.starter.service.NameService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@CompileStatic
class NameController {
    @Autowired
    private NameService service;

    @PostMapping("/parse/name")
    def parseNames(@RequestBody List<String> names) {
        return service.parseNames(names)
    }

}
