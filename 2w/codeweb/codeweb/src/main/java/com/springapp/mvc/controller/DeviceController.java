package com.springapp.mvc.controller;


import com.springapp.mvc.entity.Device;
import com.springapp.mvc.service.DeviceService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class DeviceController
{
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/device", method = RequestMethod.GET)
    public String listUsers(ModelMap model)
    {
        model.addAttribute("device", new Device());
        model.addAttribute("devices", deviceService.listDevices());
        return "devices";
    }

//    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
//    public
//    @ResponseBody
//    String listDevicesJson(ModelMap model) throws JSONException
//    {
//        return deviceService.jsonList();
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("device") Device device, BindingResult result)
    {
        deviceService.save(device);
        return "redirect:/device";
    }
    @RequestMapping(value="/download_profile", method = RequestMethod.GET)
    String getProfile(){
        return "redirect:/device";
    }
    @RequestMapping(value="/download_certificate", method = RequestMethod.GET)
    String getCert(){
        return "redirect:/device";
    }
    @RequestMapping("/delete/{deviceId}")
    public String delete(@PathVariable("deviceId") Long deviceId)
    {
        deviceService.delete(deviceId);
        return "redirect:/device";
    }
}