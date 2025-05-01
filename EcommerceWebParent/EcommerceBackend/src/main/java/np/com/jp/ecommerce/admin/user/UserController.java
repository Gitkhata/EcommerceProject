package np.com.jp.ecommerce.admin.user;

import np.com.jp.ecommerce.common.entity.Role;
import np.com.jp.ecommerce.common.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
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

    @GetMapping("/users/new")
    public String createUser(Model model) {
        List<Role> listRoles = userService.listRoles();
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("newUser", user);
        model.addAttribute("listRoles", listRoles);

        return "create-user";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        log.info("saved user: {}", user);
        redirectAttributes.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/users";
    }
}
