package io.javabrains.springbootquickstart.service;

import io.javabrains.springbootquickstart.topic.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Java", "Java Incepatori", "Curs la clasa"),
            new Topic("SQL", "SQL Full Course", "Curs online"),
            new Topic("C#", "C# Incepatori", "Curs la clasa")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(final String topicId) {
        Optional<Topic> possibleTopic = topics.stream().filter(t -> t.getId().equalsIgnoreCase(topicId)).findFirst();
        //todo throw custom exception
        return possibleTopic.orElse(null);
    }

    public void postTopic(final Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(final Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(topic.getId())) {
                topics.set(i, topic);
            }
        }
    }

    public void deleteTopic(final String topicId) {
        topics.removeIf(t -> t.getId().equals(topicId));
    }


}
