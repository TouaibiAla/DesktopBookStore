/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Catégorie;
import entitys.Livre;
import entitys.User;
import interfaces.InterfaceCatégorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import technique.MyConnection;

/**
 *
 * @author nadia
 */
public class CatégorieService implements InterfaceCatégorie {
    
    MyConnection cnx;
    public CatégorieService()
    {
        cnx=MyConnection.getInstance();
        System.out.println("Connection établie");
    }
    
    @Override
    public void addCatégorie(Catégorie c) {
    try {
        String re = "insert into categorie (libelle) values (?)";
        PreparedStatement ps = cnx.getConnection().prepareStatement(re);
                    ps.setString(1, c.getLibelle());
                    ps.executeUpdate();
                    System.out.println("Catégorie added successfully");


    } catch (SQLException ex) {
        Logger.getLogger(CatégorieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   
    
    //@Override
   /* public List<Catégorie>  afficherCatégorie() {
          List<Catégorie> l=new ArrayList();
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req1= "select * from categorie ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                //System.out.println("ID "+rs.getInt("ID")+"Nom "+rs.getString("Nom"));
               Catégorie c = new Catégorie();
                c.setIdCategorie(rs.getInt("idCategorie"));
                c.setLibelle(rs.getString("libelle"));
                l.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("erreur affichage");
        }
        return l;
        
    }*/
    

    @Override
    public void updateCatégorie(int idCategorie, Catégorie c) {
    try {
            String req1= "UPDATE `categorie` SET `libelle` = ? WHERE `categorie`.`idCategorie` ="+idCategorie;
            PreparedStatement ps = cnx.getConnection().prepareStatement(req1);
            ps.setString(1, c.getLibelle());

            ps.executeUpdate(); 
            System.out.println("Categories update succeeded");
        } catch (SQLException ex) {
            System.err.println(ex);
        }    }
    
 @Override
    public Catégorie getCategorieId(int idCategorie) {
        Catégorie categorie = new Catégorie();
        try {
            String req1= "select * from categorie WHERE idCategorie = "+idCategorie;
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
               categorie= new Catégorie();
                categorie.setIdCategorie(rs.getInt("idCategorie"));
           
            }
            
            System.out.println("categories getId succeeded");
        } catch (SQLException ex) {
            System.err.println("erreur getId");
        }
        return categorie;
    }
    
    @Override
    public void removeCategorie(int idCategorie) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
            String req1= "DELETE FROM `categorie` WHERE `categorie`.`idCategorie` ="+idCategorie;
            Statement s= cnx.getConnection().createStatement();
            int rs = s.executeUpdate(req1);
            System.out.println("Catégorie a été supprimée avec succés");
        } catch (SQLException ex) {
            System.err.println(ex);
        }    
    }

    @Override
    public ObservableList<Catégorie> displayCategories() {
ObservableList<Catégorie> categoriesList = FXCollections.observableArrayList();
        //new ArrayList<Catégorie>();
        try {
            String req1= "select * from categorie ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Catégorie categorie = new Catégorie();
               categorie.setIdCategorie(rs.getInt("idCategorie"));
                categorie.setLibelle(rs.getString("libelle"));
                
                categoriesList.add(categorie);
            }
            System.out.println("categories display succeeded");
        } catch (SQLException ex) {
            System.err.println("erreur display");
        }
        return  categoriesList;    }
    
     @Override
     public ArrayList<Catégorie> getCategorieByLibelle( String libelle) {
         ArrayList<Catégorie> l = new ArrayList<Catégorie>();
         try {
             String rq= "select * from categorie where libelle='"+libelle+"'";
             Statement s= cnx.getConnection().createStatement();
             ResultSet rs = s.executeQuery(rq);
             while(rs.next())
             {
                 Catégorie c  = new Catégorie();
                 c.setLibelle(rs.getString("libelle"));
                
                
                 l.add(c);
             }
             System.out.println("Liste catégorie crée ");
         } catch (SQLException e) {
             System.err.println("Erreur de creation de la liste catégorie");
         }
        return l;
     }
     
        
    }

   

 
    


   

    

