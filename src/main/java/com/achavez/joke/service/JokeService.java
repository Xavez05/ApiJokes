package com.achavez.joke.service;

import com.achavez.joke.dto.JokeDTO;

import java.util.List;

public interface JokeService {
    List<JokeDTO> getJokes();
}
