/**
 * 
 */
package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import datos.Constantes;
import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;
import mundo.Asignatura;
import mundo.Barrio;
import mundo.Ciudad;
import mundo.Encuesta;
import mundo.Estudiante;
import mundo.Matricula;
import mundo.Modelador;

/**
 * @author Rubén Fúquene
 * 
 * Clase encargada de recibir peticiones y enviar datos al modelador
 *
 */
public class Controlador implements ActionListener
{
	private Modelador modelo;
	private VentanaInicioSesion ventanaLogin;
	private Ventana_Carga_Asignatura_Admin ventanaRegistroAsignatura;
	private Ventana_Carga_de_estudiantes ventanaRegistroEstudiante;
	private Ventana_Modificar_Datos ventanamodificardatos;
	private Ventana_Carga_Asignatura ventanaMatriculaEst;
	private Ventana_Encuesta ventanaEncuestas;
	private VentanaModificarEstudianteDesdeAdmin ventanaModAdmin;
	
	/**
	 * Contructor de la clase controlador
	 */
	public Controlador()
	{
		modelo = new Modelador();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GestorEstudiantes gEs = new GestorEstudiantes();
					GestorAsignaturas gAs = new GestorAsignaturas();
					GestorEncuestas gEn = new GestorEncuestas();
					Controlador controlador = new Controlador();
					VentanaInicioSesion frame = new VentanaInicioSesion(controlador);
					controlador.setVentanaLogin(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	/**
	 * Metodo actionPerformed encargado de estar atento a cualquier accion en las ventanas 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Acción de los botones
		if(e.getSource().getClass().equals(new JButton().getClass()))
		{
			// Inicio de sesión
			if(e.getActionCommand().equals(Constantes.COMANDO_BTN_INGRESAR))
			{
				if(ventanaLogin.getTxtCod().equals("") || ventanaLogin.getTxtCod().equals(""))
				{
					ventanaLogin.limpiarCampos();
					JOptionPane.showMessageDialog( ventanaLogin, Constantes.CAMPOS_VACIOS, Constantes.USUARIO_ERRONEO, JOptionPane.INFORMATION_MESSAGE );
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ESTUDIANTE))
				{
					ventanaLogin.dispose();
					try
					{
						Ventana_Usuario frame = new Ventana_Usuario(this);
						frame.setVisible(true);
					} catch (Exception ec)
					{
						ec.printStackTrace();

					}
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ADMIN))
				{
					ventanaLogin.dispose();
					try
					{
						Ventana_Administrador frame = new Ventana_Administrador(this);
						frame.setVisible(true);
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ERRONEO))
				{
					ventanaLogin.limpiarCampos();
					JOptionPane.showMessageDialog( ventanaLogin, Constantes.MENSAJE_LOGIN_FALLIDO, Constantes.USUARIO_ERRONEO, JOptionPane.INFORMATION_MESSAGE );
				}
			}
			//Abre ventana para registrar una nueva asignatura
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_CARGAR_ASIGNATURA))
			{
				try 
				{
					Ventana_Carga_Asignatura_Admin dialog = new Ventana_Carga_Asignatura_Admin(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			//Almacena una asignatura en BD
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_REGISTRAR_ASIGNATURA))
			{
				if(ventanaRegistroAsignatura.getTxtCodAsign().isEmpty()  || ventanaRegistroAsignatura.getTxtNomAsign().isEmpty())
				{
					JOptionPane.showMessageDialog(null, Constantes.CARGA_FALLIDA_CAMPO_VACIO);
				}
				else
				{
					if(modelo.RegistrarAsignatura(ventanaRegistroAsignatura.getTxtCodAsign(), ventanaRegistroAsignatura.getTxtNomAsign()))
					{
						this.ventanaRegistroAsignatura.dispose();
						JOptionPane.showMessageDialog(null, Constantes.CARGA_EXITOSA_ASIGNATURA);
					}
				}
				
				
			}
			//Abre ventana para registrar un nuevo estudiante
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_CARGAR_ESTUDIANTE))
			{
				try
				{
					Ventana_Carga_de_estudiantes dialog = new Ventana_Carga_de_estudiantes(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			//Registra a un estudiante nuevo
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_REGISTRAR_ESTUDIANTE))
			{
				if(ventanaRegistroEstudiante.getTxtCodigo().isEmpty() || ventanaRegistroEstudiante.getTxtNombre().isEmpty()||
						ventanaRegistroEstudiante.getTxtApellido().isEmpty()|| ventanaRegistroEstudiante.getTxtContrasenia().isEmpty())
				{
					JOptionPane.showMessageDialog(null, Constantes.CARGA_FALLIDA_CAMPO_VACIO);
				}
				else
				{
					if(modelo.RegistrarEstudiante(ventanaRegistroEstudiante.getTxtCodigo(), ventanaRegistroEstudiante.getTxtNombre(),
							ventanaRegistroEstudiante.getTxtApellido(), ventanaRegistroEstudiante.getTxtCiudad(),ventanaRegistroEstudiante.getTxtBarrio(), ventanaRegistroEstudiante.getTxtContrasenia()))
					{
						String[] asignaturasSeleccionadas = this.ventanaRegistroEstudiante.obtenerAsignaturasSeleccionadas();
						
						if(asignaturasSeleccionadas != null)
							for(int cadaAsignatura = 0; cadaAsignatura < asignaturasSeleccionadas.length; cadaAsignatura++)
							{
								modelo.matricular(asignaturasSeleccionadas[cadaAsignatura], ventanaRegistroEstudiante.getTxtCodigo());
							}
						
						this.ventanaRegistroEstudiante.dispose();
						JOptionPane.showMessageDialog(null, Constantes.CARGA_EXITOSA_ESTUDIANTE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, Constantes.CARGA_FALLIDA_ESTUDIANTE);
					}
				}
				
			}
			//Abre ventana para registrar un nuevo estudiante
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_ASIGNATURAS))
			{
				try
				{
					Ventana_Lista_Asignatura_Admin dialog = new Ventana_Lista_Asignatura_Admin(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_ESTUDIANTES)) {
				try
				{
					VentanaListaEstudiantes dialog = new VentanaListaEstudiantes(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_CARGAR_ASIGNATURA_ESTUDIANTE))
			{
				try 
				{
					Ventana_Carga_Asignatura dialog = new Ventana_Carga_Asignatura(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_MODIFICACION_DE_DATOS)) {
				try
				{
					Ventana_Modificar_Datos dialog = new Ventana_Modificar_Datos(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			//Modificación del estudiante desde estudiante
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_MODIFICACION_DE_DATOS))
			{
				if(ventanamodificardatos.getTextNombre().isEmpty() || ventanamodificardatos.getTextApellido().isEmpty() || ventanamodificardatos.getTxtCiudad().isEmpty() || ventanamodificardatos.getTxtBarrio().isEmpty() || ventanamodificardatos.getTxtPass().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, Constantes.CARGA_FALLIDA_CAMPO_VACIO);
				}
				else
				{
					if(modelo.modificarEstudiante(ventanamodificardatos.getTextNombre(), ventanamodificardatos.getTextApellido(), ventanamodificardatos.getTxtCiudad(), ventanamodificardatos.getTxtBarrio(),ventanamodificardatos.getTxtPass()))
					{
						this.ventanamodificardatos.dispose();
						JOptionPane.showMessageDialog(null, Constantes.MODIFICACION_EXITOSA_ESTUDIANTE);

					}
					else
					{
						this.ventanamodificardatos.dispose();
						JOptionPane.showMessageDialog(null, Constantes.MODIFICACION_FALLIDA_ESTUDIANTE);
					}
				}
			}
			//Realizar matrícula desde el lado del estudiante
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_MATRICULAR_DESDE_ESTUDIANTE))
			{
				String[] asignaturasSeleccionadas = this.ventanaMatriculaEst.obtenerAsignaturasSeleccionadas();
				ArrayList<Matricula> matriculas = modelo.obtenerMatriculasEstudiantes(); 
				Boolean matricular;
				
				if(asignaturasSeleccionadas != null)
					for(int cadaAsignatura = 0; cadaAsignatura < asignaturasSeleccionadas.length; cadaAsignatura++)
					{
						matricular = true;
						for(Matricula cadaMatricula : matriculas)
						{
							if(cadaMatricula.getDe_la_asignatura().equals(asignaturasSeleccionadas[cadaAsignatura]))
								matricular = false;
						}
						
						if(matricular)
							modelo.matricular(asignaturasSeleccionadas[cadaAsignatura], ((Estudiante) modelo.getUsuarioLogueado()).getCodigo());
					}
				
				this.ventanaMatriculaEst.dispose();
				JOptionPane.showMessageDialog(null, Constantes.MATRICULA_EXITOSA_ESTUDIANTES);
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_REALIZAR_ENCUESTAS))
			{
				try
				{
					Ventana_Encuesta dialog = new Ventana_Encuesta(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_REGISTRAR_ENCUESTA))
			{
				String[][] lasrespuestas = ventanaEncuestas.obtenerResultadoEncuesta();
				String[] respuestasCuantitativas = new String[Constantes.CANTIDAD_PREGUNTAS_CUANTITATIVAS];
				String respuestaAbierta;

				for(int cadaFila = 0; cadaFila < lasrespuestas.length; cadaFila++)
				{
					for(int cadaCol = 1; cadaCol < lasrespuestas[cadaFila].length - 1; cadaCol++)
					{
						respuestasCuantitativas[cadaCol - 1] = lasrespuestas[cadaFila][cadaCol];
					}
					
					if(modelo.agregarEncuestaRespondida(lasrespuestas[cadaFila][0], respuestasCuantitativas, lasrespuestas[cadaFila][5]))
					{
						ventanaEncuestas.dispose();
						JOptionPane.showMessageDialog(null, Constantes.ENCUESTAS_RESPONDIDAS);
					}
				}
			}
			//Lanza ventana para ver las asignaturas
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_VER_RESULTADOS_ENCUESTAS))
			{
				try
				{
					VentanaResultadosEncuesta dialog = new VentanaResultadosEncuesta(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			//Modificación del estudiante desde la ventana de admin
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_MODIFICAR_ESTU_DESDE_ADMIN))
			{
				String nuevoCod = ventanaModAdmin.getTxtcodigo();
				String nuevoNombre = ventanaModAdmin.getTxtNombre();
				String nuevoApellido = ventanaModAdmin.getTxtApellido();
				String nuevaCiudad = ventanaModAdmin.getComboBox_ciudadSelccion();
				String nuevaBarrio = ventanaModAdmin.getComboBox_barrioSelccion();
				String pass = ventanaModAdmin.getPasswordField();
				
				if(nuevoNombre.isEmpty() ||nuevoApellido.isEmpty() || nuevaCiudad.isEmpty() || nuevaBarrio.isEmpty() || pass.isEmpty() || nuevoCod.isEmpty())
				{
					JOptionPane.showMessageDialog(null, Constantes.CARGA_FALLIDA_CAMPO_VACIO);
				}
				else
				{
					if(modelo.modificarEstudianteAdmin(ventanaModAdmin.getCodigoViejo(), nuevoCod, nuevoNombre, nuevoApellido, nuevaCiudad, nuevaBarrio, pass))
					{
						this.ventanaModAdmin.dispose();
						JOptionPane.showMessageDialog(null, Constantes.MODIFICACION_EXITOSA_ESTUDIANTE);
					}
					else
					{
						this.ventanaModAdmin.dispose();
						JOptionPane.showMessageDialog(null, Constantes.MODIFICACION_FALLIDA_ESTUDIANTE);
					}
				}
			}
		}
		//Eventos producidos por un JComboBox
		else if(e.getSource().getClass().equals(new JComboBox().getClass()))
		{
			if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_CIUDADES_CARGA))
			{
				ArrayList<Barrio> barrios = modelo.ver_barrios(ventanaRegistroEstudiante.getComboBox_ciudad()+1 + "");
				ventanaRegistroEstudiante.getComboBox_barrio().setModel(new DefaultComboBoxModel<Barrio>());
				for(int i=0; i<barrios.size(); i++)
				{
					ventanaRegistroEstudiante.getComboBox_barrio().addItem(barrios.get(i).getNombre());
				}
			}
			
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_CIUDADES_MODIFICAR))
			{
				ArrayList<Barrio> barrios = modelo.ver_barrios(ventanamodificardatos.getComboBox_ciudad()+1 + "");
				ventanamodificardatos.getComboBox_barrio().setModel(new DefaultComboBoxModel<Barrio>());
				for(int i=0; i<barrios.size(); i++)
				{
					ventanamodificardatos.getComboBox_barrio().addItem(barrios.get(i).getNombre());
				}
			}
			//
			else if(e.getActionCommand().equals(Constantes.COMANDO_COMBO_CIUDADES_MOD_ADMIN))
			{
				ArrayList<Barrio> barrios = modelo.ver_barrios(ventanaModAdmin.getComboCiudad().getSelectedIndex() + 1 + "");
				ventanaModAdmin.getComboBarrio().setModel(new DefaultComboBoxModel<Barrio>());
				for(int i=0; i<barrios.size(); i++)
				{
					ventanaModAdmin.getComboBarrio().addItem(barrios.get(i).getNombre());
				}
			}
		}
	}
	/**
	 * Metodo encargado de listar asignaturas
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList<Asignatura> listarAsignaturas()
	{
		return modelo.listarAsignaturas();
	}
	/**
	 * Metodo encargado de listar estudiantes
	 * @return ArrayList<Estudiante>
	 */
	public ArrayList<Estudiante> listarEstudiantes()
	{
		return modelo.ver_estudiantes();
	}
	
	/**
	 * Metodo encargado de listar asignaturas de un estudiante
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList<Matricula> listarMatriculasPorEstudiante()
	{
		return modelo.obtenerMatriculasEstudiantes();
	}
	
	/**
	 * Metodo encargado recibir la ventana de login
	 */
	public void setVentanaLogin(VentanaInicioSesion ventanaLogin)
	{
		this.ventanaLogin = ventanaLogin;
	}
	/**
	 * Metodo encargado recibir la ventana de registro de asignaturas 
	 */
	public void setVentanaRegistroAsignatura(Ventana_Carga_Asignatura_Admin ventanaRegistroAsignatura)
	{
		this.ventanaRegistroAsignatura = ventanaRegistroAsignatura;
	}
	/**
	 * Metodo encargado recibir la ventana de registro de estudiantes
	 */
	public void setVentanaRegistroEstudiante(Ventana_Carga_de_estudiantes ventanaRegistroEstudiante)
	{
		this.ventanaRegistroEstudiante = ventanaRegistroEstudiante;
	}	
	/**
	 * Metodo encargado recibir la ventana de modificar datos
	 */
	public void setVentanaModificarDatos(Ventana_Modificar_Datos ventanaModificarDatos) 
	{
		this.ventanamodificardatos = ventanaModificarDatos;
	}
	/**
	 * Metodo encargado recibir la ventana de matricular estudiante
	 */
	public void setVentanaMatriculaEst(Ventana_Carga_Asignatura ventanaMatriculaEst)
	{
		this.ventanaMatriculaEst = ventanaMatriculaEst;
	}
	
	public void setVentanaModAdmin(VentanaModificarEstudianteDesdeAdmin ventanaModAdmin)
	{
		this.ventanaModAdmin = ventanaModAdmin;
	}
	
	public void setVentanaEncuestas(Ventana_Encuesta ventanaEncuestas)
	{
		this.ventanaEncuestas = ventanaEncuestas;
	}
	
	public Encuesta getEncuestaDummy()
	{
		return modelo.obtetnerEncuestaDummy();
	}
	
	public Asignatura buscarAsignaturaCod(String cod)
	{
		return modelo.buscarAsignaturaPorCodigo(cod);
	}
	
	public void verResultadosEncuestas(String codigoAsign)
	{
		ArrayList<Encuesta> lasEncuestasAsign = modelo.obtenerEncuestaPorAsign(codigoAsign);
		ArrayList<Encuesta> encuestasRespon = modelo.encuestasRespondidas(lasEncuestasAsign);
		double porcentajes[][] = modelo.calcularPorcentajesEncuestas(encuestasRespon);
		
		try
		{
			Ventana_Resultado_Encuesta_Detalle dialog = new Ventana_Resultado_Encuesta_Detalle(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			String registros[] = new String[5];
			for (int i = 0; i < porcentajes.length; i++)
			{
				registros[0] = (i+1) +"";
				registros[1] = (int)porcentajes[i][0] + " %";
				registros[2] = (int)porcentajes[i][1] + " %";
				registros[3] = (int)porcentajes[i][2] + " %";
				registros[4] = (int)porcentajes[i][3] + " %";
				
				((DefaultTableModel) dialog.getTablePorcentajes().getModel()).addRow(registros);;
			}
			
			String abierta[] = new String[1];
			for(Encuesta cadaEncuesta : encuestasRespon)
			{
				abierta[0] = cadaEncuesta.getRespuesta_abierta();
				
				((DefaultTableModel) dialog.getTableAbiertas().getModel()).addRow(abierta);;
			}
			
			dialog.getTitulo().setText("Cantidad de encuestas respondidas: " + encuestasRespon.size());
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			dialog.getTablePorcentajes().setDefaultRenderer(String.class, centerRenderer);

		} catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}

	public ArrayList<Ciudad> listarCiudades()
	{
		return modelo.ver_ciudades();
	}
	
	public ArrayList<Barrio> listarBarrios(String ciudad)
	{
		return modelo.ver_barrios(ciudad);
	}
}