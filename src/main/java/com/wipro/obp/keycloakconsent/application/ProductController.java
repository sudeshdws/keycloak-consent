package com.wipro.obp.keycloakconsent.application;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
class ProductController {

	@GetMapping(path = "/products")
	public String getProducts(Model model){
		model.addAttribute("products", Arrays.asList("iPad","iPhone","iPod"));
		return "products";
	}

	@GetMapping(path = "/bank-api")
	public String getBankApi(Model model) {
		model.addAttribute("products", Arrays.asList("iPad","iPhone","iPod"));
		return "products";
	}


	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		System.out.println("in logout method");
		request.logout();
		///return "logout";
		return "main";
	}


//         public void logoutAll() {
//                 log <http://log.info/>.info <http://log.info/>("Received request to log out all users.");
//         for (HttpSession session : sessions.getAll()) {
//             session.invalidate();
//         }
//        sessions.clear(); 	}

}
