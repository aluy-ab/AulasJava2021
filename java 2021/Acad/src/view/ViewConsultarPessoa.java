package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.Controller;
import model.Model;
import model.ModelPessoa;

import net.miginfocom.swing.MigLayout;
import singleton.SingletonLogger;
import util.Parameter;
import view.tableModel.TableModelPessoa;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ViewConsultarPessoa extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField fieldnome;
	private JTable table;

	private Controller ctrl;
	private TableModelPessoa tableModel;
	
	public static void main(String[] args) {
		try {
			ViewConsultarPessoa dialog = new ViewConsultarPessoa(null);	
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrar(Component parent) {
		try {
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(parent);
			setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			SingletonLogger.getInstance().doLog(e.getMessage());
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewConsultarPessoa(Controller ctrl) {
		setTitle("Consultar pessoas...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConsultarPessoa.class.getResource("/resource/people.png")));
		//this.ctrl = ctrl;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
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
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblnome = new JLabel("Nome:");
		GridBagConstraints gbc_lblnome = new GridBagConstraints();
		gbc_lblnome.insets = new Insets(0, 0, 5, 5);
		gbc_lblnome.anchor = GridBagConstraints.EAST;
		gbc_lblnome.gridx = 1;
		gbc_lblnome.gridy = 1;
		panel.add(lblnome, gbc_lblnome);
		
		fieldnome = new JTextField();
		GridBagConstraints gbc_fieldnome = new GridBagConstraints();
		gbc_fieldnome.insets = new Insets(0, 0, 5, 5);
		gbc_fieldnome.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 2;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JPanel panel_1 = new JPanel();
		panelFiltro.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(ViewConsultarPessoa.class.getResource("/resource/people.png")));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		panel_1.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tableModel = new TableModelPessoa();
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					Model model = tableModel.getModel(table.getSelectedRow());
					ctrl.manter(model);
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon(ViewConsultarPessoa.class.getResource("/resource/exit2.png")));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel_2.add(btnFechar, BorderLayout.EAST);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setIcon(new ImageIcon(ViewConsultarPessoa.class.getResource("/resource/plus2.png")));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.manter(new ModelPessoa());
			}
		});
		panel_2.add(btnInserir, BorderLayout.WEST);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void consultar() {
		try {
			tableModel.setArray(ctrl.consultar(new Parameter("nome", fieldnome.getText())));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			SingletonLogger.getInstance().doLog(e.getMessage());
		}
		
	}

}
