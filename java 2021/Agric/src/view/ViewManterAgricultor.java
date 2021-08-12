package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Model;
import model.ModelAgricultor;
import singleton.SingletonLogger;

public class ViewManterAgricultor extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField fieldidagricultor;
	private JTextField fieldnome;
	private JButton btnExcluir;
	
	private Controller ctrl;
	private ModelAgricultor model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewManterAgricultor dialog = new ViewManterAgricultor(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrar(Model model, Component parent) {
		this.model = (ModelAgricultor)model;
		if (this.model.getIdagricultor()==null) {
			this.fieldidagricultor.setText("");
			this.fieldnome.setText("");
		} else {
			this.fieldidagricultor.setText(this.model.getIdagricultor().toString());
			this.fieldnome.setText(this.model.getNome());
		}
		
		btnExcluir.setEnabled( this.model.getIdagricultor()!=null);
		setLocationRelativeTo(parent);

		setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public ViewManterAgricultor( Controller ctrl ) {
		setTitle("Manter agricultor...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewManterAgricultor.class.getResource("/resources/house.png")));
		this.ctrl = ctrl;

		setBounds(100, 100, 375, 137);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 41, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblidagricultor = new JLabel("Identificador do agricultor:");
		GridBagConstraints gbc_lblidagricultor = new GridBagConstraints();
		gbc_lblidagricultor.fill = GridBagConstraints.VERTICAL;
		gbc_lblidagricultor.anchor = GridBagConstraints.EAST;
		gbc_lblidagricultor.insets = new Insets(0, 0, 5, 5);
		gbc_lblidagricultor.gridx = 0;
		gbc_lblidagricultor.gridy = 0;
		contentPanel.add(lblidagricultor, gbc_lblidagricultor);

		fieldidagricultor = new JTextField();
		fieldidagricultor.setText("1");
		fieldidagricultor.setHorizontalAlignment(SwingConstants.RIGHT);
		fieldidagricultor.setEditable(false);
		GridBagConstraints gbc_fieldidagricultor = new GridBagConstraints();
		gbc_fieldidagricultor.insets = new Insets(0, 0, 5, 5);
		gbc_fieldidagricultor.fill = GridBagConstraints.BOTH;
		gbc_fieldidagricultor.gridx = 1;
		gbc_fieldidagricultor.gridy = 0;
		contentPanel.add(fieldidagricultor, gbc_fieldidagricultor);
		fieldidagricultor.setColumns(7);

		JLabel lblnome = new JLabel("Nome:");
		GridBagConstraints gbc_lblnome = new GridBagConstraints();
		gbc_lblnome.fill = GridBagConstraints.VERTICAL;
		gbc_lblnome.insets = new Insets(0, 0, 0, 5);
		gbc_lblnome.anchor = GridBagConstraints.EAST;
		gbc_lblnome.gridx = 0;
		gbc_lblnome.gridy = 1;
		contentPanel.add(lblnome, gbc_lblnome);

		fieldnome = new JTextField();
		GridBagConstraints gbc_fieldnome = new GridBagConstraints();
		gbc_fieldnome.gridwidth = 2;
		gbc_fieldnome.insets = new Insets(0, 0, 0, 5);
		gbc_fieldnome.fill = GridBagConstraints.BOTH;
		gbc_fieldnome.gridx = 1;
		gbc_fieldnome.gridy = 1;
		contentPanel.add(fieldnome, gbc_fieldnome);
		fieldnome.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(5, 5));

			btnExcluir = new JButton("Excluir");
			btnExcluir.setIcon(new ImageIcon(ViewManterAgricultor.class.getResource("/resources/excluir.png")));
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					excluir();
				}
			});
			buttonPane.add(btnExcluir, BorderLayout.WEST);

			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(0);
			buttonPane.add(panel, BorderLayout.EAST);

			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.setIcon(new ImageIcon(ViewManterAgricultor.class.getResource("/resources/gravar.png")));
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ViewManterAgricultor.this.model.setNome ( fieldnome.getText() );
					try {
						ctrl.salvar(ViewManterAgricultor.this.model);
					} catch (Exception e) {
						JOptionPane.showMessageDialog( ViewManterAgricultor.this, 
								e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						SingletonLogger.getInstance().doLog ( e.getMessage() );
					}
				}
			});
			panel.add(btnSalvar);

			JButton btnFechar = new JButton("Fechar");
			btnFechar.setIcon(new ImageIcon(ViewManterAgricultor.class.getResource("/resources/fechar.png")));
			btnFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			panel.add(btnFechar);
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public void excluir () {
		try {			
			Object[] options = {"Confirmar", "Cancelar"}; 
			int n = JOptionPane.showOptionDialog(this,"Deseja realmente excluir esse registro?","Excluir", 
			        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

			 if(n == 0){
				 ctrl.excluir(model);
			 }					
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			SingletonLogger.getInstance().doLog ( e.getMessage() );
		}
	}
	
	public void close () {
		setVisible(false);
	}

}
