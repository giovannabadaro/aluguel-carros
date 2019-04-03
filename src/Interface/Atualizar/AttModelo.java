package Interface.Atualizar;

import java.awt.EventQueue;
import java.text.ParseException;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Interface.FormatedTextMask;
import model.bean.Modelo;
import model.dao.ModeloDAO;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttModelo extends JInternalFrame {
	private JTextField textField_cat;
	private JTextField textField_modelo;
	private JTextField textField_cambio;
	private JTextField textField_direcao;	
	private Modelo model;
	private ModeloDAO ModelDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttModelo frame = new AttModelo();
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
	public AttModelo() throws ParseException {
		setTitle("Atualizar modelo de ve\u00EDculo");
		FormatedTextMask ftm = new FormatedTextMask();
		setClosable(true);
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		JFormattedTextField fTextField_NPas = new JFormattedTextField(ftm.getMaskInt());
		fTextField_NPas.setBounds(10, 126, 46, 20);
		getContentPane().add(fTextField_NPas);
		
		JLabel label_pass = new JLabel("N\u00BA de passageiros");
		label_pass.setBounds(10, 111, 116, 14);
		getContentPane().add(label_pass);
		
		textField_cat = new JTextField();
		textField_cat.setColumns(10);
		textField_cat.setBounds(10, 72, 60, 20);
		getContentPane().add(textField_cat);
		
		JLabel label_cat = new JLabel("Categoria");
		label_cat.setBounds(10, 56, 81, 14);
		getContentPane().add(label_cat);
		
		textField_modelo = new JTextField();
		textField_modelo.setColumns(10);
		textField_modelo.setBounds(10, 25, 341, 20);
		getContentPane().add(textField_modelo);
		
		JLabel label_modelo = new JLabel("Modelo");
		label_modelo.setBounds(10, 11, 46, 14);
		getContentPane().add(label_modelo);
		
		textField_cambio = new JTextField();
		textField_cambio.setColumns(10);
		textField_cambio.setBounds(80, 72, 151, 20);
		getContentPane().add(textField_cambio);
		
		JLabel label_cambio = new JLabel("C\u00E2mbio");
		label_cambio.setBounds(80, 56, 46, 14);
		getContentPane().add(label_cambio);
		
		textField_direcao = new JTextField();
		textField_direcao.setColumns(10);
		textField_direcao.setBounds(241, 72, 183, 20);
		getContentPane().add(textField_direcao);
		
		JLabel label_dir = new JLabel("Dire\u00E7\u00E3o");
		label_dir.setBounds(243, 56, 46, 14);
		getContentPane().add(label_dir);
		
		JComboBox comboBox_marca = new JComboBox();
		comboBox_marca.setBounds(361, 25, 63, 20);
		getContentPane().add(comboBox_marca);
		
		JLabel label_marca = new JLabel("Marca");
		label_marca.setBounds(362, 11, 46, 14);
		getContentPane().add(label_marca);
		
		JButton btnAtualizarModelo = new JButton("Atualizar modelo");
		btnAtualizarModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String categoria = textField_cat.getText();
				String cambio = textField_cambio.getText();
				String direcao = textField_direcao.getText();
				String pass = fTextField_NPas.getText();
				String marca = comboBox_marca.getSelectedItem().toString();
				model = new Modelo(categoria, cambio, direcao, pass, marca);
				
				ModelDAO = new ModeloDAO();
				ModelDAO.Atualizar(model);
			}
		});
		btnAtualizarModelo.setBounds(299, 236, 125, 23);
		getContentPane().add(btnAtualizarModelo);

	}

}
