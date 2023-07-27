package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Product;

public interface IProductService {

	public String saveProduct(Product product);
	
	public String updateProduct(Product product);
	
	public String deleteProductById(Integer id);
	
	public Product getProductById(Integer id);
	
	public List<Product> getAllProduct();
}
