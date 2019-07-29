package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.daos.ProductsDao;
import co.grandcircus.coffeeshop.daos.UserDao;
import co.grandcircus.coffeeshop.entities.Product;
import co.grandcircus.coffeeshop.entities.User;

@Controller
public class CoffeeshopController {

	@Autowired
	private ProductsDao dao;

	@RequestMapping("/")
	public ModelAndView index() {
		List<Product> theProducts = dao.findAll();
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("products", theProducts);

		return mv;

	}

	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}

	@Autowired
	private UserDao daoUser;

	@RequestMapping("/register-result")
	public ModelAndView add() {
		return new ModelAndView("register-result");
	}

	@PostMapping("/register-result")
	public ModelAndView addRegisterResult(User users) {
		daoUser.create(users);
		return new ModelAndView("register-result");
	}

//	@RequestMapping("/register")
//	public ModelAndView showRegister() {
//
//		ModelAndView mv = new ModelAndView("register");
//		mv.addObject("User", user);
//		return mv;
//
//	}

//	@RequestMapping("/register")
//	public ModelAndView userList() {
//		List<User> theUsers = dao.findAll();
//		return new ModelAndView("userList", "Users", theUsers);
//
//	}

	/*
	 * @RequestMapping("/register-result") public ModelAndView
	 * showRegisterResult(@RequestParam("name") String Name) { ModelAndView mav =
	 * new ModelAndView("register-result"); //mav.addObject("name", Name); return
	 * mav; }
	 */
	
	
	/*
	 * @RequestMapping("/register-result") public ModelAndView
	 * showRegisterResult(@RequestParam("name") String Name) { ModelAndView mav =
	 * new ModelAndView("register-result"); //mav.addObject("name", Name); return
	 * mav; }
	 */

	/*
	 * @PostMapping("/register-result") public ModelAndView
	 * createRegisterResult(@RequestParam("user") String user) { //dao.create(user);
	 * ModelAndView mav = new ModelAndView("register-result"); mav.addObject("name",
	 * Name); return mav; //return ("redirect:/"); }
	 */

}
