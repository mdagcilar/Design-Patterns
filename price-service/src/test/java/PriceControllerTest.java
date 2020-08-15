import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceControllerTest {

    @Test
    public void getPrice() {
        PriceController priceController = new PriceController();
        String price = priceController.getPrice();
        Assertions.assertEquals(price, "20");
    }

}