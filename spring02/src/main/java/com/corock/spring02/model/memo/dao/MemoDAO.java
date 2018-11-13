package com.corock.spring02.model.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.corock.spring02.model.memo.dto.MemoDTO;

public interface MemoDAO {
	
	@Select("SELECT * FROM Memo ORDER BY idx DESC")
	public List<MemoDTO> list();
	
	// mybatis query에 전달할 변수는 @Param으로 처리
	@Insert("INSERT INTO Memo (idx, writer, memo)" +
				"VALUES ( (SELECT NVL(MAX(idx) + 1, 1) FROM Memo), #{writer}, #{memo} )")	
	public void insert(@Param("writer") String writer, @Param("memo") String memo);
	
	@Select("SELECT * FROM Memo WHERE idx = #{idx}")
	public MemoDTO memo_view(@Param("idx") int idx);
	
}
