package Interface.Atualizar;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import Interface.FormatedTextMask;
import model.bean.PessoaFisica;
import model.dao.PessoaFisicaDAO;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttPessoaFisica extends JInternalFrame {
	private JTextField textField_nome;
	private JTextField textField_end;
	private PessoaFisicaDAO PFDAO;
	private PessoaFisica PF;
	private JTextField textField_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttPessoaFisica frame = new AttPessoaFisica();
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
	public AttPessoaFisica() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Atualizar cadastro de Cliente F\u00EDsico");
		setClosable(true);
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		textField_nome = new JTextField();
		textField_nome.setColumns(10);
		textField_nome.setBounds(10, 32, 354, 20);
		getContentPane().add(textField_nome);
		
		JComboBox comboBox_sexo = new JComboBox();
		comboBox_sexo.setToolTipText("M\r\nF");
		comboBox_sexo.setBounds(374, 32, 50, 20);
		getContentPane().add(comboBox_sexo);
		
		JLabel label_sexo = new JLabel("Sexo");
		label_sexo.setBounds(378, 11, 46, 14);
		getContentPane().add(label_sexo);
		
		JLabel label_Nome = new JLabel("Nome");
		label_Nome.setBounds(10, 11, 46, 14);
		getContentPane().add(label_Nome);
		
		JLabel label_end = new JLabel("Endere\u00E7o");
		label_end.setBounds(10, 63, 46, 14);
		getContentPane().add(label_end);
		
		textField_end = new JTextField();
		textField_end.setColumns(10);
		textField_end.setBounds(10, 77, 414, 20);
		getContentPane().add(textField_end);
		
		JLabel label_cpf = new JLabel("CPF");
		label_cpf.setBounds(10, 108, 46, 14);
		getContentPane().add(label_cpf);
		
		JFormattedTextField fTextField_cpf = new JFormattedTextField(ftm.getMaskCpf());
		fTextField_cpf.setBounds(10, 121, 144, 20);
		getContentPane().add(fTextField_cpf);
		
		JLabel label_nasc = new JLabel("Data de Nascimento");
		label_nasc.setBounds(184, 108, 112, 14);
		getContentPane().add(label_nasc);
		
		JFormattedTextField fTextField_datanasc = new JFormattedTextField(ftm.getMaskData());
		fTextField_datanasc.setBounds(184, 121, 107, 20);
		getContentPane().add(fTextField_datanasc);
		
		JButton btnAtualizarCadastro = new JButton("Atualizar cadastro");
		btnAtualizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_nome.getText();
				String cpf = fTextField_cpf.getText();
			    String sexo = comboBox_sexo.getSelectedItem().toString();
			    String endereco = textField_end.getText();
			    String nasc = fTextField_datanasc.getText();
			    String id = textField_id.getText();
			    
			    PF = new PessoaFisica(cpf, sexo, nasc, id, endereco, nome);
				PFDAO = new PessoaFisicaDAO();
				PFDAO.Atualizar(PF);
				
			}
		});
		btnAtualizarCadastro.setBounds(280, 236, 144, 23);
		getContentPane().add(btnAtualizarCadastro);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(306, 108, 46, 14);
		getContentPane().add(lblId);
		
		textField_id = new JTextField();
		textField_id.setBounds(302, 121, 86, 20);
		getContentPane().add(textField_id);
		textField_id.setColumns(10);

	}
}
