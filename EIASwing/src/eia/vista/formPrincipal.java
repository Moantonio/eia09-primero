package eia.vista;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class formPrincipal {

	private JFrame framePrincipal = null;  //  @jve:decl-index=0:visual-constraint="33,-1"
	private JPanel panelContenidoPrincipal = null;
	private JMenuBar menuPrincipal = null;
	private JMenu menuProyecto = null;
	private JMenu menuFactores = null;
	private JMenu menuAlternativas = null;
	private JMenuItem salirMenuItem = null;
	private JMenuItem acercaDeMenuItem = null;
	private JDialog dialogAcercaDe = null;  //  @jve:decl-index=0:visual-constraint="613,51"
	private JPanel panelContenidoAcercaDe = null;
	private JLabel labelVersion = null;
	private JMenu menuValoracion = null;
	private JMenu menuInformes = null;
	private JMenu menuAyuda = null;
	private JMenu menuNuevo = null;
	private JMenuItem autoviaMenuItem = null;
	private JMenuItem presaMenuItem = null;
	private JMenuItem puertoMenuItem = null;
	private JMenuItem vertederoMenuItem = null;
	private JMenuItem otroMenuItem = null;
	private JMenuItem abrirMenuItem = null;
	private JMenuItem guardarMenuItem = null;
	private JMenuItem guardarComoMenuItem = null;
	private JMenuItem descripcionMenuItem = null;
	private JMenuItem verFactoresMenuItem = null;
	private JMenuItem modificarPesosMenuItem = null;
	private JMenuItem valorarMenuItem = null;
	private JMenuItem verResultadosMenuItem = null;
	private JMenuItem verInformeMenuItem = null;
	private JMenuItem funcionamientoMenuItem = null;
	private JMenuItem legislacionMenuItem = null;
	private JMenuItem anadirAlternativaMenuItem = null;
	private JMenu eliminarAlternativaMenu = null;
	private JMenu modificarAlternativaMenu = null;
	private JPanel infoProyectoPanel = null;
	private JPanel alternativasPanel = null;
	private JScrollPane alternativasScrollPane = null;
	private JTable alternativasTable = null;

	/**
	 * This method initializes framePrincipal
	 *
	 * @return javax.swing.JFrame
	 */
	private JFrame getFramePrincipal() {
		if (framePrincipal == null) {
			framePrincipal = new JFrame();
			framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			framePrincipal.setJMenuBar(getMenuPrincipal());
			framePrincipal.setSize(500, 500);
			framePrincipal.setContentPane(getPanelContenidoPrincipal());
			framePrincipal.setTitle("EIA09");
			framePrincipal.setResizable(false);
		}
		return framePrincipal;
	}

	/**
	 * This method initializes panelContenidoPrincipal
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelContenidoPrincipal() {
		if (panelContenidoPrincipal == null) {
			panelContenidoPrincipal = new JPanel();
			panelContenidoPrincipal.setLayout(null);
			panelContenidoPrincipal.add(getInfoProyectoPanel(), null);
			panelContenidoPrincipal.add(getAlternativasPanel(), null);
		}
		return panelContenidoPrincipal;
	}

	/**
	 * This method initializes menuPrincipal
	 *
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getMenuPrincipal() {
		if (menuPrincipal == null) {
			menuPrincipal = new JMenuBar();
			menuPrincipal.setLayout(new BoxLayout(getMenuPrincipal(), BoxLayout.X_AXIS));
			menuPrincipal.add(getMenuProyecto());
			menuPrincipal.add(getMenuFactores());
			menuPrincipal.add(getMenuAlternativas());
			menuPrincipal.add(getMenuValoracion());
			menuPrincipal.add(getMenuInformes());
			menuPrincipal.add(getMenuAyuda());
		}
		return menuPrincipal;
	}

	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuProyecto() {
		if (menuProyecto == null) {
			menuProyecto = new JMenu();
			menuProyecto.setText("Proyecto");
			menuProyecto.add(getMenuNuevo());
			menuProyecto.add(getAbrirMenuItem());
			menuProyecto.addSeparator();
			menuProyecto.add(getGuardarMenuItem());
			menuProyecto.add(getGuardarComoMenuItem());
			menuProyecto.addSeparator();
			menuProyecto.add(getDescripcionMenuItem());
			menuProyecto.addSeparator();
			menuProyecto.add(getSalirMenuItem());
		}
		return menuProyecto;
	}

	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuFactores() {
		if (menuFactores == null) {
			menuFactores = new JMenu();
			menuFactores.setText("Factores");
			menuFactores.add(getVerFactoresMenuItem());
			menuFactores.add(getModificarPesosMenuItem());
		}
		return menuFactores;
	}

	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuAlternativas() {
		if (menuAlternativas == null) {
			menuAlternativas = new JMenu();
			menuAlternativas.setText("Alternativas");
			menuAlternativas.add(getAnadirAlternativaMenuItem());
			menuAlternativas.add(getModificarAlternativaMenu());
			menuAlternativas.add(getEliminarAlternativaMenu());
		}
		return menuAlternativas;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSalirMenuItem() {
		if (salirMenuItem == null) {
			salirMenuItem = new JMenuItem();
			salirMenuItem.setText("Salir");
			salirMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return salirMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAcercaDeMenuItem() {
		if (acercaDeMenuItem == null) {
			acercaDeMenuItem = new JMenuItem();
			acercaDeMenuItem.setText("Acerca de EIA09");
			acercaDeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getDialogAcercaDe();
					aboutDialog.pack();
					Point loc = getFramePrincipal().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return acercaDeMenuItem;
	}

	/**
	 * This method initializes dialogAcercaDe
	 *
	 * @return javax.swing.JDialog
	 */
	private JDialog getDialogAcercaDe() {
		if (dialogAcercaDe == null) {
			dialogAcercaDe = new JDialog(getFramePrincipal(), true);
			dialogAcercaDe.setTitle("About");
			dialogAcercaDe.setContentPane(getPanelContenidoAcercaDe());
		}
		return dialogAcercaDe;
	}

	/**
	 * This method initializes panelContenidoAcercaDe
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelContenidoAcercaDe() {
		if (panelContenidoAcercaDe == null) {
			panelContenidoAcercaDe = new JPanel();
			panelContenidoAcercaDe.setLayout(new BorderLayout());
			panelContenidoAcercaDe.add(getlabelVersion(), BorderLayout.CENTER);
		}
		return panelContenidoAcercaDe;
	}

	/**
	 * This method initializes aboutVersionLabel
	 *
	 * @return javax.swing.JLabel
	 */
	private JLabel getlabelVersion() {
		if (labelVersion == null) {
			labelVersion = new JLabel();
			labelVersion.setText("EIA09 - Versión 0.1");
			labelVersion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return labelVersion;
	}

	/**
	 * This method initializes menuValoracion
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuValoracion() {
		if (menuValoracion == null) {
			menuValoracion = new JMenu();
			menuValoracion.setText("Valoracion");
			menuValoracion.add(getValorarMenuItem());
			menuValoracion.add(getVerResultadosMenuItem());
		}
		return menuValoracion;
	}

	/**
	 * This method initializes menuInformes
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuInformes() {
		if (menuInformes == null) {
			menuInformes = new JMenu();
			menuInformes.setText("Informes");
			menuInformes.add(getVerInformeMenuItem());
		}
		return menuInformes;
	}


	/**
	 * This method initializes menuAyuda
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
			menuAyuda.add(getFuncionamientoMenuItem());
			menuAyuda.add(getLegislacionMenuItem());
			menuAyuda.addSeparator();
			menuAyuda.add(getAcercaDeMenuItem());
		}
		return menuAyuda;
	}

	/**
	 * This method initializes menuNuevo
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuNuevo() {
		if (menuNuevo == null) {
			menuNuevo = new JMenu();
			menuNuevo.setText("Nuevo");
			menuNuevo.add(getAutoviaMenuItem());
			menuNuevo.add(getPresaMenuItem());
			menuNuevo.add(getPuertoMenuItem());
			menuNuevo.add(getVertederoMenuItem());
			menuNuevo.addSeparator();
			menuNuevo.add(getOtroMenuItem());
		}
		return menuNuevo;
	}

	/**
	 * This method initializes AutoviaMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAutoviaMenuItem() {
		if (autoviaMenuItem == null) {
			autoviaMenuItem = new JMenuItem();
			autoviaMenuItem.setText("Autovía");
		}
		return autoviaMenuItem;
	}

	/**
	 * This method initializes PresaMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getPresaMenuItem() {
		if (presaMenuItem == null) {
			presaMenuItem = new JMenuItem();
			presaMenuItem.setText("Presa");
		}
		return presaMenuItem;
	}

	/**
	 * This method initializes puertoMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getPuertoMenuItem() {
		if (puertoMenuItem == null) {
			puertoMenuItem = new JMenuItem();
			puertoMenuItem.setText("Puerto deportivo");
		}
		return puertoMenuItem;
	}

	/**
	 * This method initializes vertederoMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getVertederoMenuItem() {
		if (vertederoMenuItem == null) {
			vertederoMenuItem = new JMenuItem();
			vertederoMenuItem.setText("Vertedero");
		}
		return vertederoMenuItem;
	}

	/**
	 * This method initializes otroMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getOtroMenuItem() {
		if (otroMenuItem == null) {
			otroMenuItem = new JMenuItem();
			otroMenuItem.setText("Otro");
		}
		return otroMenuItem;
	}

	/**
	 * This method initializes abrirMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAbrirMenuItem() {
		if (abrirMenuItem == null) {
			abrirMenuItem = new JMenuItem();
			abrirMenuItem.setText("Abrir");
		}
		return abrirMenuItem;
	}

	/**
	 * This method initializes guardarMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getGuardarMenuItem() {
		if (guardarMenuItem == null) {
			guardarMenuItem = new JMenuItem();
			guardarMenuItem.setText("Guardar");
		}
		return guardarMenuItem;
	}

	/**
	 * This method initializes guardarComoMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getGuardarComoMenuItem() {
		if (guardarComoMenuItem == null) {
			guardarComoMenuItem = new JMenuItem();
			guardarComoMenuItem.setText("Guardar como...");
		}
		return guardarComoMenuItem;
	}

	/**
	 * This method initializes descripcionMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getDescripcionMenuItem() {
		if (descripcionMenuItem == null) {
			descripcionMenuItem = new JMenuItem();
			descripcionMenuItem.setText("Descripción");
		}
		return descripcionMenuItem;
	}

	/**
	 * This method initializes verFactoresMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getVerFactoresMenuItem() {
		if (verFactoresMenuItem == null) {
			verFactoresMenuItem = new JMenuItem();
			verFactoresMenuItem.setText("Ver listado");
		}
		return verFactoresMenuItem;
	}

	/**
	 * This method initializes modificarPesosMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getModificarPesosMenuItem() {
		if (modificarPesosMenuItem == null) {
			modificarPesosMenuItem = new JMenuItem();
			modificarPesosMenuItem.setText("Modificar pesos");
		}
		return modificarPesosMenuItem;
	}

	/**
	 * This method initializes valorarMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getValorarMenuItem() {
		if (valorarMenuItem == null) {
			valorarMenuItem = new JMenuItem();
			valorarMenuItem.setText("Valorar");
		}
		return valorarMenuItem;
	}

	/**
	 * This method initializes verResultadosMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getVerResultadosMenuItem() {
		if (verResultadosMenuItem == null) {
			verResultadosMenuItem = new JMenuItem();
			verResultadosMenuItem.setText("Ver resultados");
		}
		return verResultadosMenuItem;
	}

	/**
	 * This method initializes verInformeMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getVerInformeMenuItem() {
		if (verInformeMenuItem == null) {
			verInformeMenuItem = new JMenuItem();
			verInformeMenuItem.setText("Ver informe");
		}
		return verInformeMenuItem;
	}

	/**
	 * This method initializes funcionamientoMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getFuncionamientoMenuItem() {
		if (funcionamientoMenuItem == null) {
			funcionamientoMenuItem = new JMenuItem();
			funcionamientoMenuItem.setText("Funcionamiento");
		}
		return funcionamientoMenuItem;
	}

	/**
	 * This method initializes legislacionMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getLegislacionMenuItem() {
		if (legislacionMenuItem == null) {
			legislacionMenuItem = new JMenuItem();
			legislacionMenuItem.setText("Legislación");
		}
		return legislacionMenuItem;
	}

	/**
	 * This method initializes anadirAlternativaMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAnadirAlternativaMenuItem() {
		if (anadirAlternativaMenuItem == null) {
			anadirAlternativaMenuItem = new JMenuItem();
			anadirAlternativaMenuItem.setText("Añadir");
		}
		return anadirAlternativaMenuItem;
	}

	/**
	 * This method initializes eliminarAlternativaMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getEliminarAlternativaMenu() {
		if (eliminarAlternativaMenu == null) {
			eliminarAlternativaMenu = new JMenu();
			eliminarAlternativaMenu.setText("Eliminar");
		}
		return eliminarAlternativaMenu;
	}

	/**
	 * This method initializes modificarAlternativaMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getModificarAlternativaMenu() {
		if (modificarAlternativaMenu == null) {
			modificarAlternativaMenu = new JMenu();
			modificarAlternativaMenu.setText("Modificar");
		}
		return modificarAlternativaMenu;
	}

	/**
	 * This method initializes infoProyectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getInfoProyectoPanel() {
		if (infoProyectoPanel == null) {
			infoProyectoPanel = new JPanel();
			infoProyectoPanel.setLayout(null);
			infoProyectoPanel.setBounds(new Rectangle(31, 24, 434, 172));
			infoProyectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Proyecto"));
		}
		return infoProyectoPanel;
	}

	/**
	 * This method initializes alternativasPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getAlternativasPanel() {
		if (alternativasPanel == null) {
			alternativasPanel = new JPanel();
			alternativasPanel.setLayout(null);
			alternativasPanel.setBounds(new Rectangle(28, 228, 434, 188));
			alternativasPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Alternativas"));
			alternativasPanel.add(getAlternativasScrollPane(), null);
		}
		return alternativasPanel;
	}

	/**
	 * This method initializes alternativasScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getAlternativasScrollPane() {
		if (alternativasScrollPane == null) {
			alternativasScrollPane = new JScrollPane();
			alternativasScrollPane.setBounds(new Rectangle(16, 31, 401, 100));
			alternativasScrollPane.setViewportView(getAlternativasTable());
		}
		return alternativasScrollPane;
	}

	/**
	 * This method initializes alternativasTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getAlternativasTable() {
		if (alternativasTable == null) {
			String[] columnas = {"Alternativa", "Valoración"};
			Object[][] datos = {{"Alternativa 0", "X"}};
			alternativasTable = new JTable(datos,columnas);
			//alternativasTable.setEnabled(false);
			alternativasTable.getTableHeader().setReorderingAllowed(false);
			TableColumnModel col = alternativasTable.getColumnModel();
			col.getColumn(0).setResizable(false);
			col.getColumn(1).setResizable(false);
			col.getColumn(0).setPreferredWidth(350);


		}
		return alternativasTable;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				formPrincipal application = new formPrincipal();
				application.getFramePrincipal().setVisible(true);
			}
		});
	}

}
