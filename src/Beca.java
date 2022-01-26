import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class Beca extends JFrame implements ActionListener, ItemListener{
    JLabel et,nombre_et, promedio_et, direccion_et, semestre_et;
    JTextField nombre, promedio;
    JTextArea direccion, mensaje;
    JComboBox semestre_lista;
    JButton enviar;
    String semestre_elegido;
    Float prom;
    
    Beca(){
    setLayout(null);
    setTitle("Formulario para alumnos");
    setBounds(300,300,400,600);
    //Indicación
    et = new JLabel("Completa la siguiente información");
    et.setBounds(20,15,350,30);
    add(et);
    //Nombre
    nombre_et = new JLabel("Nombre completo:");
    nombre_et.setBounds(20,50,200,30);
    add(nombre_et);
    nombre = new JTextField();
    nombre.setBounds(150,50,200,30);
    add(nombre);
    //Promedio
    promedio_et = new JLabel("Promedio general:");
    promedio_et.setBounds(20,90,200,30);
    add(promedio_et);
    promedio = new JTextField();
    promedio.setBounds(150,90,50,30);
    add(promedio);
    //Dirección
     direccion_et = new JLabel("Escribe tu dirección:");
    direccion_et.setBounds(20,140,200,30);
    add(direccion_et);
    direccion = new JTextArea();
    direccion.setBounds(20,180,200,50);
    add(direccion);
    //Semestre
    semestre_et = new JLabel("Selecciona el semestre:");
    semestre_et.setBounds(20,250,200,30);
    add(semestre_et);
    semestre_lista = new JComboBox();
    semestre_lista.setBounds(20,290,200,30);
     semestre_lista.addItem("");
    semestre_lista.addItem("Primer semestre");
    semestre_lista.addItem("Segundo semestre");
    semestre_lista.addItem("Tercer semestre");
    semestre_lista.addItemListener(this);
    add(semestre_lista);
    //Botón
    enviar = new JButton("Enviar información");
    enviar.setBounds(120,350,150,40);
    enviar.addActionListener(this);
    add(enviar);
    //Mensaje final
    mensaje = new JTextArea();
    mensaje.setBounds(50,430,280,100);
    add(mensaje);
    
      
    
    }
    
    public static void main(String[] args) {
        Beca marco = new Beca();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prom = Float.parseFloat(promedio.getText());
       if(prom>8 && semestre_elegido.equals("Tercer semestre")){
           mensaje.setText("El alumno "+nombre.getText()+" obtuvo la \nbeca,la cual se enviará a la dirección:\n"+direccion.getText());
       }else{
          mensaje.setText("El alumno"+nombre.getText()+"\nno obtuvo la beca");
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      semestre_elegido = (String)semestre_lista.getSelectedItem();
    }
    
}
