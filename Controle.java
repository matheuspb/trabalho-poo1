import java.util.Arrays;

public class Controle {

	public static void main(String[] args) {
		
		View view = new View();
		
		//int numeroDeCidades = view.pedeInt("Quantas cidades existem ?");
		Cidades cidades = new Cidades();
		
		int[][] matriz = {
				{1, 1, 1, 0},
				{0, 1, 1, 0},
				{1, 0, 1, 1},
				{0, 0, 1, 1}
		};
		
		cidades.setMatriz(matriz);
		cidades.mostraMatriz();
		
		//view.mostraString(Boolean.toString(cidades.soTemLigacoesMaoDupla(3)));
		//view.mostraInt("", cidades.maiorNumeroEntradas());
		view.mostraString(Arrays.toString(cidades.possuemSaidasDiretas(1)));
		
	}

}
