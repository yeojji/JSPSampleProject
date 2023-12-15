package db.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.dto.PersonInfoDTO;
import db.util.DBConnectionManager;

public class PersonInfoDAO {
	
	//필드변수
			Connection conn;
			PreparedStatement psmt;
			ResultSet rs;
	
	//select... find... read...
	public List<PersonInfoDTO> findPersonInfoList(){
		
	
		//결과가 한개인지 여러개인지(List)인지 
		
			//DBConnectionManager 만들어준 connection을 활용
			conn = DBConnectionManager.connectDB();
			
		      String sql = " SELECT * FROM t_person_info ORDER BY id";

		      List<PersonInfoDTO> personInfoList = null;
		      
		      try {
		         psmt = conn.prepareStatement(sql);
		         //Connection 활용해서 sql 명령을 실행하는 객체

		         rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!
		         personInfoList = new ArrayList<PersonInfoDTO>();
		         
		         while(rs.next()) {
		            
		        PersonInfoDTO personInfoDTO = new PersonInfoDTO(rs.getInt("id"),rs.getString("name"));
		        
		        personInfoList.add(personInfoDTO);

		         }

		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		    	 DBConnectionManager.closeDB(conn, psmt, rs);
		      }
		      
		      return personInfoList;
		
	}
	
	public PersonInfoDTO findPersonInfoById(int id) {
		
		conn = DBConnectionManager.connectDB();
		
	      String sql = " SELECT * FROM t_person_info " 
	    		  		+" WHERE id = ? ";

	      PersonInfoDTO personInfo = null;
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         //Connection 활용해서 sql 명령을 실행하는 객체
	         
	         psmt.setInt(1, id);

	         rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!
	         
	         
	         if(rs.next()) {
	            
	       personInfo = new PersonInfoDTO(rs.getInt("id"),rs.getString("name"));
	    
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	    	 DBConnectionManager.closeDB(conn, psmt, rs);
	      }
	      
	      return personInfo;
	}
	


	
	public int savePersonInfo(int id, String name) {
		conn = DBConnectionManager.connectDB();
		
	      String sql = " INSERT INTO t_person_info "
	    		  		+ " VALUES( ?, ?) ";
	      int result = 0;
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         //Connection 활용해서 sql 명령을 실행하는 객체

	         psmt.setInt(1, id);
	         psmt.setString(2, name);
	         
	         result = psmt.executeUpdate(); //1 , 0
	         
	        // rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!

	         /*
	          SELECT 쿼리 : psmt.executeQuery(); ->결과로 ResultSet
	          INSERT,UPDATE,DELETE 쿼리 : psmt.executeUpdate(); 
	          							-> 결과로 적용된 행의 숫자 
	          */
	         
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	    	 DBConnectionManager.closeDB(conn, psmt, rs);
	      }

		return result;
	}



public int savePersonInfo(String name) { 
	conn = DBConnectionManager.connectDB();
	
      String sql = " INSERT INTO t_person_info "
    		  		+ " VALUES( (SELECT NVL(MAX(id),0) + 1 FROM t_person_info), ?) ";
      int result = 0;
      
      try {
         psmt = conn.prepareStatement(sql);
         //Connection 활용해서 sql 명령을 실행하는 객체

         psmt.setString(1, name);
         
         result = psmt.executeUpdate(); //1 , 0
         
        // rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!

         /*
          SELECT 쿼리 : psmt.executeQuery(); ->결과로 ResultSet
          INSERT,UPDATE,DELETE 쿼리 : psmt.executeUpdate(); 
          							-> 결과로 적용된 행의 숫자 
          */
         
        
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
    	 DBConnectionManager.closeDB(conn, psmt, rs);
      }

	return result;
}

	public int savePersonInfo(PersonInfoDTO personInfo) {
		
		conn = DBConnectionManager.connectDB();
		
	      String sql = " INSERT INTO t_person_info "
	    		  		+ " VALUES( ?, ?) ";
	      int result = 0;
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         //Connection 활용해서 sql 명령을 실행하는 객체
	
	         psmt.setInt(1, personInfo.getId());
	         psmt.setString(2, personInfo.getName());
	         
	         result = psmt.executeUpdate(); //1 , 0
	         
	        // rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!
	
	         /*
	          SELECT 쿼리 : psmt.executeQuery(); ->결과로 ResultSet
	          INSERT,UPDATE,DELETE 쿼리 : psmt.executeUpdate(); 
	          							-> 결과로 적용된 행의 숫자 
	          */
	         
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	    	 DBConnectionManager.closeDB(conn, psmt, rs);
	      }
	
		return result;
	}
	
	/*
	 select find
	 insert save
	 update modify
	 delete remove
	 */
	
	//수정
	public int modifyPersonInfo(PersonInfoDTO personInfo) {
		//해당 아이디에 맞는 사람의 이름을 수정
		
			conn = DBConnectionManager.connectDB();
			
		      String sql = " UPDATE  t_person_info "
		    		  		+ " SET name = ? "
		    		  		+ " WHERE id = ? ";
		      int result = 0;
		      
		      try {
		         psmt = conn.prepareStatement(sql);
		         //Connection 활용해서 sql 명령을 실행하는 객체
		         psmt.setString(1, personInfo.getName());
		         psmt.setInt(2, personInfo.getId());
		         
		         
		         result = psmt.executeUpdate(); //1 , 0
		         
		        // rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!
		
		         /*
		          SELECT 쿼리 : psmt.executeQuery(); ->결과로 ResultSet
		          INSERT,UPDATE,DELETE 쿼리 : psmt.executeUpdate(); 
		          							-> 결과로 적용된 행의 숫자 
		          */
		         
		        
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		    	 DBConnectionManager.closeDB(conn, psmt, rs);
		      }
		
			return result;
		}
	
	//삭제
	public int removePersonInfo(int id) {
		//해당 아이디에 맞는 사람의 이름을 삭제
		
			conn = DBConnectionManager.connectDB();
			
		      String sql = " DELETE FROM t_person_info "
		    		  		+ " WHERE id = ? ";
		      
		      System.out.println("%s %d %s");
		      int result = 0;
		      
		      try {
		         psmt = conn.prepareStatement(sql);
		         //Connection 활용해서 sql 명령을 실행하는 객체
		         psmt.setInt(1,id);
		         
		         
		         
		         result = psmt.executeUpdate(); //1 , 0
		         
		        // rs = psmt.executeQuery(); //준비된 sql 쿼리문 실행!
		
		         /*
		          SELECT 쿼리 : psmt.executeQuery(); ->결과로 ResultSet
		          INSERT,UPDATE,DELETE 쿼리 : psmt.executeUpdate(); 
		          							-> 결과로 적용된 행의 숫자 
		          */
		         
		        
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		    	 DBConnectionManager.closeDB(conn, psmt, rs);
		      }
		
			return result;
		}
}

		/*
		 *  PersonInfoDAO 를 생성하고, 데이터를 조회해서 가져오는 메소드를 작성하세요.
		
		1) t_person_info 에 있는 전체 정보를 조회해오는 메소드 생성 (return 필수)
		
		2) id 값을 기준으로 한 개의 사람 정보를 가져오는 메소드 생성 (return 필수)
		
		3) 메인에서 해당 메소드를 활용하여 데이터를 읽어오고, 콘솔 창에 출력하세요.
		
		*/
