
public class PessoaDocumento {
	private static int proximoId = 1;

	private int IDPessoaDocumento;
	private int IDPessoa;
	private int IDDocumento;
	private String DataHoraAssociacao;

	public int getIDPessoaDocumento() {
		return IDPessoaDocumento;
	}

	public void setIDPessoaDocumento(int iDPessoaDocumento) {
		IDPessoaDocumento = iDPessoaDocumento;
	}

	public int getIDPessoa() {
		return IDPessoa;
	}

	public void setIDPessoa(int iDPessoa) {
		IDPessoa = iDPessoa;
	}

	public int getIDDocumento() {
		return IDDocumento;
	}

	public void setIDDocumento(int iDDocumento) {
		IDDocumento = iDDocumento;
	}

	public String getDataHoraAssociacao() {
		return DataHoraAssociacao;
	}

	public void setDataHoraAssociacao(String dataHoraAssociacao) {
		DataHoraAssociacao = dataHoraAssociacao;
	}

	public void PreencheDados(int idDocumento, String datahoraassociacao, int idPessoa) {
		IDPessoaDocumento = proximoId++;
		IDDocumento = idDocumento;
		IDPessoa = idPessoa;
		DataHoraAssociacao = datahoraassociacao;
	}

	public void Exibedados(boolean Quebra) {
		System.out.println("");
		System.out.print("ID Documento: " + IDDocumento + "ID Pessoa/Documento: " + IDPessoaDocumento + "ID Pessoa: "
				+ IDPessoa + "  Data e hora de Associação: " + DataHoraAssociacao);
		if (Quebra) {
			System.out.println();
		}
	}

	public void Exibedados() {
		Exibedados(true);

	}
}
