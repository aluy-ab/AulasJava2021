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
import model.ModelPessoa;
import singleton.SingletonLogger;

public class ViewManterPessoa extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField fieldidpessoa;
	private JTextField fieldnome;
	private JButton btnExcluir;
	
	private Controller ctrl;
	private ModelPessoa model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewManterPessoa dialog = new ViewManterPessoa(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrar(Model model, Component parent) {
		this.model = (ModelPessoa)model;
		if (this.model.getIdpessoa()==null) {
			this.fieldidpessoa.setText("");
			this.fieldnome.setText("");
		} else {
			this.fieldidpessoa.setText(this.model.getIdpessoa().toString());
			this.fieldnome.setText(this.model.getNome());
		}
		
		btnExcluir.setEnabled( this.model.getIdpessoa()!=null);
		setLocationRelativeTo(parent);

		setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public ViewManterPessoa( Controller ctrl ) {
		setTitle("Manter pessoa...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewManterPessoa.class.getResource("/resources/house.png")));
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

		JLabel lblidpessoa = new JLabel("Identificador da pessoa:");
		GridBagConstraints gbc_lblidpessoa = new GridBagConstraints();
		gbc_lblidpessoa.fill = GridBagConstraints.VERTICAL;
		gbc_lblidpessoa.anchor = GridBagConstraints.EAST;
		gbc_lblidpessoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblidpessoa.gridx = 0;
		gbc_lblidpessoa.gridy = 0;
		contentPanel.add(lblidpessoa, gbc_lblidpessoa);

		fieldidpessoa = new JTextField();
		fieldidpessoa.setText("1");
		fieldidpessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		fieldidpessoa.setEditable(false);
		GridBagConstraints gbc_fieldidpessoa = new GridBagConstraints();
		gbc_fieldidpessoa.insets = new Insets(0, 0, 5, 5);
		gbc_fieldidpessoa.fill = GridBagConstraints.BOTH;
		gbc_fieldidpessoa.gridx = 1;
		gbc_fieldidpessoa.gridy = 0;
		contentPanel.add(fieldidpessoa, gbc_fieldidpessoa);
		fieldidpessoa.setColumns(7);

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
			btnExcluir.setIcon(new ImageIcon(ViewManterPessoa.class.getResource("/resources/excluir.png")));
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
			btnSalvar.setIcon(new ImageIcon(ViewManterPessoa.class.getResource("/resources/gravar.png")));
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ViewManterPessoa.this.model.setNome ( fieldnome.getText() );
					try {
						ctrl.salvar(ViewManterPessoa.this.model);
					} catch (Exception e) {
						JOptionPane.showMessageDialog( ViewManterPessoa.this, 
								e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						SingletonLogger.getInstance().doLog ( e.getMessage() );
					}
				}
			});
			panel.add(btnSalvar);

			JButton btnFechar = new JButton("Fechar");
			btnFechar.setIcon(new ImageIcon(ViewManterPessoa.class.getResource("/resources/fechar.png")));
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
