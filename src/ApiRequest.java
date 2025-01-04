import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiRequest {
    private static final String API_KEY = "9076839138c9a28024478fc5";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public Currency pairConversion (String baseCode, String targetCode, Float amountToConvert) {
        String address = API_URL + API_KEY + "/pair/" + baseCode + "/" + targetCode + "/" + amountToConvert;

        var formattedAddress = getValidURL(address);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(formattedAddress))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't do the operation.");
        }
    }

    static String getValidURL(String invalidURLString) {
        try {
            // Convert the String and decode the URL into the URL class
            URL url = new URL(URLDecoder.decode(invalidURLString, StandardCharsets.UTF_8.toString()));

            // Use the methods of the URL class to achieve a generic solution
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            // return String or
            // uri.toURL() to return URL object
            return uri.toString();
        } catch (URISyntaxException | UnsupportedEncodingException | MalformedURLException ignored) {
            return null;
        }
    }
}
