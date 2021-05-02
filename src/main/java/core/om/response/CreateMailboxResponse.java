package core.om.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CreateMailboxResponse implements Serializable {

    private static final long serialVersionUID = 2045881290406043243L;

    private Set<String> emailAddressSet;

    public CreateMailboxResponse(){
        this.emailAddressSet = new HashSet<>();
    }

    public Set<String> getEmailAddressSet() {
        return emailAddressSet;
    }

    public void setEmailAddressSet(Set<String> emailAddressSet) {
        this.emailAddressSet = emailAddressSet;
    }
}
