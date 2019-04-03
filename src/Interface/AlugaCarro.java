package Interface;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.bean.Reserva;
import model.dao.ReservaDAO;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlugaCarro extends JInternalFrame {
	private JTextField textField_idCliente;
	private ReservaDAO RDAO;
	private Reserva reserv;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlugaCarro frame = new AlugaCarro();
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
	public AlugaCarro() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		setClosable(true);
		setTitle("Alugar Carro");
		setBounds(85, 20, 364, 300);
		getContentPane().setLayout(null);
		
		JLabel lblIdCLiente = new JLabel("ID do Cliente");
		lblIdCLiente.setBounds(10, 11, 122, 14);
		getContentPane().add(lblIdCLiente);
		
		textField_idCliente = new JTextField();
		textField_idCliente.setBounds(10, 27, 105, 20);
		getContentPane().add(textField_idCliente);
		textField_idCliente.setColumns(10);
		
		JLabel lblDataDeRetirada = new JLabel("Data de retirada");
		lblDataDeRetirada.setBounds(10, 58, 97, 14);
		getContentPane().add(lblDataDeRetirada);
		
		JLabel lblDataDeDevoluo = new JLabel("Data de devolu\u00E7\u00E3o");
		lblDataDeDevoluo.setBounds(143, 58, 105, 14);
		getContentPane().add(lblDataDeDevoluo);
		
		JFormattedTextField fTextField_DataRetirada = new JFormattedTextField(ftm.getMaskData());
		fTextField_DataRetirada.setBounds(10, 72, 97, 20);
		getContentPane().add(fTextField_DataRetirada);
		
		JFormattedTextField fTextField_DataDevolucao = new JFormattedTextField(ftm.getMaskData());
		fTextField_DataDevolucao.setBounds(143, 72, 97, 20);
		getContentPane().add(fTextField_DataDevolucao);
		
		JLabel lblCategoriaDoCarro = new JLabel("Modelo do carro ");
		lblCategoriaDoCarro.setBounds(128, 11, 129, 14);
		getContentPane().add(lblCategoriaDoCarro);
		
		JComboBox comboBox_ModeloDisp = new JComboBox();
		comboBox_ModeloDisp.setBounds(125, 27, 64, 20);
		getContentPane().add(comboBox_ModeloDisp);
		
		JLabel lblFilialDeRetirada = new JLabel("Filial de Retirada");
		lblFilialDeRetirada.setBounds(10, 103, 97, 14);
		getContentPane().add(lblFilialDeRetirada);
		
		JComboBox comboBox_FilialRetirada = new JComboBox();
		comboBox_FilialRetirada.setBounds(10, 118, 148, 20);
		getContentPane().add(comboBox_FilialRetirada);
		
		JLabel lblFilialDeDevoluo = new JLabel("Filial de Devolu\u00E7\u00E3o");
		lblFilialDeDevoluo.setBounds(188, 103, 105, 14);
		getContentPane().add(lblFilialDeDevoluo);
		
		JComboBox comboBox_filialdev = new JComboBox();
		comboBox_filialdev.setBounds(188, 118, 148, 20);
		getContentPane().add(comboBox_filialdev);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 149, 46, 14);
		getContentPane().add(lblPreo);
		
		JFormattedTextField fTextField_Valor = new JFormattedTextField();
		fTextField_Valor.setBounds(10, 164, 105, 20);
		getContentPane().add(fTextField_Valor);
		
		
		JButton btnReservarCarro = new JButton("Reservar carro");
		btnReservarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataRet = fTextField_DataRetirada.getText();
				String dataDev = fTextField_DataDevolucao.getText();
				String FilialOrig = comboBox_FilialRetirada.getSelectedItem().toString();
				String Filialdest = comboBox_filialdev.getSelectedItem().toString();
				String ModeloCod = comboBox_ModeloDisp.getSelectedItem().toString();
				String custo = fTextField_Valor.getText();
				String ClienteID = textField_idCliente.getText();
			
				reserv = new Reserva(dataRet, dataDev, FilialOrig, Filialdest, ClienteID, ModeloCod, custo);
				
				RDAO = new ReservaDAO();
				RDAO.Create(reserv);
			}
		});
		btnReservarCarro.setBounds(207, 236, 129, 23);
		getContentPane().add(btnReservarCarro);

	}
}
