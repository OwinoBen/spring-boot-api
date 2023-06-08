package com.example.streamsschedule.repository;

import com.example.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();
    public LiveStreamRepository(){
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                "Spring Boot helps you to create stand-alone, " +
                        "production-grade Spring-based applications that you can run. " +
                        "We take an opinionated view of the Spring platform and third-party " +
                        "libraries, so that you can get started with minimum fuss. " +
                        "Most Spring Boot applications need very little Spring configuration.",
                "https://www.twtich.tv/danvega",
                LocalDateTime.of(2023,6, 1, 11,0),
                LocalDateTime.of(2022,6,1,12,0)
                )
        );
    }

    public List<LiveStream> findAll(){
        return streams;
    }
    public LiveStream findById(String id){
        return streams.stream().filter(stream->stream.id().equals(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No stream found"));
    }

    public LiveStream create(LiveStream stream){
        streams.add(stream);
        return stream;
    }

    public  void  update(LiveStream stream, String id){
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id){
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
