package org.changli.covermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.changli.covermanager.entity.Personnel;

public interface PersonnelMapper {

	@Select("select * from personnel")
	@Results({
		@Result(property = "personID",  column = "personID"),
		@Result(property = "name", column = "name"),
		@Result(property = "work_status", column = "work_status"),
		@Result(property = "operation_number", column = "operation_number"),
		@Result(property = "img", column = "img"),
		@Result(property = "workID", column = "workID"),
		@Result(property = "phone", column = "phone")
		})
	List<Personnel> selectAll();
	
	@Select("SELECT * FROM personnel WHERE personID = #{personID}")
	@Results({
		@Result(property = "personID",  column = "personID"),
		@Result(property = "name", column = "name"),
		@Result(property = "work_status", column = "work_status"),
		@Result(property = "operation_number", column = "operation_number"),
		@Result(property = "img", column = "img"),
		@Result(property = "workID", column = "workID"),
		@Result(property = "phone", column = "phone")
	})
	Personnel selectPersonnel(String coverID);

	@Insert("INSERT INTO personnel(personID, name, work_status, operation_number, img, workID, phone)  "
			+ "VALUES(#{personID},  #{name},  #{work_status},  #{operation_number},  #{img},  #{workID},  #{phone} )")
	void insert(Personnel user);

	@Update("UPDATE personnel SET name=#{name}, work_status=#{work_status}, operation_number=#{operation_number}"
			+ ", img=#{img}, workID=#{workID}, phone=#{phone} "
			+ " WHERE personID =#{personID}")
	void update(Personnel user);

	@Delete("DELETE FROM personnel WHERE personID =#{personID} ")
	void delete(String personID);
	
}
