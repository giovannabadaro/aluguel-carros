package Interface.Inserir;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.text.html.parser.Parser;

import Interface.FormatedTextMask;
import model.bean.GeradorDeIds;
import model.bean.Veiculo;
import model.dao.VeiculoDAO;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsCarro extends JInternalFrame {
	private JTextField textField_Modelo;
	private JTextField textField_Cor;
	private JTextField textField_Marca;
	private Veiculo vec;
	private VeiculoDAO VDAO;
	private JTextField textField_filial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsCarro frame = new InsCarro();
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
	public InsCarro() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		
		setTitle("Cadastrar ve\u00EDculo");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		textField_Modelo = new JTextField();
		textField_Modelo.setColumns(10);
		textField_Modelo.setBounds(10, 27, 276, 20);
		getContentPane().add(textField_Modelo);
		
		JLabel label_Modelo = new JLabel("Modelo");
		label_Modelo.setBounds(10, 11, 70, 14);
		getContentPane().add(label_Modelo);
		
		JLabel label_Placa = new JLabel("Placa");
		label_Placa.setBounds(10, 61, 46, 14);
		getContentPane().add(label_Placa);
		
		JFormattedTextField fTextField_Placa = new JFormattedTextField(ftm.getMaskPlaca());
		fTextField_Placa.setColumns(10);
		fTextField_Placa.setBounds(10, 74, 122, 20);
		getContentPane().add(fTextField_Placa);
		
		JLabel label_Categoria = new JLabel("Categoria");
		label_Categoria.setBounds(10, 105, 62, 14);
		getContentPane().add(label_Categoria);
		
		textField_Cor = new JTextField();
		textField_Cor.setColumns(10);
		textField_Cor.setBounds(81, 120, 117, 20);
		getContentPane().add(textField_Cor);
		
		JLabel label_Cor = new JLabel("Cor");
		label_Cor.setBounds(82, 105, 95, 14);
		getContentPane().add(label_Cor);
		
		JFormattedTextField fTextField_Chassi = new JFormattedTextField(ftm.getMaskChassi());
		fTextField_Chassi.setColumns(17);
		fTextField_Chassi.setBounds(149, 74, 251, 20);
		getContentPane().add(fTextField_Chassi);
		
		JLabel label_Chassi = new JLabel("Chassi");
		label_Chassi.setBounds(152, 58, 46, 14);
		getContentPane().add(label_Chassi);
		
		JLabel label_KM = new JLabel("KM");
		label_KM.setBounds(221, 105, 95, 14);
		getContentPane().add(label_KM);
		
		JFormattedTextField fTextField_KM = new JFormattedTextField(ftm.getMaskInt());
		fTextField_KM.setColumns(10);
		fTextField_KM.setBounds(221, 120, 117, 20);
		getContentPane().add(fTextField_KM);
		
		JLabel label_Marca = new JLabel("Marca");
		label_Marca.setBounds(296, 11, 70, 14);
		getContentPane().add(label_Marca);
	
		
		textField_Marca = new JTextField();
		textField_Marca.setColumns(10);
		textField_Marca.setBounds(296, 27, 117, 20);
		getContentPane().add(textField_Marca);
		
		JFormattedTextField fTextField_Categoria = new JFormattedTextField(ftm.getMaskChar());
		fTextField_Categoria.setColumns(17);
		fTextField_Categoria.setBounds(10, 120, 46, 20);
		getContentPane().add(fTextField_Categoria);
		
		JLabel lblUltimaReviso = new JLabel("Ultima Revis\u00E3o");
		lblUltimaReviso.setBounds(10, 151, 88, 14);
		getContentPane().add(lblUltimaReviso);
		
		JTextField TextField_UltimaRev = new JTextField();
		TextField_UltimaRev.setBounds(10, 167, 122, 20);
		getContentPane().add(TextField_UltimaRev);
		
		JButton btnInserirCarro = new JButton("Inserir carro");
		btnInserirCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String placa = fTextField_Placa.getText();
				String chassi = fTextField_Chassi.getText();
				String cor = textField_Cor.getText();
				String km = fTextField_KM.getText();
				java.util.Date date = new Date();
				String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
				String ultimaRevisao = TextField_UltimaRev.getText();
				String modelo_codigo = textField_Modelo.getText();
				String filial = textField_filial.getText();
				
				vec = new Veiculo(placa, chassi, cor, km, data, ultimaRevisao, filial , modelo_codigo);
				VDAO = new VeiculoDAO();
				VDAO.Create(vec);
				
			}
		});
		btnInserirCarro.setBounds(286, 236, 138, 23);
		getContentPane().add(btnInserirCarro);
		
		JLabel lblFilial = new JLabel("filial");
		lblFilial.setBounds(152, 151, 46, 14);
		getContentPane().add(lblFilial);
		
		textField_filial = new JTextField();
		textField_filial.setBounds(149, 167, 49, 20);
		getContentPane().add(textField_filial);
		textField_filial.setColumns(10);
		
		

	}
}
