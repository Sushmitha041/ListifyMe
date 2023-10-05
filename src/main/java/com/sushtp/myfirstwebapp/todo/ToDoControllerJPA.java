package com.sushtp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoControllerJPA {
	private ToDoRepository todoRepository;
	
	public ToDoControllerJPA(ToDoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String getAllTodos(ModelMap model){
		String username = getLoggedInUserName(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodos";
	}

	private String getLoggedInUserName(ModelMap model) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String showTodoPage(ModelMap model){
		String username = getLoggedInUserName(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusMonths(6),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result){
		if(result.hasErrors())
		{
			return "todo";
		}
		String username = getLoggedInUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result){
		if(result.hasErrors())
		{
			return "todo";
		}
		String username = getLoggedInUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
}
