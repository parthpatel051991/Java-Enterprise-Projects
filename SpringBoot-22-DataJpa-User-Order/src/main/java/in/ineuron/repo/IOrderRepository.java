package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.OrderList;
import in.ineuron.model.User;


public interface IOrderRepository extends JpaRepository<OrderList, Integer> {

	List<OrderList> findByUser(User user);
}
