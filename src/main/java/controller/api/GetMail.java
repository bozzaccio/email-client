package controller.api;

import core.IRestApi;
import core.exception.BadRequestException;
import core.om.request.GetMailRequest;
import core.om.response.GetMailResponse;
import core.utils.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Objects;

public class GetMail implements IRestApi<GetMailRequest, GetMailResponse> {

    @Override
    public GetMailResponse execute(GetMailRequest request) throws RuntimeException, IOException, InterruptedException, URISyntaxException {

        if (!validate(request)) {
            throw new BadRequestException();
        } else {
            String url = urlBuilder(request);

            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                    .header("Accept", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            return HttpClient.newHttpClient()
                    .send(httpRequest, new JsonBodyHandler<>(GetMailResponse.class))
                    .body();
        }
    }

    @Override
    public boolean validate(GetMailRequest request) {
        boolean isValid;

        isValid = Objects.nonNull(request.getAction())
                && Objects.nonNull(request.getUsername())
                && request.getMessageId() >= 0
                && Objects.nonNull(request.getDomain());

        return isValid;
    }

    @Override
    public String urlBuilder(GetMailRequest request) {
        String url = IRestApi.baseUrl + "?";

        if (Objects.nonNull(request.getAction())) {
            url = url + "action=" + request.getAction().toString();

            if (Objects.nonNull(request.getUsername())) {
                url = url + "&login=" + request.getUsername();
            }

            if (Objects.nonNull(request.getDomain())) {
                url = url + "&domain=" + request.getDomain();
            }

            if (request.getMessageId() >= 0) {
                url = url + "&id=" + request.getMessageId();
            }
        }

        return url;
    }
}
