package br.com.idecaph.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArquivosUtil {
	public static XSSFWorkbook getExcel(HttpServletRequest request) {
		ServletFileUpload upload = new ServletFileUpload();
		FileItemIterator iterator;
		XSSFWorkbook workbook = null;
		try {
			iterator = upload.getItemIterator(request);
			while (iterator.hasNext()) {
				FileItemStream item = iterator.next();
				InputStream uploadedFileStream = item.openStream();
				workbook = new XSSFWorkbook(uploadedFileStream);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return workbook;
	}
}
