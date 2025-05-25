package smartHome.modes;

import smartHome.EventDispatcher;
import smartHome.SystemState;
import smartHome.devices.Alarm;
import smartHome.devices.Device;
import smartHome.devices.Light;
import smartHome.devices.Thermostat;

public class EnergySavingMode implements ModeStrategy {
    @Override
    public void execute(SystemState state, EventDispatcher dispatcher) {
        System.out.println("EnergySavingMode: Activating energy-saving settings.");
        for (Device device : dispatcher.getRegisteredDevices()) {
            if (device instanceof Alarm) {
                ((Alarm) device).disarm();
            }
            if (device instanceof Thermostat) {
                ((Thermostat) device).setEcoMode();
            }
            if (device instanceof Light) {
                ((Light) device).disableVacationMode();
            }
        }
    }
}

