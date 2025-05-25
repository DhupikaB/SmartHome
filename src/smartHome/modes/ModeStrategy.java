package smartHome.modes;

import smartHome.EventDispatcher;
import smartHome.SystemState;

public interface ModeStrategy {
    void execute(SystemState state, EventDispatcher dispatcher);
}
