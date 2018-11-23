package com.example.demo.Cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Product.Product;
import com.example.demo.Product.ProductRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {
	
	@Autowired
	CartRepository cartRepo;
	@Autowired
	ProductRepository Productrepo;
	@Autowired
	CartItemRepository cartItemRepo;
	@Autowired HttpServletRequest request;

//	@RequestMapping("/cart/{id}")
//	public ModelAndView addToCart(@PathVariable Long id)
//	{
//		Optional<Product> pro=Productrepo.findById(id);
//		Cart cart = new Cart();
//		cart.setTotalValue(p.getPrice());
//		Product p = pro.get();
//
//		cart.setActive(true);
//		
//		
//		CartItems item = new CartItems();
//		item.setCart(cart);
//		item.setItem(p);
//		item.setValue(cart.getTotalValue());
//		
//		cartRepo.save(cart);
//		itemRepo.save(item);
//		
//		
//		ModelAndView model = new ModelAndView("Cart.jsp");
//		model.addObject("product",p);
//			
//		return model;
//	}

	@RequestMapping("/abc")
	public String abc()
	{
		return "abc.html";
	}
	public ModelAndView viewCart()
	{

		Long id = (Long) request.getSession().getAttribute("cartId");
		List<CartItems> list = cartItemRepo.findAllByCartId(id);

//		System.out.println(list.get(0).getItem().getName());

//		System.out.println("----------------------"+request.getSession().getAttribute("cartId"));
		ModelAndView model = new ModelAndView("Cart.jsp");
		model.addObject("lists",list);

		return model;
	}

	@RequestMapping("/Cart")
	public ModelAndView Cart()
	{
		if(request.getParameter("cartItemId")!= null)
		{
			Long cartItemId = Long.parseLong(request.getParameter("cartItemId"));
			return removeFromCart(cartItemId);
		}
        else if(request.getParameter("productId") == null)
        {
            return viewCart();
        }
		else if(request.getSession().getAttribute("username")!=null)
		{
            Long productId= Long.parseLong(request.getParameter("productId"));
			Long cartId = (Long) request.getSession().getAttribute("cartId");

//			System.out.println("-------cart id---------"+request.getSession().getAttribute("cartId"));

			Product product=Productrepo.findById(productId).orElse(new Product());

			List<CartItems> CartItemsList=cartItemRepo.findAllByCartId(cartId);

			for(int i=0;i<CartItemsList.size(); i++)
				if(product.getId()==CartItemsList.get(i).getItem().getId())
				{
					CartItems cartItems=CartItemsList.get(i);
					cartItems.setQuantity(cartItems.getQuantity()+1);
					cartItems.setValue((product.getPrice()*(cartItems.getQuantity())));
					cartItemRepo.save(cartItems);
					return viewCart();
				}

			Optional<Cart> c = cartRepo.findById(cartId);
			Cart cart = c.get();
			cart.setTotalValue(product.getPrice());
			cart.setActive(true);


			CartItems item = new CartItems();
			item.setCart(cart);
			item.setItem(product);
			item.setValue(cart.getTotalValue());

			cartRepo.save(cart);
			cartItemRepo.save(item);

			return viewCart();
		}

		ModelAndView errorPage = new ModelAndView("Error.jsp");
		errorPage.addObject("msg","Please Login");

		return errorPage;

	}

	private ModelAndView removeFromCart(Long cartItemId) {

		cartItemRepo.deleteById(cartItemId);

		return viewCart();
	}

}
