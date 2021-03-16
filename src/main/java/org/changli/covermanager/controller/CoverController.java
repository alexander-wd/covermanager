package org.changli.covermanager.controller;

import java.util.List;

import org.changli.covermanager.entity.Cover;
import org.changli.covermanager.mapper.CoverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoverController {

	@Autowired
	private CoverMapper coverMapper;
	
	@RequestMapping("/getCovers")
	/**
	 * 获取所有的井盖cover
	 * @return Cover列表
	 */
	public List<Cover> getCovers() {
		List<Cover> users=coverMapper.selectAll();
		return users;
	}
	
    @RequestMapping("/getCover")
	/**
	 * 根据ID来查找对应的井盖
	 * @param coverID 输入的ID编号
	 * @return 对应的井盖Cover对象
	 */
    public Cover getCover(@RequestParam(value = "coverID")String coverID) {
    	Cover cover=coverMapper.selectCover(coverID);
        return cover;
    }
    
    @RequestMapping("/insertCover")
	/**
	 * 插入一条井盖信息
	 * @param cover 井盖对象
	 * java.sql.SQLIntegrityConstraintViolationException
	 */
    public String insertCover(Cover cover) {
    	if(cover.isValid()) {		//检验数据是否合格
    		try {
    			coverMapper.insert(cover);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您添加的井盖编号已经存在，请更改井盖编号后重新尝试";
    		}
    		return "添加成功";
    	}else {
    		return "您添加的井盖信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="updateCover")
	/**
	 * 更改井盖信息
	 * @param cover 井盖对象
	 */
    public String updateCover(Cover cover) {
    	if(cover.isValid()) {		//检验数据是否合格
    		try {
    			coverMapper.update(cover);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您更改的井盖编号已经存在，请更改井盖编号后重新尝试";
    		}
    		return "更改成功";
    	}else {
    		return "您更改的井盖信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="/delete/Cover/{id}")
	/**
	 * 根据对应的井盖ID来进行删除
	 * @param id
	 */
    public Cover deleteCover(@PathVariable("id") String id) {
    	Cover cover=coverMapper.selectCover(id);		//根据id进行查找
    	if(cover==null){		//如果数据库中不存在
    		return null;
    	}else {
    		coverMapper.delete(id);		//删除该数据
    		return cover;		//返回被删除的数据信息
    	}
    }
}
