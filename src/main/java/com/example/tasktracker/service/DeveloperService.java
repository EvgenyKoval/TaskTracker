package com.example.tasktracker.service;

import com.example.tasktracker.entities.Developer;
import com.example.tasktracker.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DeveloperService {

	@Autowired
	private DeveloperRepository repo;

	public Developer save(Developer developer) {
		return repo.save(developer);
	}

	public Iterable<Developer> save(Iterable<Developer> iterable) {
		return repo.save(iterable);
	}

	@Transactional
	public Developer findOne(Long aLong, boolean permanently) {
		Developer dev = repo.findOne(aLong);
		if (permanently) {
			dev.getTasks().size();
		}
		return dev;
	}

	public boolean exists(Long aLong) {
		return repo.exists(aLong);
	}

	public Iterable<Developer> findAll() {
		return repo.findAll();
	}

	public Iterable<Developer> findAll(Iterable<Long> iterable) {
		return repo.findAll(iterable);
	}

	public long count() {
		return repo.count();
	}

	public void delete(Long aLong) {
		repo.delete(aLong);
	}

	public void delete(Developer developer) {
		repo.delete(developer);
	}

	public void delete(Iterable<Developer> iterable) {
		repo.delete(iterable);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
}
