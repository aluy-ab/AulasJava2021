package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.ControllerAgricultor;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMainWindow window = new ViewMainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMainWindow.class.getResource("/resources/house.png")));
		frame.setBounds(100, 100, 731, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmConsultarAgricultor = new JMenuItem("Consultar agricultores...");
		mntmConsultarAgricultor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControllerAgricultor(frame);
			}
		});
		mntmConsultarAgricultor.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resources/edit.png")));
		mntmConsultarAgricultor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnSistema.add(mntmConsultarAgricultor);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnSistema.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnSistema.add(separator);
		
		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mntmFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmFechar.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resources/fechar.png")));
		mntmFechar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnSistema.add(mntmFechar);
	}

}
