public class Controle {
	
	private static View view = new View();
	private static Cidades cidades;
	
	public static void setEstradas() {
		// para cada estrada possivel,
		// pergunta para o usuario se existe essa estrada
		int numeroCidades = view.pedeInt("Quantas cidades existem ?");
		cidades = new Cidades(numeroCidades);
		int[][] matriz = new int[numeroCidades][numeroCidades];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (i == j) {
					matriz[i][j] = 1;
					continue;
				}
				String entrada = view.pedeString("Existe estrada de " + i
						+ " ate " + j + " ? (s/n)");
				char resposta = entrada.charAt(0);
				// pega o primeiro char da string
				if (resposta == 's')
					matriz[i][j] = 1;
				else if (resposta == 'n')
					matriz[i][j] = 0;
			}
		}
		
		cidades.setMatriz(matriz);
	}
	
	public static void mostraMatriz() {
		// mostra a matriz formatada
		String output = "";
		for (int i = 0; i < cidades.getMatriz().length; i++) {
			for (int j = 0; j < cidades.getMatriz().length; j++) {
				output += (cidades.getMatriz()[i][j] + " ");
			}
			output += "\n";
		}
		view.mostraString(output);
	}
	
	public static void main(String[] args) {
		
		setEstradas();
		mostraMatriz();
		
	}

}
