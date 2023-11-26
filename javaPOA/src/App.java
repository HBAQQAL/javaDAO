import java.util.Scanner;

import DAO.clientDAO;
import DB.Connexion;
import Models.Client;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello, World!");
        Connection connection = Connexion.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = scanner.nextLine();
        System.out.println("Enter your email : ");
        String email = scanner.nextLine();
        System.out.println("Enter your phone number : ");
        String phone = scanner.nextLine();
        System.out.println("Enter your address : ");
        String address = scanner.nextLine();
        Client client = new Client(0, name, email, phone, address);
        clientDAO clientDAO = new clientDAO();
        clientDAO.create(client);
        
    }
}
