package program;
import java.io.IOException;
import java.util.Scanner;
import model.convert;
import model.convert;
import service.ViaConvert;

public class Teste {

	public static void main(String[] args) {
	
	Scanner ler = new Scanner(System.in);
	float valor;
	String esc;
	
	ViaConvert viaConvert = new ViaConvert();
	
	System.out.print("Valor: ");
	valor = ler.nextFloat();
	
	System.out.print("1 Dolar\n "
			+ "2 Euro \n"
			+ "3 BitCoin : ");
	esc = ler.next();
	
	  try {
           convert convert = viaConvert.getMoeda(esc);
         
          System.out.print(convert.converter(valor));;
         
      } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }  
	
	
	}
}
