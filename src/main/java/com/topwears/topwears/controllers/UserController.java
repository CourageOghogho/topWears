package com.topwears.topwears.controllers;


import com.topwears.topwears.models.enums.Role;
import com.topwears.topwears.models.pojos.ApiResponse;
import com.topwears.topwears.models.pojos.UserRegistrationRequest;
import com.topwears.topwears.services.UserService;
import com.topwears.topwears.utils.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final ResponseManager responseManager;
    private final UserService userService;

    @PostMapping("/")
    public ApiResponse registerUser(@RequestBody UserRegistrationRequest request){
        return  responseManager.success(userService.register(request));
    }
    @GetMapping("/{id}")
    public  ApiResponse getUser(@PathVariable("id") Long id){
        return responseManager.success(userService.getUser(id));
    }

    @GetMapping("/")
    public  ApiResponse allUsers(){
        return responseManager.success(userService.getAll());
    }

    @GetMapping("/{role}")
    public  ApiResponse allCustomerUsers(@PathVariable("role") Role role){
        return responseManager.success(userService.getUsersByRole(role));
    }
}
