package model;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TambahData;

public class TabelModelData extends AbstractTableModel{
    
    public TabelModelData(List<TambahData> lstMhs){
        this.lstMhs = lstMhs;
    }
    @Override
    public int getRowCount() {
        return this.lstMhs.size(); 
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "NIM";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Kelas";
            case 4:
                return "Prodi";
            case 5:
                return "Fakultas";
            case 6:
                return "Angkatan";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lstMhs.get(rowIndex).getNim();
            case 1:
                return lstMhs.get(rowIndex).getNama();
            case 2:
                return lstMhs.get(rowIndex).getJenisKelamin();
            case 3:
                return lstMhs.get(rowIndex).getKelas();
            case 4:
                return lstMhs.get(rowIndex).getProdi();
            case 5:
                return lstMhs.get(rowIndex).getFakultas();
            case 6:
                return lstMhs.get(rowIndex).getAngkatan();
            default:
                return null;
        }
    }
    List<TambahData> lstMhs;
    
}