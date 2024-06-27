package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.impl.ContactImpl;
import com.example.demo.model.Contact;

@Controller
public class ContactController {
	 private ContactImpl contactImpl;
    @Autowired
    public ContactController(ContactImpl contactImpl) {
    	this.contactImpl=contactImpl;
    }

    @GetMapping("/contacts")
    public String getAllContacts(Model model) {
        List<Contact> contacts = contactImpl.findAll();
        model.addAttribute("contacts", contacts);
        return "contactlist.jsp"; 
    }

    @GetMapping("/add-contact")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "addcontact.jsp"; 
    }

    @PostMapping("/save-contact")
    public String saveContact(@ModelAttribute Contact contact) {
        contactImpl.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit-contact")
    public String editContactForm(@RequestParam int id, Model model) {
        Contact contact = contactImpl.findById(id);
        model.addAttribute("contact", contact);
        return "editcontact.jsp"; 
    }

    @PostMapping("/update-contact")
    public String updateContact(@ModelAttribute Contact contact) {
        contactImpl.update(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete-contact")
    public String deleteContact(@RequestParam int id) {
        contactImpl.deleteById(id);
        return "redirect:/contacts";
    }
    @GetMapping("/search")
    public String searchContacts(@RequestParam String name, Model model) {
        List<Contact> contacts = contactImpl.searchByName(name);
        model.addAttribute("contacts", contacts);
        model.addAttribute("isSearch", true);
        return "contactlist.jsp"; 
    }
}