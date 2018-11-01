/*
    Programming for Computer Scientists (CS118) - Lab 5
    Classes and objects
*/

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import lab5.*;

public class ModuleTest {
    @Test
    public void testModule() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random module codes
        for(int i=0; i<100; i++) {
            int x = random.nextInt(100, 1000);

            String moduleCode = "CS" + x;
            String moduleName = "CS" + x + ": MGP for Computer Scientists";

            // create a module
            Module module = new Module(moduleCode, moduleName);

            assertTrue(
                "getModuleCode does not return the correct module code",
                module.getModuleCode().equals(moduleCode));
            assertTrue(
                "getModuleName does not return the correct module name",
                module.getModuleName().equals(moduleName));
        }
    }

    @Test
    public void testAddAssessments() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // run 100 tests
        for(int i=0; i<100; i++) {
            // create a module
            Module module = new Module("CS141", "Functional Programming");

            // add some assessments that do not exceed a total weight of 100
            int total = 0;

            while(total + 3 <= 100) {
                int weight = random.nextInt(3, Math.min(100-total+1,21));

                Assessment assessment = new Assessment();
                assessment.setWeight(weight);

                assertTrue(
                    "addAssessment fails, even though the total weight does not exceed 100",
                    module.addAssessment(assessment));

                total += weight;
            }
        }
    }

    @Test
    public void testCalculateOverallAverages() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // run 100 tests
        for(int i=0; i<100; i++) {
            // create a module
            Module module = new Module("CS141", "Functional Programming");

            // add some assessments that do not exceed a total weight of 100
            int total = 0;
            double average = 0.0;

            while(total + 3 <= 100) {
                int weight = random.nextInt(3, Math.min(100-total+1,21));
                int mark = random.nextInt(0, 101);

                Assessment assessment = new Assessment();
                assessment.setWeight(weight);
                assessment.setMark(mark);

                average += mark * (weight/100.0);

                assertTrue(
                    "addAssessment fails, even though the total weight does not exceed 100",
                    module.addAssessment(assessment));

                total += weight;
            }

            assertEquals(Math.ceil(average), module.calculateOverallMark(), 0.01);
        }
    }
}
