

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.*;
import java.io.*;

import static java.lang.Integer.parseInt;

class Polynomial {

     public int index;
     public int value;

     public Polynomial() {
     }

     public Polynomial(int index,int value)
     {
         this.index=index;
         this.value=value;
     }



     public static Integer maximum(int a, int b)
     {
         return Math.max(a, b);

     }
     public static List<Integer> GetHashFromFile(String inputFileName, int n, int m) throws FileNotFoundException {
         var inputFile = new File(inputFileName);
         var scanner = new Scanner(inputFile);
        // List<Integer> integerList = new ArrayList<Integer>();

         List<Integer> list = new ArrayList<>();
         for(int i=0;i<2*(n+m);i++) {
             return list;

             var line = scanner.nextInt();
             list.add(line);
         }
            // while (scanner.hasNextInt()) {
                // int line = scanner.nextInt();
                // list.add(line);

             //}


     }

     public static void Encryption(String word) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
         //String word="Hello world";
         Cipher cipher=Cipher.getInstance("AES");

         SecretKeySpec keySpec=new SecretKeySpec("Bar12345Bar12345".getBytes(),"AES");
         cipher.init(Cipher.ENCRYPT_MODE,keySpec);
         byte[]bytes=cipher.doFinal(word.getBytes());
         for (byte b: bytes)
         {
             System.out.print(b);
         }
         System.out.println();


     }

     public static void Archiving(String line) throws IOException {
         if(line.equals("zip"))
         {
              ZipOutputStream zout=new ZipOutputStream(new FileOutputStream("D://file/archive.zip"));
             ZipEntry entry=new ZipEntry("input.txt");
             zout.putNextEntry(entry);
             FileInputStream fis=new FileInputStream("D://file/input.txt");
             byte[]buffer=new byte[fis.available()];
             fis.read(buffer);
             zout.write(buffer);
             zout.closeEntry();
             zout.close();
         }
         else
         if(line.equals("rar"))
         {
             ZipOutputStream zout=new ZipOutputStream(new FileOutputStream("D://file/archive.rar"));
             ZipEntry entry=new ZipEntry("input.txt");
             zout.putNextEntry(entry);
             FileInputStream fis=new FileInputStream("D://file/input.txt");
             byte[]buffer=new byte[fis.available()];
             fis.read(buffer);
             zout.write(buffer);
             zout.closeEntry();
             zout.close();
         }
         else
         if(line.equals("jar"))
         {
             JarOutputStream jout=new JarOutputStream(new FileOutputStream("D://file/archive.jar"));
             JarEntry entry=new JarEntry("input.txt");
             jout.putNextEntry(entry);
             FileInputStream fis=new FileInputStream("D://file/input.txt");
             byte[]buffer=new byte[fis.available()];
             fis.read(buffer);
             jout.write(buffer);
             jout.closeEntry();
             jout.close();
         }
         else  throw new RuntimeException(" ERROR " + line);

     }

     public static void OutListWithIterator(List<Integer> integerList)
     {
         Iterator<Integer> iter = integerList.iterator();
         while(iter.hasNext()){

             System.out.print(iter.next()+" ");
         }

     }
     public static void OutWithLambda(List<Integer> integerList)
     {
         integerList.forEach( (s) -> System.out.print(s + " ") );
     }

     public static int Difference(int n,int m)
     {
         return Math.abs(n-m);
     }

     public static void OutInXML() throws XMLStreamException, FileNotFoundException {
         XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newFactory();
         XMLStreamWriter writer=xmlOutputFactory.createXMLStreamWriter(new FileOutputStream("output.xml"));
         writer.writeStartDocument();
         writer.writeStartElement("root");
         writer.writeStartElement("font");
         writer.writeAttribute("index","202");
         writer.writeCharacters("TimesNewRoman");
         writer.writeEndElement();
         writer.writeEndElement();
         writer.writeEndDocument();
     }

     public static void getHashTable(Hashtable<Integer,Integer> first,int n,int m,List<Integer> integerList,List<Integer> firstList)
     {
         System.out.print("D(x)= c0 ");
         for(int i=1; i<=n; i++)
         {
             System.out.print(" + c"+i+"*x^"+i);
         }

         System.out.println();

         for(int i=0; i<=n; i++)
         {
             System.out.print("c"+i+"=");
             first.put(i, (Integer) integerList.get(i));
             firstList.add(integerList.get(i));
             System.out.println((Integer)integerList.get(i));
         }
         System.out.print("First polynomial D(x)= "+first.get(0));
         for(int i=1; i<=n; i++){
             System.out.print(" + "+first.get(i)+"x^"+i);
         }
         System.out.println();





         Hashtable<Integer,Integer> second=new Hashtable<Integer,Integer>();
         System.out.print("E(x)= a0 ");
         for(int i=1; i<=n; i++)
         {
             System.out.print(" + a"+i+"*x^"+i);
         }
         System.out.println();
         for(int i=0; i<=m; i++)
         {
             System.out.print("a"+i+"=");
             second.put(i, (Integer)integerList.get(i+maximum(m,n)+1));
             System.out.println((Integer)integerList.get(i+maximum(m,n)+1));
         }
         System.out.print("Second polynomial E(x)= "+second.get(0));
         for(int i=1; i<=m; i++)
         {
             System.out.print(" + "+second.get(i)+"x^"+i);
         }
         System.out.println();




         if(n>m)
         {
             for(int i=m+1;i<=n;i++)
             {
                 second.put(i,0);
             }
         }
         else
         {
             for(int i=n+1;i<=m;i++)
             {
                 first.put(i,0);
             }
         }



         Hashtable<Integer,Integer> sum=new Hashtable<Integer,Integer>();
         sum.put(0, (Integer)first.get(0)+(Integer)second.get(0));
         System.out.print("Sum of polynomials D(x)+E(x)= "+sum.get(0));
         for(int i=1; i<=maximum(n,m); i++)
         {
             sum.put(i, (Integer)first.get(i)+(Integer)second.get(i));
             System.out.print(" + "+sum.get(i)+"x^"+i);
         }

         System.out.println();
         Hashtable<Integer,Integer> sortTable=new Hashtable<>();
         sortTable.putAll(first);
         for(int i=1; i<=maximum(n,m); i++)
         {
             sum.put(i, (Integer)sortTable.get(i)+(Integer)second.get(i));
             System.out.print(" + "+sum.get(i)+"x^"+i);
         }
     }


     public static void WriteHashtableJSon(Hashtable<Integer, Integer> hashtable, int num) throws IOException {
         JSONArray bookList = new JSONArray();
         JSONObject polynomial= new JSONObject();
         polynomial.put("index", hashtable.get(num));
         polynomial.put("value", hashtable.get(num));
         //book.put("number", hashtable.get(num).number);
         JSONObject bookObject = new JSONObject();
         bookObject.put("polynomial", polynomial);
         bookList.add(bookObject);


         try (FileWriter file = new FileWriter("hashTableOut.json")) {
             file.write(bookList.toJSONString());

         } catch (IOException e) {
             e.printStackTrace();
         }
         //System.out.println("Json: " + bookObject);
     }

     public static void ReadJson(String nameFile) throws IOException,  ParseException {
         Object obj = new JSONParser().parse(new FileReader(nameFile));
         JSONObject jo = (JSONObject) obj;
         Integer index = (Integer) jo.get("index");
         //Integer num = parseInt(number);
         Integer value = (Integer) jo.get("value");
         System.out.println(value + index);
         //String name = (String) jo.get("name");
         Polynomial polynomial = new Polynomial();
         //return polynomial;
     }




 }




