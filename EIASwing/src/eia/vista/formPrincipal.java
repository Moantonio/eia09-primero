package eia.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;
import eia.model.*;

public class formPrincipal {

	private JFrame framePrincipal = null;  //  @jve:decl-index=0:visual-constraint="33,-1"
	private JPanel panelContenidoPrincipal = null;
	private JMenuBar menuPrincipal = null;
	private JMenu menuProyecto = null;
	private JMenu menuFactores = null;
	private JMenu menuAlternativas = null;
	private JMenuItem salirMenuItem = null;
	private JMenuItem acercaDeMenuItem = null;
	private JDialog dialogAcercaDe = null;  //  @jve:decl-index=0:visual-constraint="544,1"
	private JPanel panelContenidoAcercaDe = null;
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
	private JTextField nombreTextField = null;
	private JLabel nombreLabel = null;
	private JLabel descripcionLabel = null;
	private JLabel tipoLabel = null;
	private JLabel companiaLabel = null;
	private JLabel autorLabel = null;
	private JLabel poblacionLabel = null;
	private JLabel paisLabel = null;
	private JLabel provinciaLabel = null;
	private JLabel fechaLabel = null;
	private JLabel vidaUtilLabel = null;
	private JTextField tipoTextField = null;
	private JTextArea descripcionTextArea = null;
	private JTextField companiaTextField = null;
	private JTextField poblacionTextField = null;
	private JTextField paisTextField = null;
	private JTextField provinciaTextField = null;
	private JTextField autorTextField = null;
	private JTextField fechaTextField = null;
	private JTextField vidaUtilTextField = null;
	private JLabel mesesLabel = null;
	private JButton modificarButton = null;
	private JButton anadirAltButton = null;
	private JButton eliminarAltButton = null;
	private JButton editarAltButton = null;

	// Variables del modelo
	private Proyecto proyecto = null;

	/**
	 * This method initializes framePrincipal
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
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAcercaDeMenuItem() {
		if (acercaDeMenuItem == null) {
			acercaDeMenuItem = new JMenuItem();
			acercaDeMenuItem.setText("Acerca de EIA09");
			acercaDeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getDialogAcercaDe();
					Point loc = getFramePrincipal().getLocation();
					loc.translate(20, 20);
					aboutDialog.setModal(true);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return acercaDeMenuItem;
	}

	/**
	 * This method initializes dialogAcercaDe
	 * @return javax.swing.JDialog
	 */
	private JDialog getDialogAcercaDe() {
		if (dialogAcercaDe == null) {
			dialogAcercaDe = new JDialog(getFramePrincipal(), true);
			dialogAcercaDe.setTitle("Acerca de EIA09");
			dialogAcercaDe.setSize(new Dimension(200,200));
			dialogAcercaDe.setContentPane(getPanelContenidoAcercaDe());
			dialogAcercaDe.setResizable(false);
		}
		return dialogAcercaDe;
	}

