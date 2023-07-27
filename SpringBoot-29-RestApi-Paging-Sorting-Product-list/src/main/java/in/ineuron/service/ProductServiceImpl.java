package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.model.Product;
import in.ineuron.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repo;

	@Override
	public Iterable<Product> fetchDetails(boolean asc, String... properties) {

		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<Product> listEntities = repo.findAll(sort);

		return listEntities;
	}

	@Override
	public Iterable<Product> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		
		PageRequest pageable = PageRequest.of(pageNo, pageSize, asc?Direction.ASC:Direction.DESC, properties);
		
		Page<Product> page = repo.findAll(pageable);
		
		return page.getContent();
	}

	@Override
	public List<Product> fetchDetailsByPagination(int pageSize) {
		
//		//total record count
//		long count = repo.count();  //total 4
//		
//		//deciding pages count
//		Long pagesCount= count/pageSize; //pagesCount = 4/2=2
//		
//		
//		pagesCount= count%pageSize ==0 ? pagesCount : ++pagesCount; //pagesCount=2
		
		
		PageRequest pageable = PageRequest.ofSize(pageSize);
		
		Page<Product> page = repo.findAll(pageable);
		
		return page.getContent();
		
		
	}

}
