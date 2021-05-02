package core.om.response;

import java.io.InputStream;
import java.io.Serializable;

public class GetAttachmentResponse implements Serializable {

    private static final long serialVersionUID = 2502879915965858333L;

    private InputStream file;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }
}
