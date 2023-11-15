package ge.softlab.distancecalculator.controllers;
import ge.softlab.distancecalculator.entities.UserDomain;
import ge.softlab.distancecalculator.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDomain> addUser(@RequestBody UserDomain user) {
        UserDomain addedUser = userService.addUser(user);
        return ResponseEntity.ok(addedUser);
    }
}
