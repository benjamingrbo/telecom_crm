package com.telecom.telecomplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "feedback_text", nullable = false)
    private String feedbackText;

    @Column(name = "rating", nullable = false, columnDefinition = "INT CHECK (rating BETWEEN 1 AND 5)")
    private Integer rating;

    @Column(name = "feedback_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date feedbackDate;


    private Long customerId;

}
