
public class Pessoa {
	private static int proximoId = 1;
	
	private int IDPessoa;
	private String Nome;
	private String CPF;
	private String Email;
	private String Telefone;
	
	
	public int getIDPessoa() {
		return IDPessoa;
	}
	public void setIDPessoa(int iDPessoa) {
		IDPessoa = iDPessoa;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public void PreencheDados(String nome, String cpf, String email, String telefone) {
		IDPessoa = proximoId++;
		Nome = nome;
		CPF = cpf;
		Email = email;
		Telefone = telefone;
	}
	
	public void Exibedados(boolean Quebra) {
		System.out.println("");
		System.out.print("ID: " + IDPessoa + "  Nome: " + Nome + "  CPF: " + CPF + "  Email: " + Email
				+ "  Telefone:" + Telefone);
		if (Quebra) {
			System.out.println();
		}
	}

	public void Exibedados() {
		Exibedados(true);
	}
}
