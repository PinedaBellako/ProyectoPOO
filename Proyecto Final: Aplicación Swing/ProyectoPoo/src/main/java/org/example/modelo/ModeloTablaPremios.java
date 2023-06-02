package org.example.modelo;

import org.example.persistencia.PremiosDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaPremios implements TableModel {
    private ArrayList<Premios> datos;
    public static final int COLUMNAS = 6;
    private PremiosDAO premiosDAO;

    public ModeloTablaPremios() {
        datos = new ArrayList<>();
        premiosDAO = new PremiosDAO();
    }

    public ModeloTablaPremios(ArrayList<Premios> datos) {
        this.datos = datos;
        premiosDAO = new PremiosDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int RowIndex) {
        switch (RowIndex){
            case 0:
                return "Id";
            case 1:
                return "Categoria";
            case 2:
                return "Condecorado";
            case 3:
                return "Nacionalidad";
            case 4:
                return "Fecha";
            case 5:
                return "Url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int RowIndex) {
        switch (RowIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Premios tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getCategoria();
            case 2:
                return tmp.getCondecorado();
            case 3:
                return tmp.getNacionalidad();
            case 4:
                return tmp.getFecha();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setID();
                break;
            case 1:
                datos.get(rowIndex).setCategoria((String)o);
                break;
            case 2:
                datos.get(rowIndex).setCondecorado((String)o);
                break;
            case 3:
                datos.get(rowIndex).setNacionalidad((String)o);
                break;
            case 4:
                datos.get(rowIndex).setFecha((String)o);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String)o);
                break;
            default:
                System.out.println("No se modifica nada");

        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarDatos(){
        try {
            ArrayList<Premios> tirar = premiosDAO.obtenerTodo();
            System.out.println(tirar);
            datos = premiosDAO.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println("error" + sqle.getMessage());
        }
    }
    public Premios getPremiosIndex(int index){
        return datos.get(index);
    }

    public boolean agregarPremios(Premios premios){
        boolean resultado = false;
        try {
            if(premiosDAO.insertar(premios)){
                datos.add(premios);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println("error" + sqle.getMessage());
        }
        return resultado;
    }


    public boolean actualizar(Premios premios) {
        boolean resultado = false;
        try {
            if (premiosDAO.update(premios)) {
                datos.add(premios);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error" + sqle.getMessage());
        }
        return resultado;
    }

    public boolean eliminar(Premios premios) {
        boolean resultado = false;
        try {
            if (premiosDAO.delete(String.valueOf(premios))) {
                datos.add(premios);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error" + sqle.getMessage());
        }
        return resultado;
    }

}
