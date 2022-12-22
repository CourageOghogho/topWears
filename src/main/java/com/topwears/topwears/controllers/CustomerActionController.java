package com.topwears.topwears.controllers;

import com.topwears.topwears.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerActionController {
    private final CommentService commentService;

}
