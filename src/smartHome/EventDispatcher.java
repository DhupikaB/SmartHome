package smartHome;

import smartHome.devices.Device;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {
    private List<Device> devices = new ArrayList<>();

    public List<Device> getRegisteredDevices() {
        return devices;
    }


    public void registerDevice(Device device){
        devices.add(device);
    }

    public void notifyDevice(String event){
        System.out.println("Notifying devices the event: "+event);
        for(Device device : devices){
            device.update(event);
        }
    }


}
