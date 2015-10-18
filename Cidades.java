public class Cidades {

	private int[][] matriz;

	public Cidades() {
		super();
	}

	public Cidades(int numeroCidades) {
		super();
		matriz = new int[numeroCidades][numeroCidades];
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public int numeroDeSaidas(int k) { // item 1
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

	public int numeroDeEntradas(int k) { // item 1
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
		// obs.: se houver empate, retorna a cidade de menor numero
		int cidadeMaiorNumero = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (numeroDeEntradas(cidadeMaiorNumero) < numeroDeEntradas(i))
				cidadeMaiorNumero = i;
		}
		return cidadeMaiorNumero;
	}

	public boolean soTemLigacoesMaoDupla(int k) { // item 3
		/*
		 * retorna true se a cidade k possui apenas ligacoes de mao dupla com
		 * outras, consequentemente retorna false se existe algum caminho:
		 * -que saia de k para outra cidade mas nao o inverso
		 * -que chegue em k de outra cidade mas nao o inverso
		 */
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[k][i] != matriz[i][k]) {
				return false;
			}
		}
		return true;
	}

	public int[] possuemSaidasDiretas(int k) { // item 4
		/*
		 * retorna um Array com o numero das cidades que tem saida direta 
		 * para a cidade k, ou seja 'matriz[i][k] == 1'
		 */
		int[] cidadesComSaidasDiretas = new int[numeroDeEntradas(k)];
		int indice = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			if (i == k)
				continue;
			if (matriz[i][k] == 1) {
				cidadesComSaidasDiretas[indice] = i;
				indice++;
			}
		}

		return cidadesComSaidasDiretas;
	}
	
	public int[] cidadesIsoladas() { // item 5.a)
		/*
		 * retorna um array com o numero das cidades que estao isoladas,
		 * ou seja, nao possuem saidas nem entradas para outras cidades
		 */
		int numeroDeCidadesIsoladas = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			if (numeroDeEntradas(k) == 0 && numeroDeSaidas(k) == 0)
				numeroDeCidadesIsoladas++;
		}
		
		int[] cidadesSemLigacoes = new int[numeroDeCidadesIsoladas];
		int indice = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			if (numeroDeEntradas(k) == 0 && numeroDeSaidas(k) == 0) {
				cidadesSemLigacoes[indice] = k;
				indice++;
			}
		}

		return cidadesSemLigacoes;
	}
	
	public int[] cidadesSemSaida() { // item 5.b)
		/*
		 * retorna um array com os numeros das cidades que nao possuem
		 * saida para nenhuma outra cidade, porem possuem alguma entrada
		 */
		int numeroDeCidadesSemSaida = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			if (numeroDeSaidas(k) == 0 && numeroDeEntradas(k) != 0)
				numeroDeCidadesSemSaida++;
		}
		
		int[] arrayCidadesSemSaidas = new int [numeroDeCidadesSemSaida];
		int indice = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			if (numeroDeSaidas(k) == 0 && numeroDeEntradas(k) != 0) {
				arrayCidadesSemSaidas[indice] = k;
				indice++;
			}
		}
		
		return arrayCidadesSemSaidas;
	}
	
	public int[] cidadesSemEntrada() { // item 5.c)
		/*
		 * retorna um array com os numeros das cidades que nao possuem
		 * entrada vinda de nenhuma outra cidade, porem possuem alguma saida
		 */
		int numeroDeCidadesSemEntrada = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			if (numeroDeEntradas(k) == 0 && numeroDeSaidas(k) != 0)
				numeroDeCidadesSemEntrada++;
		}
		
		int[] arrayCidadesSemEntrada = new int[numeroDeCidadesSemEntrada];
		int indice = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			if (numeroDeEntradas(k) == 0 && numeroDeSaidas(k) != 0) {
				arrayCidadesSemEntrada[indice] = k;
				indice++;
			}
		}
		
		return arrayCidadesSemEntrada;
	}
}
