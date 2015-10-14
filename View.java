import javax.swing.JOptionPane;

public class View {

	public String pedeString(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

	public int pedeInt(String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
	}

	public double pedeDouble(String mensagem) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
	}

	public void mostraString(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public void mostraInt(String mensagem, int numero) {
		JOptionPane.showMessageDialog(null, mensagem + numero);
	}
	
}
