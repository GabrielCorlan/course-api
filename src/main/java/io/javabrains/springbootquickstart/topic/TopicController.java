package io.javabrains.springbootquickstart.topic;

import io.javabrains.springbootquickstart.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics() {
        final List<Topic> allTopics = topicService.getAllTopics();
        return ResponseEntity.ok().body(allTopics);
    }

    @GetMapping("/topics/{topicId}")
    public ResponseEntity<Topic> getTopicById(@PathVariable final String topicId) {
        final Topic topicById = topicService.getTopicById(topicId);
        if (Objects.isNull(topicById)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topicById);
    }

    @PostMapping("/topics")
    public void createTopic(@RequestBody final Topic topic) {
        topicService.postTopic(topic);
    }

    @PutMapping("/topics")
    public void updateTopic(@RequestBody final Topic topic) {
        topicService.updateTopic(topic);
    }

    @DeleteMapping("/topics/{topicId}")
    public void deleteTopic(@PathVariable final String topicId) {
        topicService.deleteTopic(topicId);
    }


}
