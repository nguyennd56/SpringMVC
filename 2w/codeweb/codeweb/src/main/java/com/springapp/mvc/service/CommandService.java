package com.springapp.mvc.service;

import com.springapp.mvc.dao.CommandRepository;
import com.springapp.mvc.entity.Command;
import com.springapp.mvc.model.CommandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyennd on 7/21/2014.
 */
@Service
public class CommandService {
    @Autowired
    CommandRepository commandRepository;
    public List<CommandModel> listAll(){
        List<Command> lc = commandRepository.findAll();
        List<CommandModel> commandModels = new ArrayList<CommandModel>();
        for(Command command:lc){
            CommandModel commandModel = new CommandModel();
            commandModel.setName(command.getName());
            commandModel.setId(command.getId());
            commandModels.add(commandModel);
        }
        return commandModels;
    }
    public void add(Command command){
        commandRepository.save(command);
    }
    public void del(Long id){
        commandRepository.delete(commandRepository.findOne(id));
    }
}
