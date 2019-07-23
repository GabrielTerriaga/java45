package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			//ler arquivo e guarda na variavel
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(","); //recorte da string
				String name = fields[0]; // variavel para pegar o name
				int votes = Integer.parseInt(fields[1]);
				
				if (map.containsKey(name)) {
					int votesSoFar = map.get(name);
					map.put(name, votes + votesSoFar);
				}
				else {
					map.put(name, votes);
				}
				
				line = br.readLine(); //line recebe a proxima linha do arquivo
			}	
			
			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}
		}
			catch(IOException e){
				System.out.println("erro");
			}
		
		sc.close();
		}
	}
