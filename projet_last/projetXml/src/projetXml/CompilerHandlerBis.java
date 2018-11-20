package projetXml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import mapper.AuthorHandler;

public class CompilerHandlerBis extends DefaultHandler {
	String newFileName;
	private static final int NBIMPORTANT = 57;

	AuthorHandler gestionTemporaire = new AuthorHandler();
	List<String> listAuthors = new ArrayList<>();
	final StringBuilder builder = new StringBuilder();
	boolean isGoodPaper = false;
	boolean isAuthor = false;
    int inc = 0;
	String currentAuthor = "";

	File yourFile = new File("nameToFind.txt");
	FileOutputStream outputStream ;
	
	public CompilerHandlerBis(final String nfn) throws IOException {
		newFileName = nfn;
		try {
			yourFile.createNewFile();
			outputStream = new FileOutputStream(yourFile, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if ("article".equals(qName) || "inproceedings".equals(qName)) {
			isGoodPaper = true;
		}
		if (isGoodPaper && "author".equals(qName)) {
			isAuthor = true;
		}
	}

	private void premiereEcriture()
	{
		for(int i = 0 ; i < listAuthors.size(); i++)
		{
			try {
				outputStream.write(listAuthors.get(i).getBytes());
				outputStream.write(":".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			for(int j = 0 ; j < listAuthors.size();j++)
			{
				if(i != j)
					try {
						outputStream.write(listAuthors.get(j).getBytes());
						outputStream.write(",".getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			try {
				outputStream.write("\n".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		listAuthors.clear();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) {
		if (isGoodPaper && "author".equals(qName)) {
			listAuthors.add(currentAuthor);
			currentAuthor = "";
			isAuthor = false;
		}
		if ("article".equals(qName) || "inproceedings".equals(qName)) {
			isGoodPaper = false;
			if(listAuthors.size() > 0) 
			{
				premiereEcriture();
			}
		}
	}

	@Override
	public void characters(char ch[], int begin, int length) {
		if (isGoodPaper && isAuthor) {
			String author = new String(ch, begin, length);
			currentAuthor = currentAuthor.concat(author);
		}
	}

	@Override
	public void endDocument() {
		System.out.print("fini");
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
