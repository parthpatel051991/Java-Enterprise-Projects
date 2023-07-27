package in.ineuron.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.model.Product;


public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {

	
	public Product findProductByName(String name);
}
