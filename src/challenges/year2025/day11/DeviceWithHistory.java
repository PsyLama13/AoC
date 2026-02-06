package challenges.year2025.day11;

import java.util.List;

public record DeviceWithHistory(Device device, List<String> history) {
    public boolean containsDevice(Device device) {
        return containsDeviceString(device.name());
    }

    public boolean containsDeviceString(String deviceName) {
        return history.contains(deviceName);
    }
}
