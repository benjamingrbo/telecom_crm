package com.telecom.telecomplus.repository;

import com.telecom.telecomplus.model.CustomerDTO;
import com.telecom.telecomplus.model.Feedback;
import com.telecom.telecomplus.model.FeedbackDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT new com.telecom.telecomplus.model.FeedbackDTO (f.id, c.firstName, c.lastName, f.feedbackText,f.rating, f.feedbackDate) FROM Customer c INNER JOIN Feedback f ON c.id = f.customerId ")
    List<FeedbackDTO> getSveAA();
}
