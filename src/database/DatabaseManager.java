package database;    

import java.awt.Component;
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
			statement.executeUpdate("create table if not exists plan (id integer, name string)");
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ArrayList<Displayable> readDatabase() {
		ArrayList<Displayable> panels = new ArrayList<>();
		
		try {
			ResultSet rs = statement.executeQuery("select * from plan");
			while(rs.next()) {
				// TODO: This assumes that we are retrieving a slime from the database, not food.
				panels.add(SlimeRancherRepository.getSlimeOrFood(rs.getString("name")));
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
			statement.executeUpdate("create table plan (id integer, name string)");
			
			int id = 0;
			for(Component c : components) {	
				Panel p = (Panel) c;
				System.out.println("insert into plan values (" + id++ + ", '" + p.getName() + "')");
				statement.executeUpdate("insert into plan values (" + id++ + ", '" + p.getName() + "')");
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