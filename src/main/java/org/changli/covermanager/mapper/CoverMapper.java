package org.changli.covermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.changli.covermanager.entity.Cover;

public interface CoverMapper {

	@Select("select * from cover")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude"),
		@Result(property = "height", column = "height"),
		@Result(property = "temperature", column = "temperature"),
		@Result(property = "humidity", column = "humidity"),
		@Result(property = "daily_traffic", column = "daily_traffic")
	})
	/**
	 * 获取所有的井盖cover
	 * @return Cover列表
	 */
	List<Cover> selectAll();
	
	@Select("SELECT * FROM cover WHERE coverID = #{coverID}")
	@Results({
		@Result(property = "coverID",  column = "coverID"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude"),
		@Result(property = "height", column = "height"),
		@Result(property = "temperature", column = "temperature"),
		@Result(property = "humidity", column = "humidity"),
		@Result(property = "daily_traffic", column = "daily_traffic")
	})
	/**
	 * 根据ID来查找对应的井盖
	 * @param coverID 输入的ID编号
	 * @return 对应的井盖Cover对象
	 */
	Cover selectCover(String coverID);

	@Insert("INSERT INTO cover(coverID, longitude, latitude, height, temperature, humidity, daily_traffic) "
			+ "VALUES(#{coverID},  #{longitude},  #{latitude},  #{height},  #{temperature},  #{humidity},  #{daily_traffic})")
	/**
	 * 插入一条井盖信息
	 * @param cover 井盖对象
	 */
	void insert(Cover cover);

	@Update("UPDATE cover SET longitude=#{longitude}, latitude=#{latitude}, "
			+ "height=#{height}, temperature=#{temperature}, humidity=#{humidity}, daily_traffic=#{daily_traffic}"
			+ " WHERE coverID =#{coverID}")
	/**
	 * 更改井盖信息
	 * @param cover 井盖对象
	 */
	void update(Cover cover);

	@Delete("DELETE FROM cover WHERE coverID =#{coverID}")
	/**
	 * 根据对应的井盖ID来进行删除
	 * @param id
	 */
	void delete(String id);
}
