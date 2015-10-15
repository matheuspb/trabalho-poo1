public class Controle {

	private static View view = new View();
	private static Cidades cidades;

	public static void setEstradas() {
		// pergunta para o usuario quantas cidades existem,
		// e para cada estrada possivel,
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
		
		// item 1
		int k = view.pedeInt("De o valor de k para o item 1: ");
		view.mostraString(cidades.numeroDeEntradas(k) + " estradas chegam a cidade " +
				k + ",\n" + cidades.numeroDeSaidas(k) + " estradas saem da cidade " + k);
		
		// item 2
		view.mostraString("A cidade " + cidades.maiorNumeroEntradas() + 
				" e' a cidade a qual chega maior numero de estradas");
		
		// item 3
		k = view.pedeInt("De o valor de k para o item 3: ");
		if (cidades.soTemLigacoesMaoDupla(k))
			view.mostraString("A cidade " + k + " so possue ligacoes de mao dupla !");
		else 
			view.mostraString("A cidade " + k + " possue alguma ligacao simples");
		
		// item 4
		k = view.pedeInt("De o valor de k para o item 4: ");
		int[] cidadesComSaidaParaK = cidades.possuemSaidasDiretas(k);
		String stringSaida = "";
		if (cidadesComSaidaParaK.length == 0)
			stringSaida += "Nenhuma cidade tem saida direta para " + k;
		else {
			stringSaida += "A(s) cidade(s) que possue(m) saida direta para " + k + " sao:\n";
			for (int i = 0; i < cidadesComSaidaParaK.length; i++) {
				stringSaida += cidadesComSaidaParaK[i] + ", ";
			}
		}
		view.mostraString(stringSaida);
		stringSaida = "";
		
		// item 5
		int[] cidadesIsoladas = cidades.cidadesIsoladas();
		int[] cidadesSemSaida = cidades.cidadesSemSaida();
		int[] cidadesSemEntrada = cidades.cidadesSemEntrada();
		
		// item 5.a
		if (cidadesIsoladas.length != 0) {
			stringSaida = "As cidades isoladas sao:\n";
			for (int i = 0; i < cidadesIsoladas.length; i++) {
				stringSaida += cidadesIsoladas[i] + ", ";
			}
			view.mostraString(stringSaida);
		} else {
			view.mostraString("Nao existem cidades isoladas");
		}
		
		// item 5.b
		if (cidadesSemSaida.length != 0) {
			stringSaida = "As cidades sem saida sao:\n";
			for (int i = 0; i < cidadesSemSaida.length; i++) {
				stringSaida += cidadesSemSaida[i] + ", ";
			}
			view.mostraString(stringSaida);
		} else {
			view.mostraString("Nao existem cidades sem saida");
		}
		
		// item 5.c
		if (cidadesSemEntrada.length != 0) {
			stringSaida = "As cidades sem entrada sao:\n";
			for (int i = 0; i < cidadesSemEntrada.length; i++) {
				stringSaida += cidadesSemEntrada[i] + ", ";
			}
			view.mostraString(stringSaida);
		} else {
			view.mostraString("Nao existem cidades sem entrada");
		}
		
	}
}
