package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class StartTable {

    private final UserService userService;

    @Autowired
    public StartTable(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void postConstruct() {
        userService.addUser(new User("User1", 33));
        userService.addUser(new User("User2", 45));
        userService.addUser(new User("User3", 20));
        userService.addUser(new User("User4", 22));
    }
}