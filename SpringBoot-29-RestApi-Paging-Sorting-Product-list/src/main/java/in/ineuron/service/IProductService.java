package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Product;

public interface IProductService {

	
	
	
	public Iterable<Product> fetchDetails(boolean asc, String... properties);

	public Iterable<Product> fetchDetailsByPageNo(int pageNo,int pageSize,boolean asc, String... properties);

	public List<Product> fetchDetailsByPagination(int pageSize);
}
