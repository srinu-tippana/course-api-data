package com.enhance.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {

	//public List<Course> getCourseByTopic(String topicId);
	
	//Here lets say we want to find something or a course that has this particular name
	public List<Course> findByTopicId(String topicId);
	
	
}
 