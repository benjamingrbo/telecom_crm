package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Device;
import com.telecom.telecomplus.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId);
    }

    public Device updateDevice(Long deviceId, Device updatedDevice) {
        return deviceRepository.findById(deviceId)
                .map(device -> {

                    if (updatedDevice.getMake() != null) {
                        device.setMake(updatedDevice.getMake());
                    }
                    if (updatedDevice.getModel() != null) {
                        device.setModel(updatedDevice.getModel());
                    }
                    if (updatedDevice.getCost() != null) {
                        device.setCost(updatedDevice.getCost());
                    }

                    return deviceRepository.save(device);
                })
                .orElse(null);
    }

    public Device createDevice(Device newDevice) {
        return deviceRepository.save(newDevice);
    }


    public String deleteDeviceById(Long deviceId) {
        deviceRepository.deleteById(deviceId);
        return "Device with id: " + deviceId + " has been deleted.";
    }
}
