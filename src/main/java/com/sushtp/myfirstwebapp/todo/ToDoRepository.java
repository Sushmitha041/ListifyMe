package com.sushtp.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);
}
