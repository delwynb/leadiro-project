package com.leadiro.starter.controller

import com.leadiro.starter.service.MuseumService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/museum")
@CompileStatic
class MuseumController {

    @Autowired
    MuseumService service;

    @PostMapping
    def searchByKeywords(@RequestBody List<String> keywords) {
        return service.search(keywords)
    }

    @GetMapping("/{id}")
    def getById(@PathVariable String id) {
        return service.getRecordById(id)
    }

}
