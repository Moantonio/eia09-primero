package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;
import eia.modelo.Alternativa;
import eia.modelo.InfoProyecto;
import eia.modelo.Proyecto;
import eia.util.TipoProyecto;
import eia.util.xml.XMLAcciones;
import eia.util.xml.XMLProyecto;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz M�nguez.
 *         Enrique Gallego Mart�n.
 *         Luis Gonz�lez de Paula.
 */

public class FormPrincipal {

	private JFrame framePrincipal = null;  //  @jve:decl-index=0:visual-constraint="33,-1"
	private JPanel panelContenidoPrincipal = null;
	private JMenuBar menuPrincipal = null;
	private JMenu menuProyecto = null;
	private JMenu menuFactores = null;
	private JMenu menuAlternativas = null;
	private JMenuItem salirMenuItem = null;
	private JMenuItem acercaDeMenuItem = null;
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
	private JMenuItem verFactoresMenuItem = null;
	private JMenuItem modificarFactoresMenuItem = null;
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
	private TablaNoEditable modeloTabla = new TablaNoEditable();
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
	private JButton aceptarButton = null;
	private JScrollPane barraDesplazamiento = null;

	// Variables del modelo
	private Proyecto proyecto = null;  //  @jve:decl-index=0:
	private File ficheroProyecto = null;  //  @jve:decl-index=0:
	private JasperPrint informe = null;

	private JFrame getFramePrincipal() {
		if (framePrincipal == null) {
			framePrincipal = new JFrame();
			framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//system-software-update.png"));
			framePrincipal.setJMenuBar(getMenuPrincipal());
			framePrincipal.setSize(500, 500);
			framePrincipal.setContentPane(getPanelContenidoPrincipal());
			framePrincipal.setTitle("EIA09");
			framePrincipal.setResizable(false);
			inicializarAyuda();
		}
		return framePrincipal;
	}

	private JPanel getPanelContenidoPrincipal() {
		if (panelContenidoPrincipal == null) {
			panelContenidoPrincipal = new JPanel();
			panelContenidoPrincipal.setLayout(null);
			panelContenidoPrincipal.add(getInfoProyectoPanel(), null);
			panelContenidoPrincipal.add(getAlternativasPanel(), null);
		}
		return panelContenidoPrincipal;
	}

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

	private JMenu getMenuProyecto() {
		if (menuProyecto == null) {
			menuProyecto = new JMenu();
			menuProyecto.setText("Proyecto");
			menuProyecto.setIcon(new ImageIcon(".//images//edit-find-replace.png"));
			menuProyecto.add(getMenuNuevo());
			menuProyecto.add(getAbrirMenuItem());
			menuProyecto.addSeparator();
			menuProyecto.add(getGuardarMenuItem());
			menuProyecto.add(getGuardarComoMenuItem());
			menuProyecto.addSeparator();
			menuProyecto.add(getSalirMenuItem());
			menuProyecto.setMnemonic(KeyEvent.VK_P);
		}
		return menuProyecto;
	}

	private JMenu getMenuFactores() {
		if (menuFactores == null) {
			menuFactores = new JMenu();
			menuFactores.setText("Factores");
			menuFactores.setIcon(new ImageIcon(".//images//text-html.png"));
			menuFactores.add(getVerFactoresMenuItem());
			menuFactores.add(getModificarFactoresMenuItem());
			menuFactores.setMnemonic(KeyEvent.VK_F);
			menuFactores.setEnabled(false);
		}
		return menuFactores;
	}

	private JMenu getMenuAlternativas() {
		if (menuAlternativas == null) {
			menuAlternativas = new JMenu();
			menuAlternativas.setText("Alternativas");
			menuAlternativas.add(getAnadirAlternativaMenuItem());
			menuAlternativas.add(getModificarAlternativaMenu());
			menuAlternativas.add(getEliminarAlternativaMenu());
			menuAlternativas.setIcon(new ImageIcon(".//images//edit-copy.png"));
			menuAlternativas.setMnemonic(KeyEvent.VK_A);
			menuAlternativas.setEnabled(false);
		}
		return menuAlternativas;
	}

