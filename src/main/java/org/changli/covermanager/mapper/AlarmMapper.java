package org.changli.covermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.changli.covermanager.entity.Alarm;

public interface AlarmMapper {

	@Select("select * from alarm")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "alarm_information", column = "alarm_information"),
		@Result(property = "current", column = "current")
		})
	List<Alarm> selectAll();
	
	@Select("SELECT * FROM alarm WHERE coverID = #{coverID}")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "alarm_information", column = "alarm_information"),
		@Result(property = "current", column = "current")
	})
	List<Alarm> selectAlarm(String coverID);
	
	@Select("SELECT * FROM alarm WHERE coverID = #{coverID}  AND current=#{current}")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "alarm_information", column = "alarm_information"),
		@Result(property = "current", column = "current")
	})
	Alarm selectOneAlarm(String coverID, String current);

	@Insert("INSERT INTO alarm(coverID, alarm_information, current)  "
			+ "VALUES(#{coverID}, #{alarm_information}, #{current})")
	void insert(Alarm alarm);

	@Update("UPDATE alarm SET alarm_information=#{alarm_information} "
			+ " WHERE coverID =#{coverID} AND current=#{current}")
	void update(Alarm alarm);

	@Delete("DELETE FROM alarm WHERE coverID =#{coverID} AND current=#{current} ")
	void deleteOne(String coverID, String current);
	
	@Delete("DELETE FROM alarm WHERE coverID =#{coverID}")
	void delete(String coverID);
	
}
