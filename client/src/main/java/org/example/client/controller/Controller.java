package org.example.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.common.Request;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@Log
public class Controller {

    @GetMapping("/pans/{cardPan}/pins/{cardPin}")
    public String getBalance(@PathVariable("cardPan") String cardPan,
                              @PathVariable("cardPin") int cardPin) {
        log.info("cardPan " + cardPan + " cardPin " + cardPin);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Request> request = new HttpEntity<>(new Request(cardPan, cardPin));

        log.info("request.toString()" + request.toString());

        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity("http://127.0.0.1:8080/cards/getBalance", request, String.class);
        log.info("responseEntityStr.getBody()" + responseEntityStr.getBody());

        return responseEntityStr.getBody();
    }

}
