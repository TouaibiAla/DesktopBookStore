/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Livreur;
import interfaces.InterfaceLivreur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import technique.MyConnection;

/**
 *
 * @author Aymen
 */
public class LivreurService implements InterfaceLivreur {
    
    MyConnection connection;
    public LivreurService()
    {
        connection=MyConnection.getInstance();
    }

    @Override
    public void ajouterLivreur(Livreur l) {
         try {
            String req= "insert into livreur(`NomLivreur`, `PrenomLivreur`,`Disponibilite`) values (?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setString(1, l.getNomLivreur());
            ps.setString(2, l.getPrenomLivreur());
            ps.setBoolean(3, l.getDisponibilite());
            ps.executeUpdate(); 
            System.out.println("Livreur ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println("Erreur d'ajout");
        }
    }

    @Override
    public void modifierLivreur(Livreur l) {
         try {
            String req1= "UPDATE `livreur` SET `NomLivreur` = ?, `PrenomLivreur` = ?, `Disponibilite` = ?  WHERE `IdLivreur`="+l.getIdLivreur();
            PreparedStatement ps = connection.getConnection().prepareStatement(req1);
            ps.setString(1, l.getNomLivreur());
            ps.setString(2, l.getPrenomLivreur());
            ps.setBoolean(3, l.getDisponibilite());
            ps.executeUpdate(); 
            System.out.println("Livreur modifié avec succès");
        } catch (SQLException ex) {
            System.err.println("Erreur de modification");
        }
    }

    @Override
    public void supprimerLivreur(Livreur l) {
        try {
            String req1= "DELETE FROM livreur WHERE `IdLivreur`="+l.getIdLivreur();
            Statement s= connection.getConnection().createStatement();
            int rs = s.executeUpdate(req1);
            System.out.println("Livreur supprimé");
        } catch (SQLException ex) {
            System.err.println("Erreur de suppression");
        }
    }

    @Override
    public ArrayList<Livreur> getAllLivreurs() {
        ArrayList<Livreur> ListeLivreurs = new ArrayList<Livreur>();
        try {
            String req1= "select * from livreur";
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livreur livreur = new Livreur();
                livreur.setIdLivreur(rs.getInt("idLivreur"));
                livreur.setNomLivreur(rs.getString("nomLivreur"));
                livreur.setPrenomLivreur(rs.getString("prenomLivreur"));
                livreur.setDisponibilite(rs.getBoolean("disponibilite"));
                ListeLivreurs.add(livreur);
            }
            System.out.println("Liste des livreurs affichée avec succès");
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste des livreurs");
        }
        return ListeLivreurs;
    }

    @Override
    public ArrayList<Livreur> getLivreurByNom(String nom) {
        ArrayList<Livreur> ListeLivreurs = new ArrayList<Livreur>();
        try {
            String req1= "select * from livreur where NomLivreur='"+nom+"'";
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livreur livreur = new Livreur();
                livreur.setIdLivreur(rs.getInt("IdLivreur"));
                livreur.setNomLivreur(rs.getString("NomLivreur"));
                livreur.setPrenomLivreur(rs.getString("PrenomLivreur"));
                livreur.setDisponibilite(rs.getBoolean("Disponibilite"));
                ListeLivreurs.add(livreur);
            }
            System.out.println("Méthode getLivreurByNom fonctionne correctement");
        } catch (SQLException ex) {
            System.err.println("Erreur de la méthode getLivreurByNom");
        }
        return ListeLivreurs;
    }

    @Override
    public ArrayList<Livreur> getLivreurByPrenom(String prenom) {
        ArrayList<Livreur> ListeLivreurs = new ArrayList<Livreur>();
        try {
            String req1= "select * from livreur where PrenomLivreur='"+prenom+"'";
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livreur livreur = new Livreur();
                livreur.setIdLivreur(rs.getInt("IdLivreur"));
                livreur.setNomLivreur(rs.getString("NomLivreur"));
                livreur.setPrenomLivreur(rs.getString("PrenomLivreur"));
                livreur.setDisponibilite(rs.getBoolean("Disponibilite"));
                ListeLivreurs.add(livreur);
            }
            System.out.println("Méthode getLivreurByPrenom fonctionne correctement");
        } catch (SQLException ex) {
            System.err.println("Erreur de la méthode getLivreurByPrenom");
        }
        return ListeLivreurs;
    }

    @Override
    public ArrayList<Livreur> getLivreursByDisponibilite(boolean b) {
        ArrayList<Livreur> ListeLivreurs = new ArrayList<Livreur>();
        try {
            String req1= "select * from livreur where Disponibilite="+b;
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livreur livreur = new Livreur();
                livreur.setIdLivreur(rs.getInt("IdLivreur"));
                livreur.setNomLivreur(rs.getString("NomLivreur"));
                livreur.setPrenomLivreur(rs.getString("PrenomLivreur"));
                livreur.setDisponibilite(rs.getBoolean("Disponibilite"));
                ListeLivreurs.add(livreur);
            }
            System.out.println("Méthode getLivreurByDisponiblite fonctionne correctement");
        } catch (SQLException ex) {
            System.err.println("Erreur de la méthode getLivreurByDisponibilite");
        }
        return ListeLivreurs;
    }
    @Override
    public Livreur getLivreurById(int id){
        Livreur livreur = new Livreur();
        try {
            String req1= "select * from livreur WHERE IdLivreur = "+id;
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                livreur = new Livreur();
                livreur.setIdLivreur(rs.getInt("IdLivreur"));
                livreur.setNomLivreur(rs.getString("NomLivreur"));
                livreur.setPrenomLivreur(rs.getString("PrenomLivreur"));
                livreur.setDisponibilite(rs.getBoolean("Disponibilite"));
            }
            
            System.out.println("Méthode getLivreurById fonctionne correctement");
        } catch (SQLException ex) {
            System.err.println("Erreur méthode getLivreurById");
        }
        return livreur;
    }
    
    
}
