package core.om;

import java.awt.*;

public enum StatusEnum {
    OK("OK", Color.GREEN),
    KO("KO", Color.RED);

    private final String status;
    private final Color color;

    StatusEnum(String status, Color color) {
        this.status = status;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.status;
    }

    public static Color getColorByStatus(String statusCode) {
        for (StatusEnum s : values()) {
            if (s.status.equals(statusCode)) {
                return s.color;
            }
        }
        return null;
    }
}
