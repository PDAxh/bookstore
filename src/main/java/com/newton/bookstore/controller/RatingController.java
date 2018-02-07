package com.newton.bookstore.controller;

import com.newton.bookstore.entity.Rating;
import com.newton.bookstore.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/addBook")
    public Rating createRating(@Valid @RequestBody Rating rating) {
        return RatingRepository.save(rating);
    }

    }

