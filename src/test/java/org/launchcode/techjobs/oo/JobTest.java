package org.launchcode.techjobs.oo;

import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    //Not working for some reason???
//    @BeforeEach
//    public void createJobObjects(){
//        Job job1 = new Job();
//        Job job2 = new Job();
//    }

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(null, job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertEquals('\n',job1.toString().charAt(0));
//        assertEquals('\n', job1.toString().charAt(job1.toString().length() - 1));
        assertTrue(job1.toString().startsWith(lineSeparator()));
        assertTrue(job1.toString().endsWith(lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String s = System.lineSeparator();
        assertEquals(s+"ID: " + job1.getId() + s+"Name: Product tester"+s+"Employer: ACME"+s+"Location: Desert"+s+"Position Type: Quality control"+s+"Core Competency: Persistence"+s, job1.toString());
//        assertEquals("\nID: " + job1.getId() +"\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String s = System.lineSeparator();
        assertEquals(s +"ID: " + job1.getId() + s +"Name: Data not available"+ s +"Employer: ACME"+ s +"Location: Desert"+ s +"Position Type: Quality control"+ s +"Core Competency: Persistence"+ s, job1.toString());
//        assertEquals("\nID: " + job1.getId() + "\nName: Data not available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job1.toString());
    }

    @Test
    public void testToStringHandlesAllEmptyFields(){
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", job1.toString());
    }

}

