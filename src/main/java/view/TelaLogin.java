package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

import controler.DAOsql;
import model.Usuario;

public class TelaLogin {
	
	
	public void telaLogin() {
		final JDialog dialog = new JDialog();
		GridBagLayout layout = new GridBagLayout();
		dialog.setLayout(new FlowLayout(FlowLayout.LEFT));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle("JDialog - Modal de Login");
		dialog.setLayout(layout);
		
		JLabel labelUsuario = new JLabel();
		labelUsuario.setText("Usuário:");
		GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        dialog.add(labelUsuario, gbc1);
        
    	JButton botaoAutenticar = new JButton("Entrar");
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 1;
		gbc5.gridy = 7;
		dialog.add(botaoAutenticar, gbc5);
		
        final JTextField insereLogin = new JTextField();
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		insereLogin.setColumns(20);
		dialog.add(insereLogin, gbc2);
		
		JLabel labelSenha = new JLabel();
		labelSenha.setText("Senha:");
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		dialog.add(labelSenha, gbc3);

		JButton botaoFechar = new JButton("Fechar");
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx = 1;
		gbc6.gridy = 8;
		dialog.add(botaoFechar, gbc6);
		
		final JTextField insereSenha = new JTextField();
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 1;
		gbc4.gridy = 2;
		insereSenha.setColumns(20);
		dialog.add(insereSenha, gbc4);	
		dialog.setBounds(300,1,1024,768);
		dialog.setVisible(true);
		botaoAutenticar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario usuario = new Usuario();
						usuario.setLogin(insereLogin.getText());
						usuario.setSenha(insereSenha.getText());
					
						if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty()) {
	                    	JOptionPane.showMessageDialog(null, "Os campos Login e Senha são obrigatórios!");
	                    } else {
	                    	DAOsql daosql = new DAOsql();
                    		try {
								daosql.realizarLoginDAO(usuario);
								if(usuario.getNome() == null) {
		                    		JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
		                    	} else {
		                    		Telas telas = new Telas();
		                    		dialog.setVisible(false);
		                    		telas.abrirTelaPrincipal(usuario);
		                    	}
							} catch (SQLException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
	                    }
				}
		});
		
		
		botaoFechar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
		
	}
}
