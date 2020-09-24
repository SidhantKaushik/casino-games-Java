import java.io.*;
public class StartUp {
private static int balance;
private static String name;
private File inFile = new File("CasinoInfo.txt");
private ConsoleComunicationController comm;
private PrintWriter out;
public static void main (String [] args) throws IOException
{
	StartUp main = new StartUp();
	main.processing();
}
public void processing() throws IOException {
	if (check("CasinoInfo.txt")==false)
	{
		createFile();
		addNewPerson();
	}
	else {
		openFile();
	}
	new Menu();
}
public boolean check(String x)
{
	String fileName = x;
	File check = new File(fileName);
	if (check.isFile())
	{
		return true;
		
	}
	else {
		return false;
	}
}

public void createFile() throws IOException
{
	File newf = new File("CasinoInfo.txt");
	newf.createNewFile();
}

public void addNewPerson() throws FileNotFoundException
{
	name = comm.getInput_String("Please enter your name");
	balance = 1000;
	save(balance);
}

public void save(int balance) throws FileNotFoundException {
	out = new PrintWriter(inFile);
	out.print(name);
	out.println("");
	out.print(balance);
	out.println("");
	out.close();
}

public void openFile() throws FileNotFoundException
{
	comm = new ConsoleComunicationController(inFile);
	name =comm.getInput_String();
	balance =comm.getInput_Int();
}
public static int getBalance() {
	return balance;
}
public static String getName() {
	return name;
}

}
