package api.util;

import java.util.ArrayList;

public class BoardExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Board> boardList=new ArrayList<>();
		Board board1 = new Board(1,"jang","자바","자바어");
		
		boardList.add(board1);
		display(boardList);
	}
	
	public static void display(ArrayList<Board> boardList) {
		for (int i=0; i<boardList.size();i++) {
			Board board= boardList.get(i);
			System.out.println(board.getBoardNo()
					+"\t"+board.getWriter()
					+"\t"+board.getTitle()
					+"\t"+board.getContents()
					);
		}
	}

}
