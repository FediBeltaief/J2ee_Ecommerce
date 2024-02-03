package Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import Dao.gestionUtilisateur;
import connection.SingletonConnection;
import modele.utilisateur;

public class gestionUtilisateur  implements IUtilisateurDao{
	public utilisateur add(utilisateur u){
		Connection conn = (Connection) SingletonConnection.getConnection();
		try {

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO UTILISATEUR VALUES(?,?)");

			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	
	public utilisateur update(utilisateur u) {
		Connection conn = (Connection) SingletonConnection.getConnection();
		try {

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Update utilisateur set password = ? where login= ?");

			ps.setString(2, u.getLogin());
			ps.setString(1, u.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	public void delete(String s) {
		Connection conn = (Connection) SingletonConnection.getConnection();
		try {

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("delete from utilisateur where login= ?");

			ps.setString(1,s);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public boolean exist(utilisateur u)
	{
		Connection conn = (Connection) SingletonConnection.getConnection();
		try {

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from UTILISATEUR where login= ? and password = ?");

			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<utilisateur> getAllUsers()
	{
		Connection conn = (Connection) SingletonConnection.getConnection();
		List<utilisateur> Lst=new ArrayList<>();
		utilisateur u;
		try {

			java.sql.PreparedStatement ps = conn.prepareStatement("select * from utilisateur");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				u=new utilisateur(rs.getString(1),rs.getString(2));
				Lst.add(u);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lst;
	}
	public List<utilisateur> getUsers(String s)
	{
		Connection conn = (Connection) SingletonConnection.getConnection();
		List<utilisateur> Lst=new ArrayList<>();
		try {

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from UTILISATEUR where username= ?");
			ps.setString(1, s);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Lst.add(new utilisateur(rs.getString(1),rs.getString(2)));
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lst;
	}
}
