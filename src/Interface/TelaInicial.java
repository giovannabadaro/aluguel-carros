package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import Interface.Atualizar.*;
import Interface.Inserir.*;
import Interface.Pesquisar.*;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("UseMeuCarro - UFOP 2018");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 425);
		
		//Barra de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(10, 11, 539, 343);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/Images/logo.JPG")));
		lblNewLabel.setBounds(122, 53, 315, 237);
		desktopPane.add(lblNewLabel);
		
		//Menu Inserir
		JMenu mnInserir = new JMenu("Inserir");
		menuBar.add(mnInserir);
		
		JMenuItem mnINSPessoafisica = new JMenuItem("PessoaFisica");
		mnINSPessoafisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsPessoaFisica INSFisica = new InsPessoaFisica();
					desktopPane.add(INSFisica);
					INSFisica.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnInserir.add(mnINSPessoafisica);
		
		JMenuItem mnINSPessoaJurdica = new JMenuItem("Pessoa Jur\u00EDdica");
		mnINSPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsPessoaJuridica INSJuridica = new InsPessoaJuridica();
					desktopPane.add(INSJuridica);
					INSJuridica.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnInserir.add(mnINSPessoaJurdica);
		
		JMenuItem mnINSCarro = new JMenuItem("Carro");
		mnINSCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsCarro INSCarro = new InsCarro();
					desktopPane.add(INSCarro);
					INSCarro.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JMenuItem mntmMotorista = new JMenuItem("Motorista");
		mntmMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsMotorista InsMot = new InsMotorista();
					desktopPane.add(InsMot);
					InsMot.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnInserir.add(mntmMotorista);
		mnInserir.add(mnINSCarro);
		
		JMenuItem mnINSFilial = new JMenuItem("Filial");
		mnINSFilial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsFilial INSFilial = new InsFilial();
				desktopPane.add(INSFilial);
				INSFilial.setVisible(true);
			}
		});
		mnInserir.add(mnINSFilial);
		
		//Menu Pesquisar
		JMenu mnPesquisar = new JMenu("Pesquisar");
		menuBar.add(mnPesquisar);
		
		JMenuItem mnPSQPessoaFsica = new JMenuItem("Pessoa F\u00EDsica");
		mnPSQPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PsqPessoaFisica PSQFisica = new PsqPessoaFisica();
					desktopPane.add(PSQFisica);
					PSQFisica.setVisible(true);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnPesquisar.add(mnPSQPessoaFsica);
		
		JMenuItem mnPSQPessoaJurdica = new JMenuItem("Pessoa Jur\u00EDdica");
		mnPSQPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PsqPessoaJuridica PSQJuridica = new PsqPessoaJuridica();
					desktopPane.add(PSQJuridica);
					PSQJuridica.setVisible(true);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnPesquisar.add(mnPSQPessoaJurdica);
		
		JMenuItem mnPSQCarro = new JMenuItem("Carro");
		mnPSQCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PsqCarro PSQCarro;
				try {
					PSQCarro = new PsqCarro();
					desktopPane.add(PSQCarro);
					PSQCarro.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmMotorista_1 = new JMenuItem("Motorista");
		mntmMotorista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PsqMotorista PSQMot;
				try {
					PSQMot = new PsqMotorista();
					desktopPane.add(PSQMot);
					PSQMot.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnPesquisar.add(mntmMotorista_1);
		mnPesquisar.add(mnPSQCarro);
		
		JMenuItem mnPSQFilial = new JMenuItem("Filial");
		mnPSQFilial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PsqFilial PSQFilial =  new PsqFilial();
					desktopPane.add(PSQFilial);
					PSQFilial.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnPesquisar.add(mnPSQFilial);
		
		//Menu Atualizar
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmPessoaFsica = new JMenuItem("Pessoa F\u00EDsica");
		mntmPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AttPessoaFisica ATTFisica = new AttPessoaFisica();
					desktopPane.add(ATTFisica);
					ATTFisica.setVisible(true);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAtualizar.add(mntmPessoaFsica);
		
		JMenuItem mntmPessoaJuridica = new JMenuItem("Pessoa Juridica");
		mntmPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AttPessoaJuridica ATTJuridica = new AttPessoaJuridica();
					desktopPane.add(ATTJuridica);
					ATTJuridica.setVisible(true);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAtualizar.add(mntmPessoaJuridica);
		
		JMenuItem mntmMotorista_2 = new JMenuItem("Motorista");
		mntmMotorista_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AttMotorista ATTMot = new AttMotorista();
					desktopPane.add(ATTMot);
					ATTMot.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAtualizar.add(mntmMotorista_2);
		
		JMenuItem mntmCarro = new JMenuItem("Carro");
		mntmCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AttCarro ATTCarro = new AttCarro();
					desktopPane.add(ATTCarro);
					ATTCarro.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAtualizar.add(mntmCarro);
		
		JMenuItem mntmFilial = new JMenuItem("Filial");
		mntmFilial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttFilial AttFilial =  new AttFilial();
				desktopPane.add(AttFilial);
				AttFilial.setVisible(true);
			}
		});
		mnAtualizar.add(mntmFilial);
		
		//Menu Alugar
		JMenu mnAlugar = new JMenu("Alugar");
		menuBar.add(mnAlugar);
		
		JMenuItem mnAlugarCarro = new JMenuItem("Alugar Carro");
		mnAlugarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlugaCarro AlugaCarro = new AlugaCarro();
					desktopPane.add(AlugaCarro);
					AlugaCarro.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnAlugar.add(mnAlugarCarro);
		
		JMenu mnSobreOSoftware = new JMenu("Sobre o software");
		menuBar.add(mnSobreOSoftware);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sobre sb = new Sobre();
				desktopPane.add(sb);
				sb.setVisible(true);
			}
		});
		mnSobreOSoftware.add(mntmSobre);

		
	}
}
