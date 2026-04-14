package com.Spring.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
@RestController  //Map the domain and Challenges
public class ChallengeController {
    private List<Challenge> challenges = new ArrayList<>();
    public ChallengeController(){
        Challenge challenge1 = new Challenge(1L, "January","Learn what are endpoints");
        challenges.add(challenge1);
    }
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

}
