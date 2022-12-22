
import org.xml.sax.helpers.DefaultHandler;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.login.LoginException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.zip.*;
import java.io.*;



public class Main {


    public static void main(String[] args) throws Exception, LoginException, NoSuchAlgorithmException, FileNotFoundException
    {

        //Polynomial polynomial=new Polynomial();
        FileReader fileReader=new FileReader("input.txt");
        FileWriter fileWriter=new FileWriter("output.txt");
        //Scanner scannerFromFile=new Scanner(fileReader);


        Scanner scannerFromConsole=new Scanner(System.in);
        System.out.println("Выберите тип архива: rar, jar, zip");
        String line=scannerFromConsole.nextLine();
        Polynomial.Archiving(line);
        System.out.print("Введите строку для шифрования= ");
        String word=scannerFromConsole.nextLine();
        Polynomial.Encryption(word);
        System.out.print("Степень многочлена n= ");
        int n=scannerFromConsole.nextInt();
        System.out.print("Степень многочлена m= ");
        int m=scannerFromConsole.nextInt();
        List<Integer> integerList= Polynomial.GetHashFromFile("input.txt", n,m);
        System.out.println("Вывод с помощью Iterator:");
        Polynomial.OutListWithIterator(integerList);
        System.out.println();
        System.out.println("Вывод с помощью Лямбда:");
        Polynomial.OutWithLambda(integerList);
        System.out.println();

        List<Integer> firstList=new ArrayList<>();


        Hashtable<Integer,Integer> first=new Hashtable<Integer,Integer>();
        Polynomial.getHashTable(first,n,m,integerList,firstList);
        Polynomial.OutInXML();
        Polynomial.WriteHashtableJSon(first,2);



        fileWriter.close();
        fileReader.close();
    }
}