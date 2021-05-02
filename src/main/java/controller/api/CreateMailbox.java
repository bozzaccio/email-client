package controller.api;

import core.IRestApi;
import core.exception.BadRequestException;
import core.om.request.CreateMailboxRequest;
import core.om.response.CreateMailboxResponse;
import core.utils.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Objects;

public class CreateMailbox implements IRestApi<CreateMailboxRequest, CreateMailboxResponse> {

    @Override
    public CreateMailboxResponse execute(CreateMailboxRequest request) throws RuntimeException, IOException, InterruptedException, URISyntaxException {

        if (!validate(request)) {
            throw new BadRequestException();
        } else {
            String url = urlBuilder(request);
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                    .header("Accept", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            return HttpClient.newHttpClient()
                    .send(httpRequest, new JsonBodyHandler<>(CreateMailboxResponse.class))
                    .body();
        }
    }

    @Override
    public boolean validate(CreateMailboxRequest request) {

        boolean isValid;

        isValid = !Objects.isNull(request.getAction()) && request.getCount() > 0;

        return isValid;
    }

    @Override
    public String urlBuilder(CreateMailboxRequest createMailboxRequest) {
        String url = IRestApi.baseUrl + "?";

        if (Objects.nonNull(createMailboxRequest.getAction())) {
            url = url + "action=" + createMailboxRequest.getAction().toString();

            if (createMailboxRequest.getCount() > 0) {
                url = url + "&count=" + createMailboxRequest.getCount();
            }
        }

        return url;
    }
}
