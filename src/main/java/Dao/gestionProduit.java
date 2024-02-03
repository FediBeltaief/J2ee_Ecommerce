package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.SingletonConnection;
import modele.produit;

public class gestionProduit implements IProduitDao {
	private ArrayList<produit> listeProduit = new ArrayList<>();

	public produit save(produit p) {
		Connection conn = (Connection) SingletonConnection.getConnection();
		try {

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO PRODUIT VALUES(?,?,?,?,?,?)");

			ps.setString(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(4, p.getFour());
			ps.setDouble(3, p.getPrix());
			ps.setString(5, p.getDescription());
			ps.setString(6, p.getImg());
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean ajoutProduit(produit p) {
		return this.listeProduit.add(p);
	}

	@Override
	public List<produit> getAllProduits() {
	    Connection conn = (Connection) SingletonConnection.getConnection();
	    List<produit> productList = new ArrayList<>();
	    try {
	    	java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            produit p = new produit();
	            p.setId(rs.getString("id"));
	            p.setNom(rs.getString("nom"));
	            p.setPrix(rs.getFloat("prix"));
	            p.setFour(rs.getString("four"));
	            p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
	            productList.add(p);
	        }
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return productList;
	}

	@Override
	public List<produit> getProduit(String search) {
	    Connection conn = (Connection) SingletonConnection.getConnection();
	    List<produit> productList = new ArrayList<>();
	    try {
	        java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit WHERE id = ? OR nom LIKE ? OR prix = ? OR four LIKE ?");
	        ps.setString(1, search);
	        ps.setString(2, "%" + search + "%");
	        ps.setString(3, search);
	        ps.setString(4, "%" + search + "%");
	        
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            produit p = new produit();
	            p.setId(rs.getString("id"));
	            p.setNom(rs.getString("nom"));
	            p.setPrix(rs.getFloat("prix"));
	            p.setFour(rs.getString("four"));
	            p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
	            productList.add(p);
	        }
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return productList;
	}
	public produit getProduitbyID(String search) {
	    Connection conn = (Connection) SingletonConnection.getConnection();
	    produit p = new produit();
	    try {
	        java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit WHERE id = ?");
	        ps.setString(1, search);
	        
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            p.setId(rs.getString("id"));
	            p.setNom(rs.getString("nom"));
	            p.setPrix(rs.getFloat("prix"));
	            p.setFour(rs.getString("four"));
	            p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
	        }
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return p;
	}

	@Override
	public produit updateProduit(produit p) {
		java.sql.Connection conn = SingletonConnection.getConnection();
		produit list = null;
		try {
			java.sql.PreparedStatement ps = conn.prepareStatement("UPDATE Produit  SET nom=?,prix=?,four=?,description=?,img=? WHERE id=?;");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setString(3, p.getFour());
			ps.setString(6, p.getId());
			ps.setString(4, p.getDescription());
			ps.setString(5, p.getImg());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteProduit(String id) {
		java.sql.Connection conn = SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps = conn.prepareStatement("Delete from produit where id=?;");
			ps.setString(1, id);
			int i = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.print("delete failed");
		}
	}
	
}
