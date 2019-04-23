package com.proj.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.persistence.AddAppItemForm;
import com.proj.persistence.DAO.ApplicationRepository;
import com.proj.persistence.DAO.UserRepository;
import com.proj.persistence.entity.Application;
import com.proj.persistence.entity.User;

@Service
@Controller
@RequestMapping(value = "/users")
/*
 * @Api( name = "Hotel Booking API", description =
 * "Provides a list of methods that manage hotel bookings", stage = ApiStage.RC)
 */
public class UserController {
	
	private final static Logger logger = Logger.getLogger(UserController.class);

	private UserRepository userRepository;

	private ApplicationRepository applicationRepository;

	

	@Autowired
	public UserController(UserRepository userRepository, ApplicationRepository applicationRepository) {
		this.userRepository = userRepository;
		this.applicationRepository = applicationRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		logger.info("Entering the gelAll user method");
		model.addAttribute("users", userRepository.findAll());
		return "users/index";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public User getId(int identifier) {
		logger.info("Entering the getId user method for id " + identifier);
		User user = userRepository.findById(identifier).get();
		if (user == null) {
			logger.warn("No user found with the identifier" + identifier);
		} else {
			logger.info("User " + user.toString() + " found for the identifier " + identifier);
		}
		return user;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user) {
		logger.info("Entering the create user method");
		userRepository.save(user);
		logger.info("User " + user.toString() + " saved");
		return "redirect:/users";
	}

	@Transactional
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user) {
		logger.info("Entering the update user method");
		userRepository.updateNameAndUsernameAndPassword(user.getIdentifier(), user.getName(), user.getUsername(),
				user.getPassword());
		logger.info("User " + user.toString() + " updated");
		return "redirect:/users";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String remove(int identifier) {
		logger.info("Entering the delete user method");
		try {
			userRepository.deleteById(identifier);
			logger.info("User with id " + identifier + " deleted");
		} catch (IllegalArgumentException e) {
			logger.error("Delete appliction error" + e.getMessage());
		} finally {
			return "redirect:/users";
		}

	}

	
	@RequestMapping(value = "/view/{identifier}", method = RequestMethod.GET)
	public String viewApps(Model model, @PathVariable int identifier) {
		logger.info("Entering the viewApps user method");
		User user = userRepository.findById(identifier).get();
		model.addAttribute("user", user);
		model.addAttribute("applications", user.getApplications());
		model.addAttribute("application", new Integer(0));
		return "users/view";
	}

	@RequestMapping(value = "add-item/{identifier}", method = RequestMethod.GET)
	public String addItem(Model model, @PathVariable int identifier) {
		User user = userRepository.findById(identifier).get();
		logger.info("Entering the addItem user for identifier method");
		AddAppItemForm form = new AddAppItemForm(applicationRepository.findAll(), user);
		model.addAttribute("user", user);
		model.addAttribute("form", form);
		return "users/add-item";
	}

	@RequestMapping(value = "add-item", method = RequestMethod.POST)
	public String addItem(Model model, @ModelAttribute AddAppItemForm form) {
		logger.info("Entering the addItem user method");
		User user = userRepository.findById(form.getUserId()).get();
		Application app = applicationRepository.findById(form.getAppId()).get();
		user.getApplications().add(app);
		userRepository.save(user);
		logger.info("Application " + app.toString() + " was added to user " + user.toString());
		return "redirect:/users/view/" + user.getIdentifier();
	}

	@RequestMapping(value = "/view/deleteapp/{userId}/bar/{appId}", method = RequestMethod.GET)
	public String deleteApp(Model model, @PathVariable int userId, @PathVariable int appId) {
		logger.info("Entering the deleteApp user method");
		User user = userRepository.findById(userId).get();
		Application app = applicationRepository.findById(appId).get();
		user.getApplications().remove(app);
		userRepository.save(user);
		logger.info("Application " + app.toString() + " was remoed from the user " + user.toString());
		return "redirect:/users/view/" + user.getIdentifier();
	}

}
