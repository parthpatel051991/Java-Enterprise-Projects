package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

	@Autowired
	private IProductService service;

	@PostMapping("/reg")
	public ResponseEntity<String> insertProduct(@RequestBody Product product) {

		String result = service.saveProduct(product);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyProduct(@RequestBody Product product) {
		
		String result = service.updateProduct(product);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer id) {
		
		String result = service.deleteProductById(id);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}

	
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		
		Product product = service.getProductById(id);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}

	
	@GetMapping("/find")
	public ResponseEntity<List<Product>> getAllProduct() {
		
		List<Product> list = service.getAllProduct();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	
	
}
