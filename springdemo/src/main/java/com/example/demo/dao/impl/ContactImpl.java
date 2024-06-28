package com.example.demo.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.ContactDAO;
import com.example.demo.model.Contact;
import com.example.demo.mapper.ContactRowMapper;

@Repository
public class ContactImpl implements ContactDAO {
  
    private JdbcTemplate jdbcTemplate;
	@Autowired
    public ContactImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public List<Contact> findAll() {
        return jdbcTemplate.query("SELECT id, name, phone_number FROM contact WHERE is_deleted = FALSE", new ContactRowMapper());
    }

    
    @Override
    public Contact findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, phone_number FROM contact WHERE id = ? AND is_deleted = FALSE", new ContactRowMapper(), id);
    }

    @Override
    public int save(Contact contact) {
        return jdbcTemplate.update("INSERT INTO contact (name, phone_number) VALUES (?, ?)", contact.getName(), contact.getPhoneNumber());
    }

    @Override
    public int update(Contact contact) {
        return jdbcTemplate.update("UPDATE contact SET name = ?, phone_number = ? WHERE id = ? AND is_deleted = FALSE", contact.getName(), contact.getPhoneNumber(), contact.getId());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("UPDATE contact SET is_deleted = TRUE WHERE id = ?", id);
    }

    @Override
    public List<Contact> searchByNameOrPhoneNumber(String searchTerm) {
        String sql = "SELECT id, name, phone_number FROM contact WHERE (name LIKE ? OR phone_number LIKE ?) AND is_deleted = FALSE";
        String pattern = "%" + searchTerm + "%"; 
        return jdbcTemplate.query(sql, new ContactRowMapper(), pattern, pattern);
    }
}
