package br.com.idecaph.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.idecaph.model.ColaboradorTemp;
import br.com.idecaph.utils.ArquivosUtil;

public class EnviarArquivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		XSSFWorkbook workbook = ArquivosUtil.getExcel(request);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row;
		List<ColaboradorTemp> colaboradores = new ArrayList<ColaboradorTemp>();
		int i = 1;
		do {
			try {
				row = sheet.getRow(i);
			} catch (NullPointerException e) {
				break;
			}
			String cargo = null;
			String nome = null;
			String email = null;
			try {
				cargo = row.getCell(2).getStringCellValue();
				nome = row.getCell(3).getStringCellValue();
				email = row.getCell(4).getStringCellValue();
			} catch (NullPointerException e) {
				continue;
			} 
			
			String area = null;
			try { 
				area = row.getCell(0).getStringCellValue();
			} catch (Exception e) {
			}
			
			String departamento = null;
			try {
				departamento = row.getCell(1).getStringCellValue();
			} catch (Exception e) {
			}
			
			String escolaridade = null;
			try {
				escolaridade = row.getCell(5).getStringCellValue();
			} catch (Exception e) {
			}
			
			String sexo = null;
			try {
				sexo = row.getCell(6).getStringCellValue();
			} catch (Exception e) {
			}

			String telefone = null;
			try {
				telefone = row.getCell(7).getStringCellValue();
			} catch (Exception e) {
			}
			
			String celular = null;
			try{
				celular = row.getCell(8).getStringCellValue();
			} catch (Exception e) {
			}
			
			String cpf = null;
			try {
				cpf = row.getCell(9).getStringCellValue();
			} catch (Exception e) {
			}

			Double dataAdmissao = null;
			try {
				dataAdmissao = row.getCell(10).getNumericCellValue();
			} catch (Exception e) {
			}

			Double dataDemissao = null;
			try {
				dataDemissao = row.getCell(11).getNumericCellValue();
			} catch (Exception e) {
			}
			ColaboradorTemp colaborador =  new ColaboradorTemp("empresaTeste", cargo, nome, email, area, departamento, escolaridade, sexo, telefone, celular, cpf, dataAdmissao, dataDemissao);
			colaboradores.add(colaborador);
			++i;
		} while (row != null);
		ColaboradorTemp.saveAll(colaboradores);
		try {
			response.sendRedirect("/teste.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
