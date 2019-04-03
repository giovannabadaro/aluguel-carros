package Interface.Pesquisar;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.dao.FilialDAO;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PsqFilial extends JInternalFrame {
	private JTextField textFieldEnderecoFilial;
	private JTextField textField_nome;
	private FilialDAO FDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsqFilial frame = new PsqFilial();
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
	public PsqFilial() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Pesquisar Filial");
		setBounds(155, 20, 248, 281);
		getContentPane().setLayout(null);
		
		JLabel lblEnderecoDaFilial = new JLabel("Endere\u00E7o da Filial");
		lblEnderecoDaFilial.setBounds(10, 53, 160, 14);
		getContentPane().add(lblEnderecoDaFilial);
		
		textFieldEnderecoFilial = new JTextField();
		textFieldEnderecoFilial.setColumns(10);
		textFieldEnderecoFilial.setBounds(10, 68, 213, 20);
		getContentPane().add(textFieldEnderecoFilial);
		
		JLabel lblIdDaFilial = new JLabel("Id da Filial");
		lblIdDaFilial.setBounds(10, 99, 76, 14);
		getContentPane().add(lblIdDaFilial);
		
		JFormattedTextField TextFieldIdFilial = new JFormattedTextField(ftm.getMaskInt());
		TextFieldIdFilial.setBounds(10, 117, 146, 20);
		getContentPane().add(TextFieldIdFilial);
		
		JButton btnPesquisarFilial = new JButton("Pesquisar filial");
		btnPesquisarFilial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FDAO = new FilialDAO();
				FDAO.pesquisa();
			}
		});
		btnPesquisarFilial.setBounds(10, 182, 146, 23);
		getContentPane().add(btnPesquisarFilial);
		
		JButton btnExibirTodasAs = new JButton("Exibir todas as filiais");
		btnExibirTodasAs.setBounds(10, 216, 213, 23);
		getContentPane().add(btnExibirTodasAs);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(10, 25, 213, 20);
		getContentPane().add(textField_nome);
		textField_nome.setColumns(10);

	}
}
