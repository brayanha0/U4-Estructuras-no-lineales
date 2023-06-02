package EntradaSalida;
import javax.swing.JOptionPane;

public class Tools {
    
//******************************************************************************
    public static int leeEntero(String msg){
        int x;
        do{
            try{
                x= Integer.parseInt(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static float leeFloat(String msg){
        float x;
        do{
            try{
                x= Float.parseFloat(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static char leeCaracter(String msg){
        char x;
            x= JOptionPane.showInputDialog(msg).charAt(0);
            return x;
    }
//******************************************************************************
    public static double leeDoble(String msg){
        double x;
        do{
            try{
                x= Double.parseDouble(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static short leeShort(String msg){
        short x;
        do{
            try{
                x= Short.parseShort(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static long leeLong(String msg){
        long x;
        do{
            try{
                x= Long.parseLong(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static byte leeByte(String msg){
        byte x;
        do{
            try{
                x= Byte.parseByte(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static boolean leeBoolean(String msg){
        boolean x;
        do{
            try{
                x= Boolean.parseBoolean(JOptionPane.showInputDialog(msg));
                return x;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tipo de dato incorrecto, por favor escriba numeros");
            }
        }while(true);
    }
//******************************************************************************
    public static String leeString(String msg){
        String x;
            x= JOptionPane.showInputDialog(msg);
            return x;
    }
//******************************************************************************
    public static void ImprimeMensaje(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}
