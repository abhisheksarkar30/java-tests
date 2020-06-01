package edu.abhi.test.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
 * Handles requests for the application file upload requests or just message upload for validation check.
 * 
 * @author abhishek sarkar
 */
@Controller
public class MessageValidationController {

	private static final Logger logger = LoggerFactory.getLogger(MessageValidationController.class);

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

				process(dir, inputFile, response);

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				e.printStackTrace(System.out);
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	private void process(File dir, File inputFile, HttpServletResponse response) throws IOException {
		logger.info("Server File Location=" + inputFile.getAbsolutePath());

		Runtime rt = Runtime.getRuntime();

		String command = "powershell -Command \"(gc \"" + inputFile.getAbsolutePath()
				+ "\") -replace 'F01NRIFTIAUAU010000000000', 'F01NKSCHKH0AXXX1670335254' -replace 'F01BTFGAU2SAXXX0000000001', 'F01NKSCHKH0AXXX1670335254' "
				+ "| Out-File -encoding ASCII \"" + inputFile.getAbsolutePath() + "\"\"";

		executeCommand(rt, command);

		command = "cmd.exe /c \"cd \"" + dir.getAbsolutePath() + "\" && " + "\"%JAVA8HOME%/bin/java\" -jar "
				+ "E:/AUSTPC/SwiftValidator2019/Swift/SWIFTValidator-1.0-SNAPSHOT-jar-with-dependencies.jar "
				+ inputFile.getAbsolutePath() + "\"";

		String outRes = executeCommand(rt, command);

		String fileName = outRes.substring(outRes.indexOf("Name:") + 5, outRes.indexOf(".xlsx") + 5).trim()
				.replace("\n", "");

		System.out.println("File downloading = " + fileName);

//		response.setContentType("text/plain");
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
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("message") String message,
			HttpServletResponse response) {
		String name = "sample.txt";
		if (!message.isEmpty()) {
			try {

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.base");
				File dir = new File(rootPath + File.separator + "tmp");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File inputFile = new File(dir.getAbsolutePath() + File.separator + name);
				FileWriter writer = new FileWriter(inputFile);
				writer.append(message);
				writer.flush();
				writer.close();

				process(dir, inputFile, response);

				return "You successfully uploaded message";
			} catch (Exception e) {
				e.printStackTrace(System.out);
				return "You failed to upload messsage => " + e.getMessage();
			}
		} else {
			return "Message was empty";
		}
	}

	private String executeCommand(Runtime rt, String command) {
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
		return outRes;
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