	/**
	 * This method initializes panelContenidoAcercaDe
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelContenidoAcercaDe() {
		if (panelContenidoAcercaDe == null) {
			panelContenidoAcercaDe = new JPanel();
			panelContenidoAcercaDe.setLayout(null);
			panelContenidoAcercaDe.setPreferredSize(new Dimension(200, 200));
		}
		return panelContenidoAcercaDe;
	}

	/**
	 * This method initializes menuValoracion
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
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAutoviaMenuItem() {
		if (autoviaMenuItem == null) {
			autoviaMenuItem = new JMenuItem();
			autoviaMenuItem.setText("Autovía");
			autoviaMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//Pruebas
					formAlternativa lewis = new formAlternativa();
					Point loc = getFramePrincipal().getLocation();
					loc.translate(20, 20);
					lewis.setLocation(loc);
					lewis.setModal(true);
					lewis.setVisible(true);

				}
			});
		}
		return autoviaMenuItem;
	}

	/**
	 * This method initializes PresaMenuItem
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
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAbrirMenuItem() {
		if (abrirMenuItem == null) {
			abrirMenuItem = new JMenuItem();
			abrirMenuItem.setText("Abrir");
			abrirMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Ventana de abrir
					JFileChooser fileChooser = new JFileChooser();
					// Aplicamos filtro
					FiltreSimple filtro = new FiltreSimple("Ficheros XML",".xml");
		            fileChooser.setFileFilter(filtro);
					// Directorio por defecto
					fileChooser.setCurrentDirectory(new File("./"));
					int seleccion = fileChooser.showOpenDialog(null);
					// Controlamos la selección
				    if (seleccion == JFileChooser.APPROVE_OPTION) {
				    	File file = fileChooser.getSelectedFile();
				    }
				}
			});
		}
		return abrirMenuItem;
	}

	/**
	 * This method initializes guardarMenuItem
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
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getGuardarComoMenuItem() {
		if (guardarComoMenuItem == null) {
			guardarComoMenuItem = new JMenuItem();
			guardarComoMenuItem.setText("Guardar como...");
			guardarComoMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Ventana de guardar como
					JFileChooser fileChooser = new JFileChooser();
					// Aplicamos filtro
					FiltreSimple filtro = new FiltreSimple("Ficheros XML",".xml");
		            fileChooser.setFileFilter(filtro);
					// Directorio por defecto
					fileChooser.setCurrentDirectory(new File("./"));
					int seleccion = fileChooser.showSaveDialog(null);
					// Controlamos la selección
				    if (seleccion == JFileChooser.APPROVE_OPTION) {
				    	File file = fileChooser.getSelectedFile();
				    }
				}
			});
		}
		return guardarComoMenuItem;
	}

	/**
	 * This method initializes descripcionMenuItem
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
	 * @return javax.swing.JPanel
	 */
	private JPanel getInfoProyectoPanel() {
		if (infoProyectoPanel == null) {
			mesesLabel = new JLabel();
			mesesLabel.setBounds(new Rectangle(374, 148, 42, 16));
			mesesLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
			mesesLabel.setText("meses");
			vidaUtilLabel = new JLabel();
			vidaUtilLabel.setBounds(new Rectangle(289, 148, 54, 16));
			vidaUtilLabel.setText("Vida útil:");
			fechaLabel = new JLabel();
			fechaLabel.setBounds(new Rectangle(168, 148, 44, 16));
			fechaLabel.setText("Fecha:");
			provinciaLabel = new JLabel();
			provinciaLabel.setBounds(new Rectangle(229, 123, 59, 16));
			provinciaLabel.setText("Provincia:");
			paisLabel = new JLabel();
			paisLabel.setBounds(new Rectangle(54, 148, 29, 16));
			paisLabel.setText("Pais:");
			poblacionLabel = new JLabel();
			poblacionLabel.setBounds(new Rectangle(22, 124, 60, 16));
			poblacionLabel.setText("Población:");
			autorLabel = new JLabel();
			autorLabel.setBounds(new Rectangle(249, 98, 37, 16));
			autorLabel.setText("Autor:");
			companiaLabel = new JLabel();
			companiaLabel.setBounds(new Rectangle(20, 98, 61, 16));
			companiaLabel.setText("Compañía:");
			tipoLabel = new JLabel();
			tipoLabel.setBounds(new Rectangle(245, 27, 80, 19));
			tipoLabel.setText("Tipo proyecto:");
			descripcionLabel = new JLabel();
			descripcionLabel.setBounds(new Rectangle(8, 66, 72, 16));
			descripcionLabel.setText("Descripción:");
			nombreLabel = new JLabel();
			nombreLabel.setBounds(new Rectangle(32, 27, 50, 19));
			nombreLabel.setText("Nombre:");
			infoProyectoPanel = new JPanel();
			infoProyectoPanel.setLayout(null);
			infoProyectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Descripción del proyecto", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			infoProyectoPanel.setSize(new Dimension(434, 210));
			infoProyectoPanel.setLocation(new Point(30, 11));
			infoProyectoPanel.add(getNombreTextField(), null);
			infoProyectoPanel.add(nombreLabel, null);
			infoProyectoPanel.add(descripcionLabel, null);
			infoProyectoPanel.add(tipoLabel, null);
			infoProyectoPanel.add(companiaLabel, null);
			infoProyectoPanel.add(autorLabel, null);
			infoProyectoPanel.add(poblacionLabel, null);
			infoProyectoPanel.add(paisLabel, null);
			infoProyectoPanel.add(provinciaLabel, null);
			infoProyectoPanel.add(fechaLabel, null);
			infoProyectoPanel.add(vidaUtilLabel, null);
			infoProyectoPanel.add(getTipoTextField(), null);
			infoProyectoPanel.add(getDescripcionTextArea(), null);
			infoProyectoPanel.add(getCompaniaTextField(), null);
			infoProyectoPanel.add(getPoblacionTextField(), null);
			infoProyectoPanel.add(getPaisTextField(), null);
			infoProyectoPanel.add(getProvinciaTextField(), null);
			infoProyectoPanel.add(getAutorTextField(), null);
			infoProyectoPanel.add(getFechaTextField(), null);
			infoProyectoPanel.add(getVidaUtilTextField(), null);
			infoProyectoPanel.add(mesesLabel, null);
			infoProyectoPanel.add(getModificarButton(), null);
		}
		return infoProyectoPanel;
	}

