package Interface.Pesquisar;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.dao.ModeloDAO;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PsqModelo extends JInternalFrame {
	private JTextField textField_modelo;
	private JTextField textField_Cat;
	private JTextField textField_Cambio;
	private JTextField textField_Direcao;
	private ModeloDAO MDAO;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsqModelo frame = new PsqModelo();
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
	public PsqModelo() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Pesquisar modelo de ve\u00EDculo");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		textField_modelo = new JTextField();
		textField_modelo.setColumns(10);
		textField_modelo.setBounds(10, 25, 341, 20);
		getContentPane().add(textField_modelo);
		
		textField_Cat = new JTextField();
		textField_Cat.setColumns(10);
		textField_Cat.setBounds(10, 72, 60, 20);
		getContentPane().add(textField_Cat);
		
		JLabel label_cat = new JLabel("Categoria");
		label_cat.setBounds(10, 56, 81, 14);
		getContentPane().add(label_cat);
		
		JLabel label_nPas = new JLabel("N\u00BA de passageiros");
		label_nPas.setBounds(10, 111, 116, 14);
		getContentPane().add(label_nPas);
		
		JFormattedTextField fTextField_NPas = new JFormattedTextField(ftm.getMaskInt());
		fTextField_NPas.setBounds(10, 126, 46, 20);
		getContentPane().add(fTextField_NPas);
		
		textField_Cambio = new JTextField();
		textField_Cambio.setColumns(10);
		textField_Cambio.setBounds(80, 72, 151, 20);
		getContentPane().add(textField_Cambio);
		
		JLabel label_cambio = new JLabel("C\u00E2mbio");
		label_cambio.setBounds(80, 56, 46, 14);
		getContentPane().add(label_cambio);
		
		JLabel label_modelo = new JLabel("Modelo");
		label_modelo.setBounds(10, 11, 46, 14);
		getContentPane().add(label_modelo);
		
		textField_Direcao = new JTextField();
		textField_Direcao.setColumns(10);
		textField_Direcao.setBounds(241, 72, 183, 20);
		getContentPane().add(textField_Direcao);
		
		JLabel label_direcao = new JLabel("Dire\u00E7\u00E3o");
		label_direcao.setBounds(243, 56, 46, 14);
		getContentPane().add(label_direcao);
		
		JComboBox comboBox_marca = new JComboBox();
		comboBox_marca.setBounds(361, 25, 63, 20);
		getContentPane().add(comboBox_marca);
		
		JLabel label_marca = new JLabel("Marca");
		label_marca.setBounds(362, 11, 46, 14);
		getContentPane().add(label_marca);
		
		JButton btnPesquisarModelo = new JButton("Pesquisar modelo");
		btnPesquisarModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MDAO = new ModeloDAO();
				MDAO.pesquisa();
			}
		});
		btnPesquisarModelo.setBounds(299, 236, 125, 23);
		getContentPane().add(btnPesquisarModelo);
		
		JButton btnExibirTodosOs = new JButton("Exibir todos os modelos");
		btnExibirTodosOs.setBounds(257, 208, 167, 23);
		getContentPane().add(btnExibirTodosOs);

	}

}
