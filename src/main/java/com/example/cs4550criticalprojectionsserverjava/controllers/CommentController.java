package com.example.cs4550criticalprojectionsserverjava.controllers;

import com.example.cs4550criticalprojectionsserverjava.models.Comment;
import com.example.cs4550criticalprojectionsserverjava.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
  @Autowired
  CommentService service;

  @GetMapping("/api/reviews/{rid}/comments/{cnt}")
  public List<Comment> findCommentsForReview(
          @PathVariable("rid") Integer reviewId,
          @PathVariable("cnt") Integer count) {
    return service.findCommentsForReview(reviewId, count);
  }

  @GetMapping("/api/users/{uid}/comments")
  public List<Comment> findCommentsForUser(
          @PathVariable("uid") Integer userId) {
    return service.findCommentsForUser(userId);
  }

  @PostMapping("/api/comments")
  public Comment createComment(
          @RequestBody Comment comment) {
    return service.createComment(comment);
  }

  @DeleteMapping("/api/comments/{cid}")
  public Integer deleteComment(
          @PathVariable("cid") Integer commentId) {
    return service.removeComment(commentId);
  }

  @PutMapping("/api/comments/{cid}")
  public Integer updateComment(
          @PathVariable("cid") Integer commentId,
          @RequestBody Comment comment) {
    return service.updateComment(commentId, comment);
  }
}
