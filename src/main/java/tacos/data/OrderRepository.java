package tacos.data;

import tacos.domain.Ingredient;
import tacos.domain.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);

}
