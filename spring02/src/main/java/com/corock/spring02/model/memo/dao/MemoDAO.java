package com.corock.spring02.model.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.corock.spring02.model.memo.dto.MemoDTO;

public interface MemoDAO {
	
	@Select("SELECT * FROM Memo ORDER BY idx DESC")
	public List<MemoDTO> list();
	
}
