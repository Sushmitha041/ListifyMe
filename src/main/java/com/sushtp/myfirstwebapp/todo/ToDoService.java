package com.sushtp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int countTodos= 0;
	static {
		todos.add(new Todo(++countTodos, "sushtp", "Learn Spring Boot 1",LocalDate.now().plusYears(1) , false));
		todos.add(new Todo(++countTodos, "sushtp", "Learn React",LocalDate.now().plusMonths(2) , false));
		todos.add(new Todo(++countTodos, "sushtps", "Learn AWS",LocalDate.now().plusYears(2) , false));
	}
	public List<Todo> findByUsername(String name)
	{
		Predicate<? super Todo> predicate = todo->todo.getUsername().equalsIgnoreCase(name);
		List<Todo> list = todos.stream().filter(predicate).toList();
		return list;
	}
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		 Todo todo = new Todo(++countTodos,username,description,targetDate,done);
		 todos.add(todo);
	}
	public void deleteTodo (int id) {
		Predicate<? super Todo> predicate = todo->todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo->todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
