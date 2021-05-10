package tarea7_POO;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
	
	JPanel principal;
	JPanel instrucciones;
	
	JLabel instruc1;
	JLabel espacio1;
	JLabel instruc2;
	JLabel instruc3;
	JLabel espacio2;
	JLabel instruc4;
	
	
	
	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton4;

	
	public Ventana() { //no se está usando este constructor default
		super("Aplicacion Botones");
		this.setPreferredSize(new DimensionUIResource(400,200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		agregarComponentes();
		
		this.pack();
		this.setVisible(true);
	}
	
	
	private void agregarComponentes() {
		
		
		principal = new JPanel();
		principal.setLayout(new BoxLayout(principal,BoxLayout.Y_AXIS));
		
		instrucciones = new JPanel();
		instrucciones.setLayout(new BoxLayout(instrucciones,BoxLayout.Y_AXIS));
		
		instruc1 = new JLabel("   Instrucciones: ");
		instruc2 = new JLabel("      Presione los botones ");
		instruc3 = new JLabel("      en el siguiente orden: ");
		instruc4 = new JLabel("            2  ->  1  ->  3  ");
		
		espacio1 = new JLabel("                      ");
		espacio2 = new JLabel("                      ");
		
		instrucciones.add(instruc1);
		instrucciones.add(espacio1);
		instrucciones.add(instruc2);
		instrucciones.add(instruc3);
		instrucciones.add(espacio2);
		instrucciones.add(instruc4);
		//scrollSouth = new JScrollPane(principalCenter);
		
		boton1 = new JButton("Boton 1");
		boton1.addActionListener(this);
		
		boton2 = new JButton("Boton 2");
		boton2.addActionListener(this);
		
		boton3 = new JButton("Boton 3");
		boton3.addActionListener(this);
		
		boton4 = new JButton("Revisar orden");
		boton4.addActionListener(this);
		
		principal.add(boton1);
		principal.add(boton2);
		principal.add(boton3);
		principal.add(boton4);
		
		this.add(instrucciones);
		this.add(principal);
		this.setLayout(new GridLayout());
		
	}
	
	private void compararListas(ArrayList<Integer> clicks , ArrayList<Integer> correcto) {
		if(clicks.equals(correcto) == false) {
			throw new ArithmeticException("Orden ingresado es incorrecto");
		}
		JOptionPane.showMessageDialog(this, "El orden es correcto! Gracias por participar");
		Main.ordenClicks.clear();
	}
	
	///////////////////////////////////////////////////// ///////////////////////////////////////////////////// 
	///////////////////////////////////////////////////// ///////////////////////////////////////////////////// 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(boton1)) {
			Main.ordenClicks.add(1);
			
		}
		else if(e.getSource().equals(boton2)) {
			Main.ordenClicks.add(2);
		}
		
		else if(e.getSource().equals(boton3)) {
			Main.ordenClicks.add(3);
		}
		
		else if(e.getSource().equals(boton4)) {
			try {
				compararListas(Main.ordenClicks,Main.ordenCorrecto);
			}catch (ArithmeticException a) {
				JOptionPane.showMessageDialog(this, "El orden ingresado fue incorrecto, intenta de nuevo...");
				Main.ordenClicks.clear();
			}
		}
		
		
		
	}
}
