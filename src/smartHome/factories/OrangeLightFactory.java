package smartHome.factories;

import smartHome.devices.Light;

public class OrangeLightFactory implements LightFactory {
    public Light createLight() {
        System.out.println("OrangeLightFactory: Creating Orange Light.");
        return new Light();
    }
}
