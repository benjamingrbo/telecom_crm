package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Feedback;
import com.telecom.telecomplus.model.FeedbackDTO;
import com.telecom.telecomplus.model.Polls;
import com.telecom.telecomplus.repository.FeedbackRepository;
import com.telecom.telecomplus.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Polls> getAllPolls() {
        return pollRepository.findAll();
    }

    public Polls savePoll(Polls poll) {
        return pollRepository.save(poll);
    }

}