package view;

import view.Telas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controler.DAOsql;
import model.Usuario;

public class TelaEditarECadastrarChamado extends Telas {

	public void telaEditarCadastrarChamado(final Usuario usuario) {

		final JDialog dialog = new JDialog();
		GridBagLayout layout = new GridBagLayout();
		dialog.setTitle("Modal de Edição e Cadastro de chamados");
		dialog.setBounds(200, 150, 800, 400);
		dialog.setLayout(layout);

		JLabel labelIDChamado = new JLabel();
		labelIDChamado.setText("ID Chamado");
		GridBagConstraints gridLabelIDChamado = new GridBagConstraints();
		gridLabelIDChamado.gridx = 0;
		gridLabelIDChamado.gridy = 2;

		final JTextField insereIDChamado = new JTextField();
		GridBagConstraints gridInsereIDchamado = new GridBagConstraints();
		gridInsereIDchamado.gridx = 1;
		gridInsereIDchamado.gridy = 2;
		insereIDChamado.setColumns(3);

		JLabel labelIDUsuario = new JLabel();
		labelIDUsuario.setText("ID Usuário:");
		GridBagConstraints gbc0 = new GridBagConstraints();
		gbc0.gridx = 0;
		gbc0.gridy = 4;

		final JTextField insereIDUsuario = new JTextField();
		GridBagConstraints gb0 = new GridBagConstraints();
		gb0.gridx = 1;
		gb0.gridy = 4;
		insereIDUsuario.setColumns(3);

		JLabel labelIDTecnico = new JLabel();
		labelIDTecnico.setText("ID Técnico:");
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 6;

		final JTextField insereIDTecnico = new JTextField();
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 1;
		gbc2.gridy = 6;
		insereIDTecnico.setColumns(3);

		JLabel labelTitulo = new JLabel();
		labelTitulo.setText("Título:");
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 0;
		gbc3.gridy = 8;

		final JTextField insereTitulo = new JTextField();
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 1;
		gbc4.gridy = 8;
		insereTitulo.setColumns(20);

		JLabel labelDescricao = new JLabel();
		labelDescricao.setText("Descrição:");
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 0;
		gbc5.gridy = 10;

		final JTextField insereDescricao = new JTextField();
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx = 1;
		gbc6.gridy = 10;
		insereDescricao.setColumns(20);

		JLabel labelDataAbertura = new JLabel();
		labelDataAbertura.setText("Data de abertura:");
		GridBagConstraints gbc7 = new GridBagConstraints();
		gbc7.gridx = 0;
		gbc7.gridy = 12;

		final JTextField insereDataAbertura = new JTextField();
		GridBagConstraints gbc8 = new GridBagConstraints();
		gbc8.gridx = 1;
		gbc8.gridy = 12;
		insereDataAbertura.setColumns(20);

		final JLabel labelSolucao = new JLabel();
		labelSolucao.setText("Solução:");
		final GridBagConstraints gbc9 = new GridBagConstraints();
		gbc9.gridx = 0;
		gbc9.gridy = 14;

		final JTextField insereSolucao = new JTextField();
		final GridBagConstraints gbc10 = new GridBagConstraints();
		gbc10.gridx = 1;
		gbc10.gridy = 14;
		insereSolucao.setColumns(20);

		final JLabel labelDataFechamento = new JLabel();
		labelDataFechamento.setText("Data de fechamento:");
		final GridBagConstraints gbc11 = new GridBagConstraints();
		gbc11.gridx = 0;
		gbc11.gridy = 16;

		final JTextField insereDataFechamento = new JTextField();
		final GridBagConstraints gbc12 = new GridBagConstraints();
		gbc12.gridx = 1;
		gbc12.gridy = 16;
		insereDataFechamento.setColumns(20);

		final JButton botaoSalvarNovoChamadoAberto = new JButton("Cadastrar");
		final GridBagConstraints gridSalvarAberto = new GridBagConstraints();
		gridSalvarAberto.gridx = 1;
		gridSalvarAberto.gridy = 22;

		final JButton botaoSalvarNovoChamadoFechado = new JButton("Cadastrar");
		final GridBagConstraints gridSalvarFechado = new GridBagConstraints();
		gridSalvarFechado.gridx = 1;
		gridSalvarFechado.gridy = 22;

		JButton botaoCancelar = new JButton("Cancelar");
		GridBagConstraints gridCancelar = new GridBagConstraints();
		gridCancelar.gridx = 2;
		gridCancelar.gridy = 22;

		final JCheckBox checkbox = new JCheckBox();
		checkbox.setText("**FECHAR CHAMADO**");
		checkbox.setBounds(50, 50, 20, 20);

		final JButton botaoAtualizarChamadoAberto = new JButton("Atualizar");
		final GridBagConstraints gridAtualizarAberto = new GridBagConstraints();
		gridAtualizarAberto.gridx = 0;
		gridAtualizarAberto.gridy = 22;

		final JButton botaoAtualizarChamadoFechado = new JButton("Atualizar");
		final GridBagConstraints gridAtualizarFechado = new GridBagConstraints();
		gridAtualizarFechado.gridx = 0;
		gridAtualizarFechado.gridy = 22;

		botaoSalvarNovoChamadoFechado.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {	
				String idUsuario = insereIDUsuario.getText();
				String idTecnico = insereIDTecnico.getText();
				String titulo = insereTitulo.getText();
				String descricao = insereDescricao.getText();
				String dataAbertura = insereDataAbertura.getText();
				String solucao = insereSolucao.getText();
				String dataFechamento = insereDataFechamento.getText();
				int result = new DAOsql().inserirChamado(idUsuario, idTecnico, titulo, descricao, dataAbertura, solucao, dataFechamento);
				if(result > 0) {
					JOptionPane.showMessageDialog(null, "Chamado cadastrado com sucesso!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
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
					dialog.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar chamado!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
					dialog.setVisible(false);
				}
			}
		});

