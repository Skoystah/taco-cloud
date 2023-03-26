package tacos.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.data.OrderRepository;
import tacos.domain.TacoOrder;


@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("tacoOrder")
public class OrderTacoController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderTacoController (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm (){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder,
                                Errors errors,
                                SessionStatus sessionStatus) {

        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted: {}", tacoOrder);
        orderRepository.save(tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
