package board;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardMainServer {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(8888);
			
			BoardService boardService = BoardServiceImpl.getInstance();
			
			reg.rebind("boardService", boardService);
			
		}catch(RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println("서버 준비 완료!!!");
	}

}
