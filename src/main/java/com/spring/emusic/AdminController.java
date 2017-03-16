package com.spring.emusic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@Autowired
	@Qualifier("productDao")
	private ProductDAO productDao;
	
	
	
	@RequestMapping("/admin")
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping(value  = "/admin/productInventory", method = {RequestMethod.GET,RequestMethod.POST})
	/*public String productInventory(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{*/
	public String productInventory(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		
		List<Product> product = productDao.getAllProducts();
		model.addAttribute("product",product);
		
		return "productInventory";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct")
	public String addProduct(Model model){
	
		Product product = new Product();
		product.setProductCategory("Instruments");
		product.setProductionCondition("New");
		product.setProductStatus("Acitve");
		
		model.addAttribute("product",product);
		
		
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
