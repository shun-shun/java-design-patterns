package facade.pagemaker;

import java.io.FileWriter;
import java.util.Properties;

public class PageMaker {
	private PageMaker() {

	}
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HTMLWriter writer = new HTMLWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "`s page!");
			writer.paragraph(username + "のページへようこそ");
			writer.paragraph("メールを待っていますね。");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + "is created for " + mailaddr + " (" + username + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
