package Interface.Inserir;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.bean.GeradorDeIds;
import model.bean.Modelo;
import model.dao.ModeloDAO;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsModelo extends JInternalFrame {
	private JTextField textField_modelo;
	private JTextField textField_cat;
	private JTextField textField_cambio;
	private JTextField textField_direcao;
	private Modelo model;
	private ModeloDAO ModelDAO;
	private JTextField textField_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsModelo frame = new InsModelo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public InsModelo() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		GeradorDeIds gid = new  GeradorDeIds();
		setClosable(true);
		setTitle("Inserir Novo modelo de Carro");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblModelo);
		
		textField_modelo = new JTextField();
		textField_modelo.setBounds(10, 25, 341, 20);
		getContentPane().add(textField_modelo);
		textField_modelo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(362, 11, 46, 14);
		getContentPane().add(lblMarca);
		
		JComboBox comboBox_marca = new JComboBox();
		comboBox_marca.setBounds(361, 25, 63, 20);
		getContentPane().add(comboBox_marca);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 56, 81, 14);
		getContentPane().add(lblCategoria);
		
		textField_cat = new JTextField();
		textField_cat.setBounds(10, 72, 60, 20);
		getContentPane().add(textField_cat);
		textField_cat.setColumns(10);
		
		JLabel lblCmbio = new JLabel("C\u00E2mbio");
		lblCmbio.setBounds(80, 56, 46, 14);
		getContentPane().add(lblCmbio);
		
		textField_cambio = new JTextField();
		textField_cambio.setBounds(80, 72, 151, 20);
		getContentPane().add(textField_cambio);
		textField_cambio.setColumns(10);
		
		JLabel lblDirecao = new JLabel("Dire\u00E7\u00E3o");
		lblDirecao.setBounds(243, 56, 46, 14);
		getContentPane().add(lblDirecao);
		
		textField_direcao = new JTextField();
		textField_direcao.setBounds(241, 72, 183, 20);
		getContentPane().add(textField_direcao);
		textField_direcao.setColumns(10);
		
		JLabel lblNDePassageiros = new JLabel("N\u00BA de passageiros");
		lblNDePassageiros.setBounds(10, 111, 116, 14);
		getContentPane().add(lblNDePassageiros);
		
		JFormattedTextField fTextField_NPassageiros = new JFormattedTextField(ftm.getMaskInt());
		fTextField_NPassageiros.setBounds(10, 126, 46, 20);
		getContentPane().add(fTextField_NPassageiros);
		
		JButton btnInserirModelo = new JButton("Inserir modelo");
		btnInserirModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String categoria = textField_cat.getText();
				String cambio = textField_cambio.getText();
				String direcao = textField_direcao.getText();
				String pass = fTextField_NPassageiros.getText();
				//String marca = comboBox_marca.getSelectedItem().toString();
				String id = textField_id.getText();
				model = new Modelo(id, categoria, cambio, direcao, pass);
				
				ModelDAO = new ModeloDAO();
				ModelDAO.Create(model);
			}
		});
		btnInserirModelo.setBounds(299, 236, 125, 23);
		getContentPane().add(btnInserirModelo);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(116, 111, 46, 14);
		getContentPane().add(lblId);
		
		textField_id = new JTextField();
		textField_id.setBounds(116, 126, 86, 20);
		getContentPane().add(textField_id);
		textField_id.setColumns(10);

	}

}
