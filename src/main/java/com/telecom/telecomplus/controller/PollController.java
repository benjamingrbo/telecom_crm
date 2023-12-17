package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Feedback;
import com.telecom.telecomplus.model.FeedbackDTO;
import com.telecom.telecomplus.model.Polls;
import com.telecom.telecomplus.service.FeedbackService;
import com.telecom.telecomplus.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PollController {

    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/poll/getAllPolls")
    public List<Polls> getAllPolls(){
        return pollService.getAllPolls();
    }





    @PostMapping("/poll/createPoll")
    public Polls createPoll(@RequestBody Polls newPoll){
        return pollService.savePoll(newPoll);
    }


}
