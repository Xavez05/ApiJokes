package com.achavez.joke.repository.impl;

import com.achavez.joke.dto.JokeDTO;
import com.achavez.joke.repository.JokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Slf4j
public class JokeRepositoryImpl implements JokeRepository {

    public static final String APPLICATION = "Application";
    public final RestTemplate restTemplate;
    private final String url;
    private final Integer count;


    public JokeRepositoryImpl(RestTemplate restTemplate, @Value("${url.api.chuck}") String  url, @Value("${count.api.chuch}") Integer count) {
        this.url = url;
        this.restTemplate = restTemplate;
        this.count = count;
    }

    @Override
    public List<JokeDTO> getJokes() {
        HttpEntity<String> entity = getEntity();
        Set<JokeDTO> jokes = new HashSet<>();
        int previewTotal = 0;
        int sameSizeCount = 0;
        while (jokes.size() < count){
            JokeDTO jokeDTO = restTemplate.exchange(url, HttpMethod.GET,entity, JokeDTO.class).getBody();
            jokes.add(jokeDTO);
            if (jokes.size() == previewTotal){
                sameSizeCount++;
            }else {
                sameSizeCount = 0;
            }
            previewTotal = jokes.size();
            if (sameSizeCount == 5){
                break;
            }
        }
        return new ArrayList<>(jokes);
    }

    public HttpEntity<String> getEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.USER_AGENT, APPLICATION);
        return new HttpEntity<>(headers);
    }
}
