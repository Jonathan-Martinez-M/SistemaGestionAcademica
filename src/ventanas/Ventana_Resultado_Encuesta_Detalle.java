package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Constantes;
import mundo.Ciudad;

import javax.swing.JComboBox;

public class Ventana_Resultado_Encuesta_Detalle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablePorcentajes;
	private JTable tableAbiertas;
	private JLabel titulo;

	/**
	 * Constructor de la clase Ventana_Resultado_Encuesta_Detalle
	 */
	public Ventana_Resultado_Encuesta_Detalle(Controlador control)
	{
		setTitle("Resultado de la Encuesta");
		setBounds(100, 100, 450, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 414, 110);
			contentPanel.add(scrollPane);
			
			tablePorcentajes = new JTable();
			tablePorcentajes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"/", "Pregunta 1", "Pregunta 2", "Pregunta 3", "Pregunta 4"
				}
			));
			tablePorcentajes.getColumnModel().getColumn(0).setPreferredWidth(21);
			scrollPane.setViewportView(tablePorcentajes);
		}
		
		titulo = new JLabel("");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titulo.setBounds(10, 11, 264, 24);
		contentPanel.add(titulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(113, 175, 204, 176);
		contentPanel.add(scrollPane);
		
		tableAbiertas = new JTable();
		tableAbiertas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pregunta 5"
			}
		));
		scrollPane.setViewportView(tableAbiertas);
		
		JComboBox filtroCiudades = new JComboBox();
		filtroCiudades.setBounds(290, 11, 134, 35);
		filtroCiudades.setActionCommand(Constantes.COMANDO_COMO_FILTRO_ENCUESTAS);
		filtroCiudades.addActionListener(control);
		
		ArrayList<Ciudad> ciudades = control.listarCiudades();
		for(int i=0; i < ciudades.size() ; i++) {
			filtroCiudades.addItem(ciudades.get(i).getNombre());
		}
		
		contentPanel.add(filtroCiudades);
	}

	public JTable getTablePorcentajes()
	{
		return tablePorcentajes;
	}

	public JTable getTableAbiertas()
	{
		return tableAbiertas;
	}

	public JLabel getTitulo()
	{
		return titulo;
	}
}
