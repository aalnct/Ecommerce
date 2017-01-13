package com.spring.emusic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/*
 * Author: Amit Agarwal
 */

@Entity
public class Product {
	
	
	public Product(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productId;
	
	@Column(name = "product_name")
	@NotEmpty(message = "Product Name must not be Empty")
	private String productName;
	
	@Column(name = "product_category")
	private String productCategory;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_price")
	@Min(value = 0, message = "Product price must atleast be zero")
	private double productPrice;
	
	@Column(name = "product_condition")
	private String productionCondition;
	
	@Column(name = "product_status")
	private String productStatus;
	
	@Column(name = "unit_in_stock")
	@Min(value = 0, message = "Number of units must be greater than 0")
	private int unitInStcok;
	
	@Column(name = "product_manufacturer")
	private String productManufacturer;
	
	@Transient
	private MultipartFile productImage;
	/*private Byte productImage;*/
	
	@Lob
	@Column(name = "product_image")
	private byte[] saveProductImage;
	
	
	/**
	 * @return the saveProductImage
	 */
	public byte[] getSaveProductImage() {
		return saveProductImage;
	}

	/**
	 * @param saveProductImage the saveProductImage to set
	 */
	public void setSaveProductImage(byte[] saveProductImage) {
		this.saveProductImage = saveProductImage;
	}

	/**
	 * @return the productImage
	 */
	public MultipartFile getProductImage() {
		return productImage;
	}

	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductionCondition() {
		return productionCondition;
	}

	public void setProductionCondition(String productionCondition) {
		this.productionCondition = productionCondition;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getUnitInStcok() {
		return unitInStcok;
	}

	public void setUnitInStcok(int unitInStcok) {
		this.unitInStcok = unitInStcok;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	

}
