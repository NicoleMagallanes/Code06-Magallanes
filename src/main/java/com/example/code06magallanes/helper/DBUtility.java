package com.example.code06magallanes.helper;

public interface DBUtility {
	String INSERT_RECORD = "INSERT INTO seg31(name,student_id,midterm,prefinal,final,remarks,isDeleted)"
			+ "VALUES (?,?,?,?,?,?,?)";
	
	String SELECT_ALL = "SELECT * FROM seg31 WHERE isDeleted = 0";
	
	String DELETE_RECORD = "UPDATE seg31 SET isDeleted = 1 WHERE id = ?";

	String SELECT_DATA = "SELECT * FROM seg31 WHERE id =? and isDeleted = 0";
}
