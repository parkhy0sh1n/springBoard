package com.spring.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public String selectTest() throws Exception {
		String a = sqlSession.selectOne("board.boardList");
		return a;
	}

	/**
	 * 
	 * */
	@Override
	public List<BoardVo> selectBoardList(PageVo pageVo) throws Exception {
		return sqlSession.selectList("board.boardList", pageVo);
	}

	@Override
	public int selectBoardCnt() throws Exception {
		return sqlSession.selectOne("board.boardTotal");
	}

	@Override
	public BoardVo selectBoard(BoardVo boardVo) throws Exception {
		return sqlSession.selectOne("board.boardView", boardVo);
	}

	@Override
	public int boardInsert(BoardVo boardVo) throws Exception {
		return sqlSession.insert("board.boardInsert", boardVo);
	}

	@Override
	public int boardUpdate(BoardVo boardVo) throws Exception {
		return sqlSession.update("board.boardUpdate", boardVo);
	}

	@Override
	public int boardRemove(int boardNum) throws Exception {
		return sqlSession.delete("board.boardRemove", boardNum);
	}

}
