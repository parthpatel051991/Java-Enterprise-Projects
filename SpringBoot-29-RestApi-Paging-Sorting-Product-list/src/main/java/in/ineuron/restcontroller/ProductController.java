package in.ineuron.restcontroller;

import java.util.List;

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


	
	@GetMapping("/pageNo/{pageNo}")
	public ResponseEntity<List<Product>> getProductByPageNo(@PathVariable Integer pageNo) {
		
		List<Product> products = (List<Product>) service.fetchDetailsByPageNo(pageNo, 2, false, "quantity");
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}

	
	@GetMapping("/pageSize/{pageSize}")
	public ResponseEntity<List<Product>> getProductByCustomePageSize(@PathVariable Integer pageSize) {
		
		List<Product> products = (List<Product>) service.fetchDetailsByPagination(pageSize);
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}

	
	@GetMapping("/findAll")
	public ResponseEntity<List<Product>> getAllProduct() {
		
		List<Product> list = (List<Product>) service.fetchDetails(false, "quantity" );
		
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}

	
	
}
