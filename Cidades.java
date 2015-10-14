public class Cidades {

	private int[][] matriz;
	private View view;

	public Cidades() {
		super();
		view = new View();
	}

	public Cidades(int numeroCidades) {
		super();
		matriz = new int[numeroCidades][numeroCidades];
		view = new View();
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
	
	public int[][] getMatriz() {
		return matriz;
	}

	// --> passar para o controle
	public void setEstradas() {
		// para cada estrada possivel,
		// pergunta para o usuario se existe essa estrada
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
	}
	
	// --> passar para o controle
	public void mostraMatriz() {
		String output = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				output += (matriz[i][j] + " ");
			}
			output += "\n";
		}
		view.mostraString(output);
	}

	public int estradasDeSaida(int k) { // item 1
		// retorna quantas estradas saem da cidade k
		int i = k;
		int numeroDeCaminhos = 0;
		for (int j = 0; j < matriz.length; j++) {
			if (j == k)
				continue;
			if (matriz[i][j] == 1)
				numeroDeCaminhos += 1;
		}
		return numeroDeCaminhos;
	}

	public int estradasDeEntrada(int k) { // item 1
		// retorna quantas estradas chegam na cidade k
		int j = k;
		int numeroDeCaminhos = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (i == k)
				continue;
			if (matriz[i][j] == 1)
				numeroDeCaminhos += 1;
		}
		return numeroDeCaminhos;
	}

	public int maiorNumeroEntradas() { // item 2
		// retorna qual cidade chega maior numero de estradas
		// obs.: se houver empate, retorna a cidade de maior numero
		int cidadeMaiorNumero = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (estradasDeEntrada(cidadeMaiorNumero) < estradasDeEntrada(i))
				cidadeMaiorNumero = i;
		}
		return cidadeMaiorNumero;
	}

	public boolean soTemLigacoesMaoDupla(int k) { // item 3
		/* retorna true se a cidade k possui apenas ligacoes duplas com outras,
		 * consequentemente retorna false se existe algum caminho:
		 * -que saia de k para outra cidade mas nao o inverso
		 * -que chegue em k de outra cidade mas nao o inverso
		 *
		 * obs.: retorna true se a cidade k esta isolada, por falta de contra exemplo
		 */
		boolean saida = true;
		for (int i = 0; i < matriz.length; i++) {
			if (k == i)
				continue;
			if (matriz[k][i] == 1 && matriz[i][k] != 1)
				saida = false;
		}
		return saida;
	}
	
	public int[] possuemSaidasDiretas(int k) { // item 4
		/* retorna um Array com o numero das cidades que tem saida direta
		 * para a cidade k, ou seja 'matriz[i][k] = 1'
		 */
		int numeroDeCidades = 0;
		for (int i = 0; i < matriz.length; i++) {
			if ((matriz[i][k] == 1) && (i != k))
				numeroDeCidades++;
		}
		
		int[] cidadesComSaidasDiretas = new int[numeroDeCidades];
		int indice = 0;
		for (int i = 0; i < matriz.length; i++) {
			if ((matriz[i][k] == 1) && (i != k)) {
				cidadesComSaidasDiretas[indice] = i;
				indice++;
			}
		}
		
		return cidadesComSaidasDiretas;
	}

}
