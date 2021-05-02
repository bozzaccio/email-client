package controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.IRestApi;
import core.exception.BadRequestException;
import core.om.BaseMailMessage;
import core.om.request.GetAllMailRequest;
import core.om.response.GetAllMailResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GetAllMail implements IRestApi<GetAllMailRequest, GetAllMailResponse> {

    @Override
    public GetAllMailResponse execute(GetAllMailRequest request) throws RuntimeException, IOException, InterruptedException, URISyntaxException {

        if (!validate(request)) {
            throw new BadRequestException();
        } else {
            String url = urlBuilder(request);
            ObjectMapper mapper = new ObjectMapper();
            GetAllMailResponse response = new GetAllMailResponse();

            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                    .header("Accept", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            String json = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString())
                    .body();

            try {

                List<BaseMailMessage> mailMessageList = Arrays.asList(mapper.readValue(json, BaseMailMessage[].class));
                response.setMailMessageList(mailMessageList);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }
    }

    @Override
    public boolean validate(GetAllMailRequest request) {
        boolean isValid;

        isValid = Objects.nonNull(request.getAction())
                && Objects.nonNull(request.getUsername())
                && Objects.nonNull(request.getDomain());

        return isValid;
    }

    @Override
    public String urlBuilder(GetAllMailRequest request) {
        String url = IRestApi.baseUrl + "?";

        if (Objects.nonNull(request.getAction())) {
            url = url + "action=" + request.getAction().toString();

            if (Objects.nonNull(request.getUsername())) {
                url = url + "&login=" + request.getUsername();
            }

            if (Objects.nonNull(request.getDomain())) {
                url = url + "&domain=" + request.getDomain();
            }
        }

        return url;
    }
}
