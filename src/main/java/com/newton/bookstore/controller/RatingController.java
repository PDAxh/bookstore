package com.newton.bookstore.controller;

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
    RatingRepository RatingRepository;

}
