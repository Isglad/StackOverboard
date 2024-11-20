package com.teamtreehouse.techdegree.overboard.model;

import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class UserTest {

    private Board board;
    private User user1;
    private User user2;
    private User user3;
    private Question question;
    public Answer answer;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
       // Initialize the Board
        board = new Board("JUnit Basics");

        // Initialize Users
        user1 = board.createUser("Jane");
        user2 = board.createUser("Joe");
        user3 = board.createUser("Doe");

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

    @Test
    public void downVotingAnswerDecreasesOnePoint() throws Exception {
        // User1 down-vote User2 answer
        user1.downVote(answer);

        // verify that User2's reputation decreases by 1 point
        assertEquals(-1, user2.getReputation());
    }

    // Authors Cannot Vote
    @Test
    public void userCannotUpvoteTheirOwnQuestion() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        // User attempts to vote for their own question
        user1.upVote(question);

        // Verify that user can not vote for herself
        assertFalse(true);
    }

    @Test
    public void userCannotDownvoteTheirOwnQuestion() throws Exception {
        // Verify that the appropriate exception is thrown with the correct message
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        // User attempts to down-vote for their own question
        user1.downVote(question);

        // Verify that user can not vote for herself
        assertFalse(true);
    }

    @Test
    public void userCannotUpvoteTheirOwnAnswer() throws Exception {
        // Verify that the appropriate exception is thrown with the correct message
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        // User attempts to vote for their own answer
        user2.upVote(answer);

        // Verify that user can not vote for himself
        assertFalse(true);
    }


    @Test
    public void userCannotDownvoteTheirOwnAnswer() throws Exception {
        // Verify that the appropriate exception is thrown with the correct message
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        // User attempts to down-vote for their own answer
        user2.downVote(answer);

        // Verify that user can not vote for himself
        assertFalse(true);
    }
}