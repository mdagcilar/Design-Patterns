import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PriceClientImpl implements PriceClient {

    private static final Logger LOGGER = getLogger(PriceClientImpl.class);

    public String getPrice() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:50006/price"))
                .build();

        LOGGER.info("Sending request for price info");
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            logResponse(response);
            return response.body();
        } catch (IOException | InterruptedException e) {
            LOGGER.error("Failed getting price info", e);
        }
        return null;
    }

    private void logResponse(HttpResponse<String> response) {
        if (isSuccessfulResponse(response.statusCode())) {
            LOGGER.info("Price info received succesfully");
        } else {
            LOGGER.warn("Price info request failed");
        }
    }

    private boolean isSuccessfulResponse(int statusCode) {
        return statusCode >= 200 && statusCode <=299;
    }
}
