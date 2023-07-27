package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

	@Autowired
	private IProductService service;

	

	
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> fetchProductByID(@PathVariable Integer id) {
		
		Product product = service.getProductById(id);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}

	

	
	
	
}
