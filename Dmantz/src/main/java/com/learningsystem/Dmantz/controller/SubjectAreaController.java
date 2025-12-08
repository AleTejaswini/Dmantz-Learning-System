package com.learningsystem.Dmantz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningsystem.Dmantz.model.SubjectArea;
import com.learningsystem.Dmantz.service.SubjectAreaService;

@RestController
@RequestMapping("subjectarea")
public class SubjectAreaController {
	@Autowired
	private SubjectAreaService subjectareaservice;

	@PostMapping("/addsubjectarea")
	public SubjectArea addsubjectarea(@RequestBody SubjectArea subjectarea) {
		return subjectareaservice.addsubjectarea(subjectarea);
	}
	
	
	@GetMapping("/getsubjectarea/{subjectareaID}")
	public SubjectArea getsubjectarea(@PathVariable int subjectareaID) {
		return subjectareaservice.getsubjectarea(subjectareaID);
	}
	
	@GetMapping("/getsubjectareas")
	public List<SubjectArea> getsubjectareas(){
		return subjectareaservice.getsubjectareas();
	}
	
	@DeleteMapping("/deletesubjectarea/{subjectareaId}")
	public void deletesubjectarea(@PathVariable int subjectareaId) {
		 subjectareaservice.deletesubjectarea(subjectareaId);
	}
	
	@PutMapping("/updatesubjectarea/{subjectareaId}")
	public SubjectArea updatesubjectarea(@PathVariable int subjectareaId,@RequestBody SubjectArea updatedsubjectarea) {
		return subjectareaservice.updatesubjectarea(subjectareaId, updatedsubjectarea);
	}
}
