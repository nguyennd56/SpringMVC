package com.springapp.mvc.service;

import com.springapp.mvc.dao.DeviceRepository;
import com.springapp.mvc.entity.Device;
import com.springapp.mvc.model.DeviceModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyennd on 7/17/2014.
 */
@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public List<DeviceModel> listDevices()
    {
        List<Device> deviceList = deviceRepository.findAll();

        List<DeviceModel> deviceModelList = new ArrayList<DeviceModel>();

        for(Device device : deviceList)
        {
            DeviceModel deviceModel = new DeviceModel();
            deviceModel.setId(device.getId());
            deviceModel.setName(device.getName());

            deviceModelList.add(deviceModel);
        }

        return  deviceModelList;
    }
//    public String jsonList()throws JSONException
//    {
//        JSONArray userArray = new JSONArray();
//
//
//        for (Device device : deviceRepository.findAll())
//        {
//            JSONObject deviceJSON = new JSONObject();
//            deviceJSON.put("id",device.getId());
//            deviceJSON.put("name", device.getName());
//            userArray.put(deviceJSON);
//        }
//        return userArray.toString();
//    }
    public void save(Device device){
        deviceRepository.save(device);
    }

    public void delete(long id){
        deviceRepository.delete(deviceRepository.findOne(id));
    }

}
