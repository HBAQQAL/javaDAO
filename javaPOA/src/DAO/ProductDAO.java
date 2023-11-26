package DAO;

import java.util.List;

import Models.Product;
import java.util.ArrayList;
import DB.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProductDAO implements DAO<Product , Integer> {

    @Override
    public void create(Product entity) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "INSERT INTO product (name, description, price, stock) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setDouble(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getStock());
            preparedStatement.executeUpdate();
            System.out.println("Product ajouté avec succès");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du product : " + e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = Connexion.getConnection();
            String query = "SELECT * FROM product";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery();
            while (preparedStatement.getResultSet().next()) {
                Product product = new Product();
                product.setId(res.getInt("id"));
                product.setName(res.getString("name"));
                product.setDescription(res.getString("description"));
                product.setPrice(res.getDouble("price"));
                product.setStock(res.getInt("stock"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des products : " + e);
        }
        return products;
    }

    @Override
    public Product getByID(Integer id) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "SELECT * FROM product WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet res =  preparedStatement.executeQuery();
            Product product = new Product();
            product.setId(res.getInt("id"));
            product.setName(res.getString("name"));
            product.setDescription(res.getString("description"));
            product.setPrice(res.getDouble("price"));
            product.setStock(res.getInt("stock"));
            return product;
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du product : " + e);
        } 
        return null;
    }

    @Override
    public void updateByID(Integer id , Product entity) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "UPDATE product SET name = ?, description = ?, price = ?, stock = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setDouble(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getStock());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            System.out.println("Product modifié avec succès");
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification du product : " + e);
    }
}

    @Override
    public void deleteByID(Integer id) {
        try {
            Connection connection = Connexion.getConnection();
            String query = "DELETE FROM product WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Product supprimé avec succès");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du product : " + e);
        }
    }
    
}
