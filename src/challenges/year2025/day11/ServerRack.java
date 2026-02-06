package challenges.year2025.day11;

import java.util.*;

public class ServerRack {
    Set<Device> devices = new HashSet<>();
    Device start;

    public ServerRack(List<String> input, String startString) {
        for (String s : input) {
            String[] split = s.split(": ");
            String name = split[0];
            List<String> connections = List.of(split[1].split(" "));
            Device device = new Device(name, connections);
            devices.add(device);
            if (device.name().equals(startString)) {
                start = device;
            }
        }
    }

    public long solve() {

        Queue<DeviceWithHistory> queue = new ArrayDeque<>();
        queue.add(new DeviceWithHistory(start, new ArrayList<>()));
        int counter = 0;
        while (!queue.isEmpty()) {
            DeviceWithHistory currentWithHistory = queue.poll();
            Device current = currentWithHistory.device();

            if (current.connections().contains("out")) {
                counter++;
                continue;
            }

            for (String connection : current.connections()) {
                Device next = devices.stream().filter(d -> d.name().equals(connection)).findFirst().orElse(null);
                if (next == null) {
                    {
                        continue;
                    }
                }

                if (!currentWithHistory.containsDevice(next)) {
                    List<String> history = new ArrayList<>(currentWithHistory.history());
                    history.add(current.name());
                    queue.add(new DeviceWithHistory(next, history));
                }
            }
        }
        return counter;
    }

    public long solve2() {
        Queue<DeviceWithHistory> queue = new ArrayDeque<>();
        queue.add(new DeviceWithHistory(start, new ArrayList<>()));
        int counter = 0;
        while (!queue.isEmpty()) {
            DeviceWithHistory currentWithHistory = queue.poll();
            Device current = currentWithHistory.device();

            if (current.connections().contains("out")) {
                if (currentWithHistory.containsDeviceString("fft") && currentWithHistory.containsDeviceString("dac")) {
                    counter++;
                }
                continue;
            }

            for (String connection : current.connections()) {
                Device next = devices.stream().filter(d -> d.name().equals(connection)).findFirst().orElse(null);
                if (next == null) {
                    {
                        continue;
                    }
                }

                if (!currentWithHistory.containsDevice(next)) {
                    List<String> history = new ArrayList<>(currentWithHistory.history());
                    history.add(current.name());
                    queue.add(new DeviceWithHistory(next, history));
                }
            }
        }
        return counter;
    }
}