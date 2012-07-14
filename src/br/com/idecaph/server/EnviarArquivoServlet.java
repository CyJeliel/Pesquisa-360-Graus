package br.com.idecaph.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class EnviarArquivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		// TODO Ler os dados

		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (isMultipartContent) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> fields = upload.parseRequest(request);
				Iterator<FileItem> it = fields.iterator();
				if (!it.hasNext()) {
					return;
				}
				InputStream uploadedFileStream = null;
				String uploadedFileName = null;
				while (it.hasNext()) {
					FileItem fileItem = it.next();
					boolean isFormField = fileItem.isFormField();
					if (isFormField) {

					} else {
						uploadedFileName = fileItem.getName();
						uploadedFileStream = fileItem.getInputStream();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		  Workbook workbook = Workbook.getWorkbook(uploadedFileStream);

		try {
			response.sendRedirect("/teste.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
