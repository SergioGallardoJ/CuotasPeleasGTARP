package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.TextArea;
import javax.swing.JToolBar;
import java.awt.Toolkit;

public class Interface {

	private JFrame frmApuestasGtarp;
	private JTextField txt_peleador1;
	private JTextField txt_peleador2;
	private JTextField txt_Cuota1;
	private JTextField txt_Couta2;
	private JTextField txt_NombreApostador;
	private JTextField txt_CantidadApostada;
	private JTextField txt_ApuestaTotal2;
	private JTextField txt_ApuestaTotal1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	double dineroLuchador1 = 0;
	double dineroLuchador2 = 0;
	List<String[]> apuestas = new ArrayList<>();
	double cuotaMax = 2.8;
	double cuotaMin = 1.00;
	boolean cerrarApuestas = false;
	double dineroApostado = 0;
	double dineroDescontado = 0;
	String apostador;
	char luchadorElegido;
	double cuotaLuchador1 = 0;
	double cuotaLuchador2 = 0;
	double premio;
	DefaultListModel<String> ganadoresListModel;
	DecimalFormat df = new DecimalFormat("#.##");
	private JTextField txt_dineroGenerado10;
	private JTextField txt_dineroGanadoApuestasCasa;
	private JTextField txt_Napuestas1;
	private JTextField txt_Napuestas2;
	double suma10Porciento = 0;
	double sumaGananciaNegocio = 0;
	int sumaApostadoresLuchador1 = 0;
	int sumaApostadoresLuchador2 = 0;
	Color rojoClaro = new Color(241, 148, 138);
	Color verdeClaro = new Color(130, 224, 170);
	private JTextField txt_totalApostado;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Interface window = new Interface();
					window.frmApuestasGtarp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApuestasGtarp = new JFrame();
		frmApuestasGtarp.setTitle("APUESTAS GTARP");
		frmApuestasGtarp.setResizable(false);
		frmApuestasGtarp.setBounds(100, 100, 854, 783);
		frmApuestasGtarp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApuestasGtarp.getContentPane().setLayout(null);
		String rutaIcono = "./Apuesta.png"; // Cambia esta ruta por la ruta real de tu archivo de imagen
        // Cargar la imagen
        ImageIcon icono = new ImageIcon(rutaIcono);
		
		frmApuestasGtarp.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Proyectos Eclipse\\CalculadoraCouta1v1-main\\Apuestas.png"));
		
		JPanel Jpanel_Premios = new JPanel();
		Jpanel_Premios.setVisible(false);
		Jpanel_Premios.setBounds(0, 287, 838, 457);
		frmApuestasGtarp.getContentPane().add(Jpanel_Premios);
		Jpanel_Premios.setLayout(null);
		
		JTextArea txtArea_Ganadores = new JTextArea();
		txtArea_Ganadores.setWrapStyleWord(true);
		txtArea_Ganadores.setLineWrap(true);
		txtArea_Ganadores.setEditable(false);
		txtArea_Ganadores.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		txtArea_Ganadores.setBounds(25, 64, 396, 230);
		Jpanel_Premios.add(txtArea_Ganadores);
		
		JLabel lblGanadores = new JLabel("Apuestas Ganadoras:");
		lblGanadores.setForeground(new Color(50, 205, 50));
		lblGanadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanadores.setFont(new Font("Impact", Font.PLAIN, 25));
		lblGanadores.setBounds(62, 4, 324, 50);
		Jpanel_Premios.add(lblGanadores);
		
		JButton btn_reiniciar = new JButton("Reiniciar");
		