	/**
	 * This method initializes alternativasPanel
	 * @return javax.swing.JPanel
	 */
	private JPanel getAlternativasPanel() {
		if (alternativasPanel == null) {
			alternativasPanel = new JPanel();
			alternativasPanel.setLayout(null);
			alternativasPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Alternativas de realización"));
			alternativasPanel.setSize(new Dimension(434, 173));
			alternativasPanel.setLocation(new Point(30, 237));
			alternativasPanel.add(getAlternativasScrollPane(), null);
			alternativasPanel.add(getAnadirAltButton(), null);
			alternativasPanel.add(getEliminarAltButton(), null);
			alternativasPanel.add(getEditarAltButton(), null);
		}
		return alternativasPanel;
	}

	/**
	 * This method initializes alternativasScrollPane
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
	 * @return javax.swing.JTable
	 */
	private JTable getAlternativasTable() {
		if (alternativasTable == null) {
			String[] columnas = {"Alternativa", "Valoración"};
			Object[][] datos = {{"Alternativa 0", "0.578"}};
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
	 * This method initializes nombreTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getNombreTextField() {
		if (nombreTextField == null) {
			nombreTextField = new JTextField();
			nombreTextField.setBounds(new Rectangle(88, 29, 151, 18));
			nombreTextField.setEnabled(false);
		}
		return nombreTextField;
	}

	/**
	 * This method initializes tipoTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getTipoTextField() {
		if (tipoTextField == null) {
			tipoTextField = new JTextField();
			tipoTextField.setBounds(new Rectangle(329, 28, 87, 18));
			tipoTextField.setEnabled(false);
		}
		return tipoTextField;
	}

	/**
	 * This method initializes descripcionTextArea
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getDescripcionTextArea() {
		if (descripcionTextArea == null) {
			descripcionTextArea = new JTextArea();
			descripcionTextArea.setBounds(new Rectangle(88, 54, 327, 36));
			descripcionTextArea.setEnabled(false);
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(new Color(192192192)));

		}
		return descripcionTextArea;
	}

	/**
	 * This method initializes companiaTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getCompaniaTextField() {
		if (companiaTextField == null) {
			companiaTextField = new JTextField();
			companiaTextField.setBounds(new Rectangle(88, 98, 125, 18));
			companiaTextField.setEnabled(false);
		}
		return companiaTextField;
	}

	/**
	 * This method initializes poblacionTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getPoblacionTextField() {
		if (poblacionTextField == null) {
			poblacionTextField = new JTextField();
			poblacionTextField.setBounds(new Rectangle(88, 123, 125, 18));
			poblacionTextField.setEnabled(false);
		}
		return poblacionTextField;
	}

	/**
	 * This method initializes paisTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getPaisTextField() {
		if (paisTextField == null) {
			paisTextField = new JTextField();
			paisTextField.setBounds(new Rectangle(89, 148, 75, 18));
			paisTextField.setEnabled(false);
		}
		return paisTextField;
	}

	/**
	 * This method initializes provinciaTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getProvinciaTextField() {
		if (provinciaTextField == null) {
			provinciaTextField = new JTextField();
			provinciaTextField.setBounds(new Rectangle(292, 123, 125, 18));
			provinciaTextField.setEnabled(false);
		}
		return provinciaTextField;
	}

	/**
	 * This method initializes autorTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getAutorTextField() {
		if (autorTextField == null) {
			autorTextField = new JTextField();
			autorTextField.setBounds(new Rectangle(292, 98, 125, 18));
			autorTextField.setEnabled(false);
		}
		return autorTextField;
	}

	/**
	 * This method initializes fechaTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getFechaTextField() {
		if (fechaTextField == null) {
			fechaTextField = new JTextField();
			fechaTextField.setBounds(new Rectangle(210, 148, 75, 18));
			fechaTextField.setEnabled(false);
		}
		return fechaTextField;
	}

	/**
	 * This method initializes vidaUtilTextField
	 * @return javax.swing.JTextField
	 */
	private JTextField getVidaUtilTextField() {
		if (vidaUtilTextField == null) {
			vidaUtilTextField = new JTextField();
			vidaUtilTextField.setBounds(new Rectangle(343, 148, 29, 18));
			vidaUtilTextField.setEnabled(false);
		}
		return vidaUtilTextField;
	}

	/**
	 * This method initializes modificarButton
	 * @return javax.swing.JButton
	 */
	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(322, 175, 94, 17));
			modificarButton.setText("Modificar");
			modificarButton.setBackground(Color.white);
			modificarButton.setName("");
		}
		return modificarButton;
	}

	/**
	 * This method initializes anadirAltButton
	 * @return javax.swing.JButton
	 */
	private JButton getAnadirAltButton() {
		if (anadirAltButton == null) {
			anadirAltButton = new JButton();
			anadirAltButton.setName("");
			anadirAltButton.setText("Añadir");
			anadirAltButton.setLocation(new Point(135, 138));
			anadirAltButton.setSize(new Dimension(88, 17));
			anadirAltButton.setBackground(Color.white);
		}
		return anadirAltButton;
	}

	/**
	 * This method initializes eliminarAltButton
	 * @return javax.swing.JButton
	 */
	private JButton getEliminarAltButton() {
		if (eliminarAltButton == null) {
			eliminarAltButton = new JButton();
			eliminarAltButton.setName("");
			eliminarAltButton.setText("Eliminar");
			eliminarAltButton.setLocation(new Point(327, 138));
			eliminarAltButton.setSize(new Dimension(88, 17));
			eliminarAltButton.setBackground(Color.white);
		}
		return eliminarAltButton;
	}

	/**
	 * This method initializes editarAltButton
	 * @return javax.swing.JButton
	 */
	private JButton getEditarAltButton() {
		if (editarAltButton == null) {
			editarAltButton = new JButton();
			editarAltButton.setName("");
			editarAltButton.setText("Editar");
			editarAltButton.setLocation(new Point(231, 138));
			editarAltButton.setSize(new Dimension(88, 17));
			editarAltButton.setBackground(Color.white);
		}
		return editarAltButton;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				formPrincipal application = new formPrincipal();
				application.getFramePrincipal().setVisible(true);
			}
		});
	}

}
