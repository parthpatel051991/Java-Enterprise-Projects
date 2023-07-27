package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Product;
import in.ineuron.repository.IProductRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repo;

	 @CircuitBreaker(name = "productByID", fallbackMethod = "fallbackGetProductById")
	 @Override
	    public Product getProductById(Integer id) {
	       
	        if (Math.random() < 0.5) {
	            throw new RuntimeException("Product Service Unavailable");
	        }
	       
	        return repo.findById(id).get();
	    }

	    // Fallback method to be called when the circuit is open or any exception occurs
	    public Product fallbackGetProductById(Integer id, Throwable throwable) {
	        
	    	System.out.println("FallBack method executed");
	    	
	        return new Product(id, "Fallback Product", 0);
	    }
	
	
	
	
	


}