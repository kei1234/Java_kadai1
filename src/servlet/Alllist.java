package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KeepaccountDao;
import dto.Keepaccount;
import dto.ReturnI;

/**
 * Servlet implementation class Alllist
 */
@WebServlet("/Alllist")
public class Alllist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alllist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Keepaccount> keepaccount = KeepaccountDao.getAll();
		int i = 0;
		for(Keepaccount result : keepaccount){

			String income = result.getIncome();
			String spending = result.getSpending();

			Keepaccount data = new Keepaccount(income,spending);
			String rs = "rs" + i;
			request.setAttribute(rs,data);
			i++;
		}
		ReturnI ri = new ReturnI(i);
		request.setAttribute("inum",ri);


		request.setCharacterEncoding("UTF-8");
		String view = "/WEB-INF/view/All.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	}