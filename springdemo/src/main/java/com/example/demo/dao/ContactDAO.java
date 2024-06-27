package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Contact;

public interface ContactDAO {
    List<Contact> findAll();
    Contact findById(int id);
    int save(Contact contact);
    int update(Contact contact);
    int deleteById(int id);
    List<Contact> searchByName(String name);
}
