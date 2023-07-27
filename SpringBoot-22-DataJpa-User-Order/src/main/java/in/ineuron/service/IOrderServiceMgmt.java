package in.ineuron.service;

import java.util.List;

import in.ineuron.model.OrderList;
import in.ineuron.model.User;

public interface IOrderServiceMgmt {

	public List<OrderList> getOrdersByUser(User user);
	
	public String insertOrderDetails(OrderList new_order);
}
