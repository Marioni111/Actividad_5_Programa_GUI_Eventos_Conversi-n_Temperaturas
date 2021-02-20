import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints configuracion = new GridBagConstraints();
	JTextField cajaTempInicial;
	JComboBox<String> comboBoxOpciones1;
	JComboBox<String> comboBoxOpciones2;
	JTextField cajaTempFinal; 
	
	public Main(){
		crearComponentes();
	}
	
	public void crearComponentes(){
		
		//configuración ventana inicial
		getContentPane().setLayout(gbl);
		setTitle("Convertidor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		acomodaComponentes(new JLabel("Covertir:"), 0, 0, 1, 1, GridBagConstraints.BOTH);
		cajaTempInicial = new JTextField("0.0");
		acomodaComponentes(cajaTempInicial, 2, 0, 1, 1, GridBagConstraints.BOTH);
		
		comboBoxOpciones1 = new JComboBox<String>();
		comboBoxOpciones1.addItem("°Celsius");
		comboBoxOpciones1.addItem("°Kelvin");
		comboBoxOpciones1.addItem("°Fahrenheit");
		comboBoxOpciones1.addItem("°Rankine");
		comboBoxOpciones1.addActionListener(this);
		acomodaComponentes(comboBoxOpciones1, 4, 0, 1, 1, GridBagConstraints.BOTH);
		
		acomodaComponentes(new JLabel("A:"), 1, 1, 1, 1, GridBagConstraints.BOTH);
		
		comboBoxOpciones2 = new JComboBox<String>();
		comboBoxOpciones2.addItem("°Celsius");
		comboBoxOpciones2.addItem("°Kelvin");
		comboBoxOpciones2.addItem("°Fahrenheit");
		comboBoxOpciones2.addItem("°Rankine");
		comboBoxOpciones2.addActionListener(this);
		acomodaComponentes(comboBoxOpciones2, 2, 1, 1, 1, GridBagConstraints.BOTH);
		
		acomodaComponentes(new JLabel("="), 3, 1, 1, 1, GridBagConstraints.BOTH);
		cajaTempFinal = new JTextField("0.0");
		acomodaComponentes(cajaTempFinal, 4, 1, 1, 1, GridBagConstraints.BOTH);
		
		pack();
	}
	
	public void acomodaComponentes(JComponent componente, int gx, int gy, int gw, int gh, int f){
		
		configuracion.gridx = gx;
		configuracion.gridy = gy;
		configuracion.gridwidth = gw;
		configuracion.gridheight = gh;
		configuracion.fill = f;
		gbl.setConstraints(componente, configuracion);
		add(componente);
		
	}//acomodaComponentes
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String entrada = (String)comboBoxOpciones1.getSelectedItem();
        String salida = (String)comboBoxOpciones2.getSelectedItem();
        
        if(entrada=="°Celsius"){
        	if (salida == "°Fahrenheit"){
        		cajaTempFinal.setText(String.valueOf(Double.parseDouble(cajaTempInicial.getText())*1.8+32));
            }
            else if(salida == "°Kelvin"){
            	cajaTempFinal.setText(String.valueOf(Double.parseDouble(cajaTempInicial.getText())+273.15));
                }
            else if(salida == "°Rankine"){
            	double conv=(Double.parseDouble(cajaTempInicial.getText())*1.8+32);
            	conv=(conv+459.67);
            	cajaTempFinal.setText(String.valueOf(conv));
                }
            else{
            	cajaTempFinal.setText(cajaTempInicial.getText());
                }
            }
        else if(entrada=="°Fahrenheit"){
        	if (salida=="°Celsius"){
        		cajaTempFinal.setText(String.valueOf(Double.parseDouble(cajaTempInicial.getText())-32/1.8));
            }
            else if(salida=="°Kelvin"){
                double conv=(Double.parseDouble(cajaTempInicial.getText()));
                conv=(conv+459.67);
                conv=(5*conv)/(9);
                cajaTempFinal.setText(String.valueOf(conv));
            }
            else if(salida == "°Rankine"){
            	cajaTempFinal.setText(String.valueOf(Double.parseDouble(cajaTempInicial.getText())+459.67));
                }
            else{
                cajaTempFinal.setText(cajaTempInicial.getText());
            }
        }
        else if(entrada=="°Kelvin") {
        	if (salida=="°Celsius") {
        		cajaTempFinal.setText(String.valueOf(Double.parseDouble(cajaTempInicial.getText())-273.15));
            }
            else if(salida=="°Fahrenheit") {
                double conv=(Double.parseDouble(cajaTempInicial.getText()));
                conv=(conv-273);
                conv=(1.8*conv)+(32);
                cajaTempFinal.setText(String.valueOf(conv));
            }
            else if(salida=="°Rankine") {
                double conv=(Double.parseDouble(cajaTempInicial.getText()));
                conv=(conv-273);
                conv=(1.8*conv)+(32);
                conv=(conv+459.67);
                cajaTempFinal.setText(String.valueOf(conv));
            }
            else{
                cajaTempFinal.setText(String.valueOf(cajaTempInicial.getText()));
            }
        }
        else if(entrada=="°Rankine") {
        	if (salida=="°Celsius") {
        		double conv = (Double.parseDouble(cajaTempInicial.getText())-459.67);
        		conv = (conv-32)/8;
        		cajaTempFinal.setText(String.valueOf(conv));
            }
            else if(salida=="°Fahrenheit") {
            	cajaTempFinal.setText(String.valueOf(Double.parseDouble(cajaTempInicial.getText())-459.67));
            }
            else if(salida=="°Kelvin") {
            	double conv = (Double.parseDouble(cajaTempInicial.getText())-459.67);
            	conv=(conv+459.67);
                conv=(5*conv)/(9);
                cajaTempFinal.setText(String.valueOf(conv));
            }
            else{
                cajaTempFinal.setText(String.valueOf(cajaTempInicial.getText()));
            }
        }
	    }
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Main();
			}
		});
	}
}