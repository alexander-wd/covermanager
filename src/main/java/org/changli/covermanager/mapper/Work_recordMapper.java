package org.changli.covermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.changli.covermanager.entity.Work_record;

public interface Work_recordMapper {

	@Select("select * from work_record")
	@Results({
		@Result(property = "maintenanceID",  column = "maintenanceID"),
		@Result(property = "personID", column = "personID"),
		@Result(property = "coverID", column = "coverID"),
		@Result(property = "start_time", column = "start_time"),
		@Result(property = "end_time", column = "end_time"),
		@Result(property = "log", column = "log")
		})
	List<Work_record> selectAll();
	
	@Select("SELECT * FROM work_record WHERE personID = #{personID}")
	@Results({
		@Result(property = "maintenanceID",  column = "maintenanceID"),
		@Result(property = "personID", column = "personID"),
		@Result(property = "coverID", column = "coverID"),
		@Result(property = "start_time", column = "start_time"),
		@Result(property = "end_time", column = "end_time"),
		@Result(property = "log", column = "log")
	})
	Work_record selectWork_record(String maintenanceID);

	@Insert("INSERT INTO work_record(maintenanceID, personID, coverID, start_time, end_time, log)  "
			+ "VALUES(#{maintenanceID},  #{personID},  #{coverID},  #{start_time},  #{end_time},  #{log} )")
	void insert(Work_record work_record);

	@Update("UPDATE work_record SET personID=#{personID}, coverID=#{coverID}, start_time=#{start_time}"
			+ ", end_time=#{end_time}, log=#{log} "
			+ " WHERE maintenanceID =#{maintenanceID}")
	void update(Work_record work_record);

	@Delete("DELETE FROM work_record WHERE maintenanceID =#{maintenanceID} ")
	void delete(String id);
	
}
