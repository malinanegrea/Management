package com.proj.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.persistence.DAO.ApplicationRepository;
import com.proj.persistence.entity.Application;


@Controller
@RequestMapping(value = "/apps")
/*
 * @Api( name = "Hotel Booking API", description =
 * "Provides a list of methods that manage hotel bookings", stage = ApiStage.RC)
 */
public class AppController {

	private ApplicationRepository applicationRepository;

	final static Logger logger = Logger.getLogger(AppController.class);

	@Autowired
	public AppController(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		//logger.info("apps");
		logger.info("Entering the getAll application method");
		model.addAttribute("applications", applicationRepository.findAll());
		return "/apps";
	}

	// @RequestMapping(value = "/getById/{identifier}", method = RequestMethod.GET)
	@GetMapping("/findOne")
	@ResponseBody
	public Application getId(int identifier) {
		logger.info("Entering the getId application method");
		Application app = applicationRepository.findById(identifier).get();
		if (app == null) {
			logger.warn("No applicatation found with the identifier" + identifier);
		} else {
			logger.info("Application" + app.toString() + " found for the identifier " + identifier);
		}

		return app;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Application app) {
		logger.info("Entering the create application method");
		applicationRepository.save(app);
		logger.info("Application " + app.toString() + " created");
		return "redirect:/apps";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Application application) {
		logger.info("Entering the update application method");
		Application app = applicationRepository.findById(application.getIdentifier()).get();
		app.setName(application.getName());
		app.setTechnology(application.getTechnology());
		app.setVersion(application.getVersion());
		applicationRepository.save(app);
		logger.info("Application " + app.toString() + " updated");
		return "redirect:/apps";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String remove(int identifier) {
		logger.info("Entering the delete application method");
		try {
			applicationRepository.deleteById(identifier);
			logger.info("Applica with id " + identifier + " deleted");
		} catch (IllegalArgumentException e) {
			logger.error("Delete appliction error" + e.getMessage());
		} finally {
			return "redirect:/apps";
		}
	}
}
