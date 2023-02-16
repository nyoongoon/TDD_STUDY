package com.test.junit;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class ScoreCollectionTest {
    @Test
    public void test(){
        //준비
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.add(()->5);
        scoreCollection.add(()->7);
        //실행
        int actualResult = scoreCollection.arithmeticMean();
        //단언
        assertThat(actualResult, equalTo(6));
    }
}