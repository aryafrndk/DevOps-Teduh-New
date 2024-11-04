package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DAO.DAOData;
import model.TambahData;
import java.util.List;

public class DAODataTest {
    
    private DAOData daoData;

    @BeforeEach
    public void setUp() {
        daoData = new DAOData();
        daoData.deleteAll();
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

}
