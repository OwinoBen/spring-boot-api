package com.example.streamsschedule;

import com.example.streamsschedule.model.ImmutableLiveStream;
import com.example.streamsschedule.model.LiveStream;
import com.example.streamsschedule.model.MutableLiveStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StreamsScheduleApplicationTests {

    @Test
    void create_new_mutable_live_stream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring Boot");
        stream.setDescription("Spring Boot helps you to create stand-alone, " +
                "production-grade Spring-based applications that you can run. " +
                "We take an opinionated view of the Spring platform and third-party " +
                "libraries, so that you can get started with minimum fuss. " +
                "Most Spring Boot applications need very little Spring configuration.");
        stream.setUrl("https://www.twtich.tv/danvega");
        stream.setStartDate(LocalDateTime.of(2023,6, 1, 11,12));
        stream.setEndDate(LocalDateTime.of(2022,6,1,12,1));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle());
    }

    @Test
    void create_new_immutable_live_stream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(
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
                );

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle());
    }

    @Test
    void create_new_record_live_stream() {
        LiveStream stream = new LiveStream(
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
        );

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.title());
        assertTrue(stream.getClass().isRecord());
        assertEquals(6,stream.getClass().getRecordComponents().length);
    }

}
