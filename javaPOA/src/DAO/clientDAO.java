package DAO;

import java.util.ArrayList;
import java.util.List;
import DB.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Models.Client;

public class clientDAO  implements DAO<Client , Integer>{

  

    @Override
    public void create(Client entity) {
       try {
        Connection connection = Connexion.getConnection();
        String query = "INSERT INTO client (nom, email, phone, address) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getEmail());
        preparedStatement.setString(3, entity.getPhone());
        preparedStatement.setString(4, entity.getAddress());
        preparedStatement.executeUpdate();
        System.out.println("Client ajouté avec succès");
       } catch (Exception e) {
        System.out.println("Erreur lors de l'ajout du client : " + e);
       }
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = Connexion.getConnection();
            String query = "SELECT * FROM client";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeQuery();
            while (preparedStatement.getResultSet().next()) {
                Client client = new Client();
                client.setId(preparedStatement.getResultSet().getInt("id"));
                client.setName(preparedStatement.getResultSet().getString("nom"));
                client.setEmail(preparedStatement.getResultSet().getString("email"));
                client.setPhone(preparedStatement.getResultSet().getString("phone"));
                client.setAddress(preparedStatement.getResultSet().getString("address"));
                clients.add(client);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des clients : " + e);
        }
        return clients;
    }

    @Override
    public Client getByID(Integer id) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "SELECT * FROM client WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet res =  preparedStatement.executeQuery();
            Client client = new Client(res.getInt("id"), res.getString("nom"), res.getString("email"), res.getString("phone"), res.getString("address"));
           return client;
        } catch (Exception e) {
          
            System.out.println("Erreur lors de la récupération du client : " + e);
        }
        return null;
    }

    @Override
    public void updateByID(Integer id) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "UPDATE client SET nom = ?, email = ?, phone = ?, address = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "name");
            preparedStatement.setString(2, "email");
            preparedStatement.setString(3, "phone");
            preparedStatement.setString(4, "address");
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            System.out.println("Client modifié avec succès");

        } catch (Exception e) {
            
            System.out.println("Erreur lors de la modification du client : " + e);
        }

    }

    @Override
    public void deleteByID(Integer id) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "DELETE FROM client WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Client supprimé avec succès");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du client : " + e);
        }
    }
   
    
}
