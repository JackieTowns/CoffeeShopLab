package co.grandcircus.coffeeshop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.daos.ProductsDao;
import co.grandcircus.coffeeshop.daos.UserDao;
import co.grandcircus.coffeeshop.entities.Product;
import co.grandcircus.coffeeshop.entities.User;

@Controller
public class CoffeeshopController {

	// ------------------------- Product-------------------------------

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

	// ------------------------- User-------------------------------

	@Autowired
	private UserDao daoUser;

	@RequestMapping("/register-result")
	public ModelAndView add() {
		return new ModelAndView("register-result");
	}

	@PostMapping("/register-result")
	public ModelAndView addRegisterResult(User users, HttpSession session) {

		// if (users!=null) {
		daoUser.create(users);
		session.setAttribute("preference", users.getYourname());
		return new ModelAndView("register-result");

	}
	
	// ------------------------- Admin-------------------------------


	@RequestMapping("/admin")
	public ModelAndView admin() {
		List<Product> theProducts = dao.findAll();
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("products", theProducts);
		return mv;

	}

	@RequestMapping("/add")
	public ModelAndView submitCreateForm() {
		return new ModelAndView("add");
	}

	@PostMapping("/add")
	public ModelAndView submitCreateForm(Product product) {
		dao.create(product);
		return new ModelAndView("redirect:/admin");
	}


	@RequestMapping("/admin/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		dao.delete(id);
		return new ModelAndView("redirect:/admin");
	}


	// ------------------------- Sessions-------------------------------

	@RequestMapping("/sessions/unset")
	public ModelAndView unsetPreferences(HttpSession session) {
		session.removeAttribute("preference");
		return new ModelAndView("redirect:/register");
	}
}
