package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.Feedback;
import com.telecom.telecomplus.model.FeedbackDTO;
import com.telecom.telecomplus.model.Polls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Polls, Long> {

}
