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
        feature = new newfiture();

        Files.deleteIfExists(Paths.get(filePath));
    }

    @AfterEach
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(filePath));
    }

    @Test
    public void testLoadDataDihapus() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("5");
        }

        feature.loadDataDihapus();

        assertEquals(5, feature.getDataDihapus()); 
    }
}
