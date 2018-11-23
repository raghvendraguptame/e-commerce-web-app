package com.example.demo.Accounts;

import com.example.demo.Cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	@Autowired
	private AccountRepository repo;

	public void createSession(HttpServletRequest request, Account account)
	{
		request.getSession().setAttribute("username",account.getUsername());
		request.getSession().setAttribute("cartId",account.getCart().getCartId());
	}

//	@RequestMapping("/signup")
//	public ModelAndView Register()
//	{
//		ModelAndView model = new ModelAndView("SignUp.jsp");
//		return model;
//	}
	
	@RequestMapping("/signup")
	public String RegisterPage()
	{
		return "SignUp.jsp";
	}
	
	@RequestMapping("/login")
	public String LoginPage()
	{
		return "Login.jsp";
	}
	
	@RequestMapping("/registered")
	@ResponseBody
	public ModelAndView signUp(Account acc)
	{
		Cart cart = new Cart();
		cart.setActive(true);
		acc.setCart(cart);
		if(repo.save(acc)==null)
		{
			ModelAndView error = new ModelAndView("Error.jsp");
			return error;			
		}
		ModelAndView model = new ModelAndView("Success.jsp");
		model.addObject("account", acc);
		return model;
	}
	
	@RequestMapping("/userAccount")
	@ResponseBody
	public ModelAndView login(@RequestParam String username, String password, HttpServletRequest request)
	{
		Account acc;
		acc = repo.findByUsername(username);

		createSession(request,acc);

//		System.out.println ("------------------"+request.getSession().getAttribute("username"));
//		System.out.println ("------------------"+request.getSession().getAttribute("cartId"));






		if(username.equals(acc.getUsername()) && password.equals(acc.getPassword())!=true)
		{
//			System.out.println("INSIDE IF");
			ModelAndView Error = new ModelAndView("Login.jsp");
			Error.addObject("msg", "Incorrect");
			return Error;
		}
		ModelAndView model = new ModelAndView("userAccount.jsp");
		model.addObject("account", acc);
		return model;
	}
	
//	@RequestMapping("/error")
//	public String errorPage()
//	{
//		return "Error.jsp";
//	}
	
}
