package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Controller;
import model.Model;
import model.ModelAgricultor;
import singleton.SingletonLogger;
import util.Parameter;
import view.tableModel.TableModelAgricultor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ViewConsultarAgricultor extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField fieldnome;
	private JTable table;

	private Controller ctrl;
	private TableModelAgricultor tableModel;


	/*public static void main(String[] args) {
		try {
			ViewConsultarPessoa dialog = new ViewConsultarPessoa(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/


	public void mostrar( Component parent ) {
		try {
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(parent);
			
			setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, 
					e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			SingletonLogger.getInstance().doLog ( e.getMessage() );
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewConsultarAgricultor( Controller ctrl ) {
		setTitle("Consultar agricultores...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConsultarAgricultor.class.getResource("/resources/house.png")));
		this.ctrl = ctrl;

		setBounds(100, 100, 577, 377);
		{
			JPanel panelFiltro = new JPanel();
			getContentPane().add(panelFiltro, BorderLayout.NORTH);
			panelFiltro.setLayout(new BorderLayout(0, 0));

			JPanel panel = new JPanel();
			panelFiltro.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);

			Component verticalStrut = Box.createVerticalStrut(5);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 1;
			gbc_verticalStrut.gridy = 0;
			panel.add(verticalStrut, gbc_verticalStrut);

			Component horizontalStrut = Box.createHorizontalStrut(5);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.fill = GridBagConstraints.VERTICAL;
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 0;
			gbc_horizontalStrut.gridy = 1;
			panel.add(horizontalStrut, gbc_horizontalStrut);

			JLabel lblnome = new JLabel("Nome:");
			GridBagConstraints gbc_lblnome = new GridBagConstraints();
			gbc_lblnome.anchor = GridBagConstraints.EAST;
			gbc_lblnome.insets = new Insets(0, 0, 5, 5);
			gbc_lblnome.fill = GridBagConstraints.VERTICAL;
			gbc_lblnome.gridx = 1;
			gbc_lblnome.gridy = 1;
			panel.add(lblnome, gbc_lblnome);

			fieldnome = new JTextField();
			fieldnome.setToolTipText("Informe o nome do agricultor");
			GridBagConstraints gbc_fieldnome = new GridBagConstraints();
			gbc_fieldnome.insets = new Insets(0, 0, 5, 5);
			gbc_fieldnome.fill = GridBagConstraints.BOTH;
			gbc_fieldnome.gridx = 2;
			gbc_fieldnome.gridy = 1;
			panel.add(fieldnome, gbc_fieldnome);
			fieldnome.setColumns(10);

			Component horizontalStrut_1 = Box.createHorizontalStrut(5);
			GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
			gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut_1.gridx = 3;
			gbc_horizontalStrut_1.gridy = 1;
			panel.add(horizontalStrut_1, gbc_horizontalStrut_1);

			Component verticalStrut_1 = Box.createVerticalStrut(5);
			GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
			gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
			gbc_verticalStrut_1.gridx = 1;
			gbc_verticalStrut_1.gridy = 2;
			panel.add(verticalStrut_1, gbc_verticalStrut_1);

			JPanel panel_1 = new JPanel();
			panelFiltro.add(panel_1, BorderLayout.EAST);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

			JButton btnConsultar = new JButton("Consultar");
			btnConsultar.setIcon(new ImageIcon(ViewConsultarAgricultor.class.getResource("/resources/procurar.png")));
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultar();
				}
			});
			panel_1.add(btnConsultar);
		}

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		tableModel = new TableModelAgricultor();
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2) {
					Model model = tableModel.getModel(table.getSelectedRow());
					ctrl.manter(model);
				}
			}
		});

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon(ViewConsultarAgricultor.class.getResource("/resources/fechar.png")));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel.add(btnFechar, BorderLayout.EAST);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.setIcon(new ImageIcon(ViewConsultarAgricultor.class.getResource("/resources/inserir.png")));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.manter( new ModelAgricultor() );
			}
		});
		panel.add(btnInserir, BorderLayout.WEST);
	}


	public void consultar() {
		try {
			tableModel.setArray( ctrl.consultar( 
					new Parameter ( "nome", fieldnome.getText() ) ) );
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, 
					e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			SingletonLogger.getInstance().doLog ( e.getMessage() );
		}		
	}


}
