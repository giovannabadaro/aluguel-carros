package Interface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Sobre extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setClosable(true);
		setTitle("Sobre o software");
		setBounds(45, 20, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblUniversidadeFederalDe = new JLabel("Universidade Federal de ouro Preto");
		lblUniversidadeFederalDe.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblUniversidadeFederalDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversidadeFederalDe.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUniversidadeFederalDe.setBounds(63, 11, 361, 14);
		getContentPane().add(lblUniversidadeFederalDe);
		
		JLabel lblSistemasDeInformao = new JLabel("Sistemas de informa\u00E7\u00E3o");
		lblSistemasDeInformao.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblSistemasDeInformao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemasDeInformao.setAlignmentX(0.5f);
		lblSistemasDeInformao.setBounds(63, 44, 361, 14);
		getContentPane().add(lblSistemasDeInformao);
		
		JLabel lblBancoDeDados = new JLabel("Banco de Dados I - Bruno Rabello Monteiro");
		lblBancoDeDados.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblBancoDeDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancoDeDados.setAlignmentX(0.5f);
		lblBancoDeDados.setBounds(63, 27, 361, 14);
		getContentPane().add(lblBancoDeDados);
		
		JLabel lblDesenvolvedores = new JLabel("Desenvolvedores:");
		lblDesenvolvedores.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDesenvolvedores.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesenvolvedores.setAlignmentX(0.5f);
		lblDesenvolvedores.setBounds(10, 111, 414, 14);
		getContentPane().add(lblDesenvolvedores);
		
		JLabel lblLarissa = new JLabel("Larissa");
		lblLarissa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLarissa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLarissa.setAlignmentX(0.5f);
		lblLarissa.setBounds(10, 192, 414, 14);
		getContentPane().add(lblLarissa);
		
		JLabel lblGabriel = new JLabel("Gabriel Augusto Requena dos Reis");
		lblGabriel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGabriel.setHorizontalAlignment(SwingConstants.CENTER);
		lblGabriel.setAlignmentX(0.5f);
		lblGabriel.setBounds(10, 131, 414, 14);
		getContentPane().add(lblGabriel);
		
		JLabel lblMarcos = new JLabel("Marcos");
		lblMarcos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMarcos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcos.setAlignmentX(0.5f);
		lblMarcos.setBounds(10, 171, 414, 14);
		getContentPane().add(lblMarcos);
		
		JLabel lblGiovana = new JLabel("Giovana");
		lblGiovana.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiovana.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiovana.setAlignmentX(0.5f);
		lblGiovana.setBounds(10, 151, 414, 14);
		getContentPane().add(lblGiovana);
		
		JLabel lblNewLabel = new JLabel("\u00A9Todos os direitos reservados 2018 ");
		lblNewLabel.setBounds(209, 245, 215, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/Images/backgroud.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 270);
		getContentPane().add(lblNewLabel_1);

	}

}
