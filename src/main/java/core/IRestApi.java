package core;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IRestApi<Request, Response> {

    String baseUrl = "https://www.1secmail.com/api/v1/";

    Response execute(Request request) throws RuntimeException, IOException, InterruptedException, URISyntaxException;

    boolean validate(Request request);

    String urlBuilder(Request request);
}
