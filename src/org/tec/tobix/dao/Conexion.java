package org.tec.tobix.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
	

		private static Conexion instancia= new Conexion();
		private Connection con;
		
		private Conexion() {
			String url = "jdbc:db2://dashdb-txn-sbox-yp-dal09-03.services.dal.bluemix.net:50000/BLUDB";
			String user = "whb59900";
			String password = "m3ph3ppzt^f8wqrp";  
			
				try 
				{
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					// Create the connection using the IBM Data Server Driver for JDBC and SQLJ
					this.con = DriverManager.getConnection (url, user, password);     
					// Commit changes manually
					this.con.setAutoCommit(true);
				} 
				catch (ClassNotFoundException e)
			    {
					System.err.println("Could not load JDBC driver");
					System.out.println("Exception: " + e);
					e.printStackTrace();
				}
				catch(SQLException ex)                                                     
				{
					System.err.println("SQLException information");
					while(ex!=null) 
					{
						System.err.println ("Error msg: " + ex.getMessage());
						System.err.println ("SQLSTATE: " + ex.getSQLState());
						System.err.println ("Error code: " + ex.getErrorCode());
						ex.printStackTrace();
						ex = ex.getNextException(); // For drivers that support chained exceptions
					}
				}
			}

		public static Conexion getInstance(){
			if (instancia!=null) {
			return instancia;
		}
			else {
			instancia=new Conexion();	
			return instancia;
			}
			}
		public Connection getConnection() {
			return this.con;
			
		}
	}


