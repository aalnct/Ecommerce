package com.spring.emusic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.emusic.dao.ProductDAO;
import com.spring.emusic.model.Product;

@Controller
public class AdminController {
	
	private Path path;

	@Autowired
	private ProductDAO productDao;
	
	
	
	@RequestMapping("/admin")
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping(value  = "/admin/productInventory", method = {RequestMethod.GET,RequestMethod.POST})
	/*public String productInventory(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{*/
	public String productInventory(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{
		/*response.setContentType("image/*");*/
		
		ModelAndView mav = new ModelAndView();
		
		List<Product> product = productDao.getAllProducts();
		/*
		for(Product p : product){
			byte[] prod = p.getSaveProductImage();
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.setContentType("text/html");
			if(prod!=null){
				response.getOutputStream().write(prod);	
			}
		    
		}*/
		model.addAttribute("product",product);
		/*mav.addObject("product", product);*/
		
		/*new ModelAndView("productInventory");*/
		
		/*response.getOutputStream().flush();
		response.getOutputStream().close();*/
		
		return "productInventory";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct")
	public String addProduct(Model model){
	
		Product product = new Product();
		product.setProductCategory("Instruments");
		product.setProductionCondition("New");
		product.setProductStatus("Acitve");
		
		model.addAttribute("product",product);
		
		/*new ModelAndView("addProduct");*/
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct",method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, 
			BindingResult result,HttpServletRequest request) throws IOException{
		
		if(result.hasErrors()){
			return "addProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		
		byte[] byteArrayFiles = productImage.getBytes();
		
		product.setSaveProductImage(byteArrayFiles);
		
		
		
		
		productDao.addProduct(product);
		
		/*MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getContextPath();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId()+".png");
		
		System.out.println(path.toString());
		if(productImage!=null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception exception){
				exception.printStackTrace();
				throw new RuntimeException("Product Image Save failed");
			}
		}*/
		
		/*return "productInventory";*/
		return "redirect:/admin/productInventory";//spring knows this is the path name and not jsp page
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id, Model model){
		productDao.deleteProduct(id);
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value = "/admin/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable("id") String id, Model model){
		Product product = productDao.getProductById(id);
		model.addAttribute(product);
		return "editProduct";
	}
	
	@RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") Product product, HttpServletRequest request) throws IOException{
		MultipartFile productImage = product.getProductImage();
		
		byte[] savedImage = productImage.getBytes();
		
		if(savedImage!=null){
			try{
				product.setSaveProductImage(savedImage);
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		
		productDao.editProduct(product);
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	
}
