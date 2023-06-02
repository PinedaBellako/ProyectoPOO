package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPremios extends JFrame {
    private JLabel lblId;
    private JLabel lblCategoria;
    private JLabel lblCondecorado;
    private JLabel lblNacionalidad;
    private JLabel lblFecha;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtCategoria;
    private JTextField txtCondecorado;
    private JTextField txtNacionalidad;
    private JTextField txtFecha;
    private JTextField txtUrl;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblPremios;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JLabel Imagen;

    private JLabel lblIdmod;
    private  JLabel lblCategoriaMod;
    private  JLabel lblCondecoradoMod;
    private  JLabel lblNacionalidadMod;
    private  JLabel lblFechaMod;
    private  JLabel lblUrlMod;
    private JTextField txtIdMod;
    private JTextField txtCategoriaMod;
    private JTextField txtCondecoradoMod;
    private JTextField txtNacionalidadMod;
    private JTextField txtFechaMod;
    private JTextField txtUrlMod;
    private JLabel lblEliminarId;
    private JTextField txtElminarId;
    private JLabel lblEliminar;
    private JLabel lblActualizar;
    private JButton btnEliminar;
    private JButton btnActualizar;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public VentanaPremios(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this. getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(80, 184, 158));
        lblId = new JLabel("Id: ");
        lblCategoria = new JLabel("Categoria de Premio Nobel: ");
        lblCondecorado = new JLabel("Condecorado del Premio Nobel: ");
        lblNacionalidad = new JLabel("Nacionalidad del condecorado: ");
        lblFecha = new JLabel("Fecha de otorgacion: ");
        lblUrl = new JLabel("Url de la imagen: ");
        txtId =new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtCategoria = new JTextField(10);
        txtCondecorado = new JTextField(10);
        txtNacionalidad = new JTextField(10);
        txtFecha = new JTextField(10);
        txtUrl = new JTextField(10);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblCategoria);
        panel1.add(txtCategoria);
        panel1.add(lblCondecorado);
        panel1.add(txtCondecorado);
        panel1.add(lblNacionalidad);
        panel1.add(txtNacionalidad);
        panel1.add(lblFecha);
        panel1.add(txtFecha);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);

        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(128, 199, 139));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblPremios = new JTable();
        scrollPane = new JScrollPane(tblPremios);
        panel2.add(scrollPane);

        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(130, 184, 80));
        Imagen = new JLabel("...");
        panel3.add(Imagen);

        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(211, 178, 100));

        lblActualizar= new JLabel(" Actualizar el registro ");

        lblIdmod=new JLabel("Id:");
        lblCategoriaMod = new JLabel("Categoria de Premio Nobel: ");
        lblCondecoradoMod = new JLabel("Condecorado del Premio Nobel: ");
        lblNacionalidadMod = new JLabel("Nacionalidad del condecorado: ");
        lblFechaMod = new JLabel("Fecha de otorgacion: ");
        lblUrlMod = new JLabel("Url de la imagen: ");

        btnActualizar=new JButton("Actualizar");

        lblEliminar=new JLabel(" Eliminar registro ");
        lblEliminarId=new JLabel("Id por eliminar");
        txtElminarId=new JTextField(3);
        btnEliminar=new JButton("Eliminar");

        txtIdMod =new JTextField(3);
        txtCategoriaMod = new JTextField(10);
        txtCondecoradoMod = new JTextField(10);
        txtNacionalidadMod = new JTextField(10);
        txtFechaMod = new JTextField(10);
        txtUrlMod = new JTextField(10);

        panel4.add(lblActualizar);
        panel4.add(lblIdmod);
        panel4.add(txtIdMod);
        panel4.add(lblCategoriaMod);
        panel4.add(txtCategoriaMod);
        panel4.add(lblCondecoradoMod);
        panel4.add(txtCondecoradoMod);
        panel4.add(lblNacionalidadMod);
        panel4.add(txtNacionalidadMod);
        panel4.add(lblFechaMod);
        panel4.add(txtFechaMod);
        panel4.add(lblUrlMod);
        panel4.add(txtUrlMod);
        panel4.add(btnActualizar);

        panel4.add(lblEliminarId);
        panel4.add(txtElminarId);
        panel4.add(lblEliminar);
        panel4.add(btnEliminar);

        //agregar

        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    public void setLblCategoria(JLabel lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    public JLabel getLblCondecorado() {
        return lblCondecorado;
    }

    public void setLblCondecorado(JLabel lblCondecorado) {
        this.lblCondecorado = lblCondecorado;
    }

    public JLabel getLblNacionalidad() {
        return lblNacionalidad;
    }

    public void setLblNacionalidad(JLabel lblNacionalidad) {
        this.lblNacionalidad = lblNacionalidad;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(JTextField txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public JTextField getTxtCondecorado() {
        return txtCondecorado;
    }

    public void setTxtCondecorado(JTextField txtCondecorado) {
        this.txtCondecorado = txtCondecorado;
    }

    public JTextField getTxtNacionalidad() {
        return txtNacionalidad;
    }

    public void setTxtNacionalidad(JTextField txtNacionalidad) {
        this.txtNacionalidad = txtNacionalidad;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblPremios() {
        return tblPremios;
    }

    public void setTblPremios(JTable tblPremios) {
        this.tblPremios = tblPremios;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JLabel getImagen() {
        return Imagen;
    }

    public void setImagen(JLabel imagen) {
        Imagen = imagen;
    }

    public JLabel getLblCategoriaMod() {
        return lblCategoriaMod;
    }

    public void setLblCategoriaMod(JLabel lblCategoriaMod) {
        this.lblCategoriaMod = lblCategoriaMod;
    }

    public JLabel getLblCondecoradoMod() {
        return lblCondecoradoMod;
    }

    public void setLblCondecoradoMod(JLabel lblCondecoradoMod) {
        this.lblCondecoradoMod = lblCondecoradoMod;
    }

    public JLabel getLblNacionalidadMod() {
        return lblNacionalidadMod;
    }

    public void setLblNacionalidadMod(JLabel lblNacionalidadMod) {
        this.lblNacionalidadMod = lblNacionalidadMod;
    }

    public JLabel getLblFechaMod() {
        return lblFechaMod;
    }

    public void setLblFechaMod(JLabel lblFechaMod) {
        this.lblFechaMod = lblFechaMod;
    }

    public JLabel getLblUrlMod() {
        return lblUrlMod;
    }

    public void setLblUrlMod(JLabel lblUrlMod) {
        this.lblUrlMod = lblUrlMod;
    }

    public JTextField getTxtIdMod() {
        return txtIdMod;
    }

    public void setTxtIdMod(JTextField txtIdMod) {
        this.txtIdMod = txtIdMod;
    }

    public JTextField getTxtCategoriaMod() {
        return txtCategoriaMod;
    }

    public void setTxtCategoriaMod(JTextField txtCategoriaMod) {
        this.txtCategoriaMod = txtCategoriaMod;
    }

    public JTextField getTxtCondecoradoMod() {
        return txtCondecoradoMod;
    }

    public void setTxtCondecoradoMod(JTextField txtCondecoradoMod) {
        this.txtCondecoradoMod = txtCondecoradoMod;
    }

    public JTextField getTxtNacionalidadMod() {
        return txtNacionalidadMod;
    }

    public void setTxtNacionalidadMod(JTextField txtNacionalidadMod) {
        this.txtNacionalidadMod = txtNacionalidadMod;
    }

    public JTextField getTxtFechaMod() {
        return txtFechaMod;
    }

    public void setTxtFechaMod(JTextField txtFechaMod) {
        this.txtFechaMod = txtFechaMod;
    }

    public JTextField getTxtUrlMod() {
        return txtUrlMod;
    }

    public void setTxtUrlMod(JTextField txtUrlMod) {
        this.txtUrlMod = txtUrlMod;
    }

    public JLabel getLblEliminar() {
        return lblEliminar;
    }

    public void setLblEliminar(JLabel lblEliminar) {
        this.lblEliminar = lblEliminar;
    }

    public JLabel getLblActualizar() {
        return lblActualizar;
    }

    public void setLblActualizar(JLabel lblActualizar) {
        this.lblActualizar = lblActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblIdmod() {
        return lblIdmod;
    }

    public void setLblIdmod(JLabel lblIdmod) {
        this.lblIdmod = lblIdmod;
    }

    public JLabel getLblEliminarId() {
        return lblEliminarId;
    }

    public void setLblEliminarId(JLabel lblEliminarId) {
        this.lblEliminarId = lblEliminarId;
    }

    public JTextField getTxtElminarId() {
        return txtElminarId;
    }

    public void setTxtElminarId(JTextField txtElminarId) {
        this.txtElminarId = txtElminarId;
    }

    public void limpiar(){
            txtCategoria.setText("");
            txtCondecorado.setText("");
            txtNacionalidad.setText("");
            txtFecha.setText("");
            txtUrl.setText("");
        }
        public void limpiar2(){
            txtCategoriaMod.setText("");
            txtCondecoradoMod.setText("");
            txtNacionalidadMod.setText("");
            txtFechaMod.setText("");
            txtUrlMod.setText("");
    }
}
