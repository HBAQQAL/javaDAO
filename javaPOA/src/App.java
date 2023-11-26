import java.util.Scanner;

import DAO.clientDAO;
import DB.Connexion;
import Models.Client;
import Models.Product;
import DAO.ProductDAO;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();
        clientDAO clientDAO = new clientDAO();
        Product product = new Product();
        Client client = new Client();
        int choix = 0;
        do {
            System.out.println("1- Ajouter un produit");
            System.out.println("2- Afficher les produits");
            System.out.println("3- Ajouter un client");
            System.out.println("4- Afficher les clients");
            System.out.println("5- modifier un produit");
            System.out.println("6- modifier un client");
            System.out.println("7- supprimer un produit");
            System.out.println("8- supprimer un client");
            System.out.println("9- quitter");
            System.out.println("Faites votre choix");
            choix = sc.nextInt();
            switch (choix) {
                case 1 :
                    System.out.println("Entrer le nom du produit");
                    product.setName(sc.next());
                    System.out.println("Entrer la description du produit");
                    product.setDescription(sc.next());
                    System.out.println("Entrer le prix du produit");
                    product.setPrice(sc.nextDouble());
                    System.out.println("Entrer le stock du produit");
                    product.setStock(sc.nextInt());
                    productDAO.create(product);
                    break;
                case 2 :
                    System.out.println(productDAO.getAll());
                    break;
                case 3 :
                    System.out.println("Entrer le nom du client");
                    client.setName(sc.next());
                    System.out.println("Entrer l'email du client");
                    client.setEmail(sc.next());
                    System.out.println("Entrer l'address du client");
                    client.setAddress(sc.next());
                    System.out.println("Entrer le numéro de téléphone du client");
                    client.setPhone(sc.next());
                    clientDAO.create(client);
                    break;
                case 4 :
                    System.out.println(clientDAO.getAll());
                    break;
                case 5 :
                    System.out.println("Entrer l'id du produit à modifier");
                    product.setId(sc.nextInt());
                    System.out.println("Entrer le nom du produit");
                    product.setName(sc.next());
                    System.out.println("Entrer la description du produit");
                    product.setDescription(sc.next());
                    System.out.println("Entrer le prix du produit");
                    product.setPrice(sc.nextDouble());
                    System.out.println("Entrer le stock du produit");
                    product.setStock(sc.nextInt());
                    productDAO.updateByID(product.getId(), product);
                    break;
                case 6 :
                    System.out.println("Entrer l'id du client à modifier");
                    client.setId(sc.nextInt());
                    System.out.println("Entrer le nom du client");
                    client.setName(sc.next());
                    System.out.println("Entrer l'email du client");
                    client.setEmail(sc.next());
                    System.out.println("Entrer l'address du client");
                    client.setAddress(sc.next());
                    System.out.println("Entrer le numéro de téléphone du client");
                    client.setPhone(sc.next());
                    clientDAO.updateByID(client.getId(), client);
                    break;
                case 7 :
                    System.out.println("Entrer l'id du produit à supprimer");
                    product.setId(sc.nextInt());
                    productDAO.deleteByID(null);
                    break;
                case 8 :
                    System.out.println("Entrer l'id du client à supprimer");
                    client.setId(sc.nextInt());
                    clientDAO.deleteByID(null);
                    break;
                case 9 :
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (choix != 9);
    }
}