	private JMenuItem getSalirMenuItem() {
		if (salirMenuItem == null) {
			salirMenuItem = new JMenuItem();
			salirMenuItem.setText("Salir");
			salirMenuItem.setMnemonic(KeyEvent.VK_S);
			salirMenuItem.setIcon(new ImageIcon(".//images//system-log-out.png"));
			salirMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return salirMenuItem;
	}

	private JMenuItem getAcercaDeMenuItem() {
		if (acercaDeMenuItem == null) {
			acercaDeMenuItem = new JMenuItem();
			acercaDeMenuItem.setText("Acerca de EIA09");
			acercaDeMenuItem.setMnemonic(KeyEvent.VK_A);
			acercaDeMenuItem.setIcon(new ImageIcon(".//images//format-indent-more.png"));
			acercaDeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAcercaDe();
				}
			});
		}
		return acercaDeMenuItem;
	}

	private JMenu getMenuValoracion() {
		if (menuValoracion == null) {
			menuValoracion = new JMenu();
			menuValoracion.setText("Valoracion");
			menuValoracion.add(getVerResultadosMenuItem());
			menuValoracion.setMnemonic(KeyEvent.VK_V);
			menuValoracion.setEnabled(false);
			menuValoracion.setIcon(new ImageIcon(".//images//utilities-system-monitor.png"));
		}
		return menuValoracion;
	}

	private JMenu getMenuInformes() {
		if (menuInformes == null) {
			menuInformes = new JMenu();
			menuInformes.setText("Informes");
			menuInformes.add(getGenerarInformeMenuItem());
			menuInformes.add(getVerInformeMenuItem());
			menuInformes.setMnemonic(KeyEvent.VK_I);
			menuInformes.setEnabled(false);
			menuInformes.setIcon(new ImageIcon(".//images//preferences-system-windows.png"));
		}
		return menuInformes;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
			menuAyuda.setIcon(new ImageIcon(".//images//help-browser.png"));
			menuAyuda.add(getFuncionamientoMenuItem());
			menuAyuda.add(getLegislacionMenuItem());
			menuAyuda.addSeparator();
			menuAyuda.add(getAcercaDeMenuItem());
			menuAyuda.setMnemonic(KeyEvent.VK_U);
		}
		return menuAyuda;
	}

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
			menuNuevo.setMnemonic(KeyEvent.VK_N);
			menuNuevo.setIcon(new ImageIcon(".//images//window-new.png"));
		}
		return menuNuevo;
	}

	private JMenuItem getAutoviaMenuItem() {
		if (autoviaMenuItem == null) {
			autoviaMenuItem = new JMenuItem();
			autoviaMenuItem.setText("Autov�a");
			autoviaMenuItem.setMnemonic(KeyEvent.VK_A);
			autoviaMenuItem.setIcon(new ImageIcon(".//images//x-office-spreadsheet-template.png"));
			autoviaMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProyecto(TipoProyecto.AUTOV�A);
				}
			});
		}
		return autoviaMenuItem;
	}

	private JMenuItem getPresaMenuItem() {
		if (presaMenuItem == null) {
			presaMenuItem = new JMenuItem();
			presaMenuItem.setText("Presa");
			presaMenuItem.setMnemonic(KeyEvent.VK_P);
			presaMenuItem.setIcon(new ImageIcon(".//images//x-office-document-template.png"));
			presaMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProyecto(TipoProyecto.PRESA);
				}
			});
		}
		return presaMenuItem;
	}

	private JMenuItem getPuertoMenuItem() {
		if (puertoMenuItem == null) {
			puertoMenuItem = new JMenuItem();
			puertoMenuItem.setText("Puerto deportivo");
			puertoMenuItem.setIcon(new ImageIcon(".//images//x-office-drawing-template.png"));
			puertoMenuItem.setMnemonic(KeyEvent.VK_U);
			puertoMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProyecto(TipoProyecto.PUERTODEPORTIVO);
				}
			});
		}
		return puertoMenuItem;
	}

	private JMenuItem getVertederoMenuItem() {
		if (vertederoMenuItem == null) {
			vertederoMenuItem = new JMenuItem();
			vertederoMenuItem.setText("Vertedero");
			vertederoMenuItem.setIcon(new ImageIcon(".//images//x-office-presentation-template.png"));
			vertederoMenuItem.setMnemonic(KeyEvent.VK_V);
			vertederoMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProyecto(TipoProyecto.VERTEDERO);
				}
			});
		}
		return vertederoMenuItem;
	}

	private JMenuItem getOtroMenuItem() {
		if (otroMenuItem == null) {
			otroMenuItem = new JMenuItem();
			otroMenuItem.setText("Personalizado");
			otroMenuItem.setIcon(new ImageIcon(".//images//x-office-document.png"));
			otroMenuItem.setMnemonic(KeyEvent.VK_E);
			otroMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProyecto(TipoProyecto.PERSONALIZADO);
				}
			});
		}
		return otroMenuItem;
	}

	private JMenuItem getAbrirMenuItem() {
		if (abrirMenuItem == null) {
			abrirMenuItem = new JMenuItem();
			abrirMenuItem.setText("Abrir");
			abrirMenuItem.setMnemonic(KeyEvent.VK_A);
			abrirMenuItem.setIcon(new ImageIcon(".//images//document-open.png"));
			abrirMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirProyecto();
				}
			});
		}
		return abrirMenuItem;
	}

	private JMenuItem getGuardarMenuItem() {
		if (guardarMenuItem == null) {
			guardarMenuItem = new JMenuItem();
			guardarMenuItem.setText("Guardar");
			guardarMenuItem.setMnemonic(KeyEvent.VK_G);
			guardarMenuItem.setEnabled(false);
			guardarMenuItem.setIcon(new ImageIcon(".//images//document-save.png"));
			guardarMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardarProyecto();
				}
			});
		}
		return guardarMenuItem;
	}

	private JMenuItem getGuardarComoMenuItem() {
		if (guardarComoMenuItem == null) {
			guardarComoMenuItem = new JMenuItem();
			guardarComoMenuItem.setText("Guardar como...");
			guardarComoMenuItem.setMnemonic(KeyEvent.VK_U);
			guardarComoMenuItem.setEnabled(false);
			guardarComoMenuItem.setIcon(new ImageIcon(".//images//document-save-as.png"));
			guardarComoMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardarComoProyecto();
				}
			});
		}
		return guardarComoMenuItem;
	}

	private JMenuItem getVerFactoresMenuItem() {
		if (verFactoresMenuItem == null) {
			verFactoresMenuItem = new JMenuItem();
			verFactoresMenuItem.setText("Ver listado");
			verFactoresMenuItem.setMnemonic(KeyEvent.VK_V);
			verFactoresMenuItem.setIcon(new ImageIcon(".//images//text-x-generic-template.png"));
			verFactoresMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarFactores(false);
				}
			});
		}
		return verFactoresMenuItem;
	}

	private JMenuItem getModificarFactoresMenuItem() {
		if (modificarFactoresMenuItem == null) {
			modificarFactoresMenuItem = new JMenuItem();
			modificarFactoresMenuItem.setText("Modificar pesos");
			modificarFactoresMenuItem.setMnemonic(KeyEvent.VK_M);
			modificarFactoresMenuItem.setIcon(new ImageIcon(".//images//document-properties.png"));
			modificarFactoresMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarFactores(true);
				}
			});
		}
		return modificarFactoresMenuItem;
	}

	private JMenuItem getVerResultadosMenuItem() {
		if (verResultadosMenuItem == null) {
			verResultadosMenuItem = new JMenuItem();
			verResultadosMenuItem.setMnemonic(KeyEvent.VK_E);
			verResultadosMenuItem.setText("Ver resultados");
			verResultadosMenuItem.setIcon(new ImageIcon(".//images//view-refresh.png"));
			verResultadosMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					valorarAlternativas();
			}
		});
		}
		return verResultadosMenuItem;
	}

	private JMenuItem getVerInformeMenuItem() {
		if (verInformeMenuItem == null) {
			verInformeMenuItem = new JMenuItem();
			verInformeMenuItem.setMnemonic(KeyEvent.VK_E);
			verInformeMenuItem.setText("Ver informe");
			verInformeMenuItem.setIcon(new ImageIcon(".//images//format-justify-center.png"));
			verInformeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarInforme();
			}
		});
		}
		return verInformeMenuItem;
	}

	private JMenuItem getFuncionamientoMenuItem() {
		if (funcionamientoMenuItem == null) {
			funcionamientoMenuItem = new JMenuItem();
			funcionamientoMenuItem.setMnemonic(KeyEvent.VK_F);
			funcionamientoMenuItem.setText("Funcionamiento");
			funcionamientoMenuItem.setIcon(new ImageIcon(".//images//internet-news-reader.png"));

		}
		return funcionamientoMenuItem;
	}

	private JMenuItem getLegislacionMenuItem() {
		if (legislacionMenuItem == null) {
			legislacionMenuItem = new JMenuItem();
			legislacionMenuItem.setMnemonic(KeyEvent.VK_L);
			legislacionMenuItem.setIcon(new ImageIcon(".//images//edit-select-all.png"));
			legislacionMenuItem.setText("Legislaci�n");
			legislacionMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzarLegislacion();
				}
			});
		}
		return legislacionMenuItem;
	}

	private void lanzarLegislacion(){
		//TODO abrir la dir donde este la legislacion en HTML
		ApplicationLauncher.launchURL("http://www.eia.es/web/04/cn02.asp");
	}

	private JMenuItem getAnadirAlternativaMenuItem() {
		if (anadirAlternativaMenuItem == null) {
			anadirAlternativaMenuItem = new JMenuItem();
			anadirAlternativaMenuItem.setText("A�adir");
			anadirAlternativaMenuItem.setMnemonic(KeyEvent.VK_D);
			anadirAlternativaMenuItem.setIcon(new ImageIcon(".//images//list-add.png"));
			anadirAlternativaMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearAlternativa();
				}
			});
		}
		return anadirAlternativaMenuItem;
	}

	private JMenu getEliminarAlternativaMenu() {
		if (eliminarAlternativaMenu == null) {
			eliminarAlternativaMenu = new JMenu();
			eliminarAlternativaMenu.setIcon(new ImageIcon(".//images//list-remove.png"));
			eliminarAlternativaMenu.setMnemonic(KeyEvent.VK_L);
			eliminarAlternativaMenu.setText("Eliminar");
		}
		return eliminarAlternativaMenu;
	}

	private JMenu getModificarAlternativaMenu() {
		if (modificarAlternativaMenu == null) {
			modificarAlternativaMenu = new JMenu();
			modificarAlternativaMenu.setMnemonic(KeyEvent.VK_E);
			modificarAlternativaMenu.setIcon(new ImageIcon(".//images//applications-system.png"));
			modificarAlternativaMenu.setText("Editar");
		}
		return modificarAlternativaMenu;
	}

	private JPanel getInfoProyectoPanel() {
		if (infoProyectoPanel == null) {
			mesesLabel = new JLabel();
			mesesLabel.setBounds(new Rectangle(381, 148, 42, 16));
			mesesLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
			mesesLabel.setText("meses");
			vidaUtilLabel = new JLabel();
			vidaUtilLabel.setBounds(new Rectangle(296, 148, 54, 16));
			vidaUtilLabel.setText("Vida �til:");
			fechaLabel = new JLabel();
			fechaLabel.setBounds(new Rectangle(175, 148, 44, 16));
			fechaLabel.setText("Fecha:");
			provinciaLabel = new JLabel();
			provinciaLabel.setBounds(new Rectangle(236, 123, 59, 16));
			provinciaLabel.setText("Provincia:");
			paisLabel = new JLabel();
			paisLabel.setBounds(new Rectangle(61, 148, 29, 16));
			paisLabel.setText("Pais:");
			poblacionLabel = new JLabel();
			poblacionLabel.setBounds(new Rectangle(29, 124, 60, 16));
			poblacionLabel.setText("Poblaci�n:");
			autorLabel = new JLabel();
			autorLabel.setBounds(new Rectangle(256, 98, 37, 16));
			autorLabel.setText("Autor:");
			companiaLabel = new JLabel();
			companiaLabel.setBounds(new Rectangle(27, 98, 61, 16));
			companiaLabel.setText("Compa��a:");
			tipoLabel = new JLabel();
			tipoLabel.setBounds(new Rectangle(252, 27, 80, 19));
			tipoLabel.setText("Tipo proyecto:");
			descripcionLabel = new JLabel();
			descripcionLabel.setBounds(new Rectangle(15, 66, 72, 16));
			descripcionLabel.setText("Descripci�n:");
			nombreLabel = new JLabel();
			nombreLabel.setBounds(new Rectangle(39, 27, 50, 19));
			nombreLabel.setText("Nombre:");
			infoProyectoPanel = new JPanel();
			infoProyectoPanel.setLayout(null);
			infoProyectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Descripci�n del proyecto", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			infoProyectoPanel.setSize(new Dimension(445, 210));
			infoProyectoPanel.setLocation(new Point(24, 11));
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
			infoProyectoPanel.add(getScrollPane(), null);
			infoProyectoPanel.add(getCompaniaTextField(), null);
			infoProyectoPanel.add(getPoblacionTextField(), null);
			infoProyectoPanel.add(getPaisTextField(), null);
			infoProyectoPanel.add(getProvinciaTextField(), null);
			infoProyectoPanel.add(getAutorTextField(), null);
			infoProyectoPanel.add(getFechaTextField(), null);
			infoProyectoPanel.add(getVidaUtilTextField(), null);
			infoProyectoPanel.add(mesesLabel, null);
			infoProyectoPanel.add(getModificarButton(), null);
			infoProyectoPanel.add(getAceptarButton(), null);
		}
		return infoProyectoPanel;
	}

	private JPanel getAlternativasPanel() {
		if (alternativasPanel == null) {
			alternativasPanel = new JPanel();
			alternativasPanel.setLayout(null);
			alternativasPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Alternativas de realizaci�n"));
			alternativasPanel.setLocation(new Point(24, 237));
			alternativasPanel.setSize(new Dimension(445, 173));
			alternativasPanel.add(getAlternativasScrollPane(), null);
			alternativasPanel.add(getAnadirAltButton(), null);
			alternativasPanel.add(getEliminarAltButton(), null);
			alternativasPanel.add(getEditarAltButton(), null);
		}
		return alternativasPanel;
	}

	private JScrollPane getAlternativasScrollPane() {
		if (alternativasScrollPane == null) {
			alternativasScrollPane = new JScrollPane();
			alternativasScrollPane.setBounds(new Rectangle(20, 28, 401, 100));
			alternativasScrollPane.setViewportView(getAlternativasTable());
		}
		return alternativasScrollPane;
	}

	private JTable getAlternativasTable() {
		if (alternativasTable == null) {

			alternativasTable = new TablaColores(modeloTabla);
			modeloTabla.addColumn("Alternativa");
			modeloTabla.addColumn("Valoraci�n");


			alternativasTable.setRowSelectionAllowed(true);
			alternativasTable.setShowVerticalLines(false);
			alternativasTable.setEnabled(false);
			alternativasTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			alternativasTable.setRowSelectionAllowed(true);
			alternativasTable.getTableHeader().setReorderingAllowed(false);


			TableColumnModel col = alternativasTable.getColumnModel();
			col.getColumn(0).setResizable(false);
			col.getColumn(1).setResizable(false);
			col.getColumn(0).setPreferredWidth(350);
		}
		return alternativasTable;
	}

	private JTextField getNombreTextField() {
		if (nombreTextField == null) {
			nombreTextField = new JTextField();
			nombreTextField.setBounds(new Rectangle(95, 29, 151, 18));
			nombreTextField.setEnabled(false);
		}
		return nombreTextField;
	}

	private JTextField getTipoTextField() {
		if (tipoTextField == null) {
			tipoTextField = new JTextField();
			tipoTextField.setBounds(new Rectangle(336, 28, 87, 18));
			tipoTextField.setEnabled(false);
		}
		return tipoTextField;
	}

	private JTextArea getDescripcionTextArea() {
		if (descripcionTextArea == null) {
			descripcionTextArea = new JTextArea();
			descripcionTextArea.setBounds(new Rectangle(88, 54, 327, 36));
			descripcionTextArea.setEnabled(false);
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(new Color(192192192)));
			descripcionTextArea.setLineWrap(true);
			descripcionTextArea.setWrapStyleWord(true);
		}
		return descripcionTextArea;
	}

	private JScrollPane getScrollPane() {
		if (barraDesplazamiento == null) {
			barraDesplazamiento = new JScrollPane(getDescripcionTextArea());
			barraDesplazamiento.setBounds(new Rectangle(95, 54, 327, 36));
			barraDesplazamiento.setEnabled(true);
			barraDesplazamiento.setBorder(BorderFactory.createLineBorder(new Color(116, 158, 192), 0));
		}
		return barraDesplazamiento;
	}

	JScrollPane scroll = new JScrollPane();
	private JMenuItem generarInformeMenuItem = null;

	private JTextField getCompaniaTextField() {
		if (companiaTextField == null) {
			companiaTextField = new JTextField();
			companiaTextField.setBounds(new Rectangle(95, 98, 125, 18));
			companiaTextField.setEnabled(false);
		}
		return companiaTextField;
	}

	private JTextField getPoblacionTextField() {
		if (poblacionTextField == null) {
			poblacionTextField = new JTextField();
			poblacionTextField.setBounds(new Rectangle(95, 123, 125, 18));
			poblacionTextField.setEnabled(false);
		}
		return poblacionTextField;
	}

	private JTextField getPaisTextField() {
		if (paisTextField == null) {
			paisTextField = new JTextField();
			paisTextField.setBounds(new Rectangle(96, 148, 75, 18));
			paisTextField.setEnabled(false);
		}
		return paisTextField;
	}

	private JTextField getProvinciaTextField() {
		if (provinciaTextField == null) {
			provinciaTextField = new JTextField();
			provinciaTextField.setBounds(new Rectangle(299, 123, 125, 18));
			provinciaTextField.setEnabled(false);
		}
		return provinciaTextField;
	}

	private JTextField getAutorTextField() {
		if (autorTextField == null) {
			autorTextField = new JTextField();
			autorTextField.setBounds(new Rectangle(299, 98, 125, 18));
			autorTextField.setEnabled(false);
		}
		return autorTextField;
	}

	private JTextField getFechaTextField() {
		if (fechaTextField == null) {
			fechaTextField = new JTextField();
			fechaTextField.setBounds(new Rectangle(217, 148, 75, 18));
			fechaTextField.setEnabled(false);
		}
		return fechaTextField;
	}

	private JTextField getVidaUtilTextField() {
		if (vidaUtilTextField == null) {
			vidaUtilTextField = new JTextField();
			vidaUtilTextField.setBounds(new Rectangle(350, 148, 29, 18));
			vidaUtilTextField.setEnabled(false);
		}
		return vidaUtilTextField;
	}

	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(329, 175, 94, 17));
			modificarButton.setText("Modificar");
			modificarButton.setEnabled(false);
			modificarButton.setBackground(Color.white);
			modificarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					permitirModificarDescripcion();
				}
			});
		}
		return modificarButton;
	}

	private JButton getAnadirAltButton() {
		if (anadirAltButton == null) {
			anadirAltButton = new JButton();
			anadirAltButton.setName("");
			anadirAltButton.setText("A�adir");
			anadirAltButton.setLocation(new Point(139, 135));
			anadirAltButton.setSize(new Dimension(88, 17));
			anadirAltButton.setEnabled(false);
			anadirAltButton.setBackground(Color.white);
			anadirAltButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearAlternativa();
				}
			});
		}
		return anadirAltButton;
	}

	private JButton getEliminarAltButton() {
		if (eliminarAltButton == null) {
			eliminarAltButton = new JButton();
			eliminarAltButton.setName("");
			eliminarAltButton.setText("Eliminar");
			eliminarAltButton.setLocation(new Point(331, 135));
			eliminarAltButton.setSize(new Dimension(88, 17));
			eliminarAltButton.setEnabled(false);
			eliminarAltButton.setBackground(Color.white);
			eliminarAltButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = alternativasTable.getSelectedRow();
					if (indice != -1){
						Alternativa alternativa = proyecto.getAlternativas().get(indice);
						eliminarAlternativa(alternativa);
					}
				}
			});
		}
		return eliminarAltButton;
	}

	private JButton getEditarAltButton() {
		if (editarAltButton == null) {
			editarAltButton = new JButton();
			editarAltButton.setName("");
			editarAltButton.setText("Editar");
			editarAltButton.setLocation(new Point(235, 135));
			editarAltButton.setSize(new Dimension(88, 17));
			editarAltButton.setEnabled(false);
			editarAltButton.setBackground(Color.white);
			editarAltButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = alternativasTable.getSelectedRow();
					if (indice != -1){
						Alternativa alternativa = proyecto.getAlternativas().get(indice);
						editarAlternativa(alternativa,indice);
					}
				}
			});
		}
		return editarAltButton;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(239, 175));
			aceptarButton.setSize(new Dimension(87, 17));
			aceptarButton.setBackground(Color.white);
			aceptarButton.setVisible(false);
			aceptarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificarDescripcion();
				}
			});
		}
		return aceptarButton;
	}

	private void actualizarDescripcion(){
		nombreTextField.setText(proyecto.getInformacion().getNombre());
		tipoTextField.setText(proyecto.getTipo().toString());
		descripcionTextArea.setText(proyecto.getInformacion().getDescripcion());
		companiaTextField.setText(proyecto.getInformacion().getCompania());
		autorTextField.setText(proyecto.getInformacion().getAutor());
		poblacionTextField.setText(proyecto.getInformacion().getPoblacion());
		provinciaTextField.setText(proyecto.getInformacion().getProvincia());
		paisTextField.setText(proyecto.getInformacion().getPais());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fechaStr = format.format(proyecto.getInformacion().getFecha());
		fechaTextField.setText(fechaStr);
		vidaUtilTextField.setText(String.valueOf(proyecto.getInformacion().getVidaUtil()));
		modificarButton.setEnabled(true);
	}

	private void actualizarAlternativas(){
		//Limpiar alternativas
		modeloTabla.setRowCount(0);
		alternativasTable.setEnabled(true);
		anadirAltButton.setEnabled(true);
		editarAltButton.setEnabled(true);
		eliminarAltButton.setEnabled(true);

		// Borramos el submen� modificar y eliminar alternativa
		getModificarAlternativaMenu().removeAll();
		getEliminarAlternativaMenu().removeAll();

		for (int i=0;i<proyecto.getAlternativas().size();i++)
		{
			final Alternativa alternativa = proyecto.getAlternativas().get(i);
			//Lo a�adimos a la lista
			String valor = "Sin valorar";
			if (alternativa.getValorada()){
				valor = String.valueOf(alternativa.getValorTotal());
			}
			String[] fila = {alternativa.getId(),valor};
			modeloTabla.addRow(fila);

			//Lo ponemos en el men� modificar
			JMenuItem alternativaModItem = new JMenuItem();
			alternativaModItem.setText(alternativa.getId());
			getModificarAlternativaMenu().add(alternativaModItem);
			alternativaModItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editarAlternativa(alternativa,0);
				}
			});
			//Lo ponemos en el men� eliminar
			JMenuItem alternativaElimItem = new JMenuItem();
			alternativaElimItem.setText(alternativa.getId());
			getEliminarAlternativaMenu().add(alternativaElimItem);
			alternativaElimItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarAlternativa(alternativa);
				}
			});
		}

	}

	private void actualizarMenu(){
		menuAlternativas.setEnabled(true);
		menuFactores.setEnabled(true);
		guardarComoMenuItem.setEnabled(true);
	}

	private void actualizarValorar(){
		if (comprobarValorar()){
			menuValoracion.setEnabled(true);
			menuInformes.setEnabled(true);
			verInformeMenuItem.setEnabled(false);
		}else{
			menuValoracion.setEnabled(false);
			menuInformes.setEnabled(false);
			verInformeMenuItem.setEnabled(false);
		}
	}

	private void crearProyecto(TipoProyecto tipo){
		// Creamos un formulario de creaccion de proyecto
		FormCrearProyecto ventanaCrear = new FormCrearProyecto(tipo.toString());
		Point loc = getFramePrincipal().getLocation();
		loc.translate(20, 20);
		ventanaCrear.setLocation(loc);
		ventanaCrear.setModal(true);
		ventanaCrear.setVisible(true);
		if(ventanaCrear.isFlagAceptar()){
			//Tomamos los datos
			String nombre = ventanaCrear.getNombre();
			String descripcion = ventanaCrear.getDescripcion();
			//Creamos el proyecto
			InfoProyecto info = new InfoProyecto();
			info.setNombre(nombre);
			info.setDescripcion(descripcion);

			XMLProyecto xmlProy = new XMLProyecto(".//plantillas//proyectoEIA.dtd");
			proyecto = (Proyecto)xmlProy.leer(".//plantillas//proyectoVacio.xml");
			proyecto.setInformacion(info);
			proyecto.setTipo(tipo);

			//Actualizamos la vista
			actualizarDescripcion();
			actualizarAlternativas();
			actualizarMenu();
			ficheroProyecto = null;
			guardarMenuItem.setEnabled(false);
		}
		ventanaCrear.dispose();
	}

	private void modificarDescripcion() {
		nombreTextField.setEnabled(false);
		proyecto.getInformacion().setNombre(nombreTextField.getText());
		descripcionTextArea.setEnabled(false);
		proyecto.getInformacion().setDescripcion(descripcionTextArea.getText());
		companiaTextField.setEnabled(false);
		proyecto.getInformacion().setCompania(companiaTextField.getText());
		autorTextField.setEnabled(false);
		proyecto.getInformacion().setAutor(autorTextField.getText());
		poblacionTextField.setEnabled(false);
		proyecto.getInformacion().setPoblacion(poblacionTextField.getText());
		provinciaTextField.setEnabled(false);
		proyecto.getInformacion().setProvincia(provinciaTextField.getText());
		paisTextField.setEnabled(false);
		proyecto.getInformacion().setPais(paisTextField.getText());
		vidaUtilTextField.setEnabled(false);
		proyecto.getInformacion().setVidaUtil(Integer.parseInt(vidaUtilTextField.getText()));
		aceptarButton.setVisible(false);
		modificarButton.setEnabled(true);
	}

	private void mostrarAcercaDe() {
		FormAcercaDe aboutDialog = new FormAcercaDe(getFramePrincipal());
		Point loc = getFramePrincipal().getLocation();
		loc.translate(20, 20);
		aboutDialog.setModal(true);
		aboutDialog.setLocation(loc);
		aboutDialog.setVisible(true);

	}

	private void abrirProyecto() {
		// Ventana de abrir
		JFileChooser fileChooser = new JFileChooser();
		// Aplicamos filtro
		FiltreSimple filtro = new FiltreSimple("Ficheros XML",".xml");
		fileChooser.setFileFilter(filtro);
		// Directorio por defecto
		fileChooser.setCurrentDirectory(new File(".//proyectos//"));
		int seleccion = fileChooser.showOpenDialog(null);
		// Controlamos la selecci�n
		if (seleccion == JFileChooser.APPROVE_OPTION) {

			informe = null;
			ficheroProyecto = fileChooser.getSelectedFile();
			XMLProyecto xmlProy = new XMLProyecto("..//plantillas//proyectoEIA.dtd");
			proyecto = (Proyecto)xmlProy.leer(ficheroProyecto.getAbsolutePath());

			//Actualizamos la vista
			actualizarDescripcion();
			actualizarAlternativas();
			actualizarMenu();
			actualizarValorar();
			guardarMenuItem.setEnabled(true);
		}
	}

	private void guardarProyecto() {
		if (ficheroProyecto!=null){
			String curDir = System.getProperty("user.dir");
			curDir = curDir + "//plantillas//proyectoEIA.dtd";
			XMLProyecto xmlProy = new XMLProyecto(curDir);
			xmlProy.escribir(proyecto,ficheroProyecto.getAbsolutePath());
		}
	}

	private void guardarComoProyecto() {
		// Ventana de guardar como
		JFileChooser fileChooser = new JFileChooser();
		// Aplicamos filtro
		FiltreSimple filtro = new FiltreSimple("Ficheros XML",".xml");
		fileChooser.setFileFilter(filtro);
		// Directorio por defecto
		fileChooser.setCurrentDirectory(new File(".//proyectos//"));
		int seleccion = fileChooser.showSaveDialog(null);
		// Controlamos la selecci�n
		if (seleccion == JFileChooser.APPROVE_OPTION) {

			ficheroProyecto = fileChooser.getSelectedFile();
			String curDir = System.getProperty("user.dir");
			curDir = curDir + "//plantillas//proyectoEIA.dtd";
			XMLProyecto xmlProy = new XMLProyecto(curDir);
			//XMLProyecto xmlProy = new XMLProyecto("..//plantillas//proyectoEIA.dtd");
			if(ficheroProyecto.isFile()){
				int opcion = JOptionPane.showConfirmDialog (null,
						"�Est� seguro que desea reemplazar este archivo?",
						"Reemplazar archivo",
						JOptionPane.YES_NO_OPTION);
				if (opcion==JOptionPane.YES_OPTION){
					xmlProy.escribir(proyecto,ficheroProyecto.getAbsolutePath());
				}
			}else{
				xmlProy.escribir(proyecto,ficheroProyecto.getAbsolutePath()+".xml");
				ficheroProyecto = new File(ficheroProyecto.getAbsolutePath()+".xml");
			}

			guardarMenuItem.setEnabled(true);
		}
	}

	private void permitirModificarDescripcion() {
		nombreTextField.setEnabled(true);
		descripcionTextArea.setEnabled(true);
		companiaTextField.setEnabled(true);
		autorTextField.setEnabled(true);
		poblacionTextField.setEnabled(true);
		provinciaTextField.setEnabled(true);
		paisTextField.setEnabled(true);
		vidaUtilTextField.setEnabled(true);
		aceptarButton.setVisible(true);
		modificarButton.setEnabled(false);
	}

	private void crearAlternativa() {
		FormCrearAlternativa crearAlternativa = new FormCrearAlternativa(getFramePrincipal(),proyecto.getInformacion().getNombre());
		Point posActual = getFramePrincipal().getLocation();
		posActual.translate(20, 20);
		crearAlternativa.setLocation(posActual);
		crearAlternativa.setModal(true);
		crearAlternativa.setVisible(true);
		if(crearAlternativa.isFlagAceptar()){
			String nombre = crearAlternativa.getNombreAlternativa();

			final Alternativa alternativa = new Alternativa();
			if (proyecto.getTipo() != TipoProyecto.PERSONALIZADO){
				String filename = null;
				if (proyecto.getTipo() == TipoProyecto.AUTOV�A){
					filename = ".//plantillas//accionesVia.xml";
				} else if(proyecto.getTipo() == TipoProyecto.PRESA){
					filename = ".//plantillas//accionesPresa.xml";
				} else if(proyecto.getTipo() == TipoProyecto.PUERTODEPORTIVO){
					filename = ".//plantillas//accionesPuerto.xml";
				} else if(proyecto.getTipo() == TipoProyecto.VERTEDERO){
					filename = ".//plantillas//accionesVertedero.xml";
				}
				XMLAcciones xmlAcciones = new XMLAcciones(".//plantillas//listaAcciones.dtd");
				alternativa.setAcciones(xmlAcciones.leer(filename));
			}
			alternativa.setId(nombre);

			// La a�adimos al proyecto
			proyecto.getAlternativas().add(alternativa);
			//Refrescar la lista
			String[] fila = {nombre,"Sin valorar"};
			modeloTabla.addRow(fila);

			//Lo ponemos en el men� modificar
			JMenuItem alternativaModItem = new JMenuItem();
			alternativaModItem.setText(nombre);
			getModificarAlternativaMenu().add(alternativaModItem);
			alternativaModItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editarAlternativa(alternativa,0);
				}
			});
			//Lo ponemos en el men� eliminar
			JMenuItem alternativaElimItem = new JMenuItem();
			alternativaElimItem.setText(nombre);
			getEliminarAlternativaMenu().add(alternativaElimItem);
			alternativaElimItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarAlternativa(alternativa);
				}
			});
		}
		crearAlternativa.dispose();
		menuValoracion.setEnabled(false);
	}

	private void eliminarAlternativa(Alternativa alternativa) {
		int seleccion = JOptionPane.showConfirmDialog (null,
				"�Est� seguro que desea eliminar esta alternativa?",
				"Eliminar alternativa de realizaci�n",
				JOptionPane.YES_NO_OPTION);
		if (seleccion==JOptionPane.YES_OPTION){
			//Obtenemos el indice de la alternativa
			int indice = proyecto.getAlternativas().indexOf(alternativa);
			//Borramos la alternativa del proyecto
			proyecto.getAlternativas().remove(alternativa);
			//Eliminamos el proyecto de la lista
			modeloTabla.removeRow(indice);
			//Lo eliminamos del men� modificar
			getModificarAlternativaMenu().remove(indice);
			//Lo eliminamos del men� eliminar
			getEliminarAlternativaMenu().remove(indice);
		}
	}

	private void editarAlternativa(Alternativa alternativa,int indice) {
		FormAlternativa editarAlternativa = new FormAlternativa(getFramePrincipal(), (Alternativa)alternativa.clone(), proyecto.getFactores());
		Point posActual = getFramePrincipal().getLocation();
		posActual.translate(20, 20);
		editarAlternativa.setLocation(posActual);
		editarAlternativa.setModal(true);
		editarAlternativa.setVisible(true);

		if(editarAlternativa.isFlagAceptar()){
			// Actualizamos la alternativa con su clon
			alternativa.setEfectos(editarAlternativa.getAlternativa().getEfectos());
			alternativa.setValorTotal(editarAlternativa.getAlternativa().getValorTotal());
			alternativa.setValorada(editarAlternativa.getAlternativa().getValorada());
			modeloTabla.setValueAt(alternativa.getId(), indice, 0);

			if (alternativa.getValorada()){
				modeloTabla.setValueAt(alternativa.getValorTotal(),indice,1);
			}else{
				modeloTabla.setValueAt("Sin valorar",indice,1);
			}
			// Vemos si podemos valorar el proyecto
			actualizarValorar();
		}
		editarAlternativa.dispose();

	}

	private boolean comprobarValorar(){
		boolean valorar = true;
		int i = 0;
		while (valorar&&i<proyecto.getAlternativas().size()){
			if (!proyecto.getAlternativas().get(i).getValorada()){
				valorar = false;
			}
			i++;
		}
		return valorar;
	}

	private void mostrarFactores(boolean modificar){
		FormFactores visualizarFactores = new FormFactores(getFramePrincipal(), proyecto.getFactores(), modificar);
		Point posActual = getFramePrincipal().getLocation();
		posActual.translate(20, 20);
		visualizarFactores.setLocation(posActual);
		visualizarFactores.setModal(true);
		visualizarFactores.setVisible(true);
	}

	private void valorarAlternativas(){
		String id = proyecto.analizarAlternativas().getId();
		if (id != null)
			JOptionPane.showMessageDialog(null, "Mejor alternativa de realizaci�n: "+id, "Valorar alternativas", JOptionPane.INFORMATION_MESSAGE);
	}

	private JMenuItem getGenerarInformeMenuItem() {
		if (generarInformeMenuItem == null) {
			generarInformeMenuItem = new JMenuItem();
			generarInformeMenuItem.setMnemonic(KeyEvent.VK_G);
			generarInformeMenuItem.setText("Generar informe");
			generarInformeMenuItem.setIcon(new ImageIcon(".//images//tab-new.png"));
			generarInformeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					generarInforme();
				}
			});
		}
		return generarInformeMenuItem;
	}

	@SuppressWarnings("unchecked")
	private void generarInforme() {
		// Archivo base con el dise�o del reporte
		String reporte=".//reportes//informe.jrxml";
		try{
			// Compilamos el dise�o
			JasperReport jasperReport = JasperCompileManager.compileReport(reporte);

			XMLProyecto xmlProy = new XMLProyecto("proyectoEIA.dtd");
			xmlProy.escribir(proyecto,".//reportes//reporte.xml");

			JRXmlDataSource fileXML = new JRXmlDataSource(".//reportes//reporte.xml","/proyectoEIA");

			//Llenamos el reporte con la informaci�n y par�metros necesarios
			Map parameters = new HashMap();

			//Generamos el informe
			informe = JasperFillManager.fillReport(jasperReport, parameters, fileXML);
			//Exportamos el reporte a pdf y lo guardamos en disco
			JasperExportManager.exportReportToPdfFile(informe,".//informes//informe.pdf");

			verInformeMenuItem.setEnabled(true);
		}catch (JRException e){
			e.printStackTrace();
		}
	}

	private void mostrarInforme() {
		if (informe!=null){
			JasperViewer jviewer = new JasperViewer(informe,false);
			jviewer.setVisible(true);
		}
	}

	private void inicializarAyuda(){
		try {
			// Carga el fichero de ayuda
			File fichero = new File(".//help//help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			// Crea el HelpSet y el HelpBroker
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker ayuda = helpset.createHelpBroker();
			ayuda.enableHelpOnButton(funcionamientoMenuItem, "intro_eia", helpset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormPrincipal application = new FormPrincipal();
				application.getFramePrincipal().setVisible(true);
			}
		});
	}

}
