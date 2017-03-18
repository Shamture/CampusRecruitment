package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.conn;

/**
 * Servlet implementation class UploadFile
 */
public class Uploadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File tmpDir;
	// private static final String DESTINATION_DIR_PATH
	// ="D:/IFAN/WebContent/Advertisements";
	private File destinationDir;
	String fileurl = "";
	float filesize = 0;
	String filetype = "";
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		destinationDir = new File("D:/workspace/CampusRecruitment/WebContent/files");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploadfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("::::::::::::::::::::::::::::::::::::entered into dopost:::::::::::::::::::::::::");
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		String filedescription = null;
		StringBuilder builder = new StringBuilder();

		PrintWriter out = response.getWriter();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		/*
		 * Set the size threshold, above which content will be stored on disk.
		 */
		fileItemFactory.setSizeThreshold(1 * 1024 * 1024); // 1 MB
		/*
		 * Set the temporary directory to store the uploaded files of size above
		 * threshold.
		 */
		fileItemFactory.setRepository(tmpDir);

		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		try {
			/*
			 * Parse the request
			 */
			List items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();
			String filename = "";
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				/*
				 * Handle Form Fields.
				 */
				if (item.isFormField()) {
					System.out.println("File Name = " + item.getFieldName()
							+ ", Value = " + item.getString());
													
				} else {
					// Handle Uploaded files.
					filename = item.getName();
					System.out.println("Field Name = " + item.getFieldName()
							+ ", File Name = " + item.getName()
							+ ", Content type = " + item.getContentType()
							+ ", File Size = " + item.getSize());
					fileurl = item.getName();
					// size in MB
					filesize = item.getSize();
					filesize = filesize / (1024 * 1024);
					filetype = item.getContentType();

					System.out.println("fileurl is:::" + fileurl);
					System.out.println("filesize is:::" + filesize);

					/*
					 * Write file to the ultimate location.
					 */
					File file = new File(destinationDir, fileurl);
					item.write(file);
					

				}

			}

			response.setContentType("text/html");
			
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("uname");
			st=con.createStatement();
			String qry="insert into resume_file values(resseq.nextval,'"+fileurl+"',Sysdate,'"+uname+"')";
             int n=st.executeUpdate(qry);
             if(n>0)
             {
            	 System.out.println("inserted");
            	 out.print("uploaded sucessfully");
             }
		} catch (FileUploadException ex) {
			log("Error encountered while parsing the request", ex);
		} catch (Exception ex) {
			log("Error encountered while uploading file", ex);
		}
		
	
	
	}

}
