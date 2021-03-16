package org.changli.covermanager.controller;

import java.util.List;

import org.changli.covermanager.entity.Personnel;
import org.changli.covermanager.mapper.PersonnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonnelController {

	@Autowired
	private PersonnelMapper personnelMapper;
	
	@RequestMapping("/getPersonnels")
	/**
	 * 获取所有的人员信息Personnel
	 * @return Personnels 人员位置列表
	 */
	public List<Personnel> getPersonnels() {
		List<Personnel> personnels=personnelMapper.selectAll();
		return personnels;
	}
	
    @RequestMapping("/getPersonnel")
	/**
	 * 根据人员编号personID来查找对应的人员
	 * @param personID 输入的人员编号
	 * @return 对应的人员Personnel
	 */
    public Personnel getPersonnel(@RequestParam(value = "personID")String personID) {
    	Personnel Personnel=personnelMapper.selectPersonnel(personID);
        return Personnel;
    }
    
    @RequestMapping("/insertPersonnel")
	/**
	 * 插入一条人员信息Personnel
	 * @param Personnel 人员信息
	 */
    public String insertPersonnel(Personnel personnel) {
    	if(personnel.isValid()) {		//检验数据是否合格
    		try {
    			personnelMapper.insert(personnel);
    		}catch(Exception e) {		//捕获异常，由于外键引用以及唯一键约束
    			return "您添加的人员编号错误，请更改人员编号后重新尝试";
    		}
    		return "添加成功";
    	}else {
    		return "您添加的人员信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="updatePersonnel")
    /**
     * 更新一条人员信息Personnel
     * @param Personnel 人员信息
     */
    public String updatePersonnel(Personnel personnel) {
    	if(personnel.isValid()) {		//检验数据是否合格
    		try {
    			personnelMapper.update(personnel);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您更改的人员编号不存在，请更改人员编号后重新尝试";
    		}
    		return "更改成功";
    	}else {
    		return "您更改的人员信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="/delete/Personnel")
    /**
     * 根据personID来删除一条人员信息Personnel
     * @param personID 对应的人员编号
     */
    public Personnel deletePersonnel(@RequestParam(value = "personID")String personID) {
    	Personnel location = personnelMapper.selectPersonnel(personID);		//根据id进行查找
    	if(location==null){		//如果数据库中不存在
    		return null;
    	}else {
    		personnelMapper.delete(personID);	//删除该数据
    		return location;		//返回被删除的数据信息
    	}
    }
	
}
