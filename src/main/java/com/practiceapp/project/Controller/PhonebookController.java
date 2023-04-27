package com.practiceapp.project.Controller;

import java.util.List;

import com.practiceapp.project.Entity.Phonebook;
import com.practiceapp.project.Service.PhoneBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class PhonebookController {

	@Autowired
	private PhoneBookService service;
	
	@PostMapping("/create")
	public Phonebook createContact(@RequestBody Phonebook book) {
		return service.createContact(book);	
	}
	@PostMapping("/createall")
	public List<Phonebook> createMultipleContacts(@RequestBody List<Phonebook> books){
		return service.createAllContact(books);
	}
	
	@GetMapping("/getbyid/{id}")
	public Phonebook getOneContact(@PathVariable int id) {
		return service.getContactById(id);
	}
	@GetMapping("/getall")
	public List<Phonebook> getMultipleContact() {
		return service.getAllContact();
	}
	@DeleteMapping("/deletebyid/{id}")
	public String deleteOne(@PathVariable int id) {
		service.deleteContactById(id);
		return "Single contact deleted";
	}
	@DeleteMapping("/deleteall")
	public String deleteAllContacts() {
		service.deleteAllContact();
		return "All  contacts deleted";
	}
	
	@PutMapping("/update")
	public Phonebook updateContact(Phonebook book1) {
		return service.updateContact(book1);
	}
	
	
}
