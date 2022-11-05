package com.enhance.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enhance.springbootstarter.topic.Topic;
import com.enhance.springbootstarter.topic.TopicRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		//return topics;
		/// TO get the list that is in the TopicService business class  we call the method is public which will in turn give us the private data
		   // here what it will return is a list that is of type topic
		
		//Here we will run the query and now this query will give us all the rows and we need to convert them into instances of topic
		List<Course> courses= new ArrayList<>();
		
		/*Here we need to create a method in such a way that it will find courses based
		 on the topicId*/
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		
		return courses;
		 
	}
	
	public Course getCourse(String id)
	{
		 
		
		return courseRepository.findById(id).get();
		
	}

	public void addCourse(Course course) {
		
		
		courseRepository.save(course);
		
	}
   /***
    * 
    * @param topic
    * @param id
    */
	public void updateCourse(Course course) {
		
		/*for(Topic topic1:topics)
		{
			if(topic1.getId().equals(id))
			{
				int index=topics.indexOf(topic1);
				topics.set(index, topic);
			}
		}
		/*for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}*/
		
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		/*for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.remove(i);
			}
		}*/
		
		//topics.removeIf(t->t.getId().equals(id));
		
		courseRepository.deleteById(id);
	}
	
}
