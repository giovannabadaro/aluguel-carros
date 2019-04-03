package Interface.Pesquisar;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Interface.FormatedTextMask;
import model.dao.PessoaFisicaDAO;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PsqPessoaFisica extends JInternalFrame {
	private JTextField textFieldNomeCliente;
	private PessoaFisicaDAO PFDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsqPessoaFisica frame = new PsqPessoaFisica();
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
	public PsqPessoaFisica() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		setClosable(true);
		setTitle("Pesquisar Pessoa F\u00EDsica");
		setBounds(155, 20, 245, 300);
		getContentPane().setLayout(null);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setColumns(10);
		textFieldNomeCliente.setBounds(10, 26, 213, 20);
		getContentPane().add(textFieldNomeCliente);
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		labelNomeCliente.setBounds(10, 11, 160, 14);
		getContentPane().add(labelNomeCliente);
		
		JLabel labelCpf = new JLabel("CPF");
		labelCpf.setBounds(10, 57, 76, 14);
		getContentPane().add(labelCpf);
		
		JFormattedTextField TextFieldCPF = new JFormattedTextField(ftm.getMaskCpf());
		TextFieldCPF.setColumns(10);
		TextFieldCPF.setBounds(10, 75, 213, 20);
		getContentPane().add(TextFieldCPF);
		
		JLabel labelDataNasc = new JLabel("Data de nascimento");
		labelDataNasc.setBounds(10, 106, 146, 14);
		getContentPane().add(labelDataNasc);
		
		JFormattedTextField TextFieldDataNAsc = new JFormattedTextField(ftm.getMaskData());
		TextFieldDataNAsc.setToolTipText("");
		TextFieldDataNAsc.setText("");
		TextFieldDataNAsc.setColumns(10);
		TextFieldDataNAsc.setBounds(10, 122, 160, 20);
		getContentPane().add(TextFieldDataNAsc);
		
		JButton button = new JButton("Pesquisar cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PFDAO = new PessoaFisicaDAO();
				PFDAO.pesquisa();
			}
		});
		button.setBounds(10, 185, 146, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Exibir todos os clientes f\u00EDsicos");
		button_1.setBounds(10, 219, 213, 23);
		getContentPane().add(button_1);

	}

}
