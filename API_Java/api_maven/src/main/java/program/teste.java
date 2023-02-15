package program;
import java.io.IOException;
import java.util.Scanner;
import model.perfil;
import service.ViaGit;


public class teste {


    public static void main(String[] args) {

    	Scanner ler = new Scanner(System.in);
    	String login;
    	
        ViaGit viaGit = new ViaGit();

        System.out.print("Qual a URL do perfil do GitHub? : ");
        login = ler.next();
        
        try {
            perfil perfil = viaGit.getLogin(login);
           
            System.out.print(perfil.toString());;
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
    }
}




