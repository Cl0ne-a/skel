package com.example.skel.appresource;
import com.example.skel.domain.User;
import com.example.skel.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/userList")
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRestFunctional {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public @ResponseBody @Validated List<User> findAll(){
        log.info("****REST PLACE INIT****");
        return this.userService.findAll();
    }
}
