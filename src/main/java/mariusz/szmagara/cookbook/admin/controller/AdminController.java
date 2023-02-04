package mariusz.szmagara.cookbook.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import mariusz.szmagara.cookbook.user.model.User;
import mariusz.szmagara.cookbook.user.service.UserService;

import java.util.Optional;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/panel")
    public String getAdminPanel(Model model) {
        model.addAttribute("usersListWithoutAuthenticated", userService.findAllWithoutAuthenticated());
        model.addAttribute("newUser", new User());
        return "adminPanel";
    }

    @PostMapping("/admin/panel/addNewUser")
    public String addNewUser(User user) {
        userService.addNewUser(user);
        return "redirect:/admin/panel";
    }

    @PostMapping("/admin/panel/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/panel";
    }

    @GetMapping("/admin/panel/modifyUser/{id}")
    public String modifyUser(@PathVariable Long id, Model model) {
        Optional<User> optionalUserById = userService.findUserById(id);
        if (optionalUserById.isPresent()) {
            User userToModify = optionalUserById.get();
            model.addAttribute("userToModify", userToModify);
            return "modifyUserForm";
        } else {
            return "error";
        }
    }
}
