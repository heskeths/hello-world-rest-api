package com.hesketh.helloworldrestapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {

    private final AtomicInteger count = new AtomicInteger(0);

    @RequestMapping(value={"/request"}, method = RequestMethod.POST, consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<Response> postRequest(@RequestBody Request request) {
        log.debug("Message received [{}]", request);

        HttpStatusCode statusCode = HttpStatus.OK;

        int responseId = count.incrementAndGet();

        Response response = new Response(String.valueOf(responseId), "Request ID: " + request.getId());

        return new ResponseEntity<>(response, statusCode);
    }
}
