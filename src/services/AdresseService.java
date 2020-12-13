/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Adresse;
import interfaces.InterfaceAdresse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import technique.MyConnection;

/**
 *
 * @author Documents
 */
public class AdresseService implements InterfaceAdresse{

    MyConnection connection;
    public AdresseService()
    {
        connection=MyConnection.getInstance();
    }
    @Override
    public void addAdresse(Adresse a) {
        try{
            String req= "insert into adresse(`gouvernorat`, `rue`,`ville`, `codePostale`) values  (?,?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setString(1, a.getGouvernorat());
            ps.setString(2, a.getRue());
            ps.setString(3, a.getVille());
            ps.setInt(4, a.getCodePostal());
            System.out.println(ps);
            ps.executeUpdate(); 
            System.out.println("adress added successfully");
        } catch (SQLException ex) {
            System.err.println("add erreur");
        
        }
    }

    @Override
    public void updateAdresse(Adresse a) {
        try {
            String req1= "UPDATE `adresse` SET `gouvernorat` = ?, `ville` = ?, `rue` = ?, `codePostale` = ?  WHERE `idAdresse`="+a.getIdAdresse();
            PreparedStatement ps = connection.getConnection().prepareStatement(req1);
            ps.setString(1, a.getGouvernorat());
            ps.setString(2, a.getVille());
            ps.setString(3, a.getRue());
            ps.setInt(4, a.getCodePostal());
            ps.executeUpdate(); 
            System.out.println("adress updated successfully");
        } catch (SQLException ex) {
            System.err.println("error");
        }
    }

    @Override
    public void removeAdresse(Adresse a) {
        try {
            String req1= "DELETE FROM adresse WHERE `idAdresse`="+a.getIdAdresse();
            Statement s= connection.getConnection().createStatement();
            int rs = s.executeUpdate(req1);
            System.out.println("Adress deleted successfully");
        } catch (SQLException ex) {
            System.err.println("Eror");
        }
    }

    @Override
    public Adresse getAdressById(int id) {
        Adresse adresse = new Adresse();
        try {
            String req1= "select * from adresse WHERE idAdresse = "+id;
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                adresse = new Adresse();
                adresse.setIdAdresse(rs.getInt("idAdresse"));
                adresse.setGouvernorat(rs.getString("gouvernorat"));
                adresse.setVille(rs.getString("ville"));
                adresse.setRue(rs.getString("rue"));
                adresse.setCodePostal(rs.getInt("codePostale"));
            }
            
            System.out.println("adress getId succeeded");
        } catch (SQLException ex) {
            System.err.println("getid erreur");
        }
        return adresse;
    }
    
}
