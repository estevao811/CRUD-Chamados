package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.DAOsql;
import model.Usuario;

public class JPanelSecundario {
	
	public Component abrirPanelSecundario(final Usuario usuario) {
		
		DAOsql daosql = new DAOsql();
		
		final JPanel panelSecundario = new JPanel();
		panelSecundario.setPreferredSize(new Dimension(550,700));
		panelSecundario.setBackground(new Color(204, 204, 204));
		panelSecundario.setLayout(null);
		
		final JDesktopPane jDesktopPane = new JDesktopPane();
		jDesktopPane.setBounds(0, 0, 550, 700);
		jDesktopPane.setBackground(Color.BLACK);
		jDesktopPane.setLayout(null);
		/*
		JButton reabrirTelaChamadosAbertos = new JButton();
		reabrirTelaChamadosAbertos.setBounds(0, 0, 200, 20);
		reabrirTelaChamadosAbertos.setText("Reabrir tela Chamados Abertos");
		
		JButton reabrirTelaChamadosAtendimento = new JButton();
		reabrirTelaChamadosAtendimento.setBounds(0, 25, 260, 20);
		reabrirTelaChamadosAtendimento.setText("Reabrir tela Chamados em Atendimento");
		*/
		Object[][] linhasChamadosAbertosPorMim = daosql.buscarChamadosAbertosIDusuario(usuario.getIdUsuario());
		String[] colunasChamadosAbertosPorMim = {"Título", "Data de abertura", "Cod. Chamado"};
	    final DefaultTableModel modelChamadosAbertosPorMim = new DefaultTableModel(linhasChamadosAbertosPorMim, colunasChamadosAbertosPorMim);
	    final JTable tableChamadosAbertosPorMim = new JTable(modelChamadosAbertosPorMim);	    
	    JScrollPane scrollChamadosAbertosPorMim = new JScrollPane(tableChamadosAbertosPorMim);
	    scrollChamadosAbertosPorMim.setBounds(15, 15, 400, 300);
	     
	    
	    Object[][] linhasChamadosAtendimentoPorMim = daosql.buscarChamadosAtendimentoIDusuario(usuario.getIdUsuario());
		String[] colunasChamadosAtendimentoPorMim = {"Título", "Data de abertura", "Cod. Chamado"};
	    final DefaultTableModel modelChamadosAtendimentoPorMim = new DefaultTableModel(linhasChamadosAtendimentoPorMim, colunasChamadosAtendimentoPorMim);
	    final JTable tableChamadosAtendimentoPorMim = new JTable(modelChamadosAtendimentoPorMim);	    
	    JScrollPane scrollChamadosAtendimentoPorMim = new JScrollPane(tableChamadosAtendimentoPorMim);
	    scrollChamadosAtendimentoPorMim.setBounds(15, 15, 400, 300);
	    
		
	    tableChamadosAbertosPorMim.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		if(evt.getButton() == MouseEvent.BUTTON3 ) {
        			int row = tableChamadosAbertosPorMim.rowAtPoint(evt.getPoint());
                    int col = tableChamadosAbertosPorMim.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0) {
                        String idChamado =  (String)tableChamadosAbertosPorMim.getValueAt(row, 2);
                        int resposta = JOptionPane.showConfirmDialog(null, "Confirmar a deleção do chamado?");
                        if(resposta == JOptionPane.YES_OPTION) {
                        	new DAOsql().excluirChamadoPorId(idChamado);
                        	tableChamadosAbertosPorMim.remove(row);
                            JOptionPane.showMessageDialog(null, "Chamado excluído!");
        					JFrame frameAtualizado = new JFrame();
            				JPanelPrincipal jPanelPrincipalAtualizado = new JPanelPrincipal();
            				JPanelSecundario jPanelSecundarioAtualizado = new JPanelSecundario();
            				frameAtualizado.dispose(); 
            				frameAtualizado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            				frameAtualizado.setBackground(Color.LIGHT_GRAY);
            				frameAtualizado.setTitle("Sistema de CHAMADOS");	
            				frameAtualizado.setLocation(120, 0);
            				frameAtualizado.add(jPanelPrincipalAtualizado.abrirPanelPrincipal(usuario), BorderLayout.WEST);
            				frameAtualizado.add(jPanelSecundarioAtualizado.abrirPanelSecundario(usuario), BorderLayout.EAST);
            				frameAtualizado.pack();
            				frameAtualizado.setVisible(true);
                        }
                    }
        		}
        	}		        
        });
	    
	    tableChamadosAtendimentoPorMim.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		if(evt.getButton() == MouseEvent.BUTTON3 ) {
        			int row = tableChamadosAtendimentoPorMim.rowAtPoint(evt.getPoint());
                    int col = tableChamadosAtendimentoPorMim.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0) {
                        String idChamado =  (String)tableChamadosAtendimentoPorMim.getValueAt(row, 2);
                        int resposta = JOptionPane.showConfirmDialog(null, "Confirmar a deleção do chamado?");
                        if(resposta == JOptionPane.YES_OPTION) {
                        	new DAOsql().excluirChamadoPorId(idChamado);
                        	tableChamadosAtendimentoPorMim.remove(row);
                            JOptionPane.showMessageDialog(null, "Chamado excluído!");
        					JFrame frameAtualizado = new JFrame();
            				JPanelPrincipal jPanelPrincipalAtualizado = new JPanelPrincipal();
            				JPanelSecundario jPanelSecundarioAtualizado = new JPanelSecundario();
            				frameAtualizado.dispose(); 
            				frameAtualizado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            				frameAtualizado.setBackground(Color.LIGHT_GRAY);
            				frameAtualizado.setTitle("Sistema de CHAMADOS");	
            				frameAtualizado.setLocation(120, 0);
            				frameAtualizado.add(jPanelPrincipalAtualizado.abrirPanelPrincipal(usuario), BorderLayout.WEST);
            				frameAtualizado.add(jPanelSecundarioAtualizado.abrirPanelSecundario(usuario), BorderLayout.EAST);
            				frameAtualizado.pack();
            				frameAtualizado.setVisible(true);
                        }
                    }
        		}
        	}		        
        });
	    
	    
		final JInternalFrame jInternalFrame1 = new JInternalFrame();
		jInternalFrame1.setLayout(null);
		jInternalFrame1.setTitle("Chamados abertos por mim");
		jInternalFrame1.setBackground(Color.GRAY);
		jInternalFrame1.setBounds(60, 50, 450, 300);
		jInternalFrame1.add(scrollChamadosAbertosPorMim);
		jInternalFrame1.setClosable(true);
		jInternalFrame1.setResizable(true);
		jInternalFrame1.setIconifiable(true);
		jInternalFrame1.setMaximizable(true);
		jInternalFrame1.setVisible(true);
		
		
		final JInternalFrame jInternalFrame2 = new JInternalFrame();
		jInternalFrame2.setLayout(null);
		jInternalFrame2.setTitle("Chamados em atendimento por mim");
		jInternalFrame2.setBackground(Color.GRAY);
		jInternalFrame2.setBounds(60, 360, 450, 300);
		jInternalFrame2.add(scrollChamadosAtendimentoPorMim);
		jInternalFrame2.setClosable(true);
		jInternalFrame2.setIconifiable(true);
		jInternalFrame2.setResizable(true);
		jInternalFrame2.setMaximizable(true);
		jInternalFrame2.setVisible(true);
		
		/*
		reabrirTelaChamadosAbertos.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (jInternalFrame1.isVisible() == false) {
							jInternalFrame1.setVisible(true);
							jDesktopPane.add(jInternalFrame1);
						}
					}
				});
		
		reabrirTelaChamadosAtendimento.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (jInternalFrame2.isVisible() == false) {
							jInternalFrame2.setVisible(true);
							jDesktopPane.add(jInternalFrame2);
						}
					}
				});
		
		
		jDesktopPane.add(reabrirTelaChamadosAbertos);
		jDesktopPane.add(reabrirTelaChamadosAtendimento);*/
		jDesktopPane.add(jInternalFrame2);
		jDesktopPane.add(jInternalFrame1);
		panelSecundario.add(jDesktopPane);
		return panelSecundario;
	}

}
