package Interface.Pesquisar;

import java.awt.EventQueue;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.dao.PessoaJuridicaDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
;

public class PsqPessoaJuridica extends JInternalFrame {
	private JTextField textFieldNomeCliente;
	private PessoaJuridicaDAO PJDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsqPessoaJuridica frame = new PsqPessoaJuridica();
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
	public PsqPessoaJuridica() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		setClosable(true);
		setTitle("Pesquisar Pessoa Jur\u00EDdica");
		setBounds(155, 20, 245, 300);
		getContentPane().setLayout(null);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setColumns(10);
		textFieldNomeCliente.setBounds(10, 26, 213, 20);
		getContentPane().add(textFieldNomeCliente);
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		labelNomeCliente.setBounds(10, 11, 160, 14);
		getContentPane().add(labelNomeCliente);
		
		JLabel labelCnpj = new JLabel("CNPJ");
		labelCnpj.setBounds(10, 57, 76, 14);
		getContentPane().add(labelCnpj);
		
		JButton button = new JButton("Pesquisar cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PJDAO = new PessoaJuridicaDAO();
						PJDAO.pesquisa();
			}
		});
		button.setBounds(10, 182, 146, 23);
		getContentPane().add(button);
		
		JButton btnExibirTodosOs = new JButton("Exibir todos os clientes jur\u00EDdicos");
		btnExibirTodosOs.setBounds(10, 216, 213, 23);
		getContentPane().add(btnExibirTodosOs);
		
		
		JFormattedTextField TextFieldCNPJ = new JFormattedTextField(ftm.getMaskCnpj());
		TextFieldCNPJ.setBounds(10, 75, 146, 20);
		getContentPane().add(TextFieldCNPJ);

	}
}
