package org.example.controlador;


import org.example.Vista.VentanaPremios;
import org.example.modelo.ModeloTablaPremios;
import org.example.modelo.Premios;
import org.example.persistencia.ConexionSingleton;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ControladorPremios extends MouseAdapter {
    private VentanaPremios view;
    private ModeloTablaPremios modelo;
    public ControladorPremios(VentanaPremios view) {
        this.view = view;
        modelo= new ModeloTablaPremios();
        this.view.getTblPremios().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getTblPremios().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTblPremios().setModel(modelo);
            this.view.getTblPremios().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            Premios premios = new Premios();
            premios.setId(0);
            premios.setCategoria(this.view.getTxtCategoria().getText());
            premios.setCondecorado(this.view.getTxtCondecorado().getText());
            premios.setNacionalidad(this.view.getTxtNacionalidad().getText());
            premios.setFecha(this.view.getTxtFecha().getText());
            premios.setUrl(this.view.getTxtUrl().getText());
            this.view.getTblPremios().updateUI();
            if (modelo.agregarPremios(premios)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblPremios().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. por favor revise su conexion", "Erro", JOptionPane.ERROR_MESSAGE);

            }
            this.view.limpiar();
        }
        if (e.getSource() == this.view.getBtnActualizar()) {
            int respuesta = JOptionPane.showConfirmDialog(view, "Estas seguro que se actualice el registro?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                Premios premios = new Premios();
                premios.setId(Integer.parseInt((String) this.view.getTxtIdMod().getText()));
                premios.setCategoria(this.view.getTxtCategoriaMod().getText());
                premios.setCondecorado(this.view.getTxtCondecoradoMod().getText());
                premios.setNacionalidad(this.view.getTxtNacionalidadMod().getText());
                premios.setFecha(this.view.getTxtFechaMod().getText());
                premios.setUrl(this.view.getTxtUrlMod().getText());
                this.view.getTblPremios().updateUI();
                if (modelo.actualizar(premios)) {
                    JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblPremios().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo actualizo en la base de datos. por favor revise su conexion", "Erro", JOptionPane.ERROR_MESSAGE);

                }
                this.view.limpiar2();
            }else {this.view.limpiar2();}
        }
        if (e.getSource() == this.view.getBtnEliminar()) {
            int respuesta = JOptionPane.showConfirmDialog(view, "Estas seguro de borrar el registro?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                String sqlDelete = "DELETE FROM Premios WHERE id=?;";
                PreparedStatement pstm = null;
                try {
                    pstm = ConexionSingleton.getInstance("PremiosNobelDB.db").getConnection().prepareStatement(sqlDelete);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    pstm.setInt(1, Integer.parseInt(this.view.getTxtElminarId().getText()));
                    this.view.getTblPremios().updateUI();
                    JOptionPane.showMessageDialog(view, "Se elimino correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(view, "No se elimino correctamente", "aviso", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                try {
                    pstm.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view, "Error en Id", "aviso", JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(ex);
                }finally {
                    this.view.limpiar2();
                }
            }
        }
        if (e.getSource()==view.getTblPremios()) {
            int index=this.view.getTblPremios().getSelectedRow();
            Premios tmp= modelo.getPremiosIndex(index);
            try {
                this.view.getImagen().setIcon(tmp.getImagen());
            }catch (MalformedURLException mfue){
                System.out.println(e.toString());
            }

        }
    }
}