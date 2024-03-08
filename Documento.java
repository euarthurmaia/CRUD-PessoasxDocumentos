
public class Documento {
	private static int proximoId = 1;

	private int IDDocumento;
	private String Descricao;
	private String URL;

	public int getIDDocumento() {
		return IDDocumento;
	}

	public void setIDDocumento(int iDDocumento) {
		IDDocumento = iDDocumento;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void PreencheDados(String descricao, String url) {
		IDDocumento = proximoId++;
		Descricao = descricao;
		URL = url;
	}

	public void Exibedados(boolean Quebra) {
		System.out.println("");
		System.out.print("ID: " + IDDocumento + "  Descricao: " + Descricao + "  URL: " + URL);
		if (Quebra) {
			System.out.println();
		}
	}

	public void Exibedados() {
		Exibedados(true);
	}
}
