package Interface.Atualizar;

import java.awt.EventQueue;
import java.text.ParseException;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import Interface.FormatedTextMask;
import model.bean.Motorista;
import model.dao.MotoristaDAO;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttMotorista extends JInternalFrame {
	private JFormattedTextField fTextField_DataCNH;
	private Motorista mot;
	private MotoristaDAO motDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttMotorista frame = new AttMotorista();
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
	public AttMotorista() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Atualizar cadastro de motorista");
		setBounds(155, 20, 252, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_CNH = new JLabel("N\u00FAmero CNH");
		lblNewLabel_CNH.setBounds(10, 54, 92, 14);
		getContentPane().add(lblNewLabel_CNH);
		
		JFormattedTextField fTextField_CNH = new JFormattedTextField(ftm.getMaskCNH());
		fTextField_CNH.setBounds(10, 69, 157, 20);
		getContentPane().add(fTextField_CNH);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(12, 11, 46, 14);
		getContentPane().add(lblRg);
		
		JFormattedTextField fTextField_RG = new JFormattedTextField(ftm.getMaskRG());
		fTextField_RG.setText("");
		fTextField_RG.setBounds(10, 26, 164, 20);
		getContentPane().add(fTextField_RG);
		
		JLabel lblVencimentoDaCnh = new JLabel("Vencimento da CNH");
		lblVencimentoDaCnh.setBounds(10, 100, 118, 14);
		getContentPane().add(lblVencimentoDaCnh);
		
		fTextField_DataCNH = new JFormattedTextField();
		fTextField_DataCNH.setBounds(10, 115, 118, 20);
		getContentPane().add(fTextField_DataCNH);
		
		JLabel lblIdDoCliente = new JLabel("Id do Cliente");
		lblIdDoCliente.setBounds(139, 100, 92, 14);
		getContentPane().add(lblIdDoCliente);
		
		JFormattedTextField fTextField_cliente = new JFormattedTextField(ftm.getMaskInt());
		fTextField_cliente.setBounds(138, 115, 93, 20);
		getContentPane().add(fTextField_cliente);
		
		JButton btnNewButton = new JButton("Atualizar motorista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnh = fTextField_CNH.getText();
				String rg = fTextField_RG.getText();
				String venc = fTextField_DataCNH.getText();
				String id = fTextField_cliente.getText();
				mot = new Motorista(cnh, rg, venc, id);
				motDAO = new MotoristaDAO();
				motDAO.Atualizar(mot);
				
			}
		});
		btnNewButton.setBounds(87, 236, 141, 23);
		getContentPane().add(btnNewButton);

	}

}