		btn_reiniciar.setEnabled(false);
		btn_reiniciar.setBounds(319, 412, 180, 39);
		Jpanel_Premios.add(btn_reiniciar);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 379, 838, 15);
		Jpanel_Premios.add(separator_1_1);
		
		JLabel lblDineroGeneradoPor = new JLabel("Dinero Generado por el 10% :");
		lblDineroGeneradoPor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDineroGeneradoPor.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		lblDineroGeneradoPor.setBounds(35, 294, 255, 50);
		Jpanel_Premios.add(lblDineroGeneradoPor);
		
		txt_dineroGenerado10 = new JTextField();
		txt_dineroGenerado10.setBackground(new Color(50, 205, 50));
		txt_dineroGenerado10.setText("0.0");
		txt_dineroGenerado10.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dineroGenerado10.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_dineroGenerado10.setEditable(false);
		txt_dineroGenerado10.setColumns(10);
		txt_dineroGenerado10.setBounds(300, 304, 86, 33);
		Jpanel_Premios.add(txt_dineroGenerado10);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("$");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2_1_1.setBounds(396, 294, 25, 50);
		Jpanel_Premios.add(lblNewLabel_2_2_1_1);
		
		JLabel lblDineroDeApostadores = new JLabel("Dinero ganado de apuestas :");
		lblDineroDeApostadores.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDineroDeApostadores.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		lblDineroDeApostadores.setBounds(389, 294, 295, 50);
		Jpanel_Premios.add(lblDineroDeApostadores);
		
		txt_dineroGanadoApuestasCasa = new JTextField();
		txt_dineroGanadoApuestasCasa.setBackground(new Color(50, 205, 50));
		txt_dineroGanadoApuestasCasa.setText("0.0");
		txt_dineroGanadoApuestasCasa.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dineroGanadoApuestasCasa.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_dineroGanadoApuestasCasa.setEditable(false);
		txt_dineroGanadoApuestasCasa.setColumns(10);
		txt_dineroGanadoApuestasCasa.setBounds(694, 304, 86, 33);
		Jpanel_Premios.add(txt_dineroGanadoApuestasCasa);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("$");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2_1_1_1.setBounds(790, 294, 25, 50);
		Jpanel_Premios.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("(De los que perdieron)");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(503, 338, 143, 21);
		Jpanel_Premios.add(lblNewLabel_4_1);
		
		JTextArea txtArea_Perdedores = new JTextArea();
		txtArea_Perdedores.setWrapStyleWord(true);
		txtArea_Perdedores.setLineWrap(true);
		txtArea_Perdedores.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		txtArea_Perdedores.setEditable(false);
		txtArea_Perdedores.setBounds(439, 63, 376, 230);
		Jpanel_Premios.add(txtArea_Perdedores);
		
		JLabel lblApuestasPerdedoras = new JLabel("Apuestas Perdedoras:");
		lblApuestasPerdedoras.setForeground(new Color(255, 0, 0));
		lblApuestasPerdedoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuestasPerdedoras.setFont(new Font("Impact", Font.PLAIN, 25));
		lblApuestasPerdedoras.setBounds(472, 4, 324, 50);
		Jpanel_Premios.add(lblApuestasPerdedoras);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(428, 10, 38, 300);
		Jpanel_Premios.add(separator_3);
		
		ganadoresListModel = new DefaultListModel<>();
	
		
		
		JLabel lblNewLabel = new JLabel("CALCULADORA DE CUOTAS 1V1");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(257, 11, 315, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PELEADOR 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(46, 139, 200, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PELEADOR 2:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(545, 144, 200, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("VS");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(356, 171, 69, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_1_2);
		
		txt_peleador1 = new JTextField();
		txt_peleador1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_peleador1.setBounds(33, 183, 200, 33);
		frmApuestasGtarp.getContentPane().add(txt_peleador1);
		txt_peleador1.setColumns(10);
		
		txt_peleador2 = new JTextField();
		txt_peleador2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_peleador2.setColumns(10);
		txt_peleador2.setBounds(573, 188, 200, 33);
		frmApuestasGtarp.getContentPane().add(txt_peleador2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 349, 838, 15);
		frmApuestasGtarp.getContentPane().add(separator);
		
		JButton btn_OK = new JButton("OK");
		
		btn_OK.setBounds(356, 287, 86, 33);
		frmApuestasGtarp.getContentPane().add(btn_OK);
		
		JLabel lblNewLabel_2 = new JLabel("Cuota:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(48, 228, 69, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cuota:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(562, 228, 61, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_2_1);
		
		txt_Cuota1 = new JTextField();
		txt_Cuota1.setText("0.9");
		txt_Cuota1.setEditable(false);
		txt_Cuota1.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_Cuota1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Cuota1.setBounds(127, 236, 86, 33);
		frmApuestasGtarp.getContentPane().add(txt_Cuota1);
		txt_Cuota1.setColumns(10);
		
		txt_Couta2 = new JTextField();
		txt_Couta2.setText("0.9");
		txt_Couta2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Couta2.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_Couta2.setEditable(false);
		txt_Couta2.setColumns(10);
		txt_Couta2.setBounds(633, 236, 86, 33);
		frmApuestasGtarp.getContentPane().add(txt_Couta2);
		
		JButton btn_NuevoApostador = new JButton("Nuevo Apostador");
		
		btn_NuevoApostador.setEnabled(false);
		btn_NuevoApostador.setBounds(296, 375, 200, 50);
		frmApuestasGtarp.getContentPane().add(btn_NuevoApostador);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(65, 446, 86, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_3);
		
		txt_NombreApostador = new JTextField();
		txt_NombreApostador.setEditable(false);
		txt_NombreApostador.setBounds(154, 458, 112, 33);
		frmApuestasGtarp.getContentPane().add(txt_NombreApostador);
		txt_NombreApostador.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cantidad:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(290, 446, 102, 50);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_3_1);
		
		txt_CantidadApostada = new JTextField();
		txt_CantidadApostada.setEditable(false);
		txt_CantidadApostada.setColumns(10);
		txt_CantidadApostada.setBounds(397, 458, 124, 33);
		frmApuestasGtarp.getContentPane().add(txt_CantidadApostada);
		
		JRadioButton rb_peleador1 = new JRadioButton("");
		rb_peleador1.setEnabled(false);
		buttonGroup_1.add(rb_peleador1);
		rb_peleador1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rb_peleador1.setBounds(536, 446, 132, 50);
		frmApuestasGtarp.getContentPane().add(rb_peleador1);
		
		JRadioButton rb_peleador2 = new JRadioButton("");
		rb_peleador2.setEnabled(false);
		buttonGroup_1.add(rb_peleador2);
		rb_peleador2.setFont(new Font("Tahoma", Font.BOLD, 13));
		rb_peleador2.setBounds(670, 446, 141, 50);
		frmApuestasGtarp.getContentPane().add(rb_peleador2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Apuestas ($):");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(33, 67, 200, 44);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_2_2);
		
		txt_ApuestaTotal2 = new JTextField();
		txt_ApuestaTotal2.setText("0");
		txt_ApuestaTotal2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ApuestaTotal2.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_ApuestaTotal2.setEditable(false);
		txt_ApuestaTotal2.setColumns(10);
		txt_ApuestaTotal2.setBounds(573, 112, 200, 33);
		frmApuestasGtarp.getContentPane().add(txt_ApuestaTotal2);
		
		txt_ApuestaTotal1 = new JTextField();
		txt_ApuestaTotal1.setText("0");
		txt_ApuestaTotal1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ApuestaTotal1.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_ApuestaTotal1.setEditable(false);
		txt_ApuestaTotal1.setColumns(10);
		txt_ApuestaTotal1.setBounds(33, 110, 200, 33);
		frmApuestasGtarp.getContentPane().add(txt_ApuestaTotal1);
		
		JLabel lblNewLabel_4 = new JLabel("<- (Total por Peleador apostado Menos el 10%) ->");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(243, 72, 320, 33);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_4);
		
		JLabel lbl_NombrePeleador1 = new JLabel("");
		lbl_NombrePeleador1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_NombrePeleador1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombrePeleador1.setBounds(243, 177, 118, 44);
		frmApuestasGtarp.getContentPane().add(lbl_NombrePeleador1);
		
		JLabel lbl_NombrePeleador2 = new JLabel("");
		lbl_NombrePeleador2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_NombrePeleador2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombrePeleador2.setBounds(423, 177, 118, 44);
		frmApuestasGtarp.getContentPane().add(lbl_NombrePeleador2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 67, 838, 15);
		frmApuestasGtarp.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 623, 838, 15);
		frmApuestasGtarp.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ganador:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_2.setBounds(257, 649, 112, 79);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_3_2);
		
		JRadioButton rb_ganador1 = new JRadioButton("Peleador 1");
		rb_ganador1.setEnabled(false);
		buttonGroup.add(rb_ganador1);
		rb_ganador1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rb_ganador1.setBounds(359, 661, 102, 50);
		frmApuestasGtarp.getContentPane().add(rb_ganador1);
		
		JRadioButton rb_ganador2 = new JRadioButton("Peleador 2");
		rb_ganador2.setEnabled(false);
		buttonGroup.add(rb_ganador2);
		rb_ganador2.setFont(new Font("Tahoma", Font.BOLD, 13));
		rb_ganador2.setBounds(480, 661, 112, 50);
		frmApuestasGtarp.getContentPane().add(rb_ganador2);
		
		JButton btn_CerrarApuestas = new JButton("Cerrar Apuestas");
		
		btn_CerrarApuestas.setEnabled(false);
		btn_CerrarApuestas.setBounds(46, 656, 200, 50);
		frmApuestasGtarp.getContentPane().add(btn_CerrarApuestas);
		
		JButton btn_ConfirmarApuesta = new JButton("Confirmar Apuesta");
		
		btn_ConfirmarApuesta.setEnabled(false);
		btn_ConfirmarApuesta.setBounds(296, 538, 200, 50);
		frmApuestasGtarp.getContentPane().add(btn_ConfirmarApuesta);
		
		JButton btn_verPremios = new JButton("Ver Premios");
		
		btn_verPremios.setEnabled(false);
		btn_verPremios.setBounds(611, 661, 200, 50);
		frmApuestasGtarp.getContentPane().add(btn_verPremios);
		
		JLabel lbl_Ganador1 = new JLabel("¡GANADOR!");
		lbl_Ganador1.setVisible(false);
		lbl_Ganador1.setFont(new Font("Jokerman", Font.BOLD, 21));
		lbl_Ganador1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ganador1.setBounds(235, 143, 157, 39);
		frmApuestasGtarp.getContentPane().add(lbl_Ganador1);
		
		JLabel lbl_Ganador2 = new JLabel("¡GANADOR!");
		lbl_Ganador2.setVisible(false);
		lbl_Ganador2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ganador2.setFont(new Font("Jokerman", Font.BOLD, 21));
		lbl_Ganador2.setBounds(408, 143, 157, 39);
		frmApuestasGtarp.getContentPane().add(lbl_Ganador2);
		
		JLabel lblNewLabel_5 = new JLabel("Nº Apuestas:");
		lblNewLabel_5.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(253, 215, 108, 33);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_5);
		
		txt_Napuestas1 = new JTextField();
		txt_Napuestas1.setText("0");
		txt_Napuestas1.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		txt_Napuestas1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Napuestas1.setEditable(false);
		txt_Napuestas1.setBounds(277, 249, 55, 27);
		frmApuestasGtarp.getContentPane().add(txt_Napuestas1);
		txt_Napuestas1.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nº Apuestas:");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(431, 215, 108, 33);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_5_1);
		
		txt_Napuestas2 = new JTextField();
		txt_Napuestas2.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		txt_Napuestas2.setText("0");
		txt_Napuestas2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Napuestas2.setEditable(false);
		txt_Napuestas2.setColumns(10);
		txt_Napuestas2.setBounds(455, 249, 55, 27);
		frmApuestasGtarp.getContentPane().add(txt_Napuestas2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Apuestas ($):");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2_1.setBounds(573, 67, 200, 44);
		frmApuestasGtarp.getContentPane().add(lblNewLabel_2_2_1);
		
		txt_totalApostado = new JTextField();
		txt_totalApostado.setText("0");
		txt_totalApostado.setHorizontalAlignment(SwingConstants.CENTER);
		txt_totalApostado.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_totalApostado.setEditable(false);
		txt_totalApostado.setVisible(false);
		txt_totalApostado.setColumns(10);
		txt_totalApostado.setBounds(257, 110, 284, 33);
		frmApuestasGtarp.getContentPane().add(txt_totalApostado);
		
		
		
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!txt_peleador1.getText().isEmpty() && !txt_peleador2.getText().isEmpty()) { //Boton OK a los peleadores
					txt_peleador1.setEditable(false);
					txt_peleador2.setEditable(false);
					lbl_NombrePeleador1.setText(txt_peleador1.getText());
					lbl_NombrePeleador2.setText(txt_peleador2.getText());
					
					btn_NuevoApostador.setEnabled(true);
					
					rb_peleador1.setText(lbl_NombrePeleador1.getText());
					rb_peleador2.setText(lbl_NombrePeleador2.getText());
					
					rb_ganador1.setText(lbl_NombrePeleador1.getText());
					rb_ganador2.setText(lbl_NombrePeleador2.getText());
					
					btn_CerrarApuestas.setEnabled(true);
					btn_OK.setEnabled(false);
					
					
					
					
				}
			}
		});
		
		btn_NuevoApostador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_NombreApostador.setEditable(true);
				txt_CantidadApostada.setEditable(true);
				rb_peleador1.setEnabled(true);
				rb_peleador2.setEnabled(true);
				
				btn_ConfirmarApuesta.setEnabled(true);
				btn_NuevoApostador.setEnabled(false);
			}
		});
		
		
		btn_ConfirmarApuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pasamos los datos del apostador a las variables.
				apostador = txt_NombreApostador.getText();
				dineroApostado = Double.parseDouble(txt_CantidadApostada.getText()); 
				///descontamos el 10%
				dineroDescontado = dineroApostado * 0.1;
				suma10Porciento += dineroDescontado;
				dineroApostado -= dineroDescontado;
				
				//acumulamos el dinero de los luchadores
				if (rb_peleador1.isSelected()) {
					dineroLuchador1 += dineroApostado;
					sumaApostadoresLuchador1 ++;
					txt_Napuestas1.setText(df.format(sumaApostadoresLuchador1));
				} else {
					dineroLuchador2 += dineroApostado;
					sumaApostadoresLuchador2 ++;
					txt_Napuestas2.setText(df.format(sumaApostadoresLuchador2));
				}
				if (rb_peleador1.isSelected()) {
					luchadorElegido = 'A';
				} else {
					luchadorElegido = 'B';
				}
				//almacenamos todos los datos en una lista
				String[] apuesta = {apostador,String.valueOf(dineroApostado),String.valueOf(luchadorElegido)};
				apuestas.add(apuesta);
				
				//calcular y mostrar el dinero acumulado de cada luchador
				cuotaLuchador1 = calcularCuota(dineroLuchador1, dineroLuchador2, cuotaMax, cuotaMin);
				cuotaLuchador2 = calcularCuota(dineroLuchador2, dineroLuchador1, cuotaMax, cuotaMin);
				

				txt_Cuota1.setText(df.format(cuotaLuchador1));
				txt_Couta2.setText(df.format(cuotaLuchador2));
				
				txt_ApuestaTotal1.setText(df.format(dineroLuchador1));
				txt_ApuestaTotal2.setText(df.format(dineroLuchador2));
				
				txt_NombreApostador.setText(null);
				txt_CantidadApostada.setText(null);
				rb_peleador1.setSelected(false);
				rb_peleador2.setSelected(false);
				btn_NuevoApostador.setEnabled(true);
				
				txt_NombreApostador.setEditable(false);
				txt_CantidadApostada.setEditable(false);
				
				rb_peleador1.setEnabled(false);
				rb_peleador2.setEnabled(false);
				
				
				
				
			}
		});
		
		btn_CerrarApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rb_ganador1.setEnabled(true);
				rb_ganador2.setEnabled(true);
				btn_verPremios.setVisible(true);
				btn_verPremios.setEnabled(true);
				btn_CerrarApuestas.setEnabled(false);
				
				btn_NuevoApostador.setEnabled(false);
				btn_ConfirmarApuesta.setEnabled(false);
				btn_CerrarApuestas.setEnabled(false);
				
			}
			
		});
		
		btn_verPremios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double dineroTotal = 0;
				btn_NuevoApostador.setEnabled(false);
				btn_NuevoApostador.setVisible(false);
				btn_ConfirmarApuesta.setEnabled(false);
				btn_ConfirmarApuesta.setVisible(false);
				btn_CerrarApuestas.setEnabled(false);
				btn_CerrarApuestas.setVisible(false);
				
				if (rb_ganador1.isSelected()) {
					txt_peleador1.setBackground(verdeClaro);
	                txt_peleador2.setBackground(rojoClaro);
	                txt_peleador1.setForeground(Color.white);
	                txt_peleador2.setForeground(Color.white);
				} else if (rb_ganador2.isSelected()) {
					txt_peleador1.setBackground(rojoClaro);
	                txt_peleador2.setBackground(verdeClaro);
	                txt_peleador1.setForeground(Color.white);
	                txt_peleador2.setForeground(Color.white);
				}
				
				for (String[] apuesta : apuestas) {
					double premioIndividual=0;
					double dineroApostado = Double.parseDouble(apuesta[1]);
					char luchadorElegido = apuesta[2].charAt(0);
					if (luchadorElegido == 'A' && rb_ganador1.isSelected()) {
		                premioIndividual = dineroApostado * calcularCuota(dineroLuchador1, dineroLuchador2, cuotaMax, cuotaMin);
		                
		            } else if (luchadorElegido == 'B' && rb_ganador2.isSelected()){
		            	premioIndividual = dineroApostado * calcularCuota(dineroLuchador2, dineroLuchador1, cuotaMax, cuotaMin);
		            	
		            }else {
		                premioIndividual = 0; // Si el apostador no ganó según su elección, no hay premio
		            }
					
					txt_dineroGenerado10.setText(df.format(suma10Porciento));
					dineroTotal += premioIndividual;
					String mensaje = apuesta[0]+":  Apostado($): "+df.format(dineroApostado)+" Recibe($): "+df.format(premioIndividual)+"\n";
					
					if (premioIndividual > 0.0) {
						txtArea_Ganadores.setText(txtArea_Ganadores.getText().concat(mensaje));
					
					}else if(premioIndividual == 0.0){
						txtArea_Perdedores.setText(txtArea_Perdedores.getText().concat(mensaje));
						
					}else {
						System.err.println(mensaje.toString()+"No ha sido añadido.");
					}
					
					
				}
				
				
				Jpanel_Premios.setVisible(true);
				btn_CerrarApuestas.setEnabled(false);
				rb_ganador1.setEnabled(false);
				rb_ganador2.setEnabled(false);
				btn_reiniciar.setEnabled(true);
				
				if (rb_ganador1.isSelected()) {
					lbl_Ganador1.setVisible(true);
					lbl_Ganador2.setVisible(false);
					
				} else if (rb_ganador2.isSelected()) {
					lbl_Ganador2.setVisible(true);
					lbl_Ganador1.setVisible(false);
				}
				btn_verPremios.setEnabled(false);
				btn_verPremios.setVisible(false);
				
				///PARA VERIFICAR QUE SI SE PASAN DE LA CUOTA DE 2.8 EL RESTO DEL DINERO ES NUESTRO
				if (rb_ganador1.isSelected() && (dineroLuchador1 < dineroLuchador2*2.8)) {
					sumaGananciaNegocio += (dineroLuchador2-dineroLuchador1);
				} 
				txt_dineroGanadoApuestasCasa.setText(df.format(sumaGananciaNegocio));
				double sumaTotal = dineroLuchador1 + dineroLuchador2; 
				txt_totalApostado.setText("Dinero Total: "+String.valueOf(sumaTotal));
				txt_totalApostado.setVisible(true);
			}
		});
		
		btn_reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_peleador1.setText(null);
				txt_peleador1.setEnabled(true);
				txt_peleador1.setEditable(true);
				txt_peleador2.setText(null);
				txt_peleador2.setEnabled(true);
				txt_peleador2.setEditable(true);
				lbl_NombrePeleador1.setText(null);
				lbl_NombrePeleador2.setText(null);
				txt_ApuestaTotal1.setText("0");
				txt_ApuestaTotal2.setText("0");
				
				cuotaLuchador1 = 0;
				cuotaLuchador2 = 0;
				dineroApostado = 0;
				dineroDescontado = 0;
				dineroLuchador1 = 0;
				dineroLuchador2 = 0;
				
				txt_Cuota1.setText("0.9");
				txt_Couta2.setText("0.9");
				
				Jpanel_Premios.setVisible(false);
				btn_NuevoApostador.setEnabled(false);
				btn_ConfirmarApuesta.setEnabled(false);
				apuestas.clear();
				btn_OK.setEnabled(true);
			
				lbl_Ganador1.setVisible(false);
				lbl_Ganador2.setVisible(false);
				
				btn_NuevoApostador.setVisible(true);
				btn_CerrarApuestas.setVisible(true);
				btn_ConfirmarApuesta.setVisible(true);
				suma10Porciento = 0;
				sumaApostadoresLuchador1 = 0;
				sumaApostadoresLuchador2 = 0;
				sumaGananciaNegocio = 0;
				
				txt_Napuestas1.setText("0");
				txt_Napuestas2.setText("0");
				
				txt_peleador1.setBackground(Color.white);
				txt_peleador2.setBackground(Color.white);
				txt_peleador1.setForeground(txt_ApuestaTotal1.getForeground());
				txt_peleador2.setForeground(txt_ApuestaTotal1.getForeground());
				
				txt_totalApostado.setVisible(false);
				
			}
		});
		
	}
	public static double calcularCuota(double dineroApostado, double dineroRival, double cuotaMaxima, double cuotaMinima) {
        double proporcion = dineroApostado / (dineroApostado + dineroRival);
        double cuota = 1 / proporcion;
        cuota = Math.max(cuota, cuotaMinima);
        cuota = Math.min(cuota, cuotaMaxima);
        return cuota;
    }
}
