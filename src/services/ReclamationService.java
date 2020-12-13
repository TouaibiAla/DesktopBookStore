/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Reclamation;
import interfaces.InterfaceReclamation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.MyConnection;

/**
 *
 * @author Touaibi-Alaa
 */
public class ReclamationService implements InterfaceReclamation{
    MyConnection connection;
    UserService userService;
    public ReclamationService(){
        connection=MyConnection.getInstance();
        userService=new UserService();
    }
    @Override
    public void ajouterReclamation(Reclamation r) {
        try {
            String req="insert into reclamation(`sujet`,`description`,`idUtilisateur`) values (?,?,?)";
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.setString(1, r.getSujet());
            ps.setString(2, r.getDescription());
            ps.setInt(3,r.getIdUtilisatuer().getId());
            ps.executeUpdate();
            System.out.println("Reclamatiopn ajout avec succées");
        } catch (SQLException ex) {
           System.err.println("ajout Reclamation");
        }
    }

    @Override
    public void modifierReclamation(Reclamation r) {
        try {
            String req="update reclamation set sujet=? and description=? where idReclamation=?";
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.setString(1, r.getSujet());
            ps.setString(2, r.getDescription());
            ps.setInt(3, r.getIdReclamation());
            ps.executeUpdate();
            System.out.println("update Reclamation avec succes");
        } catch (SQLException ex) {
              System.err.println("update Reclamation");
        }
       
    }

    @Override
    public void supprimerReclamation(int id) {
        try {
            String req="delete from reclamation where idReclamation="+id;
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.executeUpdate();
            System.out.println("Reclamatiopn supprimé avec succées");
        } catch (SQLException ex) {
           System.err.println("suppression Reclamation");
        }
    }

    @Override
    public ArrayList<Reclamation> getAllReclamations() {
        ArrayList<Reclamation> arr=new ArrayList<>();
        try {
            String req="select * from reclamation";
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                Reclamation rc=new Reclamation();
                rc.setIdReclamation(rs.getInt("idReclamation"));
                rc.setSujet(rs.getString("sujet"));
                rc.setDescription(rs.getString("description"));
                rc.setIdUtilisatuer(userService.getUserId(rs.getInt("idUtilisateur")));
                arr.add(rc);
            }
        } catch (SQLException ex) {
           System.err.println("Lister tous les reclamations");
        }
        return arr;
    }

    @Override
    public Reclamation getReclamationById(int id) {
        Reclamation rc= new Reclamation();
        try {
            String req="select * from reclamation where idReclamation="+id;
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                rc.setIdReclamation(rs.getInt("idReclamation"));
                rc.setSujet(rs.getString("sujet"));
                rc.setDescription(rs.getString("description"));
                rc.setIdUtilisatuer(userService.getUserId(rs.getInt("idUtilisateur")));
            }
        } catch (SQLException ex) {
            System.err.println("reclamations par id");
        }
      return rc;
    }
    
}