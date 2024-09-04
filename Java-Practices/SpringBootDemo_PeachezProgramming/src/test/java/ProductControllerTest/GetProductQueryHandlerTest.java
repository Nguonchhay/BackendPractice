package ProductControllerTest;

import com.nguonchhay.demo.Exceptions.ProductNotFoundException;
import com.nguonchhay.demo.SpringBootDemoApplication;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductDTO;
import com.nguonchhay.demo.products.ProductRepository;
import com.nguonchhay.demo.products.QueryHandlers.GetProductQueryHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringBootDemoApplication.class)
public class GetProductQueryHandlerTest {

    @InjectMocks
    private GetProductQueryHandler getProductQueryHandler;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProductQueryHandler_validId_returnProductDTO() {
        Product product = new Product();
        product.setId(1);
        product.setCategoryId(1);
        product.setName("Test product");
        product.setPrice(2.0);
        product.setQuantity(10);

        ProductDTO productDTO = new ProductDTO(product);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        ResponseEntity<ProductDTO> responseEntity = getProductQueryHandler.execute(product.getId());
        assertEquals(productDTO, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getProductQueryHandler_invalidId_throwProductNotFoundException() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> getProductQueryHandler.execute(1));
        assertEquals("Product not found", exception.getSimpleResponse().getMessage());
    }
}