		botaoSalvarNovoChamadoAberto.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {	
				
			try {
				Integer.parseInt(insereIDUsuario.getText());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Campo C�digo usu�rio s� aceita n�meros.", "Erro!", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
			try {
				Integer.parseInt(insereIDTecnico.getText());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Campo C�digo t�cnico s� aceita n�meros.", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			
			    String primeiraLetraDescricao = insereDescricao.getText().substring(0, 1).toUpperCase();
			    String primeiraLetraTitulo = insereTitulo.getText().substring(0, 1).toUpperCase();
				
				String idUsuario = insereIDUsuario.getText();
				String idTecnico = insereIDTecnico.getText();
				String titulo = primeiraLetraTitulo + insereTitulo.getText().substring(1, insereTitulo.getText().length()).toLowerCase();
				String descricao = primeiraLetraDescricao + insereDescricao.getText().substring(1, insereDescricao.getText().length()).toLowerCase();
				String dataAbertura = insereDataAbertura.getText();
				String solucao = null;
				String dataFechamento = null;
				int result = new DAOsql().inserirChamado(idUsuario, idTecnico, titulo, descricao, dataAbertura, solucao, dataFechamento);
				if(result > 0) {
					JOptionPane.showMessageDialog(null, "Chamado cadastrado com sucesso!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
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
					dialog.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar chamado!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
					dialog.setVisible(false);
				}
			}
		});

		botaoAtualizarChamadoAberto.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {	
				int idChamado = Integer.parseInt(insereIDChamado.getText());
				int idUsuario = Integer.parseInt(insereIDUsuario.getText());
				int idTecnico = Integer.parseInt(insereIDTecnico.getText());
				String titulo = insereTitulo.getText();
				String descricao = insereDescricao.getText();
				String dataAbertura = insereDataAbertura.getText();
				String solucao = null;
				String dataFechamento = null;
				boolean result = new DAOsql().editarChamado(idUsuario, idTecnico, titulo, descricao, dataAbertura, solucao, dataFechamento, idChamado);
				if(result) {
					JOptionPane.showMessageDialog(null, "Chamado atualizado com sucesso!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
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
					dialog.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar chamado!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
					dialog.setVisible(false);
				}
			}
		});
		
		botaoAtualizarChamadoFechado.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {	
				int idChamado = Integer.parseInt(insereIDChamado.getText());
				int idUsuario = Integer.parseInt(insereIDUsuario.getText());
				int idTecnico = Integer.parseInt(insereIDTecnico.getText());
				String titulo = insereTitulo.getText();
				String descricao = insereDescricao.getText();
				String dataAbertura = insereDataAbertura.getText();
				String solucao = insereSolucao.getText();
				String dataFechamento = insereDataFechamento.getText();
				boolean result = new DAOsql().editarChamado(idUsuario, idTecnico, titulo, descricao, dataAbertura, solucao, dataFechamento, idChamado);
				if(result) {
					JOptionPane.showMessageDialog(null, "Chamado atualizado com sucesso!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
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
					dialog.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar chamado!", "Novo Chamado!", JOptionPane.INFORMATION_MESSAGE);
					dialog.setVisible(false);
				}
			}
		});
		dialog.add(checkbox);
		dialog.add(labelIDChamado, gridLabelIDChamado);
		dialog.add(insereIDChamado, gridInsereIDchamado);
		dialog.add(labelIDUsuario, gbc0);
		dialog.add(insereIDUsuario, gb0);
		dialog.add(labelIDTecnico, gbc1);
		dialog.add(insereIDTecnico, gbc2);
		dialog.add(labelTitulo, gbc3);
		dialog.add(insereTitulo, gbc4);
		dialog.add(labelDescricao, gbc5);
		dialog.add(insereDescricao, gbc6);
		dialog.add(labelDataAbertura, gbc7);
		dialog.add(insereDataAbertura, gbc8);
		dialog.add(botaoSalvarNovoChamadoAberto, gridSalvarAberto);
		dialog.add(botaoAtualizarChamadoAberto, gridAtualizarAberto);
		dialog.add(botaoCancelar, gridCancelar);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialog.setVisible(true);		
		
		checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if(checkbox.isSelected()) {
					dialog.remove(botaoSalvarNovoChamadoAberto);
					dialog.remove(botaoAtualizarChamadoAberto);
					dialog.add(labelSolucao, gbc9);
					dialog.add(insereSolucao, gbc10);
					dialog.add(labelDataFechamento, gbc11);
					dialog.add(insereDataFechamento, gbc12);
					dialog.add(botaoSalvarNovoChamadoFechado, gridSalvarFechado);
					dialog.add(botaoAtualizarChamadoFechado, gridAtualizarFechado);
					dialog.setVisible(true);
				} else {
					dialog.add(botaoSalvarNovoChamadoAberto, gridSalvarAberto);
					dialog.add(botaoAtualizarChamadoAberto, gridAtualizarAberto);
					dialog.remove(labelSolucao);
					dialog.remove(insereSolucao);
					dialog.remove(labelDataFechamento);
					dialog.remove(insereDataFechamento);
					dialog.remove(botaoSalvarNovoChamadoFechado);
					dialog.remove(botaoAtualizarChamadoFechado);
					dialog.setVisible(true);
				}
			}
		});
		
		botaoCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				dialog.setVisible(false);
			}
		});

	}
}
