package edu.abhi.test.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 * 
 * @author abhishek sarkar
 */
@Controller
public class FileValidationController {

	private static final Logger logger = LoggerFactory.getLogger(FileValidationController.class);

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file,
			HttpServletResponse response) {
		String name = file.getOriginalFilename();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.base");
				File dir = new File(rootPath + File.separator + "tmp");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File inputFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(inputFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + inputFile.getAbsolutePath());

				Runtime rt = Runtime.getRuntime();

				String command = "cmd.exe /c \"cd \"" + dir.getAbsolutePath() + "\" && "
						+ "\"%JAVA8HOME%/bin/java\" -jar "
						+ "E:/AUSTPC/SwiftValidator2019/Swift/SWIFTValidator-1.0-SNAPSHOT-jar-with-dependencies.jar "
						+ inputFile.getAbsolutePath() + "\"";

				String outRes = "";

				try {

					Process exec = rt.exec(command);
					outRes = "ErrorStream:----------------\n";
					Scanner sc = new Scanner(exec.getErrorStream());
					while (sc.hasNext()) {
						outRes += sc.next() + "\n";
					}
					sc.close();

					outRes += "InputStream:----------------\n";
					sc = new Scanner(exec.getInputStream());
					while (sc.hasNextLine()) {
						outRes += sc.nextLine() + "\n";
					}
					sc.close();

					System.out.println(outRes);
					logger.info("After task within");
				} catch (Exception e) {
					e.printStackTrace();
				}

				String fileName = outRes.substring(outRes.indexOf("Name:") + 5, outRes.indexOf(".xlsx") + 5).trim()
						.replace("\n", "");

				System.out.println("File downloading = " + fileName);

//				response.setContentType("text/plain");
				response.setContentType("text/vnd.ms-excel");
				PrintWriter out = response.getWriter();
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

				File reportfile = new File(dir.getAbsolutePath() + File.separator + fileName);
				FileInputStream fileInputStream = new FileInputStream(reportfile);

				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				out.close();

				inputFile.delete();
				reportfile.delete();

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				e.printStackTrace(System.out);
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

//	/**
//	 * Upload multiple file using Spring Controller
//	 */
//	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
//	public @ResponseBody
//	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
//			@RequestParam("file") MultipartFile[] files) {
//
//		if (files.length != names.length)
//			return "Mandatory information missing";
//
//		String message = "";
//		for (int i = 0; i < files.length; i++) {
//			MultipartFile file = files[i];
//			String name = names[i];
//			try {
//				byte[] bytes = file.getBytes();
//
//				// Creating the directory to store file
//				String rootPath = System.getProperty("catalina.home");
//				File dir = new File(rootPath + File.separator + "tmp");
//				System.out.println("Path to save : " + dir.getAbsolutePath());
//				if (!dir.exists())
//					dir.mkdirs();
//
//				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//
//				logger.info("Server File Location=" + serverFile.getAbsolutePath());
//
//				message = message + "You successfully uploaded file=" + name + "<br />";
//			} catch (Exception e) {
//				return "You failed to upload " + name + " => " + e.getMessage();
//			}
//		}
//		return message;
//	}
}
