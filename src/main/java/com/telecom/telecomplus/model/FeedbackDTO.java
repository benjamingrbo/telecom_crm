package com.telecom.telecomplus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackDTO {
    private Long id;

    private String firstName;

    private String lastName;
    private String feedbackText;
    private Integer rating;
    private Date feedbackDate;




}
