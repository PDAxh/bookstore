package com.newton.bookstore.controller;

import com.newton.bookstore.entity.Rating;
import com.newton.bookstore.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @PostMapping("/addRating")
    public Rating createRating(@Valid @RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    /*
    @GetMapping("/getBooksById/{id}")
    public ResponseEntity<Rating> getBooksById(@PathVariable(value = "id") int bookId) {
        Rating rating = ratingRepository.findOne(bookId);
        if(rating == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rating);

        */
    }