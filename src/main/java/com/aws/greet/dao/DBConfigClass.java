package com.aws.greet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class DBConfigClass {
	
	//final static AppLogger logger = new AppLogger(DbConfiguration.class.getName());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate;

}
