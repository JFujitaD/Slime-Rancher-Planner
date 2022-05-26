package database;    

import java.awt.Component;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import components.Panel;
import models.Displayable;
import models.SlimeRancherRepository;

public class DatabaseManager { 
	private Connection connection = null;
	private Statement statement = null;
	
	public DatabaseManager() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:planner.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("create table if not exists plan ("
					+ "id integer,"
					+ "name string"
					+ "posX integer"
					+ "posY integer)");
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ArrayList<Panel> readDatabase() {
		ArrayList<Panel> panels = new ArrayList<>();
		
		try {
			ResultSet rs = statement.executeQuery("select * from plan");
			while(rs.next()) {
				Panel p = new Panel(SlimeRancherRepository.getSlimeOrFood(rs.getString("name")));
				p.setLocation(rs.getInt("posX"), rs.getInt("posY"));
				panels.add(p);
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return panels;
	}
	
	public void saveToDatabase(Component[] components) {
		System.out.println("Saving to database...\nComponent Count: " + components.length);
		
		try {
			statement.executeUpdate("drop table if exists plan");
			statement.executeUpdate("create table if not exists plan ("
					+ "id integer,"
					+ "name string,"
					+ "posX integer,"
					+ "posY integer)");
			
			int id = 0;
			for(Component c : components) {	
				StringBuilder sb = new StringBuilder("insert into plan values (");
				Panel p = (Panel) c;
				Point l = p.getLocation();
				
				sb.append(id++ + ", '");
				sb.append(p.getName() + "', ");
				sb.append(l.x + ", ");
				sb.append(l.y + ")");
				
				System.out.println(sb.toString());
				statement.executeUpdate(sb.toString());
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		} 
	}
	
	public void closeConnection() {
		try {
			if(connection != null)
				connection.close();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}