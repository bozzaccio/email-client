package controller;

import controller.api.CreateMailbox;
import core.om.ActionEnum;
import core.om.request.CreateMailboxRequest;
import core.om.response.CreateMailboxResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Set;

public class EmailController {

    CreateMailbox createMailbox = new CreateMailbox();

    public Set<String> getNewMailbox() throws IOException, InterruptedException, URISyntaxException {

        Set<String> result = null;

        CreateMailboxRequest request = new CreateMailboxRequest();
        request.setAction(ActionEnum.GEN_RANDOM_MAILBOX);
        request.setCount(1);

        CreateMailboxResponse response = createMailbox.execute(request);

        if(Objects.nonNull(response) && Objects.nonNull(response.getEmailAddressSet())){
            result = response.getEmailAddressSet();
        }

        return result;
    }
}
