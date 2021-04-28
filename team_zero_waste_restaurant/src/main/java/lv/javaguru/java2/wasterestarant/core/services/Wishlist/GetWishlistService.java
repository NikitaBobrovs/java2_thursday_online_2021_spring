package lv.javaguru.java2.wasterestarant.core.services.Wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.Wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya - in process

public class GetWishlistService {

    private Database database;
    private Long clientID;

    public GetWishlistService(Database database) {
        this.database = database;
    }

    public GetWishlistResponse execute(GetWishlistRequest request){
        List<OrderItem> selectedItems = database.getWishlist(clientID);
        return new GetWishlistResponse(selectedItems);

    }

}