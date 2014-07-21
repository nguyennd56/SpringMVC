package com.springapp.mvc.controller;

import com.springapp.mvc.dao.CommandRepository;
import com.springapp.mvc.entity.Command;
import com.springapp.mvc.model.CommandModel;
import com.springapp.mvc.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nguyennd on 7/21/2014.
 */
@Controller
public class CommandController {
    @Autowired
    CommandService commandService;
    @RequestMapping(value = "/command", method = RequestMethod.GET)
    public String list(ModelMap model){
        model.addAttribute("command", new Command());
        model.addAttribute("commands", commandService.listAll());
        return "commands";
    }
    @RequestMapping(value = "/addcom", method = RequestMethod.POST)
    public String add(@ModelAttribute("command")Command command, BindingResult result){
        commandService.add(command);
        return "redirect:/command";
    }
    @RequestMapping(value = "/delcom/{id}")
    public String del(@PathVariable("id")Long id){
        commandService.del(id);
        return "redirect:/command";
    }
}
