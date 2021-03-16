package org.changli.covermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.changli.covermanager.entity.MapResult;

public interface FunctionMapper  {

	@Select("SELECT c.coverID,\r\n" + 
			"a.alarm_information,\r\n" + 
			"a.current,\r\n" + 
			"c.daily_traffic,\r\n" + 
			"c.height,\r\n" + 
			"c.humidity,\r\n" + 
			"c.latitude,\r\n" + 
			"c.longitude,\r\n" + 
			"c.temperature\r\n" + 
			"FROM cover AS c LEFT JOIN alarm AS a ON c.coverID=a.coverID\r\n" + 
			"")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude"),
		@Result(property = "height", column = "height"),
		@Result(property = "temperature", column = "temperature"),
		@Result(property = "humidity", column = "humidity"),
		@Result(property = "daily_traffic", column = "daily_traffic"),
		@Result(property = "alarm_information", column = "alarm_information"),
		@Result(property = "current", column = "current")
	})
	/**
	 * 获取所有的井盖cover
	 * @return Cover列表
	 */
	List<MapResult> selectAll();
	
	@Select("SELECT c.coverID,\r\n" + 
			"a.alarm_information,\r\n" + 
			"a.current,\r\n" + 
			"c.daily_traffic,\r\n" + 
			"c.height,\r\n" + 
			"c.humidity,\r\n" + 
			"c.latitude,\r\n" + 
			"c.longitude,\r\n" + 
			"c.temperature\r\n" + 
			"FROM cover AS c LEFT JOIN alarm AS a ON c.coverID=a.coverID WHERE c.coverID=#{coverID}" + 
			"")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude"),
		@Result(property = "height", column = "height"),
		@Result(property = "temperature", column = "temperature"),
		@Result(property = "humidity", column = "humidity"),
		@Result(property = "daily_traffic", column = "daily_traffic"),
		@Result(property = "alarm_information", column = "alarm_information"),
		@Result(property = "current", column = "current")
	})
	/**
	 * 获取所有的井盖cover
	 * @return Cover列表
	 */
	MapResult selectOne(String coverID);
	
}
