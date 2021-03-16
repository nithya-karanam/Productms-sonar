package com.infy.ProductMS;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.infy.Product.Dto.ProductDTO;
import com.infy.Product.entity.Product;
import com.infy.Product.repository.ProductRepository;
import com.infy.Product.service.ProductMSException;
import com.infy.Product.service.ProductService;
import com.infy.Product.service.ProductServiceImpl;
import com.infy.validator.Validator;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
 public class ProductMsApplicationTests {

@Mock
ProductRepository productRepository;

@Mock
Validator validator;

@InjectMocks
ProductServiceImpl service = new ProductServiceImpl();

     @Test
	public void getAllProductTest() throws ProductMSException  {
		
		Product product=new Product(1,"nike","clothing","red","image.jpeg/","shorts","shorts",4,50,500.0f,4);
		Product product1=new Product(2,"FabHomeDecor","Furniture","FabHomeDecor Fabric Double Sofa Bed (Finish Color - Leatherette Black Mechanism Type - Pull Out)","\"http://img6a.flixcart.com/image/sofa-bed/j/f/y/fhd112-double-foam-fabhomedecor-leatherette-black-leatherette-1100x1100-imaeh3gemjjcg9ta.jpeg\"","FabHomeDecor Fabric Double Sofa Bed","Living Room Furniture",4,30,32157.00f,0);
		Product product2=new Product(11,"nike","clothing","red","image.jpeg/","shorts","shorts",4,50,500.0f,4);
      List<Product> products= new ArrayList<>();
 	     products.add(product);
 	     products.add(product1);
 	    products.add(product2);
 	    Mockito.when(productRepository.findAll()).thenReturn(products);
 	 List<ProductDTO> actual=service.getAllProducts();
 	 assertEquals(products.isEmpty(), actual.isEmpty());
}
     
     @Test
 	public void getProductByCategoryValid() throws ProductMSException {
    	 Product product=new Product(1,"nike","Clothing","red","image.jpeg/","shorts","shorts",4,50,500.0f,4);
 		Product product1=new Product(2,"FabHomeDecor","Clothing","FabHomeDecor Fabric Double Sofa Bed (Finish Color - Leatherette Black Mechanism Type - Pull Out)","\"http://img6a.flixcart.com/image/sofa-bed/j/f/y/fhd112-double-foam-fabhomedecor-leatherette-black-leatherette-1100x1100-imaeh3gemjjcg9ta.jpeg\"","FabHomeDecor Fabric Double Sofa Bed","Living Room Furniture",4,30,32157.00f,0);
 		 
 		List<Product> products=new ArrayList<>();
 		products.add(product1);
 		products.add(product);
 		
 		Mockito.when(productRepository.findByCategory("Clothing")).thenReturn(products);
 		List<ProductDTO> actual=service.getProductByCategory("Clothing");
 		System.out.println("product according to category");
 		assertEquals(products.isEmpty(), actual.isEmpty());
     }
     
     
        @Test
 	public void getProductByNameValid() throws ProductMSException {
    	 Product product=new Product(1,"nike","Clothing","red","image.jpeg/","shorts","shorts",4,50,500.0f,4);
  		Product product1=new Product(2,"FabHomeDecor","Clothing","FabHomeDecor Fabric Double Sofa Bed (Finish Color - Leatherette Black Mechanism Type - Pull Out)","\"http://img6a.flixcart.com/image/sofa-bed/j/f/y/fhd112-double-foam-fabhomedecor-leatherette-black-leatherette-1100x1100-imaeh3gemjjcg9ta.jpeg\"","FabHomeDecor Fabric Double Sofa Bed","Living Room Furniture",4,30,32157.00f,0);
  		 
 		List<Product> products=new ArrayList<>();
 		products.add(product1);
 		products.add(product);
 		System.out.println();
 		Mockito.when(productRepository.findByProductname("shorts")).thenReturn(products);
 		List<ProductDTO> actual=service.getProductByName("shorts");
 		Assertions.assertEquals(products.isEmpty(), actual.isEmpty());
	
     }
        @Test
    	public void validatePrice() throws ProductMSException{
        	System.out.println("checking price");
    		assertTrue(Validator.validatePrice(500));
    	}
        @Test
    	public void validateStock() throws ProductMSException{
        	System.out.println("checking Stock");
    		assertTrue(Validator.validateStock(5));
    	}
	
}
