package lab1;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.processing.Filer;

public class index {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String line;
		// \\W   –  любой символ, кроме буквенного или цифрового символа или знака подчёркивания
		//  \\d   –  цифровой символ
		String pattern = "\\W";
		try {
			FileReader fr = new FileReader(new File ("E:\\java\\workspace\\lab1\\src\\lab1\\index.java"));
			BufferedReader reader = new BufferedReader(fr);
			while((line = reader.readLine()) != null){
				String[] words = line.split(pattern);
				for (int i = 0; i < words.length; i++) {
					if (!(map.containsKey(words[i]))){
						map.put(words[i], 1);
					}
					else{
						map.put(words[i], map.get(words[i])+1);
					}
				}
			}
			for (Map.Entry<String, Integer> arg : map.entrySet()) {
				System.out.println(arg.getValue() + " : " + arg.getKey());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
