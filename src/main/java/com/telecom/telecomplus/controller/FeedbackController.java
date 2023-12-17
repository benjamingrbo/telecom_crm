package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Feedback;
import com.telecom.telecomplus.model.FeedbackDTO;
import com.telecom.telecomplus.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback/getAllFeedbacks")
    public   List<FeedbackDTO> getAllFeedbacks(){
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/feedback/getFeedbackById/{id}")
    public Optional<Feedback> getFeedbackById(@PathVariable Long id){
        return feedbackService.getFeedbackById(id);
    }

    @PutMapping("/feedback/updateFeedback/{id}")
    public Feedback updateFeedback(@RequestBody Feedback updatedFeedback, @PathVariable  Long id){
        return feedbackService.updateFeedback(id, updatedFeedback);
    }

    @PostMapping("/feedback/createFeedback")
    public Feedback createFeedback(@RequestBody Feedback newFeedback){
        return feedbackService.createFeedback(newFeedback);
    }

    @DeleteMapping("/feedback/deleteFeedback/{id}")
    public String deleteFeedback(@PathVariable Long id){
        return feedbackService.deleteFeedbackById(id);
    }
}
