package org.djohnson.sblogic.controller;

import javax.validation.Valid;

import org.djohnson.sblogic.model.User;
import org.djohnson.sblogic.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController is the controller for CRUD functions for system users.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * ShowUserList will return a list of all users.
     * 
     * @param model the model use (generic)
     * @return list of {@link Model}
     */
    @RequestMapping(value= "/index", method = RequestMethod.GET)
    public String showUserList(Model model) {
    	
    	logger.debug("getting list of all users");
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    /**
     * ShowSignUpForm will present a string add-user.
     * 
     * @param user the {@link User} to sign up.
     * @return the string add-user (for thymeleaf)
     */
    @RequestMapping(value= "/signup", method = RequestMethod.GET)
    public String showSignUpForm(User user) {
    	
    	logger.debug("display the add user leaf");
        return "add-user";
    }
    
    /**
     * Add the new user to the system.
     * 
     * @param user		the {@link User} to add
     * @param result	the {@link BindingResult} result
     * @param model		the {@link Model} to use, generic
     * @return			if error, return back to the add user view, else the list of users
     */
    @RequestMapping(value= "/adduser", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
        	logger.debug("adding user has errors, redo");
            return "add-user";
        }
        
        userRepository.save(user);
        return "redirect:/index";
    }
    
    /**
     * Display the update user leaf.
     * @param id		the id of the user to update
     * @param model		the {@link Model} the model to use for updating
     * @return			the "update-user" string for leaf
     */
    @RequestMapping(value= "/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	
    	logger.debug("display the update user leaf");
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        
        return "update-user";
    }
    
    /**
     * Updates a user by their id.
     * 
     * @param id		the id of the user to update
     * @param user		the {@link User} object to update
     * @param result	the {@link BindingResult} the result
     * @param model		the {@link Model} to use (generic)
     * @return			if errors, go back to editing, else redirect to the index
     */
    @RequestMapping(value= "/update/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
        	logger.debug("updating the user has errors, redo");
            user.setId(id);
            return "update-user";
        }
        
        userRepository.save(user);

        return "redirect:/index";
    }
    
    /**
     * Delete a user from the system.
     * @param id		the user's id
     * @param model		the model to use
     * @return			redirects back to index (list of users)
     */
    @RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id, Model model) {
    	
    	logger.debug("delete the user");
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        
        return "redirect:/index";
    }

}
