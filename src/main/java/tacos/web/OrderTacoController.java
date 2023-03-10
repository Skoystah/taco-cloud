package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.domain.TacoOrder;


@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("tacoOrder")
public class OrderTacoController {

    @GetMapping("/current")
    public String orderForm (){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(TacoOrder tacoOrder,
                                SessionStatus sessionStatus) {
        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
