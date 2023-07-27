package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Product;


public interface IProductRepository extends JpaRepository<Product, Integer> {

	
	public Product findProductByName(String name);
}
