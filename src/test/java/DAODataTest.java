package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DAO.DAOData;  // Import the DAOData class
import view.newfiture;  // Import the newfiture class
import model.TambahData;
import java.util.List;
import javax.swing;

public class DAODataTest {
    
    private DAOData daoData;
    private JPanel mainPanel;
    private JButton btRegis1;

    @BeforeEach
    public void setUp() {
        daoData = new DAOData();
        mainPanel = new JPanel();
        btRegis1 = new JButton();

        // Set up action listener untuk btRegis1 yang memanggil btRegis1ActionPerformed
        btRegis1.addActionListener(evt -> btRegis1ActionPerformed(evt));
        
        daoData.deleteAll();
    }

    @Test
    public void testInsertAndGetAll() {
        TambahData data = new TambahData();
        data.setNim("123456");
        data.setNama("John Doe");
        data.setJenisKelamin("Laki-laki");
        data.setKelas("A");
        data.setProdi("Teknik Informatika"); // Add program field
        data.setFakultas("Fakultas Teknik"); // Add faculty field
        data.setAngkatan("2022"); // Add year field
    
        // Insert data
        daoData.insert(data);
    
        // Get all data
        List<TambahData> result = daoData.getAll();
    
        // Verify that the name and other fields are as expected
        assertEquals("John Doe", result.get(0).getNama());
        assertEquals("Teknik Informatika", result.get(0).getProdi());
        assertEquals("Fakultas Teknik", result.get(0).getFakultas());
        assertEquals("2022", result.get(0).getAngkatan());
    }

    @Test
    public void testUpdate() {
        // Arrange
        TambahData data = new TambahData();
        data.setNim("12345");
        data.setNama("John Doe");
        data.setJenisKelamin("Laki-laki");
        data.setKelas("Kelas A");
        data.setProdi("Teknik Informatika");
        data.setFakultas("Fakultas Teknik");
        data.setAngkatan("2022");
        daoData.insert(data);

        // Update
        data.setNama("Jane Doe");
        data.setProdi("Sistem Informasi");
        daoData.update(data);

        // Act
        List<TambahData> allData = daoData.getAll();

        // Assert
        assertEquals("Jane Doe", allData.get(0).getNama());
        assertEquals("Sistem Informasi", allData.get(0).getProdi());
    }

    @Test
    public void testDelete() {
        // Ensure there's data to delete
        TambahData data = new TambahData();
        data.setNim("12345");
        data.setNama("John Doe");
        data.setJenisKelamin("Laki-laki");
        data.setKelas("Kelas A");
        data.setProdi("Teknik Informatika");
        data.setFakultas("Fakultas Teknik");
        data.setAngkatan("2022");
        daoData.insert(data);

        // Delete the data
        daoData.delete("12345");
        List<TambahData> allData = daoData.getAll();
        assertFalse(allData.stream().anyMatch(mhs -> mhs.getNim().equals("12345")), "Data should be deleted");
    }

    @Test
    public void testSearch() {
        // Arrange
        TambahData data1 = new TambahData();
        data1.setNim("123456");
        data1.setNama("John Doe");
        data1.setJenisKelamin("Laki-laki");
        data1.setKelas("A");
        data1.setProdi("Teknik Informatika");
        data1.setFakultas("Fakultas Teknik");
        data1.setAngkatan("2022");
        daoData.insert(data1);
    
        TambahData data2 = new TambahData();
        data2.setNim("654321");
        data2.setNama("Jane Smith");
        data2.setJenisKelamin("Perempuan");
        data2.setKelas("B");
        data2.setProdi("Sistem Informasi");
        data2.setFakultas("Fakultas Teknik");
        data2.setAngkatan("2023");
        daoData.insert(data2);
    
        // Act: Search by NIM
        List<TambahData> resultsByNIM = daoData.search("123456");
        
        // Assert: Verify the search results contain John Doe
        assertEquals(1, resultsByNIM.size());
        assertEquals("John Doe", resultsByNIM.get(0).getNama());
    
        // Act: Search by name
        List<TambahData> resultsByName = daoData.search("Jane");
        
        // Assert: Verify the search results contain Jane Smith
        assertEquals(1, resultsByName.size());
        assertEquals("Jane Smith", resultsByName.get(0).getNama());
    
        // Act: Search with a keyword that doesn't match any data
        List<TambahData> resultsEmpty = daoData.search("Unknown");
        
        // Assert: Verify the search results are empty
        assertTrue(resultsEmpty.isEmpty(), "Search should return no results for 'Unknown'");
    }

    @Test
    void testButtonActionAddsNewFitureToMainPanel() {
        // Klik tombol untuk memicu action
        btRegis1.doClick();
    
        // Pastikan hanya ada satu komponen di mainPanel setelah penambahan
        assertEquals(1, mainPanel.getComponentCount(), "Komponen tidak berhasil ditambahkan.");
    
        // Periksa apakah komponen yang ditambahkan adalah instance dari newfiture
        assertTrue(mainPanel.getComponent(0) instanceof newfiture, "Komponen yang ditambahkan bukan instance dari newfiture.");
    }
}
