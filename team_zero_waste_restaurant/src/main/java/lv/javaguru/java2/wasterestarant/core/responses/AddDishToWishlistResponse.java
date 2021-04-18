package lv.javaguru.java2.wasterestarant.core.responses;

//Nataliya

import lv.javaguru.java2.wasterestarant.domain.OrderItem;

public class AddDishToWishlistResponse extends CoreResponse {

    private OrderItem newSelectedItem;

    public AddDishToWishlistResponse(OrderItem newSelectedItem) {
        this.newSelectedItem = newSelectedItem;
    }

    public OrderItem getNewSelectedItem() {
        return newSelectedItem;
    }

}
