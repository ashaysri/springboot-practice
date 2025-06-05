package com.example.demo.service;

import com.example.demo.model.Post;
import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoService {
    private List<Post> posts = new ArrayList<>();

    @PostConstruct
    public void loadPosts() throws Exception {
        try(InputStream is = getClass().getClassLoader().getResourceAsStream("MOCK_DATA.csv")) {
            try(CSVReader csvReader = new CSVReader(new InputStreamReader(is))) {
                List<String[]> records = csvReader.readAll();

                posts = records.stream()
                        .skip(1)
                        .map(row -> new Post(
                                Integer.parseInt(row[0]),
                                row[1],
                                row[2],
                                row[3],
                                row[4],
                                Integer.parseInt(row[5])
                        )).collect(Collectors.toList());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Post getPostById(int id) {
        return posts.stream()
                .filter(post -> post.getPostId()==id)
                .findFirst()
                .orElse(null);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String createPost(Post post) {
        try {
            posts.add(post);
            return "Post Added Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error in Adding Post";
        }
    }
}
