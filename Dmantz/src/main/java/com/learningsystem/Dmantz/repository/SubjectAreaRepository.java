package com.learningsystem.Dmantz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningsystem.Dmantz.enums.SubjectAreaNames;
import com.learningsystem.Dmantz.model.SubjectArea;

@Repository
public interface SubjectAreaRepository extends JpaRepository<SubjectArea, Integer> {

	List<SubjectArea> findBySubjectareaname(SubjectAreaNames subjectAreaNames);
	
}
