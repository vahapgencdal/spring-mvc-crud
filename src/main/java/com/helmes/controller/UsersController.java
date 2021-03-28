package com.helmes.controller;

import com.helmes.dto.UserFormDto;
import com.helmes.model.User;
import com.helmes.service.SectorService;
import com.helmes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */

@Controller
public class UsersController {

    private static final String ADD_USER = "add-user";
    private static final String REDIRECT_SLASH = "redirect:/";

    @Autowired
    private UserService userService;

    @Autowired
    private SectorService sectorService;

    @GetMapping
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String getUser(Model model) {

        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setSectors(sectorService.getMappedSectorList());
        userFormDto.setAgreeToTerm(Boolean.FALSE);

        model.addAttribute("userFormDto",userFormDto);

        return ADD_USER;

    }

    @PostMapping("/add")
    public String postUSer(@Valid @ModelAttribute UserFormDto userFormDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            userFormDto.setSectors(sectorService.getMappedSectorList());
            return ADD_USER;
        }

        userService.save(userFormDto);

        return REDIRECT_SLASH;
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {

        model.addAttribute("userFormDto", userService.getUserDto(id));
        return ADD_USER;
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") long id, Model model) {

        model.addAttribute("userFormDto", userService.getUserDto(id));
        model.addAttribute("action","view");
        return ADD_USER;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user);

        return REDIRECT_SLASH;
    }

}
