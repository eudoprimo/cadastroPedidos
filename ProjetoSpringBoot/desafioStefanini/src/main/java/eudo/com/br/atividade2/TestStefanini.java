package eudo.com.br.atividade2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestStefanini {
	
	public boolean verificarNumeroPrimo(int valor) {
		return verificaPrimos(valor);
	}
	
	private boolean verificaPrimos(Integer valor){
        List<Integer> numeros = new ArrayList<Integer>();
        List<Integer> primos = new ArrayList<Integer>();
        boolean retorno = false;
        for(int i = 0; i <= valor; i++){
            numeros.add(i);
        }

        int contador = 0; 
        int numero = 0;
        for (Integer i : numeros) {
        	contador = 0;
            for (int u = 1; u <= i; u++) {
            	if (i % u == 0) {
					contador++;
					numero = u;
					
            	}
            }
            if (contador == 2) {
				primos.add(i);  
			}		
        }
        

        if (primos.stream().anyMatch(item -> item.equals(valor))) {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;
    }
	
	public static void main(String[] args){
		TestStefanini test = new TestStefanini();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Informe um valor para verificação: ");
			int valor = scanner.nextInt();
			
			boolean t = test.verificarNumeroPrimo(valor);
			
			System.out.println(t ? "É Primo" : "Não É Primo");
		}
	}

}
