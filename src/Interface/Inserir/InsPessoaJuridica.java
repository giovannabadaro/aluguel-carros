package Interface.Inserir;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.bean.GeradorDeIds;
import model.bean.PessoaFisica;
import model.bean.PessoaJuridica;
import model.dao.PessoaFisicaDAO;
import model.dao.PessoaJuridicaDAO;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsPessoaJuridica extends JInternalFrame {
	private JTextField textField_nome;
	private JTextField textField_Endereço;
	private PessoaJuridica PJ;
	private PessoaJuridicaDAO PJDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsPessoaJuridica frame = new InsPessoaJuridica();
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
	public InsPessoaJuridica() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Cadastrar Cliente Juridico");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		textField_nome = new JTextField();
		textField_nome.setColumns(10);
		textField_nome.setBounds(10, 32, 414, 20);
		getContentPane().add(textField_nome);
		
		JLabel label_nome = new JLabel("Nome");
		label_nome.setBounds(10, 11, 46, 14);
		getContentPane().add(label_nome);
		
		JLabel label_endereço = new JLabel("Endere\u00E7o");
		label_endereço.setBounds(10, 63, 46, 14);
		getContentPane().add(label_endereço);
		
		textField_Endereço = new JTextField();
		textField_Endereço.setColumns(10);
		textField_Endereço.setBounds(10, 77, 414, 20);
		getContentPane().add(textField_Endereço);
		
		JFormattedTextField fTextField_CNPJ = new JFormattedTextField(ftm.getMaskCnpj());
		fTextField_CNPJ.setBounds(10, 121, 154, 20);
		getContentPane().add(fTextField_CNPJ);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 108, 46, 14);
		getContentPane().add(lblCnpj);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(175, 108, 46, 14);
		getContentPane().add(lblId);
		
		JFormattedTextField fTextField_ID = new JFormattedTextField(ftm.getMaskInt());
		fTextField_ID.setBounds(174, 121, 91, 20);
		getContentPane().add(fTextField_ID);

		
		JButton button_CadastraClienteJur = new JButton("Cadastrar Cliente");
		button_CadastraClienteJur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_nome.getText();
				String cnpj = fTextField_CNPJ.getText();
			    String endereco = textField_Endereço.getText();
			    String id = fTextField_ID.getText();
			    
			    PJ = new PessoaJuridica(id, endereco, nome, cnpj);
			    PJDAO = new PessoaJuridicaDAO();
			    PJDAO.Create(PJ);
			}
		});
		button_CadastraClienteJur.setBounds(280, 236, 144, 23);
		getContentPane().add(button_CadastraClienteJur);
	}

}
