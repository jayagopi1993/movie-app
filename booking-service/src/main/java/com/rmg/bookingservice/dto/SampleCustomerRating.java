package com.rmg.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleCustomerRating {

    private String activeProfile;

    private  String currentEnv;

    private  String optionalResponseType;

    private List<String> movies;

    private List<String> ratings;

    private String sampleMovie;

}
