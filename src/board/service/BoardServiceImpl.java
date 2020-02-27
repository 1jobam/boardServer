package board.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.vo.BoardVO;

public class BoardServiceImpl extends UnicastRemoteObject implements BoardService {

	private BoardDao bodao;
	
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() throws RemoteException {
		bodao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() throws RemoteException {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public Object insertBoard(BoardVO bv) {
		return bodao.insertBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return bodao.updateBoard(bv);
	}

	@Override
	public int deleteBoard(BoardVO bv) {
		return bodao.deleteBoard(bv);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return bodao.getAllBoard();
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		return bodao.getSearchBoard(bv);
	}

}
