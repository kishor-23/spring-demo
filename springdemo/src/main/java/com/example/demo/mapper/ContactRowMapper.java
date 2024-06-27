package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Contact;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        
        contact.setId(rs.getInt("id"));
        contact.setName(rs.getString("name"));
        contact.setPhoneNumber(rs.getString("phone_number"));
        return contact;
    }
}