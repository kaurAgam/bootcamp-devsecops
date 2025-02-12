package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PostInfoQuery {

    @GetMapping("/myposts/{uid}")
    public PostMessage get(@PathVariable("uid") String uid) {

        String URL = "https://jsonplaceholder.typicode.com/posts/" + uid;

        RestClient rc = RestClient.builder().build();

        PostMessage result = rc.get()
                .uri(URL)
                .retrieve()
                .body(PostMessage.class);
        System.out.println(result);

        return result;
    }

}
