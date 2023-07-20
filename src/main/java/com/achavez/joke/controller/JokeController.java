package com.achavez.joke.controller;

import com.achavez.joke.dto.JokeDTO;
import com.achavez.joke.service.JokeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/getJokes")
    public ResponseEntity<List<JokeDTO>> getJokes(){
        return ResponseEntity.ok().body(jokeService.getJokes());
    }

}
