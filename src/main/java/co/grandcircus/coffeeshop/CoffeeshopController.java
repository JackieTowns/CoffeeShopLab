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
import co.grandcircus.coffeeshop.daos.UserRepository;
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

	// ------------------------- Login-------------------------------

	@Autowired
	UserRepository daoLogin;

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}

	
	@PostMapping("/login")
	public ModelAndView submitLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {

		User loginUser = daoLogin.findByUsernameAndPassword(username, password);

		if (loginUser == null) {
			return new ModelAndView("index", "error", "Incorrect username or password. Please try again!");
		}

		session.setAttribute("user", loginUser);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}

	// ------------------------- Sessions-------------------------------

	/*
	 * @RequestMapping("/sessions/unset") public ModelAndView
	 * unsetPreferences(HttpSession session) {
	 * session.removeAttribute("preference"); return new
	 * ModelAndView("redirect:/register"); }
	 */
}
