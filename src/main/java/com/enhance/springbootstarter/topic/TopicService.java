package com.enhance.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
 
	@Autowired
	private TopicRepository topicRepository;
	
	
	
	// the above we have created a list and that is private and anyone cant acess it now if someone wants the list we need to reutn it 
	// and also keep the acess part as public as to be acessible for someone and that public method inturn will acess these private variables
	public List<Topic> getAllTopics()
	{
		//return topics;
		/// TO get the list that is in the TopicService business class  we call the method is public which will in turn give us the private data
		   // here what it will return is a list that is of type topic
		
		//Here we will run the query and now this query will give us all the rows and we need to convert them into instances of topic
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		
		return topics;
		 
	}
	
	public Topic getTopic(String id)
	{
		/*Topic tp1=null;
		for(Topic tp:topic)
		{
			if(tp.getId().equals(id))
			{
				System.out.print("hai");
				return tp;
			}
			
		} 
		return tp1;*/
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findById(id).get();
		
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		
		//topics.add(topic);
		
		topicRepository.save(topic);
		
	}
   /***
    * 
    * @param topic
    * @param id
    */
	public void updateTopic(Topic topic, String id) {
		
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
		
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
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
		
		topicRepository.deleteById(id);
	}
}
