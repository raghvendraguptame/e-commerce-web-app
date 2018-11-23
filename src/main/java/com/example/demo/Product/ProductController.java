package com.example.demo.Product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	@RequestMapping("/home")
	public String home()
	{
		return "home.html";
	}
	
//	@RequestMapping("/home")
//	public String home()
//	{
//		return "home.html";
//	}
	
//	@GetMapping("/products/{id}")
//	public Product getProduct(@PathVariable Long id)
//	{
//		return repo.findById(id).get();
//	}
	
	@RequestMapping("/viewAllProducts")
	public ModelAndView viewAllProducts()
	{
		
		ArrayList<Product> list = (ArrayList<Product>)repo.findAll();
		
		System.out.println(list.get(1).toString());
		
		ModelAndView model = new ModelAndView("AllProducts.jsp");
		model.addObject("lists", list);
		return model;
		
	}
	
	@PostMapping("/addProduct")
	@ResponseBody
	public Product addProduct(Product product)
	{
		return repo.save(product);
	}
	
	@RequestMapping("/getProduct")
    public ModelAndView showAll(Long aid)
    {
//		System.out.println("---------------------------hellooo-------------------------------------------");
        ModelAndView mv = new ModelAndView("productInfo.jsp");
        Product product =  repo.findById(aid).orElse(new Product());
//        System.out.print("----------------------"+product);
        mv.addObject(product);
//        System.out.println("-------------mv-------"+mv);
        return mv;

    }
	
//	@RequestMapping("/updateProduct")
//    public String update(Long id , Product product)
//    {
//        product.setId(id);
//        repo.save(product);
//        return "Success.jsp";
//    }
	
	@RequestMapping("/updateProduct")
    public ModelAndView update(Long id , Product product)
    {
        product.setId(id);
        repo.save(product);
        ModelAndView m = viewAllProducts();
        return m;
    }
	
	
}
