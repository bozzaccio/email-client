package controller.api.mail;

import core.IRestApi;
import core.exception.BadRequestException;
import core.om.request.GetAttachmentRequest;
import core.om.response.GetAttachmentResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class GetMailAttachment implements IRestApi<GetAttachmentRequest, GetAttachmentResponse> {

    @Override
    public GetAttachmentResponse execute(GetAttachmentRequest request) throws RuntimeException, IOException {

        if (!validate(request)) {
            throw new BadRequestException();
        } else {
            String url = urlBuilder(request);
            GetAttachmentResponse response = new GetAttachmentResponse();

            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("Accept-Charset", java.nio.charset.StandardCharsets.UTF_8.name());

            try (InputStream stream = connection.getInputStream()) {
                response.setFile(stream);
            }

            return response;
        }
    }

    @Override
    public boolean validate(GetAttachmentRequest request) {
        boolean isValid;

        isValid = Objects.nonNull(request.getAction())
                && Objects.nonNull(request.getUsername())
                && Objects.nonNull(request.getDomain())
                && Objects.nonNull(request.getFileName())
                && request.getMessageId() >= 0;

        return isValid;
    }

    @Override
    public String urlBuilder(GetAttachmentRequest request) {
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

            if (Objects.nonNull(request.getFileName())) {
                url = url + "&file=" + request.getFileName();
            }
        }

        return url;
    }
}
