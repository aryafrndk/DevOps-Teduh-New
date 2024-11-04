package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadDelTest {
    
    private newfiture feature;
    private static final String filePath = "datahapus.txt";
    
    @BeforeEach
    public void setUp() throws Exception {
        // Initialize the newfiture object before each test
        feature = new newfiture();

        // Ensure the test starts with a clean slate
        Files.deleteIfExists(Paths.get(filePath));
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Clean up the file after each test
        Files.deleteIfExists(Paths.get(filePath));
    }

    @Test
    public void testLoadDataDihapus() throws Exception {
        // Arrange: Write a sample data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("5");
        }

        // Act: Call the method that loads the data
        feature.loadDataDihapus();

        // Assert: Check if the dataDihapus is loaded correctly
        assertEquals(5, feature.getDataDihapus()); // use the getter method
    }
}
