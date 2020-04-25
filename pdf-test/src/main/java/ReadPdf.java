import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ReadPdf {

	public static void main(String[] args) {

		for(int i = 0; i < 199; i++) {
			
			String passwd = "301194" + String.format("%2s", i).replace(" ", "0") + "3407";
			
			try (PDDocument document = PDDocument.load(new File("20200123.pdf"), passwd)) {
				
				System.out.println("Unknown password : " + passwd);
				
				document.getClass();

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);

				PDFTextStripper tStripper = new PDFTextStripper();

				String pdfFileInText = tStripper.getText(document);
				//System.out.println("Text:" + st);

				// split by whitespace
				String lines[] = pdfFileInText.split("\\r?\\n");
				for (String line : lines) {
					System.out.println(line);
				}

				break;

			} catch (InvalidPasswordException e) {
				//NO-OP
			} catch (IOException e) {
				System.out.println(e);
				break;
			}
		}

	}
}