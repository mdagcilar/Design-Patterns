import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class ApiGatewayTest {

    @InjectMocks
    private ApiGateway apiGateway;

    @Mock
    private PriceClient priceClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductDesktop() {
        String price = "20";

        when(priceClient.getPrice()).thenReturn(price);

        DesktopProduct productDesktop = apiGateway.getProductDesktop();

        Assertions.assertEquals(price, productDesktop.getPrice());
    }

}