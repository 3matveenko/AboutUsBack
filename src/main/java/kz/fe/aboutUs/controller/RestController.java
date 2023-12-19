package kz.fe.aboutUs.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import kz.fe.aboutUs.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @Autowired
    MainService mainService;
    @PostMapping("/click")
    public ResponseEntity<String> create(
            @RequestBody String json) throws JsonProcessingException {
        try {
            mainService.newClick(json);
            return ResponseEntity.ok("ok");
        }   catch (JacksonException e) {
            return ResponseEntity.status(400).body("Bad request");
        }
    }
}
