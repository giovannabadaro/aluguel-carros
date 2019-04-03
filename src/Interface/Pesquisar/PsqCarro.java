package Interface.Pesquisar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Interface.FormatedTextMask;
import model.bean.Veiculo;
import model.dao.VeiculoDAO;

public class PsqCarro extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField_modelo;
	private JFormattedTextField textField_Placa;
	private JFormattedTextField textField_Chassi;
	private JTextField textField_cor;
	private JFormattedTextField textField_KM;
	private VeiculoDAO VDAO;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PsqCarro frame = new PsqCarro();
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
	public PsqCarro() throws ParseException {
		FormatedTextMask ftm = new FormatedTextMask();
		setClosable(true);
		setResizable(false);
		setTitle("Pesquisar Carro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(45, 20, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 23, 70, 14);
		contentPane.add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(296, 23, 70, 14);
		contentPane.add(lblMarca);
		
		JComboBox comboBox_Marca = new JComboBox();
		comboBox_Marca.setBounds(296, 39, 128, 20);
		contentPane.add(comboBox_Marca);
		
		textField_modelo = new JTextField();
		textField_modelo.setBounds(10, 39, 276, 20);
		contentPane.add(textField_modelo);
		textField_modelo.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 73, 46, 14);
		contentPane.add(lblPlaca);
		
		JFormattedTextField textField_Placa = new JFormattedTextField(ftm.getMaskPlaca());
		textField_Placa.setBounds(10, 86, 122, 20);
		contentPane.add(textField_Placa);
		textField_Placa.setColumns(10);
		
		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(152, 70, 46, 14);
		contentPane.add(lblChassi);
		
		textField_Chassi = new JFormattedTextField(ftm.getMaskChassi());
		textField_Chassi.setBounds(149, 86, 251, 20);
		contentPane.add(textField_Chassi);
		textField_Chassi.setColumns(17);
		
		JComboBox comboBox_cat = new JComboBox();
		comboBox_cat.setBounds(10, 132, 46, 20);
		contentPane.add(comboBox_cat);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 117, 62, 14);
		contentPane.add(lblCategoria);
		
		textField_cor = new JTextField();
		textField_cor.setColumns(10);
		textField_cor.setBounds(81, 132, 117, 20);
		contentPane.add(textField_cor);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(82, 117, 95, 14);
		contentPane.add(lblCor);
		
		textField_KM = new JFormattedTextField(ftm.getMaskInt());
		textField_KM.setColumns(10);
		textField_KM.setBounds(221, 132, 117, 20);
		contentPane.add(textField_KM);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(221, 117, 95, 14);
		contentPane.add(lblKm);
		
		JButton btnExibirTodosOs = new JButton("Exibir todos os carros");
		btnExibirTodosOs.setBounds(10, 227, 237, 23);
		contentPane.add(btnExibirTodosOs);
		
		JButton btnPesquisarCarro = new JButton("Pesquisar carro");
		btnPesquisarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VDAO = new VeiculoDAO();
				VDAO.pesquisa();
				
			}
		});
		btnPesquisarCarro.setBounds(10, 193, 138, 23);
		contentPane.add(btnPesquisarCarro);
	}

}
