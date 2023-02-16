package com.test.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet(){
        //given
        Profile profile = new Profile("Bully Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got bonuses?");
        Answer profileAnswer = new Answer(question, Bool.FALSE); // 보너스 안줌
        profile.add(profileAnswer);
        Criteria criteria = new Criteria();
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
        Profile profile = new Profile("Bully Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got milk?");
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);
        //when
        boolean matches = profile.matches(criteria);
        //then
        assertTrue(matches); //맞음
    }
}