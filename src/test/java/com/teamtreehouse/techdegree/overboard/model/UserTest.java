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
}