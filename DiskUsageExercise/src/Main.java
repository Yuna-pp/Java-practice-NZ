import java.io.File;
import java.util.Scanner;

//Create a program to be given a directory path that calculates the total size, in bytes, of every file in that directory or in any depth of subdirectories. You will want to use a recursive method or methods to do this.
//Add another mode that reports the size of each subdirectory and all its children individually, showing the hierarchy of directories.
//Add another mode that finds all files within a directory tree with a particular extension (e.g. .java or .class) and lists them.

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input the file path: ");
		String path = scanner.nextLine();
		
		File targetFile = new File(path);
		long fileSize = getFolderSize(targetFile);
		
		System.out.println(" The fileSize is " + fileSize + " bytes");
		
		System.out.print("Please input the file path: ");
		String path2 = scanner.nextLine();
		File targetFile2 = new File(path2);
		getLayer(targetFile2,0);
		
		System.out.print("Please input the file path: ");
		String path3 = scanner.nextLine();
		File targetFile3 = new File(path3);
		getExtension(targetFile3,0,".pdf");
		
		
	}
	
	public static long getFolderSize(File file) {
		if(!file.exists()) {
			return 0;
		}
		if(file.isFile()) {
			return file.length();
		}
		long totalSize = 0;
		File[] files = file.listFiles();
		if(files != null) {
			for (File f : files) {
				totalSize+=getFolderSize(f);
			}
		}
			
		return totalSize;		
	}
	
	public static void getLayer(File file, int level) {
		if(!file.exists()) {
			System.out.println("not found");
		}
		String indent = "";
	    for (int i = 0; i < level; i++) {
	        indent += "  ";
	    }
		System.out.println(indent+ "- " + file.getName());
		
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					getLayer(f,level+1);
				}
			}						
		}		
	}
	
	public static void getExtension(File file,int level, String extension) {
		if(!file.exists()) {
			System.out.println("not found");
		}
		if (file.isFile()) {
	        if (file.getName().endsWith(extension)) {
	            String indent = "";
	            for (int i = 0; i < level; i++) {
	                indent += "  ";
	            }
	            System.out.println(indent + "- " + file.getName());
	        }
	    }
		
		else if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					if(f.getName().endsWith(extension)) {
						getExtension(f,level+1,extension);
					}
					
				}
			}						
		}
		
	}
}
