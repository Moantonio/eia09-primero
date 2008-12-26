package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import eia.model.Accion;
import eia.model.Alternativa;
import eia.model.Factor;
import eia.model.InfoProyecto;
import eia.model.Proyecto;
import eia.util.FiltreSimple;
import eia.util.TablaNoEditable;
import eia.util.TipoProyecto;

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

	// Variables del modelo
	private Proyecto proyecto = null;  //  @jve:decl-index=0:
	//private File ficheroProyecto = null;

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
			menuFactores.add(getVerFactoresMenuItem());
			menuFactores.add(getModificarPesosMenuItem());
			menuFactores.setMnemonic(KeyEvent.VK_F);
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
			menuAlternativas.setMnemonic(KeyEvent.VK_A);
		}
		return menuAlternativas;
	}

	private JMenuItem getSalirMenuItem() {
		if (salirMenuItem == null) {
			salirMenuItem = new JMenuItem();
			salirMenuItem.setText("Salir");
			salirMenuItem.setMnemonic(KeyEvent.VK_S);
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
			acercaDeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAcercaDe();
				}
			});
		}
		return acercaDeMenuItem;
	}

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

	private JPanel getPanelContenidoAcercaDe() {
		if (panelContenidoAcercaDe == null) {
			panelContenidoAcercaDe = new JPanel();
			panelContenidoAcercaDe.setLayout(null);
			panelContenidoAcercaDe.setPreferredSize(new Dimension(200, 200));
		}
		return panelContenidoAcercaDe;
	}

	private JMenu getMenuValoracion() {
		if (menuValoracion == null) {
			menuValoracion = new JMenu();
			menuValoracion.setText("Valoracion");
			menuValoracion.add(getValorarMenuItem());
			menuValoracion.add(getVerResultadosMenuItem());
			menuValoracion.setMnemonic(KeyEvent.VK_V);
		}
		return menuValoracion;
	}

	private JMenu getMenuInformes() {
		if (menuInformes == null) {
			menuInformes = new JMenu();
			menuInformes.setText("Informes");
			menuInformes.add(getVerInformeMenuItem());
			menuInformes.setMnemonic(KeyEvent.VK_I);
		}
		return menuInformes;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
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
		}
		return menuNuevo;
	}

	private JMenuItem getAutoviaMenuItem() {
		if (autoviaMenuItem == null) {
			autoviaMenuItem = new JMenuItem();
			autoviaMenuItem.setText("Autovía");
			autoviaMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearProyecto(TipoProyecto.AUTOVÍA);
				}
			});
		}
		return autoviaMenuItem;
	}

	private JMenuItem getPresaMenuItem() {
		if (presaMenuItem == null) {
			presaMenuItem = new JMenuItem();
			presaMenuItem.setText("Presa");
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
		}
		return guardarMenuItem;
	}

	private JMenuItem getGuardarComoMenuItem() {
		if (guardarComoMenuItem == null) {
			guardarComoMenuItem = new JMenuItem();
			guardarComoMenuItem.setText("Guardar como...");
			guardarComoMenuItem.setMnemonic(KeyEvent.VK_U);
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
			verFactoresMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarFactores();
				}
			});
		}
		return verFactoresMenuItem;
	}

	private JMenuItem getModificarPesosMenuItem() {
		if (modificarPesosMenuItem == null) {
			modificarPesosMenuItem = new JMenuItem();
			modificarPesosMenuItem.setText("Modificar pesos");
		}
		return modificarPesosMenuItem;
	}

	private JMenuItem getValorarMenuItem() {
		if (valorarMenuItem == null) {
			valorarMenuItem = new JMenuItem();
			valorarMenuItem.setText("Valorar");
		}
		return valorarMenuItem;
	}

	private JMenuItem getVerResultadosMenuItem() {
		if (verResultadosMenuItem == null) {
			verResultadosMenuItem = new JMenuItem();
			verResultadosMenuItem.setText("Ver resultados");
		}
		return verResultadosMenuItem;
	}

	private JMenuItem getVerInformeMenuItem() {
		if (verInformeMenuItem == null) {
			verInformeMenuItem = new JMenuItem();
			verInformeMenuItem.setText("Ver informe");
		}
		return verInformeMenuItem;
	}

	private JMenuItem getFuncionamientoMenuItem() {
		if (funcionamientoMenuItem == null) {
			funcionamientoMenuItem = new JMenuItem();
			funcionamientoMenuItem.setText("Funcionamiento");
		}
		return funcionamientoMenuItem;
	}

	private JMenuItem getLegislacionMenuItem() {
		if (legislacionMenuItem == null) {
			legislacionMenuItem = new JMenuItem();
			legislacionMenuItem.setText("Legislación");
		}
		return legislacionMenuItem;
	}

	private JMenuItem getAnadirAlternativaMenuItem() {
		if (anadirAlternativaMenuItem == null) {
			anadirAlternativaMenuItem = new JMenuItem();
			anadirAlternativaMenuItem.setText("Añadir");
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
			eliminarAlternativaMenu.setText("Eliminar");
		}
		return eliminarAlternativaMenu;
	}

	private JMenu getModificarAlternativaMenu() {
		if (modificarAlternativaMenu == null) {
			modificarAlternativaMenu = new JMenu();
			modificarAlternativaMenu.setText("Editar");
		}
		return modificarAlternativaMenu;
	}

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
			infoProyectoPanel.add(getAceptarButton(), null);
		}
		return infoProyectoPanel;
	}

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

	private JScrollPane getAlternativasScrollPane() {
		if (alternativasScrollPane == null) {
			alternativasScrollPane = new JScrollPane();
			alternativasScrollPane.setBounds(new Rectangle(16, 31, 401, 100));
			alternativasScrollPane.setViewportView(getAlternativasTable());
		}
		return alternativasScrollPane;
	}

	private JTable getAlternativasTable() {
		if (alternativasTable == null) {
			alternativasTable = new JTable(modeloTabla);
			modeloTabla.addColumn("Alternativa");
			modeloTabla.addColumn("Valoración");
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
			nombreTextField.setBounds(new Rectangle(88, 29, 151, 18));
			nombreTextField.setEnabled(false);
		}
		return nombreTextField;
	}

	private JTextField getTipoTextField() {
		if (tipoTextField == null) {
			tipoTextField = new JTextField();
			tipoTextField.setBounds(new Rectangle(329, 28, 87, 18));
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
		}
		return descripcionTextArea;
	}

	private JTextField getCompaniaTextField() {
		if (companiaTextField == null) {
			companiaTextField = new JTextField();
			companiaTextField.setBounds(new Rectangle(88, 98, 125, 18));
			companiaTextField.setEnabled(false);
		}
		return companiaTextField;
	}

	private JTextField getPoblacionTextField() {
		if (poblacionTextField == null) {
			poblacionTextField = new JTextField();
			poblacionTextField.setBounds(new Rectangle(88, 123, 125, 18));
			poblacionTextField.setEnabled(false);
		}
		return poblacionTextField;
	}

	private JTextField getPaisTextField() {
		if (paisTextField == null) {
			paisTextField = new JTextField();
			paisTextField.setBounds(new Rectangle(89, 148, 75, 18));
			paisTextField.setEnabled(false);
		}
		return paisTextField;
	}

	private JTextField getProvinciaTextField() {
		if (provinciaTextField == null) {
			provinciaTextField = new JTextField();
			provinciaTextField.setBounds(new Rectangle(292, 123, 125, 18));
			provinciaTextField.setEnabled(false);
		}
		return provinciaTextField;
	}

	private JTextField getAutorTextField() {
		if (autorTextField == null) {
			autorTextField = new JTextField();
			autorTextField.setBounds(new Rectangle(292, 98, 125, 18));
			autorTextField.setEnabled(false);
		}
		return autorTextField;
	}

	private JTextField getFechaTextField() {
		if (fechaTextField == null) {
			fechaTextField = new JTextField();
			fechaTextField.setBounds(new Rectangle(210, 148, 75, 18));
			fechaTextField.setEnabled(false);
		}
		return fechaTextField;
	}

	private JTextField getVidaUtilTextField() {
		if (vidaUtilTextField == null) {
			vidaUtilTextField = new JTextField();
			vidaUtilTextField.setBounds(new Rectangle(343, 148, 29, 18));
			vidaUtilTextField.setEnabled(false);
		}
		return vidaUtilTextField;
	}

	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(322, 175, 94, 17));
			modificarButton.setText("Modificar");
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
			anadirAltButton.setText("Añadir");
			anadirAltButton.setLocation(new Point(135, 138));
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
			eliminarAltButton.setLocation(new Point(327, 138));
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
			editarAltButton.setLocation(new Point(231, 138));
			editarAltButton.setSize(new Dimension(88, 17));
			editarAltButton.setEnabled(false);
			editarAltButton.setBackground(Color.white);
			editarAltButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = alternativasTable.getSelectedRow();
					if (indice != -1){
						Alternativa alternativa = proyecto.getAlternativas().get(indice);
						editarAlternativa(alternativa);
					}
				}
			});
		}
		return editarAltButton;
	}

	/**
	 * This method initializes aceptarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(232, 175));
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
		fechaTextField.setText(String.valueOf(proyecto.getInformacion().getFecha().getTime()));
		vidaUtilTextField.setText(String.valueOf(proyecto.getInformacion().getVidaUtil()));
	}

	private void actualizarAlternativas(){
		alternativasTable.setEnabled(true);
		anadirAltButton.setEnabled(true);
		editarAltButton.setEnabled(true);
		eliminarAltButton.setEnabled(true);
	}

	private void crearProyecto(TipoProyecto tipo){
		// Creamos un formulario de creaccion de proyecto
		formCrearProyecto ventanaCrear = new formCrearProyecto(tipo.toString());
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
			proyecto = new Proyecto(info,tipo);
			//TODO Cargamos el arbol de factores para ese tipo de proyecto
			DefaultTreeModel factores = null;

			//
			Factor factorBisAbuelo = new Factor("Factor Bisabuelo",1);
			Factor factorAbuelo = new Factor("Factor abuelo",2);
			Factor factorAbuela = new Factor("Factor abuela",3);
			Factor factorHijo = new Factor("Factor hijo",4);
			Factor factorHija = new Factor("Factor hija",5);
			DefaultMutableTreeNode nodoBisAbuelo = new DefaultMutableTreeNode(factorBisAbuelo);
			DefaultMutableTreeNode nodoAbuelo = new DefaultMutableTreeNode(factorAbuelo);
			DefaultMutableTreeNode nodoAbuela = new DefaultMutableTreeNode(factorAbuela);
			DefaultMutableTreeNode nodoHija = new DefaultMutableTreeNode(factorHija);
			DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(factorHijo);
			factores = new DefaultTreeModel(nodoBisAbuelo);
			factores.insertNodeInto(nodoAbuelo, nodoBisAbuelo, 0);
			factores.insertNodeInto(nodoAbuela, nodoBisAbuelo, 1);
			factores.insertNodeInto(nodoHijo, nodoAbuelo, 0);
			factores.insertNodeInto(nodoHija, nodoAbuela, 0);
			//

			proyecto.setFactores(factores);
			//Actualizamos la vista
			actualizarDescripcion();
			actualizarAlternativas();
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
		JDialog aboutDialog = getDialogAcercaDe();
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
		fileChooser.setCurrentDirectory(new File("./"));
		int seleccion = fileChooser.showOpenDialog(null);
		// Controlamos la selección
	    if (seleccion == JFileChooser.APPROVE_OPTION) {
	    	//File file = fileChooser.getSelectedFile();
	    }
	}

	private void guardarComoProyecto() {
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
	    	//File file = fileChooser.getSelectedFile();
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
		formCrearAlternativa crearAlternativa = new formCrearAlternativa(getFramePrincipal(),proyecto.getInformacion().getNombre());
		Point posActual = getFramePrincipal().getLocation();
		posActual.translate(20, 20);
		crearAlternativa.setLocation(posActual);
		crearAlternativa.setModal(true);
		crearAlternativa.setVisible(true);
		if(crearAlternativa.isFlagAceptar()){
			String nombre = crearAlternativa.getNombreAlternativa();
			//Crear alternativa con ese nombre
			final Alternativa alternativa = new Alternativa(nombre);
			//TODO Cargamos el arbol de acciones para ese tipo de proyecto
			DefaultTreeModel acciones = null;

			//
			Accion accionBisAbuelo = new Accion("Factor Bisabuelo");
			Accion accionAbuelo = new Accion("Factor abuelo");
			Accion accionAbuela = new Accion("Factor abuela");
			Accion accionHijo = new Accion("Factor hijo");
			Accion accionHija = new Accion("Factor hija");
			DefaultMutableTreeNode nodoBisAbuelo = new DefaultMutableTreeNode(accionBisAbuelo);
			DefaultMutableTreeNode nodoAbuelo = new DefaultMutableTreeNode(accionAbuelo);
			DefaultMutableTreeNode nodoAbuela = new DefaultMutableTreeNode(accionAbuela);
			DefaultMutableTreeNode nodoHija = new DefaultMutableTreeNode(accionHija);
			DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(accionHijo);
			acciones = new DefaultTreeModel(nodoBisAbuelo);
			acciones.insertNodeInto(nodoAbuelo, nodoBisAbuelo, 0);
			acciones.insertNodeInto(nodoAbuela, nodoBisAbuelo, 1);
			acciones.insertNodeInto(nodoHijo, nodoAbuelo, 0);
			acciones.insertNodeInto(nodoHija, nodoAbuela, 0);
			//


			alternativa.setAcciones(acciones);
			// La añadimos al proyecto
			proyecto.getAlternativas().add(alternativa);
			//Refrescar la lista
			String[] fila = {nombre,""};
			modeloTabla.addRow(fila);
			//Lo ponemos en el menú modificar
			JMenuItem alternativaModItem = new JMenuItem();
			alternativaModItem.setText(nombre);
			getModificarAlternativaMenu().add(alternativaModItem);
			alternativaModItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editarAlternativa(alternativa);
				}
			});
			//Lo ponemos en el menú eliminar
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
	}

	private void eliminarAlternativa(Alternativa alternativa) {
		int seleccion = JOptionPane.showConfirmDialog (null,
				"¿Está seguro que desea eliminar esta alternativa?",
				"Eliminar alternativa de realización",
				JOptionPane.YES_NO_OPTION);
		if (seleccion==JOptionPane.YES_OPTION){
			//Obtenemos el indice de la alternativa
			int indice = proyecto.getAlternativas().indexOf(alternativa);
			//Borramos la alternativa del proyecto
			proyecto.getAlternativas().remove(alternativa);
			//Eliminamos el proyecto de la lista
			modeloTabla.removeRow(indice);
			//Lo eliminamos del menú modificar
			getModificarAlternativaMenu().remove(indice);
			//Lo eliminamos del menú eliminar
			getEliminarAlternativaMenu().remove(indice);
		}
	}

	private void editarAlternativa(Alternativa alternativa) {
		formAlternativa editarAlternativa = new formAlternativa(getFramePrincipal(), alternativa, proyecto.getFactores());
		Point posActual = getFramePrincipal().getLocation();
		posActual.translate(20, 20);
		editarAlternativa.setLocation(posActual);
		editarAlternativa.setModal(true);
		editarAlternativa.setVisible(true);

		if(editarAlternativa.isFlagAceptar()){
			// TODO si le ha dado a aceptar actualizamos info en la tabla
			// y actualizamos la alternativa con su clon
			// alternativa = editarAlternativa.getAlternativa();
		}
		editarAlternativa.dispose();

	}

	private void mostrarFactores(){
		formFactores visualizarFactores = new formFactores(getFramePrincipal(), proyecto.getFactores());
		Point posActual = getFramePrincipal().getLocation();
		posActual.translate(20, 20);
		visualizarFactores.setLocation(posActual);
		visualizarFactores.setModal(true);
		visualizarFactores.setVisible(true);
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
