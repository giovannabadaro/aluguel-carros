package Interface.Pesquisar;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import Interface.FormatedTextMask;
import model.bean.GeradorDeIds;
import model.dao.MotoristaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PsqMotorista extends JInternalFrame {
	private MotoristaDAO MDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsqMotorista frame = new PsqMotorista();
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
	public PsqMotorista() throws ParseException {
		setClosable(true);
		FormatedTextMask ftm = new FormatedTextMask();
		setTitle("Pesquisar motorista");
		setBounds(155, 20, 256, 300);
		getContentPane().setLayout(null);
		
		JFormattedTextField fTextField_rg = new JFormattedTextField(ftm.getMaskRG());
		fTextField_rg.setText("");
		fTextField_rg.setBounds(10, 26, 164, 20);
		getContentPane().add(fTextField_rg);
		
		JLabel label_RG = new JLabel("RG");
		label_RG.setBounds(12, 11, 46, 14);
		getContentPane().add(label_RG);
		
		JLabel label_CNH = new JLabel("N\u00FAmero CNH");
		label_CNH.setBounds(10, 54, 92, 14);
		getContentPane().add(label_CNH);
		
		JFormattedTextField fTextField_cnh = new JFormattedTextField(ftm.getMaskCNH());
		fTextField_cnh.setBounds(10, 69, 157, 20);
		getContentPane().add(fTextField_cnh);
		
		JLabel label_vencCnh = new JLabel("Vencimento da CNH");
		label_vencCnh.setBounds(10, 100, 118, 14);
		getContentPane().add(label_vencCnh);
		
		JFormattedTextField fTextField_vencCnh = new JFormattedTextField(ftm.getMaskData());
		fTextField_vencCnh.setBounds(10, 115, 118, 20);
		getContentPane().add(fTextField_vencCnh);
		
		JLabel label_idCliente = new JLabel("Id do Cliente");
		label_idCliente.setBounds(139, 100, 92, 14);
		getContentPane().add(label_idCliente);
		
		JFormattedTextField fTextField_id = new JFormattedTextField(ftm.getMaskInt());
		fTextField_id.setBounds(138, 115, 93, 20);
		getContentPane().add(fTextField_id);
		
		JButton btnProcurarMotorista = new JButton("Procurar motorista");
		btnProcurarMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MDAO = new MotoristaDAO();
				MDAO.pesquisa();
			}
		});
		btnProcurarMotorista.setBounds(90, 236, 141, 23);
		getContentPane().add(btnProcurarMotorista);
		
		JButton btnExibirTodosOs = new JButton("Exibir todos os motoristas");
		btnExibirTodosOs.setBounds(59, 210, 172, 23);
		getContentPane().add(btnExibirTodosOs);

	}

}
