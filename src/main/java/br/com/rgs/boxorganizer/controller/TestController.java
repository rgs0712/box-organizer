package br.com.rgs.boxorganizer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("Test")
public class TestController {

    @GetMapping
    public ResponseEntity<Date> getDate(){
        return ResponseEntity.ok(new Date());
    }
}
