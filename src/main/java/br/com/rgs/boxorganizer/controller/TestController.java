package br.com.rgs.boxorganizer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class TestController {

    @GetMapping
    public ResponseEntity<Date> getDate(){
        return ResponseEntity.ok(new Date());
    }
}
