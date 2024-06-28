package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;
@Repository
public interface ContactDAO {
    List<Contact> findAll();
    Contact findById(int id);
    int save(Contact contact);
    int update(Contact contact);
    int deleteById(int id);
    List<Contact> searchByNameOrPhoneNumber(String searchTerm);
}
