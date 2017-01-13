package com.spring.emusic;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class EmusicController {
	

	private Path path;

	@Autowired
	private ProductDAO productDao;
	
	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(Path path) {
		this.path = path;
	}

	/**
	 * @return the productDao
	 */
	public ProductDAO getProductDao() {
		return productDao;
	}

	/**
	 * @param productDao the productDao to set
	 */
	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	@RequestMapping("/")
	public String emusicLanding(){
		return  "emusichome";
	}
	
	
	@RequestMapping("/productList")
	public String getProduct(Model model){
		Product product  = null;
		List<Product> productList = productDao.getAllProducts();
		model.addAttribute("product",productList);
		return "productList";
	}

	@RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
		Product product = new Product();
		product = productDao.getProductById(productId);
		model.addAttribute(product);
        return "viewproduct";
    }
		//	moved to admin controller	
}
