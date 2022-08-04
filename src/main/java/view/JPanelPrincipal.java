package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.DAOsql;
import model.Usuario;

public class JPanelPrincipal extends Telas{
	
	public Component abrirPanelPrincipal(final Usuario usuario) {
		
		final DAOsql daosql = new DAOsql();
		
		final JPanel panelPrincipal = new JPanel();
		panelPrincipal.setPreferredSize(new Dimension(550,700));
		panelPrincipal.setBackground(Color.GRAY);
		//panelPrincipal.setBackground(new Color(255, 204, 204));
		panelPrincipal.setLayout(null);
		
		
		JButton botaoAddChamado = new JButton();
		botaoAddChamado.setBounds(0, 0, 180, 20);
		botaoAddChamado.setText("Cadastrar / Atualizar");
		
	    final JCheckBox checkbox = new JCheckBox();
		checkbox.setText("Chamados Fechados");
		checkbox.setBounds(0, 22, 300, 20);
        
		final Object[][] linhasDadosChamadosAbertos = daosql.buscarChamadosAbertos();
		final String[] colunasChamadosAbertos = {"Título", "Data de abertura", "Cod. Chamado"};
	    final DefaultTableModel modelChamadosAbertos = new DefaultTableModel(linhasDadosChamadosAbertos, colunasChamadosAbertos);
	    final JTable tableChamadosAbertos = new JTable(modelChamadosAbertos);	    
	    final JScrollPane scrollChamadosAbertos = new JScrollPane(tableChamadosAbertos);
	    scrollChamadosAbertos.setBounds(20, 50, 510, 600);
        panelPrincipal.add(scrollChamadosAbertos);
 
        final Object[][] linhasTodosDadosChamados = daosql.buscarTodosChamados();
        final String[] colunasTodosChamados = {"Título", "Data de abertura", "Cod. Chamado"};
	    final DefaultTableModel modelTodosChamados = new DefaultTableModel(linhasTodosDadosChamados, colunasTodosChamados);
	    final JTable tableTodosChamados = new JTable(modelTodosChamados);	    
	    final JScrollPane scrollTodosChamados = new JScrollPane(tableTodosChamados);
	    scrollTodosChamados.setBounds(20, 50, 510, 600);
	    
        
	    checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if(checkbox.isSelected()) {
					panelPrincipal.remove(scrollChamadosAbertos);
					panelPrincipal.add(scrollTodosChamados);
				} else {
					panelPrincipal.remove(scrollTodosChamados);
					panelPrincipal.add(scrollChamadosAbertos);
				}
			}
		});	
	    

	    botaoAddChamado.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				TelaEditarECadastrarChamado telaEditarECadastrarChamado = new TelaEditarECadastrarChamado();
        				telaEditarECadastrarChamado.telaEditarCadastrarChamado(usuario);
        			}
        		});
	    
	    
        tableChamadosAbertos.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		if(evt.getButton() == MouseEvent.BUTTON3 ) {
        			int row = tableChamadosAbertos.rowAtPoint(evt.getPoint());
                    int col = tableChamadosAbertos.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0) {
                        String idChamado =  (String)tableChamadosAbertos.getValueAt(row, 2);
                        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir chamado?");
                        if(resposta == JOptionPane.YES_OPTION) {
                        	new DAOsql().excluirChamadoPorId(idChamado);
                        	modelChamadosAbertos.removeRow(row);
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
            				//frameAtualizado.setVisible(true);
                        }
                    }
        		}
        	}		        
        });
        
        tableTodosChamados.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		if(evt.getButton() == MouseEvent.BUTTON3 ) {
        			int row = tableTodosChamados.rowAtPoint(evt.getPoint());
                    int col = tableTodosChamados.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0) {
                        String idChamado =  (String)tableTodosChamados.getValueAt(row, 2);
                        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir chamado?");
                        if(resposta == JOptionPane.YES_OPTION) {
                        	new DAOsql().excluirChamadoPorId(idChamado);
                        	modelTodosChamados.removeRow(row);
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
            				//frameAtualizado.setVisible(true);
                        }
                    }
        		}
        	}		        
        });

        panelPrincipal.add(checkbox);
        panelPrincipal.add(botaoAddChamado);
        return panelPrincipal;
       
	}
}
