package com.test.junit;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    private Profile profile;
    private Question question;
    private Criteria criteria;

    @BeforeEach
    public void create(){
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }


    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet(){
        //given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
        //when
        boolean matches = profile.matches(criteria);
        //then
        assertFalse(matches); //맞지 않음
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria(){
        //given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
        //when
        boolean matches = profile.matches(criteria);
        //then
        assertTrue(matches); //맞음
    }
}