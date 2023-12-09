package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Feedback;
import com.telecom.telecomplus.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId);
    }

    public Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback) {
        return feedbackRepository.findById(feedbackId)
                .map(feedback -> {

                    if (updatedFeedback.getFeedbackText() != null) {
                        feedback.setFeedbackText(updatedFeedback.getFeedbackText());
                    }
                    if (updatedFeedback.getRating() != null) {
                        feedback.setRating(updatedFeedback.getRating());
                    }
                    if (updatedFeedback.getFeedbackDate() != null) {
                        feedback.setFeedbackDate(updatedFeedback.getFeedbackDate());
                    }
                    if (updatedFeedback.getCustomer() != null) {
                        feedback.setCustomer(updatedFeedback.getCustomer());
                    }

                    return feedbackRepository.save(feedback);
                })
                .orElse(null);
    }

    public Feedback createFeedback(Feedback newFeedback) {
        return feedbackRepository.save(newFeedback);
    }


    public String deleteFeedbackById(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
        return "Feedback with id: " + feedbackId + " has been deleted.";
    }
}
