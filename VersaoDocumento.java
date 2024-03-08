
public class VersaoDocumento {
	private static int proximoId = 1;

	private int IDVersaoDocumento;
	private int IDDocumento;
	private String ResponsavelAlteracao;
	private String DataHoraAlteracao;

	public int getIDVersaoDocumento() {
		return IDVersaoDocumento;
	}

	public void setIDVersaoDocumento(int iDVersaoDocumento) {
		IDVersaoDocumento = iDVersaoDocumento;
	}

	public int getIDDocumento() {
		return IDDocumento;
	}

	public void setIDDocumento(int iDDocumento) {
		IDDocumento = iDDocumento;
	}

	public String getResponsavelAlteracao() {
		return ResponsavelAlteracao;
	}

	public void setResponsavelAlteracao(String responsavelAlteracao) {
		ResponsavelAlteracao = responsavelAlteracao;
	}

	public String getDataHoraAlteracao() {
		return DataHoraAlteracao;
	}

	public void setDataHoraAlteracao(String dataHoraAlteracao) {
		DataHoraAlteracao = dataHoraAlteracao;
	}

	public void PreencheDados(int iddocumento, String responsavelalteracao, String datahoraalteracao) {
		IDVersaoDocumento = proximoId++;
		IDDocumento = iddocumento;
		ResponsavelAlteracao = responsavelalteracao;
		DataHoraAlteracao = datahoraalteracao;
	}

	public void Exibedados(boolean Quebra) {
		System.out.println("");
		System.out.print("ID Versao Documento: " + IDVersaoDocumento + "  ID Documento: " + IDDocumento
				+ "  Responsável: " + ResponsavelAlteracao + " Data e hora Alteração: " + DataHoraAlteracao);
		if (Quebra) {
			System.out.println();
		}
	}

	public void Exibedados() {
		Exibedados(true);
	}

}