    package com.elife.projet_ff.controller;

    import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.elife.projet_ff.model.User;
    import com.elife.projet_ff.service.UserService;
    @CrossOrigin(origins = "http://localhost:4200")
    @RestController
    @RequestMapping("/api/user")
    public class UserController {
        @Autowired
        private final UserService userService;

     
        public UserController(UserService userService) {
            this.userService = userService;
        }

        
        @PostMapping("/create")
        public ResponseEntity<User> createUSer(@RequestBody User user){
            User createUser= userService.createUser(user);
            return new ResponseEntity<>(createUser,HttpStatus.CREATED);
        }
        @GetMapping("/find/{id}")
        public ResponseEntity<User> getUserById(@PathVariable String id){
            User user=userService.getUserById(id);
            if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @GetMapping("/all")
        public ResponseEntity<List<User>> getAllUser(){
            List<User> users=userService.getAllUser();
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
        @PutMapping("/update/{id}")
        public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String id){
            user.setId(id);
                User updateduser=userService.updateUser(user);
                return new ResponseEntity<>(updateduser,HttpStatus.OK);
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteUserById(@PathVariable String id){
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        
        @PostMapping("/login")
        public ResponseEntity<User> loginUser(@RequestBody Map<String, String> loginRequest) {
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");
            User user = userService.loginUser(email, password);
    
            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
    }
