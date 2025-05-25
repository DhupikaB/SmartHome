package smartHome.utilities;

import smartHome.modes.*;

public class ModeFactory {
    public static ModeStrategy createMode(String type) {
        if ("vacation".equalsIgnoreCase(type)) {
            return new VacationMode();
        } else if ("energy".equalsIgnoreCase(type)) {
            return new EnergySavingMode();
        } else if ("security".equalsIgnoreCase(type)) {
            return new SecurityMode();
        } else {
            return new DefaultMode();
        }
    }
}

