package com.teamtreehouse.techdegree.overboard.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private Board board;
    private User user1;
    private User user2;
    private Question question;
    public Answer answer;

    @Before
    public void setUp() throws Exception {
       // Initialize the Board
        board = new Board("JUnit Basics");

        // Initialize Users
        user1 = board.createUser("Jane");
        user2 = board.createUser("Joe");

        // Initialize a Question
        question = user1.askQuestion("What is a Test Fixture?");

        // Initialize an Answer
        answer = user2.answerQuestion(question,"Test Fixture is the class that surrounds each method.");
    }

    @Test
    public void questionUpvoteIncreasesReputationByFive() throws Exception {
        // User2 upvote User1 question
        user2.upVote(question);

        // Verify that User1's reputation increases by 5 points
        assertEquals(5, user1.getReputation());
    }

    @Test
    public void answerUpvoteIncreasesReputationByTen() throws Exception {
        // User1 upvote User2 answer
        user1.upVote(answer);

        // Verify that User2's reputation increases by 10 points
        assertEquals(10, user2.getReputation());
    }

    @Test
    public void answerAcceptedBoostsReputationByFifteen() throws Exception {
        // User1 accepts User2 answer
        user1.acceptAnswer(answer);

        // Ensure answer is marked as accepted
        assertTrue(answer.isAccepted());

        // Verify that User2's reputation increases by 15 points
        assertEquals(15, user2.getReputation());
    }
}