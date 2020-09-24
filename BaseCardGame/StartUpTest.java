import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class StartUpTest {
private StartUp check = new StartUp();
	@Test
	public void testCheck() {
	
	boolean abc = check.check("CasinoInfo.txt");
	assertEquals("check if casino file exists", true, abc);
	}

	@Test
	public void testCreateFile() throws IOException {
	check.createFile();
	File abc = new File("CasinoInfo.txt");
	assertEquals("checking if the file has been made",true ,abc.isFile());
	}
	@Test
	public void testOpenFile() throws FileNotFoundException{
	check.openFile();
	String nameWant = "Sidhant";
	int balanceWant = 2223;
	assertEquals("Testing name", nameWant, StartUp.getName());
	assertEquals("Testing balance", balanceWant, StartUp.getBalance());
	}
}
