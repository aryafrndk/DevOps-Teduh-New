import view.newfiture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DAO.DAOData;
import model.TambahData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DAODataTest {

    private DAOData daoData;
    private Connection mockConnection;
    private Statement mockStatement;
    private ResultSet mockResultSet;
    private YourClass yourClass; // Replace 'YourClass' with the actual class name if different

    @BeforeEach
    public void setUp() throws Exception {
        daoData = new DAOData();
        daoData.deleteAll();

        // Setup mocks
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);

        // Initialize 'YourClass' instance
        yourClass = new YourClass();
        yourClass.setConnection(mockConnection); // Assume there's a method to set the mock connection
    }

    @Test
    public void testInsertAndGetAll() {
        TambahData data = new TambahData();
        data.setNim("123456");
        data.setNama("John Doe");
        data.setJenisKelamin("Laki-laki");
        data.setKelas("A");
        data.setProdi("Teknik Informatika");
        data.setFakultas("Fakultas Teknik");
        data.setAngkatan("2022");

        daoData.insert(data);

        List<TambahData> result = daoData.getAll();

        assertEquals("John Doe", result.get(0).getNama());
        assertEquals("Teknik Informatika", result.get(0).getProdi());
        assertEquals("Fakultas Teknik", result.get(0).getFakultas());
        assertEquals("2022", result.get(0).getAngkatan());
    }

    @Test
    public void testUpdate() {
        TambahData data = new TambahData();
        data.setNim("12345");
        data.setNama("John Doe");
        data.setJenisKelamin("Laki-laki");
        data.setKelas("Kelas A");
        data.setProdi("Teknik Informatika");
        data.setFakultas("Fakultas Teknik");
        data.setAngkatan("2022");
        daoData.insert(data);

        data.setNama("Jane Doe");
        data.setProdi("Sistem Informasi");
        daoData.update(data);

        List<TambahData> allData = daoData.getAll();

        assertEquals("Jane Doe", allData.get(0).getNama());
        assertEquals("Sistem Informasi", allData.get(0).getProdi());
    }

    @Test
    public void testDelete() {
        TambahData data = new TambahData();
        data.setNim("12345");
        data.setNama("John Doe");
        data.setJenisKelamin("Laki-laki");
        data.setKelas("Kelas A");
        data.setProdi("Teknik Informatika");
        data.setFakultas("Fakultas Teknik");
        data.setAngkatan("2022");
        daoData.insert(data);

        daoData.delete("12345");
        List<TambahData> allData = daoData.getAll();
        assertFalse(allData.stream().anyMatch(mhs -> mhs.getNim().equals("12345")), "Data should be deleted");
    }

    @Test
    public void testSearch() {
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

        List<TambahData> resultsByNIM = daoData.search("123456");

        assertEquals(1, resultsByNIM.size());
        assertEquals("John Doe", resultsByNIM.get(0).getNama());

        List<TambahData> resultsByName = daoData.search("Jane");

        assertEquals(1, resultsByName.size());
        assertEquals("Jane Smith", resultsByName.get(0).getNama());

        List<TambahData> resultsEmpty = daoData.search("Unknown");

        assertTrue(resultsEmpty.isEmpty(), "Search should return no results for 'Unknown'");
    }

    @Test
    void testUpdateDataCount() throws Exception {
        // Mocking database interaction
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);

        // Simulate ResultSet for data count
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("total")).thenReturn(8); // Assume the new data count is 8

        // Call the method under test
        yourClass.updateDataCount();

        // Verify data counts are updated correctly
        assertEquals(8, yourClass.totalData);
        assertEquals(2, yourClass.dataDihapus);

        // Verify interactions with mocks
        verify(mockConnection).createStatement();
        verify(mockStatement).executeQuery(anyString());
        verify(mockResultSet).getInt("total");

        // Optional: Assert GUI component updates if required
        assertEquals("8", yourClass.datautuh.getText()); // Assume datautuh is a JLabel
        assertEquals("2", yourClass.datahapus.getText());
    }
}
