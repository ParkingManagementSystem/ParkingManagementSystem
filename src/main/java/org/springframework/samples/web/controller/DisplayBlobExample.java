package org.springframework.samples.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//SHOW BLOB IMAGE
public class DisplayBlobExample extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Blob image = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		System.out.println("nn");
		
		ServletOutputStream out = response.getOutputStream();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@202.20.119.117:1521:orcl","boongboong2","qndqnddl");
			stm = con.createStatement();
			System.out.println("커넥션 성공");
			if(con != null)
				System.out.println("커넥션 성공");
			rs = stm.executeQuery("select img from img_table where p = 1");
			if(rs.next()) {
				System.out.println("dd");
				image = rs.getBlob(1);
			} else {

				response.setContentType("TEXT/HTML");
				return;
			}
			
			response.setContentType("image/png");
			InputStream in = image.getBinaryStream();
			int length = (int) image.length();
			
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			
			while((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			
			in.close();
			out.flush();
			
		} catch(Exception e) {
			System.out.println("error");
			System.out.println(e.getMessage());
			e.printStackTrace();
			response.setContentType("TEXT/HTML");
			return ;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stm!=null) stm.close();
				if(con!=null) con.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
