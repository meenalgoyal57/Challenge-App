package com.Spring.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
@RestController  //Map the domain and Challenges
public class ChallengeController {

    private ChallengeService challengeService;
    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challengeService.getAllChallenges();
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded){
            return "Challenge Added Successfully";
        }else{
            return "Challenge not Added Successfully";
        }
    }
    @GetMapping("/challenges")
    public List<Challenge> getChallenge(Long id){
        return challengeService.getChallenge(id);
    }
}
