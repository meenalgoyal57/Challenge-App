package com.Spring.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
//Response Entity : Is a wrapper in which you can represent entire http response including status code and body.
@RestController  //Map the domain and Challenges
@RequestMapping("/challenges")
public class ChallengeController {

    private ChallengeService challengeService;
    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }
    @GetMapping
    public List<Challenge> getAllChallenges(){
        return challengeService.getAllChallenges();
    }

    @PostMapping
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded){
            return "Challenge Added Successfully";
        }else{
            return "Challenge not Added Successfully";
        }
    }
    @GetMapping("{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
@PutMapping("{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id,updatedChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge Not updated successfully",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted)
            return new ResponseEntity<>("Challenge Deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge Not Deleted",HttpStatus.NOT_FOUND);

    }
}
