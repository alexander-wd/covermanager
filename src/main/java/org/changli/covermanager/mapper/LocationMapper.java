package org.changli.covermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.changli.covermanager.entity.Location;

public interface LocationMapper {

	@Select("select * from location")
	@Results({
		@Result(property = "personID",  column = "personID"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude")
		})
	List<Location> selectAll();
	
	@Select("SELECT * FROM location WHERE personID = #{personID}")
	@Results({
		@Result(property = "personID",  column = "personID"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude")
	})
	Location selectLocation(String personID);

	@Insert("INSERT INTO location(personID, longitude, latitude) "
			+ "VALUES(#{personID},  #{longitude},  #{latitude})")
	void insert(Location user);

	@Update("UPDATE location SET longitude=#{longitude}, latitude=#{latitude}"
			+ " WHERE personID =#{personID}")
	void update(Location user);

	@Delete("DELETE FROM location WHERE personID =#{personID}")
	void delete(String personID);
	
}
