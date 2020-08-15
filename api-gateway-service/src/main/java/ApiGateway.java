import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ApiGateway {

    @Resource
    private PriceClient priceClient;

    @GetMapping(path = "/desktop")
    public DesktopProduct getProductDesktop() {
        DesktopProduct desktopProduct = new DesktopProduct();
        String price = priceClient.getPrice();
        desktopProduct.setPrice(price);
        return desktopProduct;
    }

}
