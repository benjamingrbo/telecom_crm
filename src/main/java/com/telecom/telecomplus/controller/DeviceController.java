package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Device;
import com.telecom.telecomplus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/device/getAllDevices")
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    @GetMapping("/device/getDeviceById/{id}")
    public Optional<Device> getDeviceById(@PathVariable Long id){
        return deviceService.getDeviceById(id);
    }

    @PutMapping("/device/updateDevice/{id}")
    public Device updateDevice(@RequestBody Device updatedDevice, @PathVariable  Long id){
        return deviceService.updateDevice(id, updatedDevice);
    }

    @PostMapping("/device/createDevice")
    public Device createDevice(@RequestBody Device newDevice){
        return deviceService.createDevice(newDevice);
    }

    @DeleteMapping("/device/deleteDevice/{id}")
    public String deleteDevice(@PathVariable Long id){
        return deviceService.deleteDeviceById(id);
    }
}
