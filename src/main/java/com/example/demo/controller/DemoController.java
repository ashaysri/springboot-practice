package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id){
        Post post = demoService.getPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = demoService.getPosts();
        if (posts == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        String result = demoService.createPost(post);
        return ResponseEntity.ok(result);
    }
}
