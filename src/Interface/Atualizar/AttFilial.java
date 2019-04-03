package Interface.Atualizar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.bean.Filial;
import model.bean.GeradorDeIds;
import model.dao.FilialDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttFilial extends JInternalFrame {
	private JTextField textField_endereço;
	private Filial fil;
	private FilialDAO FDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttFilial frame = new AttFilial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AttFilial() {
		setClosable(true);
		setTitle("Atualizar cadastro de filial");
		setBounds(155, 20, 249, 300);
		getContentPane().setLayout(null);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 11, 106, 14);
		getContentPane().add(lblEndereo);
		
		textField_endereço = new JTextField();
		textField_endereço.setBounds(10, 32, 213, 20);
		getContentPane().add(textField_endereço);
		textField_endereço.setColumns(10);
		
		JButton btnAttFilial = new JButton("Atualizar filial");
		btnAttFilial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String endereco = textField_endereço.getText();
				fil = new Filial(endereco);
				FDAO = new FilialDAO();
				FDAO.Atualizar(fil);
			}
		});
		btnAttFilial.setBounds(68, 236, 155, 23);
		getContentPane().add(btnAttFilial);

	}

}
