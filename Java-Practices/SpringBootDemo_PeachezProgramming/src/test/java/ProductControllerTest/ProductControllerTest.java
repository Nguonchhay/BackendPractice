package ProductControllerTest;

import com.nguonchhay.demo.Exceptions.ProductNotValidateException;
import com.nguonchhay.demo.SpringBootDemoApplication;
import com.nguonchhay.demo.products.CommandHandlers.CreateProductCommandHandler;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ProductControllerTest {

    @InjectMocks
    private CreateProductCommandHandler createProductCommandHandler;

    @Mock
    private ProductRepository productRepository;

    // MethodName_StateUnderTest_ExpectedBehavior
    @Test
    public void createProductCommandHandler_validProduct_returnSuccess() {
        Product product = new Product();
        product.setId(1);
        product.setCategoryId(1);
        product.setName("Test product");
        product.setPrice(2.0);
        product.setQuantity(10);
        ResponseEntity responseEntity = createProductCommandHandler.execute(product);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void setCreateProductCommandHandler_invalidPrice_throwInvalidPriceException() {
        Product product = new Product();
        product.setId(1);
        product.setCategoryId(1);
        product.setName("Test product");
        product.setPrice(-2.0);
        product.setQuantity(10);

        ProductNotValidateException exception = assertThrows(ProductNotValidateException.class, () -> createProductCommandHandler.execute(product));
        assertEquals("Price is required", exception.getSimpleResponse().getMessage());
    }
}
