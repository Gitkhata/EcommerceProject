package np.com.jp.ecommerce.admin.user;

import np.com.jp.ecommerce.common.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listAll(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
}
