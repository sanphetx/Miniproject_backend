package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Feed;
import com.example.demo.repository.FeedRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/feeds")
public class FeedController {
    private final FeedRepository feedRepository;
    
    @Autowired
    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }
    
    @GetMapping
    public List<Feed> getAllFeeds() {
        return feedRepository.findAll();
    }

    @GetMapping("/{id}")
    public Feed getFeedById(@PathVariable Long id) {
        return feedRepository.findById(id).orElse(null);
    }
   
    @GetMapping("/byUsername/{username}")
    public ResponseEntity<List<Feed>> getFeedsByUsername(@PathVariable String username) {
        List<Feed> feeds = feedRepository.findByUsername(username);
        if (feeds != null && !feeds.isEmpty()) {
            return ResponseEntity.ok(feeds);
        } else {
            
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Feed addFeed(@RequestBody Feed feed) {
        return feedRepository.save(feed);
    }

    @PutMapping("/{id}")
    public Feed updateFeed(@PathVariable Long id, @RequestBody Feed updatedFeed) {
        Feed existingFeed = feedRepository.findById(id).orElse(null);
        if (existingFeed != null) {
            existingFeed.setUsername(updatedFeed.getUsername());
            existingFeed.setFeedname(updatedFeed.getFeedname());
            existingFeed.setFeedcontent(updatedFeed.getFeedcontent());
            return feedRepository.save(existingFeed);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable Long id) {
        feedRepository.deleteById(id);
    }
}

