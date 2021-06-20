package core;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IBaseApi<Request, Response> {

    Response execute(Request request) throws RuntimeException, IOException, InterruptedException, URISyntaxException;
}
