package Interface.Inserir;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.bean.GeradorDeIds;
import model.bean.PessoaFisica;
import model.dao.PessoaFisicaDAO;
import model.dao.PessoaJuridicaDAO;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class InsPessoaFisica extends JInternalFrame {
	private JTextField textField_Nome = null;
	private JTextField textField_Endereço = null;
	private PessoaFisica PF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsPessoaFisica frame = new InsPessoaFisica();
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
	public InsPessoaFisica() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		GeradorDeIds gid = new  GeradorDeIds();
		setTitle("Cadastrar Cliente Fisico");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(10, 32, 354, 20);
		getContentPane().add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(378, 11, 46, 14);
		getContentPane().add(lblSexo);
		
		JComboBox comboBox_Sexo = new JComboBox();
		comboBox_Sexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_Sexo.setToolTipText("M\r\nF");
		comboBox_Sexo.setBounds(374, 32, 50, 20);
		getContentPane().add(comboBox_Sexo);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 108, 46, 14);
		getContentPane().add(lblCpf);
		
		JFormattedTextField fTextField_CPF = new JFormattedTextField(ftm.getMaskCpf());
		fTextField_CPF.setBounds(10, 121, 144, 20);
		getContentPane().add(fTextField_CPF);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 63, 46, 14);
		getContentPane().add(lblEndereo);
		
		textField_Endereço = new JTextField();
		textField_Endereço.setBounds(10, 77, 414, 20);
		getContentPane().add(textField_Endereço);
		textField_Endereço.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(184, 108, 112, 14);
		getContentPane().add(lblDataDeNascimento);
		
		JFormattedTextField fTextField_DataNasc = new JFormattedTextField(ftm.getMaskData());
		fTextField_DataNasc.setBounds(184, 121, 107, 20);
		getContentPane().add(fTextField_DataNasc);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(307, 108, 46, 14);
		getContentPane().add(lblId);
		
		JFormattedTextField fTextField_ID = new JFormattedTextField(ftm.getMaskInt());
		fTextField_ID.setBounds(306, 121, 71, 20);
		getContentPane().add(fTextField_ID);
		
		JButton btnCadasctraClienteFis = new JButton("Cadastrar Cliente");
		btnCadasctraClienteFis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textField_Nome.getText();
				String cpf = fTextField_CPF.getText();
			    String sexo = comboBox_Sexo.getSelectedItem().toString();
			    String endereco = textField_Endereço.getText();
			    String nasc = fTextField_DataNasc.getText();
			    String id = fTextField_ID.getText();
			    
			    PF = new PessoaFisica(cpf, sexo, nasc, id , endereco, nome);
			    PessoaFisicaDAO PFDAO = new PessoaFisicaDAO();
			    PFDAO = new PessoaFisicaDAO();
			    PFDAO.Create(PF);
				
			}
		});
		btnCadasctraClienteFis.setBounds(280, 236, 144, 23);
		getContentPane().add(btnCadasctraClienteFis);
		
		

	}
}
