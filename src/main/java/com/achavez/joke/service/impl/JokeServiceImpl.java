package com.achavez.joke.service.impl;

import com.achavez.joke.dto.JokeDTO;
import com.achavez.joke.repository.JokeRepository;
import com.achavez.joke.service.JokeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeServiceImpl implements JokeService {

    private JokeRepository jokeRepository;

    public JokeServiceImpl(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override
    public List<JokeDTO> getJokes() {
        return jokeRepository.getJokes();
    }
}
