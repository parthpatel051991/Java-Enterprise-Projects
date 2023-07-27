package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.OrderList;
import in.ineuron.model.User;
import in.ineuron.repo.IOrderRepository;

@Service("order-service")
public class OrderServiceMgmtImpl implements IOrderServiceMgmt {

	@Autowired
	private IOrderRepository repo;
	
	@Override
	public List<OrderList> getOrdersByUser(User user) {
        return repo.findByUser(user);
    }

	@Override
	public String insertOrderDetails(OrderList new_order) {
       OrderList registredOrder=null;
		
		if (new_order!=null) {
			registredOrder = repo.save(new_order);			
		}
		
		
		return (registredOrder!=null)? "Order registred succesfully with details :: "+registredOrder:"Order registration is failed";
	}

}
