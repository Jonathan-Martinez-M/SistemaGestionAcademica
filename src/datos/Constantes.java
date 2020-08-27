package datos;

public interface Constantes
{
	//Constantes de datos fijos
	public static final String CODIGO_ADMIN = "ADMIN";
	public static final String CONTRASENIA_ADMIN = "20011995";
	public static final int CANTIDAD_PREGUNTAS_CUANTITATIVAS = 5;
	public static final String PREGUNTA_CUANTITATIVA = "C";
	public static final String PREGUNTA_ABIERTA = "A";
	
	//Constantes Botones
	public static final String COMANDO_BTN_INGRESAR = "login";
	public static final String COMANDO_BTN_VTNA_CARGAR_ASIGNATURA = "Abrir carga asignatura";
	public static final String COMANDO_BTN_VTNA_CARGAR_ESTUDIANTE = "Abrir carga estudiante";
	public static final String COMANDO_BTN_VTNA_LISTA_ASIGNATURAS = "Abrir lista asignaturas";
	public static final String COMANDO_BTN_VTNA_LISTA_ESTUDIANTES = "Abrir lista estudiantes";
	public static final String COMANDO_BTN_REGISTRAR_ASIGNATURA = "Registrar asignatura";
	public static final String COMANDO_BTN_REGISTRAR_ESTUDIANTE = "Registrar estudiante";
	
	//Constantes de resolución
	public static final String USUARIO_ADMIN = "Usuario Admin";
	public static final String USUARIO_ESTUDIANTE = "Usuario Estudiante";
	public static final String USUARIO_ERRONEO = "Usuario erroneo";
	
	//Constantes de mensajes
	public static final String MENSAJE_LOGIN_FALLIDO = "Ingrese una combinación de código y contraseña válida";
	public static final String CAMPOS_VACIOS = "Ingrese un usuario y/o una contraseña";
	public static final String CARGA_EXITOSA_ASIGNATURA = "La asignatura fue creada con éxito";
	public static final String CARGA_EXITOSA_ESTUDIANTE = "El estudiante fue cargado con éxito";
	
	//Constantes de título
	public static final String TITULO_LOGIN_FALLIDO = "Datos erroneos";

	public static final String RUTA  = ".\\informacion";
}
