package org.descentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AngularController {

	@RequestMapping(value = "/{[path:[^\\.]*}", method = RequestMethod.GET)
	public String redirect() {
	  return "forward:/";
	}
}
