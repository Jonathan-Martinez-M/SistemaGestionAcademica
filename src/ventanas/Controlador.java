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
import javax.swing.JOptionPane;

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
	private Ventana_Inicial ventanaLogin;
	private Ventana_Carga_Asignatura_Admin ventanaRegistroAsignatura;
	private Ventana_Carga_de_estudiantes ventanaRegistroEstudiante;
	private Ventana_Modificar_Datos ventanamodificardatos;
	private Ventana_Carga_Asignatura ventanaMatriculaEst;
	private Ventana_Encuesta ventanaEncuestas;
	
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
					Ventana_Inicial frame = new Ventana_Inicial(controlador);
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
					Lista_de_estudiantes dialog = new Lista_de_estudiantes(this);
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
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_MODIFICACION_DE_DATOS))
			{
				if(ventanamodificardatos.getTextNombre().isEmpty() || ventanamodificardatos.getTextApellido().isEmpty() || ventanamodificardatos.getTextUbicacion().isEmpty() || ventanamodificardatos.getTxtPass().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, Constantes.CARGA_FALLIDA_CAMPO_VACIO);
				}
				else
				{
					if(modelo.ModificarEstudiante(ventanamodificardatos.getTextNombre(), ventanamodificardatos.getTextApellido(), ventanamodificardatos.getTextUbicacion(), ventanamodificardatos.getTxtPass()))
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
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_MATRICULAR_DESDE_ESTUDIANTE))
			{
				String[] asignaturasSeleccionadas = this.ventanaMatriculaEst.obtenerAsignaturasSeleccionadas();
				
				if(asignaturasSeleccionadas != null)
					for(int cadaAsignatura = 0; cadaAsignatura < asignaturasSeleccionadas.length; cadaAsignatura++)
					{
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
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_VER_RESULTADOS_ENCUESTAS))
			{
				try
				{
					Ventana_Resultados_Encuesta dialog = new Ventana_Resultados_Encuesta(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		}
		else if(e.getSource().getClass().equals(new JComboBox().getClass())){
			
			if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_CIUDADES))
			{
				ArrayList<Barrio> barrios = modelo.ver_barrios(ventanaRegistroEstudiante.getComboBox_ciudad()+1 + "");
				ventanaRegistroEstudiante.getComboBox_barrio().setModel(new DefaultComboBoxModel<Barrio>());
				for(int i=0; i<barrios.size(); i++)
				{
					ventanaRegistroEstudiante.getComboBox_barrio().addItem(barrios.get(i).getNombre());
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
	public void setVentanaLogin(Ventana_Inicial ventanaLogin)
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
	
	public ArrayList<Ciudad> listarCiudades()
	{
		return modelo.ver_ciudades();
	}
	
	public ArrayList<Barrio> listarBarrios(String ciudad)
	{
		return modelo.ver_barrios(ciudad);
	}
}