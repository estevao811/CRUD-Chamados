package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.Usuario;


public class Telas {
	

	public static void abrirTelaPrincipal(final Usuario usuario) {
		
		JFrame frame = new JFrame();
		JPanelPrincipal jPanelPrincipal = new JPanelPrincipal();
		JPanelSecundario jPanelSecundario = new JPanelSecundario();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		frame.setTitle("Sistema de CHAMADOS");	
		frame.setLocation(120, 0);
		frame.add(jPanelPrincipal.abrirPanelPrincipal(usuario), BorderLayout.WEST);
		frame.add(jPanelSecundario.abrirPanelSecundario(usuario), BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
	
	}
}
