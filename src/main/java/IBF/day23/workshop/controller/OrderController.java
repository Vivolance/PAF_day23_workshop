package IBF.day23.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import IBF.day23.workshop.model.Order;
import IBF.day23.workshop.payload.SearchRequest;
import IBF.day23.workshop.service.OrderRestTemplateService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRestTemplateService arts;

    @GetMapping
    public String searchOrder(Model model) {
        SearchRequest sr = new SearchRequest();
        model.addAttribute("searchObject", sr);
        return "searchOrder";
        
    }

    @PostMapping("/search")
    public String processSearch(@ModelAttribute("searchObject") SearchRequest searchObj, Model model, BindingResult result) {
        List<Order> orders = arts.findOrderbyId(searchObj.getOrderId());
        model.addAttribute("orders", orders);

        return "orderlist";
    }




    
}
