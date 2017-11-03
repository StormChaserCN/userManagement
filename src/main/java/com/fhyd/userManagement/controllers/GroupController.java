package com.fhyd.userManagement.controllers;

import com.fhyd.userManagement.models.Group;
import com.fhyd.userManagement.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/")
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        model.addAttribute("group", new Group());
        return "groups";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute Group group) {
        groupService.addGroup(group);
        return "redirect:/groups/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGroup(@ModelAttribute Group group) {
        groupService.updateGroup(group);
        return "redirect:/groups/";
    }

    @RequestMapping("/edit/{id}")
    public String editGroup(@PathVariable Long id, Model model) {
        model.addAttribute("group", groupService.getGroupById(id));
        model.addAttribute("uid", 0);
        return "edit_group";
    }

    @RequestMapping("/delete/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return "redirect:/groups/";
    }

    @RequestMapping("/deleteUser/{gid}/{uid}")
    public String deleteGroupUser(@PathVariable Long gid, @PathVariable Long uid) {
        groupService.delGroupUser(gid, uid);
        return "redirect:/edit/" + gid;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addGroupUser(@RequestParam("gid") Long gid, @RequestParam("uid") Long uid) {
        groupService.addGroupUser(gid, uid);
        return "redirect:/groups/edit/" + gid;
    }

}
