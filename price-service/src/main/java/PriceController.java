import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);
    private static final String DEFAULT_PRICE = "20";

    @GetMapping(value = "/price")
    public String getPrice() {
        LOGGER.info("Succesfully found price info");
        return DEFAULT_PRICE;
    }
}
