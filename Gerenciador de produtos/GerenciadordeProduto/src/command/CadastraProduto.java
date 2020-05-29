package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class CadastraProduto implements Command {

	private final ProdutoService produtoService = new ProdutoService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));		
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
		
		produtoService.cadastrarProduto(produto);
		 
		request.setAttribute("mensagem", "Produto Cadastrado com Sucesso!!");
		
		RequestDispatcher view = request.getRequestDispatcher("Cadastra.jsp");
		view.forward(request, response);
	}

}
