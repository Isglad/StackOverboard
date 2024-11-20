package com.teamtreehouse.techdegree.overboard.model;

import org.junit.Before;

import static org.junit.Assert.*;

public class UserTest {

    private Board board;
    private User user1;
    private User user2;
    private Question question;
    private Answer answer;

    @Before
    public void setUp() throws Exception {
       // Initialize the Board
        board = new Board("JUnit Basics");

        // Initialize Users
        user1 = new User(board, "Jane");
        user2 = new User(board, "Joe");

        // Initialize a Question
        question = new Question(user1, "What is a Test Fixture?");

        // Initialize an Answer
        answer = new Answer(question, user2, "Test Fixture is the class that surrounds each method.");
    }
}