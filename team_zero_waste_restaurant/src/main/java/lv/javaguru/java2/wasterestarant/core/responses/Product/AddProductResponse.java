package lv.javaguru.java2.wasterestarant.core.responses.Product;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;
import java.util.List;

public class AddProductResponse extends CoreResponse {

    private Product newProduct;

    public AddProductResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddProductResponse(Product newProduct) {
        this.newProduct = newProduct;
    }

    public Product getNewProduct() {
        return newProduct;
    }
}