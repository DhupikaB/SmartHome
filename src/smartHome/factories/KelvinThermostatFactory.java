package smartHome.factories;

import smartHome.devices.Thermostat;

public class KelvinThermostatFactory implements ThermostatFactory {
    public Thermostat createThermostat() {
        System.out.println("KelvinThermostatFactory: Creating Kelvin Thermostat.");
        return new Thermostat();
    }
}
