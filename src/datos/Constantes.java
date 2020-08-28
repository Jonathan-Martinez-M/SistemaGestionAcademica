package datos;

public interface Constantes
{
	//Constantes de datos fijos
	public static final String CODIGO_ADMIN = "ADMIN";
	public static final String CONTRASENIA_ADMIN = "20011995";
	public static final int CANTIDAD_PREGUNTAS_CUANTITATIVAS = 4;
	public static final String PREGUNTA_CUANTITATIVA = "C";
	public static final String PREGUNTA_ABIERTA = "A";
	public static final String PREGUNTA_SIN_RESPONDER = "NA";
	
	//Constantes Botones
	public static final String COMANDO_BTN_INGRESAR = "login";
	public static final String COMANDO_BTN_VTNA_CARGAR_ASIGNATURA = "Abrir carga asignatura";
	public static final String COMANDO_BTN_VTNA_CARGAR_ESTUDIANTE = "Abrir carga estudiante";
	public static final String COMANDO_BTN_VTNA_LISTA_ASIGNATURAS = "Abrir lista asignaturas";
	public static final String COMANDO_BTN_VTNA_LISTA_ESTUDIANTES = "Abrir lista estudiantes";
	public static final String COMANDO_BTN_VTNA_CARGAR_ASIGNATURA_ESTUDIANTE = "Carga Asignatura";
	public static final String COMANDO_BTN_VTNA_MODIFICACION_DE_DATOS = "Modificación de datos";
	public static final String COMANDO_BTN_VTNA_REALIZAR_ENCUESTAS = "Llenar encuestas";
	public static final String COMANDO_BTN_VTNA_VER_RESULTADOS_ENCUESTAS = "Abrir resultados encuestas";
	public static final String COMANDO_BTN_REGISTRAR_ASIGNATURA = "Registrar asignatura";
	public static final String COMANDO_BTN_REGISTRAR_ESTUDIANTE = "Registrar estudiante";
	public static final String COMANDO_BTN_MODIFICACION_DE_DATOS = "Modificar datos";
	public static final String COMANDO_BTN_MATRICULAR_DESDE_ESTUDIANTE = "Matricular Asignatura Estudiante";
	public static final String COMANDO_BTN_REGISTRAR_ENCUESTA = "Registrar encuestas";
	public static final String COMANDO_BTN_VTNA_LISTA_CIUDADES_CARGA = "lista de ciudades en carga";
	public static final String COMANDO_BTN_VTNA_LISTA_CIUDADES_MODIFICAR = "lista de ciudades en modificar";
	
	//Constantes de resolución
	public static final String USUARIO_ADMIN = "Usuario Admin";
	public static final String USUARIO_ESTUDIANTE = "Usuario Estudiante";
	public static final String USUARIO_ERRONEO = "Usuario erroneo";
	
	//Constantes de mensajes
	public static final String MENSAJE_LOGIN_FALLIDO = "Ingrese una combinación de código y contraseña válida";
	public static final String CAMPOS_VACIOS = "Ingrese un usuario y/o una contraseña";
	public static final String CARGA_EXITOSA_ASIGNATURA = "La asignatura fue creada con éxito";
	public static final String CARGA_EXITOSA_ESTUDIANTE = "El estudiante fue cargado con éxito";
	public static final String MODIFICACION_EXITOSA_ESTUDIANTE = "La modificación se realizó con éxito";
	public static final String MODIFICACION_FALLIDA_ESTUDIANTE = "La modificación no se pudo realiza, contraseña equivocada";
	public static final String CARGA_FALLIDA_ASIGNATURA = "La asignatura no pudo ser creada porque ya existe";
	public static final String CARGA_FALLIDA_ESTUDIANTE = "El estudiante no fue cargado porque el estudiante ya existe";
	public static final String MATRICULA_EXITOSA_ESTUDIANTES = "Las matrículas se realizaron exitosamente";
	public static final String CARGA_FALLIDA_CAMPO_VACIO = "No has llenado todo los campos";
	public static final String ENCUESTAS_RESPONDIDAS = "Las encuestas han sido respondidas con éxito";
	
	//Constantes de título
	public static final String TITULO_LOGIN_FALLIDO = "Datos erroneos";

	public static final String RUTA  = ".\\informacion";
}
