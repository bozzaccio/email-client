package core.om.response;

import java.util.Set;

public class CreateMailboxResponse {

    Set<String> emailAddressSet;

    public Set<String> getEmailAddressSet() {
        return emailAddressSet;
    }

    public void setEmailAddressSet(Set<String> emailAddressSet) {
        this.emailAddressSet = emailAddressSet;
    }
}
