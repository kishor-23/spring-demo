package com.example.demo.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ContactDAO;
import com.example.demo.model.Contact;
import com.example.demo.mapper.*;


@Repository
public class ContactImpl  implements ContactDAO{
	 @Autowired
	  private JdbcTemplate jdbcTemplate;
	 
	    @Override
	    public List<Contact> findAll() {
	        return jdbcTemplate.query("SELECT id,name,phone_number FROM contact", new ContactRowMapper());
	    }

	
		@SuppressWarnings("deprecation")
		@Override
	    public Contact findById(int id) {
	        return jdbcTemplate.queryForObject("SELECT id,name,phone_number FROM contact WHERE id = ?", new Object[]{id}, new ContactRowMapper());
	    }

	    @Override
	    public int save(Contact contact) {
	        return jdbcTemplate.update("INSERT INTO contact (name, phone_number) VALUES (?, ?)", new Object[]{contact.getName(), contact.getPhoneNumber()}   );
	    }

	    @Override
	    public int update(Contact contact) {
	        return jdbcTemplate.update("UPDATE contact SET name = ?, phone_number = ? WHERE id = ?",
	                contact.getName(), contact.getPhoneNumber(), contact.getId());
	    }

	    @Override
	    public int deleteById(int id) {
	        return jdbcTemplate.update("DELETE FROM contact WHERE id = ?", id);
	    }
	    // Method to search contacts by name
	    public List<Contact> searchByName(String name) {
	        String sql = "SELECT id, name, phone_number FROM contact WHERE name LIKE ?";
	        String namePattern = "%" + name + "%"; // This will allow partial matching
	        return jdbcTemplate.query(sql, new Object[]{namePattern}, new ContactRowMapper());
	    }
}
