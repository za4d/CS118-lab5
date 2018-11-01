/*
    Programming for Computer Scientists (CS118) - Lab 5
    Classes and objects
*/

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import lab5.*;

public class DynamicAssessmentArrayTest {
    @Test
    public void testCapacity() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random integers
        for(int i=0; i<100; i++) {
            int size = random.nextInt(0, 4096);

            // initialise an array with the randomly generated initial capacity
            DynamicAssessmentArray array = new DynamicAssessmentArray(size);

            assertTrue(
                "getCapacity does not return the capacity that was requested",
                array.getCapacity() == size);
        }
    }

    @Test
    public void testCanFillToCapacity() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random integers
        for(int i=0; i<100; i++) {
            int size = random.nextInt(0, 512);

            // initialise an array with the randomly generated initial capacity
            DynamicAssessmentArray array = new DynamicAssessmentArray(size);

            // fill up the array
            for(int j=0; j < size; j++) {
                Assessment assessment = new Assessment();
                assessment.setWeight(j);
                array.add(assessment);
            }

            assertTrue(
                "The array does not have as many elements as were added (within its original capacity)",
                array.getSize() == size);

            // check that we retrieve the correct assessments back from the
            // dynamic array 
            for(int j=0; j < size; j++) {
                Assessment assessment = array.get(j);

                assertTrue(
                    "The assessment retrieved at index " + j + " is not the expected one",
                    assessment.getWeight() == j);
            }
        }
    }

    @Test
    public void testCanExceedCapacity() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random integers
        for(int i=0; i<100; i++) {
            int size = random.nextInt(0, 512);

            // initialise an array with the randomly generated initial capacity
            DynamicAssessmentArray array = new DynamicAssessmentArray(size);

            assertTrue(
                "The array does not have the requested capacity",
                array.getCapacity() == size);

            // fill up the array beyond capacity
            for(int j=0; j < size*2; j++) {
                Assessment assessment = new Assessment();
                assessment.setWeight(j);
                array.add(assessment);
            }

            // add even more
            int moreToAdd = (array.getCapacity() - array.getSize()) * 2;

            for(int j=0; j < moreToAdd; j++) {
                Assessment assessment = new Assessment();
                assessment.setWeight(size*2 + j);
                array.add(assessment);
            }

            assertTrue(
                "The array does not have as many elements as were added (above its original capacity)",
                array.getSize() == (size*2)+moreToAdd);

            // check that we retrieve the correct assessments back from the
            // dynamic array despite resizing etc.
            for(int j=0; j < size*2 + moreToAdd; j++) {
                Assessment assessment = array.get(j);

                assertTrue(
                    "The assessment retrieved at index " + j + " is not the expected one",
                    assessment.getWeight() == j);
            }
        }
    }
}
