package com.github.sba.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * Configure JSON Mapper not to access entities that were not loaded by
 * Hibernate and avoid Lazy initialization.
 * 
 */
@Configuration
public class JSONConfiguration {

	@Bean
	public Module hibernate5Module() {
		Hibernate5Module module = new Hibernate5Module();
		return module;
	}
}
