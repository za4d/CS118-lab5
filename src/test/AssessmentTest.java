/*
    Programming for Computer Scientists (CS118) - Lab 5
    Classes and objects
*/

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import lab5.*;

public class AssessmentTest {
    @Test
    public void testAssessmentWeight() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Assessment assessment = new Assessment();

        // test 100 random integers
        for(int i=0; i<100; i++) {
            int x = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

            // set the weight for the assessment
            assessment.setWeight(x);

            assertTrue(
                "getWeight does not return the weight that was set",
                assessment.getWeight() == x);
        }
    }

    @Test
    public void testAssessmentMark() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Assessment assessment = new Assessment();

        // test 100 random integers
        for(int i=0; i<100; i++) {
            int x = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

            // set the mark for the assessment
            assessment.setMark(x);

            assertTrue(
                "getMark does not return the mark that was set",
                assessment.getMark() == x);
        }
    }
}
