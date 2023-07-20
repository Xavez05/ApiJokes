package com.achavez.joke.repository;

import com.achavez.joke.dto.JokeDTO;

import java.util.List;

public interface JokeRepository {
    List<JokeDTO> getJokes();
}
