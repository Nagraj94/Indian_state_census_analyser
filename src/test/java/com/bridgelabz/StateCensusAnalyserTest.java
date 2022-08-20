package com.bridgelabz;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class StateCensusAnalyserTest {

    private static final String CSV_FILE_PATH = "C:\\Users\\admin\\IdeaProjects\\Indian_state_census_analyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String CSV_WRONG_FILE_PATH = "C:\\Users\\admin\\IdeaProjects\\Indian_state_census_analyser\\src\\main\\resources\\IndiaStateCensusDat.csv";
    private static final String CSV_WRONG_FILE_EXTENSION = "C:\\Users\\admin\\IdeaProjects\\Indian_state_census_analyser\\src\\main\\resources\\IndiaStateCensusData.txt";
    private static final String CSV_WRONG_FILE_HEADER = "C:\\Users\\admin\\IdeaProjects\\Indian_state_census_analyser\\src\\main\\resources\\IndianStateCensus.csv";

    @Test
    void givenFileToMatchTheNoOfRecords() throws IOException, CsvException, StateCensusAnalyserException {
        int actual =  StateCensusAnalyser.readFile(CSV_FILE_PATH);
        Assertions.assertEquals(29,actual);
    }

    @Test
    void givenWrongFileNameShouldThrowCustomException(){
        StateCensusAnalyserException exception =  Assertions.assertThrows(StateCensusAnalyserException.class,() -> StateCensusAnalyser.readFile(CSV_WRONG_FILE_PATH));
        Assertions.assertEquals("File does not exist",exception.getMessage());
    }

    @Test
    void givenWrongFileTypeShouldThrowCustomException(){
        Assertions.assertThrows(StateCensusAnalyserException.class,() -> StateCensusAnalyser.readFile(CSV_WRONG_FILE_EXTENSION));
    }

    @Test
    void givenFileToMatchTheNoOfRec()  {
        Assertions.assertThrows(StateCensusAnalyserException.class,() -> StateCensusAnalyser.readFile(CSV_WRONG_FILE_HEADER));
    }
}