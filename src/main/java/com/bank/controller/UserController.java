package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bank.dto.UserDTO;
import com.bank.exception.DuplicateRecordException;
import com.bank.models.User;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //TO DO
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register/add", method = RequestMethod.POST)
    public String addUserForm(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, RedirectAttributes redirectAttributes) {
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "password", "notEmpty.password", "Password can not be empty");
        if (result.hasErrors()) {
            logger.error("Add user error: {}", result.getAllErrors());
            return "register";
        } else {
            try {
                User userToAdd = new User();
                userToAdd.setFirstname(user.getFirstname());
                userToAdd.setLastname(user.getLastname());
                userToAdd.setUsername(user.getUsername());
                userToAdd.setEmail(user.getEmail());
                userToAdd.setPassword(passwordEncoder.encode(user.getPassword()));
                userService.add(userToAdd);
            } catch (DuplicateRecordException e) {
                result.rejectValue("email", "duplicate", "Email is already used.");
                result.rejectValue("username", "duplicate", "Username is already used.");
                logger.error("Add user error: " + result.getAllErrors());
                return "register";
            }
            redirectAttributes.addFlashAttribute("message", "Successfully added.");
            return "redirect:/users";
        }
    }

    @RequestMapping(value = "/login/user", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session) {
        User existingUser = userService.findUser(username);
        if (username.equalsIgnoreCase("asd")) {
            session.setAttribute("username", username);
            return "redirect:/users";
        } else {

            return "login";
        }
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.GET)
    public String getEditUserForm(Model model, @RequestParam(value = "userid", required = true) Long userid, RedirectAttributes redirectAttributes) {
        User existingUser = userService.findUser(userid);
        if (existingUser != null) {
            UserDTO user = new UserDTO();
            user.setUserid(existingUser.getUserid());
            user.setFirstname(existingUser.getFirstname());
            user.setLastname(existingUser.getLastname());
            user.setUsername(existingUser.getUsername());
            user.setEmail(existingUser.getEmail());
            user.setPassword(null);
            model.addAttribute("user", user);
            return "update-user";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found");
            return "redirect:/users";
        }
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            logger.error("Update user error: " + result.getAllErrors());
            return "update-user";
        } else {
            try {
                User userToUpdate = new User();
                userToUpdate.setUserid(user.getUserid());
                userToUpdate.setFirstname(user.getFirstname());
                userToUpdate.setLastname(user.getLastname());
                userToUpdate.setUsername(user.getUsername());
                userToUpdate.setEmail(user.getEmail());
                if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
                    // If password is not null encode password.
                    userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
                } else {
                    user.setPassword(null);
                }

                userService.update(userToUpdate);
            } catch (DuplicateRecordException e) {
                result.rejectValue("email", "duplicate", "New email address already used by other user");
                logger.error("Update user error: " + result.getAllErrors());
                return "update-user";
            }
            return "redirect:/users";
        }
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String deleteUser(@Valid @ModelAttribute("userid") Long userid, BindingResult result, RedirectAttributes redirectAttributes) {
        try {
            userService.delete(userid);
            redirectAttributes.addFlashAttribute("message", "The user has been successfully deleted");
        } catch (DataIntegrityViolationException e) {
            String errorMessage = "Can not delete the current user.";
            logger.error(errorMessage);
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Delete error: " + e.getMessage());
        }
        return "redirect:/users";
    }
}
