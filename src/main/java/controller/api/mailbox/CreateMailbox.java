package controller.api.mailbox;

import core.AppConfig;
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
import java.util.List;
import java.util.Objects;

public class CreateMailbox implements IRestApi<CreateMailboxRequest, CreateMailboxResponse> {

    @Override
    public CreateMailboxResponse execute(CreateMailboxRequest request) throws RuntimeException, IOException, InterruptedException, URISyntaxException {

        if (!validate(request)) {
            throw new BadRequestException();
        } else {
            String url = urlBuilder(request);
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                    .header("Accept", "application.yaml/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            CreateMailboxResponse response = new CreateMailboxResponse();

            List<String> addressBookList =  HttpClient.newHttpClient()
                    .send(httpRequest, new JsonBodyHandler<>(List.class))
                    .body();

            addressBookList.forEach(addressBook -> {
                response.getEmailAddressSet().add(addressBook);
            });

            return response;
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
        String url = AppConfig.apiConfig.getApiUrl() + "?";

        if (Objects.nonNull(createMailboxRequest.getAction())) {
            url = url + "action=" + createMailboxRequest.getAction().toString();

            if (createMailboxRequest.getCount() > 0) {
                url = url + "&count=" + createMailboxRequest.getCount();
            }
        }

        return url;
    }
}
