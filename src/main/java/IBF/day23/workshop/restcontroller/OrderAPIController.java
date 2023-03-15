package IBF.day23.workshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IBF.day23.workshop.model.Order;
import IBF.day23.workshop.repository.OrderRepo;

@RestController
@RequestMapping("/api/orders")
public class OrderAPIController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/{order-id}")
    public ResponseEntity<List<Order>> findOrderById(@PathVariable("order-id") Integer id) {
        List<Order> orders = orderRepo.findByOrderId(id);

        if (orders.size() > 0) {
            return new ResponseEntity<>(orders, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        }

    }

    
}
