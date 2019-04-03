package Interface.Atualizar;

import java.awt.EventQueue;
import java.text.ParseException;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import Interface.FormatedTextMask;
import model.bean.PessoaJuridica;
import model.dao.PessoaJuridicaDAO;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttPessoaJuridica extends JInternalFrame {
	private JTextField textField_end;
	private JTextField textField_nome;
	private PessoaJuridica PJ;
	private PessoaJuridicaDAO PJDAO;
	private JTextField textField_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttPessoaJuridica frame = new AttPessoaJuridica();
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
	public AttPessoaJuridica() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Atualizar cadastro de cliente jur\u00EDdico");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		JFormattedTextField fTextField_cnpj = new JFormattedTextField(ftm.getMaskCnpj());
		fTextField_cnpj.setBounds(10, 121, 154, 20);
		getContentPane().add(fTextField_cnpj);
		
		JButton btnAtualizarCliente = new JButton("Atualizar Cliente");
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_nome.getText();
				String cnpj = fTextField_cnpj.getText();
			    String endereco = textField_end.getText();
			    String id = textField_id.getText();
			    
			    PJ = new PessoaJuridica(cnpj, nome, endereco, id);
			    PJDAO = new PessoaJuridicaDAO();
			    PJDAO.Atualizar(PJ);;
				
			}
		});
		btnAtualizarCliente.setBounds(280, 236, 144, 23);
		getContentPane().add(btnAtualizarCliente);
		
		textField_end = new JTextField();
		textField_end.setColumns(10);
		textField_end.setBounds(10, 77, 414, 20);
		getContentPane().add(textField_end);
		
		JLabel label_end = new JLabel("Endere\u00E7o");
		label_end.setBounds(10, 63, 46, 14);
		getContentPane().add(label_end);
		
		textField_nome = new JTextField();
		textField_nome.setColumns(10);
		textField_nome.setBounds(10, 32, 414, 20);
		getContentPane().add(textField_nome);
		
		JLabel label_nome = new JLabel("Nome");
		label_nome.setBounds(10, 11, 46, 14);
		getContentPane().add(label_nome);
		
		JLabel label_CNPJ = new JLabel("CNPJ");
		label_CNPJ.setBounds(10, 108, 46, 14);
		getContentPane().add(label_CNPJ);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(185, 108, 46, 14);
		getContentPane().add(lblId);
		
		textField_id = new JTextField();
		textField_id.setBounds(185, 121, 86, 20);
		getContentPane().add(textField_id);
		textField_id.setColumns(10);

	}

}
