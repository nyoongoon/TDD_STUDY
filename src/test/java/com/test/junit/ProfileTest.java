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
        Answer profileAnswer = new Answer(question, Bool.FALSE); // 보너스 안줌
        profile.add(profileAnswer);
        Answer criteriaAnswer = new Answer(question, Bool.TRUE); // 보너스 필요
        Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch); //중요한 질문
        criteria.add(criterion);
        //when
        boolean matches = profile.matches(criteria);
        //then
        assertFalse(matches); //맞지 않음
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria(){
        //given
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);
        //when
        boolean matches = profile.matches(criteria);
        //then
        assertTrue(matches); //맞음
    }
}