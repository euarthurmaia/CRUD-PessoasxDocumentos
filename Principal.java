import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int respGerenciador = 0;
		int loopPrincipal = 1;
		int resp = 0;
		int respAssociacao = 0;
		int loopA = 1;
		int respA = 0;
		Documento D1 = null;

		List<Pessoa> ListaPessoa;
		ListaPessoa = new ArrayList<Pessoa>();
		List<PessoaDocumento> ListaPessoaDocumento;
		ListaPessoaDocumento = new ArrayList<PessoaDocumento>();
		List<Documento> ListaDocumento;
		ListaDocumento = new ArrayList<Documento>();
		List<VersaoDocumento> ListaVersaoDocumento;
		ListaVersaoDocumento = new ArrayList<VersaoDocumento>();

		while (loopPrincipal != 0) {
			System.out.println("************************************************************");
			System.out.println("-----------------------TELA INICIAL-------------------------");
			System.out.println("");
			System.out.println("1 - Gerenciar Pessoas	2 - Gerenciar Documentos   3 - Sair");
			System.out.println("");
			respGerenciador = leitor.nextInt();

			if (respGerenciador == 1) {
				System.out.println("------------------------------------------------------------");
				System.out.println("************************************************************");
				int loopPessoa = 1;
				while (loopPessoa != 0) {
					System.out.println("");
					System.out.println("************************************************************");
					System.out.println("-----------------------TELA DE PESSOA-----------------------");
					System.out.println("");
					System.out.println("1 - Cadastrar  2 - Excluir  3 - Listar  4 - Editar  5 - Sair");
					resp = leitor.nextInt();

					if (resp == 1) {
						System.out.println("-------------------------CADASTRO---------------------------");
						System.out.println("Nome: ");
						leitor.nextLine();
						String Nome = leitor.nextLine();
						System.out.println("CPF: ");
						String CPF = leitor.nextLine();
						System.out.println("Email: ");
						String Email = leitor.nextLine();
						System.out.println("Telefone: ");
						String Telefone = leitor.nextLine();
						System.out.println("");
						System.out.println("Cadastrado com sucesso! :)");
						System.out.println("------------------------------------------------------------");
						System.out.println("************************************************************");

						Pessoa P1 = new Pessoa();
						P1.PreencheDados(Nome, CPF, Email, Telefone);
						ListaPessoa.add(P1);
					} else if (resp == 2) {
						System.out.println("-------------------------EXCLUIR----------------------------");
						int loop = 1;
						while (loop != 0) {
							int IDPessoaDELETE;
							int Confirmar = 0;
							System.out.println("Digite o código da Pessoa que deseja excluir: ");
							IDPessoaDELETE = leitor.nextInt();
							for (int j = ListaPessoaDocumento.size() - 1; j >= 0; j--) {
								if (ListaPessoaDocumento.get(j).getIDPessoa() == IDPessoaDELETE) {
									ListaPessoaDocumento.remove(j);
								}
							}
							for (int i = ListaPessoa.size() - 1; i >= 0; i--) {
								if (ListaPessoa.get(i).getIDPessoa() == IDPessoaDELETE) {
									System.out.println("Item excluído: ");
									ListaPessoa.get(i).Exibedados();
									ListaPessoa.remove(i);
									Confirmar = 1;
									break;
								}
							}
							if (Confirmar == 1) {
								System.out.println("");
								System.out.println("Pessoa Excluída com sucesso! :)");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
							} else {
								System.out.println("");
								System.out.println("Pessoa Não Encontrada! :(");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
							}
							loop = 0;
						}
					} else if (resp == 3) {
						System.out.println("--------------------------LISTA-----------------------------");
						if (ListaPessoa.isEmpty()) {
							System.out.println("");
							System.out.println("Lista de Pessoas vazia! :( ");
							System.out.println("");
							System.out.println("------------------------------------------------------------");
							System.out.println("************************************************************");
						} else {
							int qtdP = 0;
							for (int qtd = 0; qtd < ListaPessoa.size(); qtd++) {
								ListaPessoa.get(qtd).Exibedados();
								qtdP++;
							}
							System.out.println("");
							System.out.println("Quantidade de Pessoas: " + qtdP);
							System.out.println("------------------------------------------------------------");
							System.out.println("************************************************************");
						}
					} else if (resp == 4) {
						int loopEdicaoPessoa = 1;
						Pessoa PessoaEditar = null;
						int idPessoaEditar;
						int respEdicao = 0;
						System.out.println("--------------------------EDITAR----------------------------");

						if (ListaPessoa.isEmpty()) {
							System.out.println("");
							System.out.println("Lista de Pessoas vazia! :( ");
							System.out.println("");
							System.out.println("------------------------------------------------------------");
							System.out.println("************************************************************");
						} else {
							System.out.println("-----Lista de Pessoas-----");
							for (Pessoa pessoa : ListaPessoa) {
								pessoa.Exibedados();
								System.out.println("--------------------------");
							}
							System.out.println("Digite o ID da pessoa que deseja editar: ");
							idPessoaEditar = leitor.nextInt();

							for (Pessoa pessoa : ListaPessoa) {
								if (pessoa.getIDPessoa() == idPessoaEditar) {
									PessoaEditar = pessoa;
									break;
								} else {
									System.out.println("ID não encontrado! :(");
								}
							}

							if (PessoaEditar != null) {
								while (loopEdicaoPessoa != 0) {
									System.out.println("");
									System.out.println("Editar:");
									System.out.println("1 - Nome   2 - CPF   3 - Email   4 - Telefone   5 - Sair");
									respEdicao = leitor.nextInt();

									if (respEdicao == 1) {
										System.out.println("Novo Nome: ");
										leitor.nextLine();
										String novoNome = leitor.nextLine();
										PessoaEditar.setNome(novoNome);
									} else if (respEdicao == 2) {
										System.out.println("Novo CPF: ");
										leitor.nextLine();
										String novoCPF = leitor.nextLine();
										PessoaEditar.setCPF(novoCPF);
									} else if (respEdicao == 3) {
										System.out.println("Novo Email: ");
										leitor.nextLine();
										String novoEmail = leitor.nextLine();
										PessoaEditar.setEmail(novoEmail);
									} else if (respEdicao == 4) {
										System.out.println("Novo Telefone: ");
										leitor.nextLine();
										String novoTelefone = leitor.nextLine();
										PessoaEditar.setTelefone(novoTelefone);
									} else {
										System.out.println("Saindo da edição!");
										loopEdicaoPessoa = 0;
										System.out.println("");
										System.out.println(
												"------------------------------------------------------------");
										System.out.println(
												"************************************************************");
									}
								}
							}
						}
					} else if (resp == 5) {
						System.out.println("Voltando a tela inicial!");
						System.out.println("------------------------------------------------------------");
						System.out.println("************************************************************");
						System.out.println("");
						loopPessoa = 0;
					}

				}
			}
			if (respGerenciador == 2) {
				int loopDocumento = 1;
				while (loopDocumento != 0) {
					System.out.println("");
					System.out.println("************************************************************");
					System.out.println("---------------------TELA DE DOCUMENTO----------------------");
					System.out.println("");
					System.out.println("1 - Cadastrar  2 - Excluir  3 - Listar  4 - Associar  ");
					System.out.println("");
					System.out.println("5 - Editar     6 - Versão   7 - Sair");
					resp = leitor.nextInt();
					if (resp == 1) {
						System.out.println("-------------------------CADASTRO---------------------------");
						System.out.println("Descrição: ");
						leitor.nextLine();
						String Descricao = leitor.nextLine();
						System.out.println("URL: ");
						String URL = leitor.nextLine();

						D1 = new Documento();
						D1.PreencheDados(Descricao, URL);
						ListaDocumento.add(D1);

						while (true) {
							System.out.println("Deseja Associar o documento a alguma pessoa?");
							System.out.println("1 - Sim    2 - Não");
							respAssociacao = leitor.nextInt();

							if (respAssociacao == 2) {
								System.out.println("");
								System.out.println("Cadastrado com sucesso! :)");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
								System.out.println("");
								break;
							}

							else if (respAssociacao == 1) {
								System.out.println("-------------------------ASSOCIAR---------------------------");
								System.out.println("Data e Hora da associação: ");
								leitor.nextLine();
								String DataHoraAssociacao = leitor.nextLine();
								System.out.println("ID da pessoa que vai ser associada:");
								System.out.println("Digite 0 para sair (O documento será salvo sem associação!)");
								int IDPessoa = leitor.nextInt();

								if (IDPessoa == 0) {
									System.out.println("");
									System.out.println("Voltando para a Tela Inicial!");
									System.out.println("------------------------------------------------------------");
									System.out.println("************************************************************");
									System.out.println("");
									break;
								} else {
									int idDesejado = IDPessoa;

									boolean idExiste = false;
									for (Pessoa pessoa : ListaPessoa) {
										if (pessoa.getIDPessoa() == idDesejado) {
											idExiste = true;
											break;
										}
									}

									if (idExiste) {

										PessoaDocumento PD1 = new PessoaDocumento();
										PD1.PreencheDados(D1.getIDDocumento(), DataHoraAssociacao, IDPessoa);
										ListaPessoaDocumento.add(PD1);

										System.out.println("Documento associado à pessoa com sucesso! :) ");
										System.out.println(
												"------------------------------------------------------------");
										System.out.println(
												"************************************************************");
										System.out.println("");
									} else {
										System.out.println("ID da pessoa não encontrado. Associação não realizada.");
										System.out.println("Tente novamente.");
										System.out.println(
												"------------------------------------------------------------");
									}
								}
							}
						}
					}
					if (resp == 2) {
						int loop = 1;
						System.out.println("-------------------------EXCLUIR----------------------------");
						while (loop != 0) {
							int IDDocumentoDELETE;
							int Confirmar = 0;
							System.out.println("");
							System.out.println("Digite o código do Documento que deseja excluir: ");
							IDDocumentoDELETE = leitor.nextInt();

							for (int j = ListaPessoaDocumento.size() - 1; j >= 0; j--) {
								if (ListaPessoaDocumento.get(j).getIDDocumento() == IDDocumentoDELETE) {
									ListaPessoaDocumento.remove(j);
									break;
								}
							}
							for (int k = ListaVersaoDocumento.size() - 1; k >= 0; k--) {
								if (ListaVersaoDocumento.get(k).getIDDocumento() == IDDocumentoDELETE) {
									ListaVersaoDocumento.remove(k);
									break;
								}
							}
							for (int i = ListaDocumento.size() - 1; i >= 0; i--) {
								if (ListaDocumento.get(i).getIDDocumento() == IDDocumentoDELETE) {
									System.out.println("Item excluído: ");
									System.out.println("------------------------------------------------------------");
									System.out.println("************************************************************");
									System.out.println("");
									ListaDocumento.get(i).Exibedados();
									ListaDocumento.remove(i);

									Confirmar = 1;
									break;
								}
							}
							if (Confirmar == 1) {
								System.out.println("Documento excluído com sucesso!:) ");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
								System.out.println("");
							} else {
								System.out.println("Documento não encontrado! :( ");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
								System.out.println("");
							}
							loop = 0;
						}
					} else if (resp == 3) {
						System.out.println("--------------------------LISTA-----------------------------");
						if (ListaDocumento.isEmpty()) {
							System.out.println("Lista de Documento vazia! :( ");
							System.out.println("------------------------------------------------------------");
							System.out.println("************************************************************");
							System.out.println("");
							break;
						} else {
							System.out.println("-----Lista de Documento:-----");
							int qtdD = 0;
							for (int qtd = 0; qtd < ListaDocumento.size(); qtd++) {
								ListaDocumento.get(qtd).Exibedados();
								qtdD++;
							}
							System.out.println("");
							System.out.println("Quantidade de Documentos: " + qtdD);
							System.out.println("--------------------------");
							System.out.println("------------------------------------------------------------");
							System.out.println("************************************************************");
							System.out.println("");
						}
					} else if (resp == 4) {
						System.out.println("-------------------------ASSOCIAR---------------------------");
						System.out.println("1 - Exibir Documentos associados	2 - Associar Documento ");
						respA = leitor.nextInt();

						if (respA == 1) {
							System.out.println("--------------------------LISTA-----------------------------");
							if (ListaPessoaDocumento.isEmpty()) {
								System.out.println("Lista vazia! :( ");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
								System.out.println("");
							} else {
								System.out.println("-----Lista de Pessoa/Documento:-----");
								int qtdPD = 0;
								for (int qtd = 0; qtd < ListaPessoaDocumento.size(); qtd++) {
									ListaPessoaDocumento.get(qtd).Exibedados();
									qtdPD++;
								}
								System.out.println("");
								System.out.println("Quantidade de Documentos: " + qtdPD);
								System.out.println("------------------------------------");
							}
						}

						if (respA == 2) {
							while (loopA != 0) {
								while (true) {
									System.out.println("ID da pessoa que vai ser associada:");
									System.out.println("Digite 0 para sair.");
									int idDesejado = leitor.nextInt();

									if (idDesejado == 0) {
										System.out.println("Voltando para a Tela Inicial!");
										System.out.println(
												"------------------------------------------------------------");
										System.out.println(
												"************************************************************");
										System.out.println("");
										loopA = 0;
										break;
									}

									boolean idExiste = false;
									System.out.println("------------------------ASSOCIAÇÃO-------------------------");
									for (Documento documento : ListaDocumento) {
										if (documento.getIDDocumento() == idDesejado) {
											idExiste = true;

											System.out.println("Data e Hora da associação: ");
											leitor.nextLine();
											String DataHoraAssociacao = leitor.nextLine();
											System.out.println("ID da pessoa que vai ser associada:");
											System.out.println("Digite 0 para sair.");
											int IDPessoa = leitor.nextInt();

											if (IDPessoa != 0) {
												idDesejado = IDPessoa;

												boolean idExiste2 = false;
												for (Pessoa pessoa : ListaPessoa) {
													if (pessoa.getIDPessoa() == idDesejado) {
														idExiste2 = true;

														PessoaDocumento PD1 = new PessoaDocumento();
														PD1.PreencheDados(D1.getIDDocumento(), DataHoraAssociacao,
																IDPessoa);
														ListaPessoaDocumento.add(PD1);

														System.out.println(
																"Documento associado à pessoa com sucesso! :) ");
														System.out.println(
																"------------------------------------------------------------");
														System.out.println(
																"************************************************************");
														System.out.println("");
														loopA = 0;
														break;
													}
												}

												if (!idExiste2) {
													System.out.println(
															"ID da pessoa não encontrado. Associação não realizada.");
													System.out.println("Tente novamente ou digite 0 para sair.");
													System.out.println(
															"------------------------------------------------------------");
												}

												PessoaDocumento PD1 = new PessoaDocumento();
												PD1.PreencheDados(documento.getIDDocumento(), DataHoraAssociacao,
														IDPessoa);
												ListaPessoaDocumento.add(PD1);

												System.out.println("Documento associado à pessoa com sucesso! :) ");
												System.out.println(
														"------------------------------------------------------------");
												System.out.println(
														"************************************************************");
												System.out.println("");
												break;
											}
										}

										if (!idExiste) {
											break;
										}
									}
								}
							}
						}

					} else if (resp == 5) {
						System.out.println("---------------------------EDIÇÃO---------------------------");
						int loopEdicaoDocumento = 1;
						Documento DocumentoEditar = null;
						int idDocumentoEditar;
						int respEdicao = 0;
						System.out.println("---------Lista para editar---------");
						if (ListaDocumento.isEmpty()) {
							System.out.println("Lista para editar vazia! :( ");
							System.out.println("------------------------------------");
							System.out.println("------------------------------------------------------------");
							System.out.println("************************************************************");
							System.out.println("");
						} else {
							for (Documento documento : ListaDocumento) {
								documento.Exibedados();
							}

							System.out.println("Digite o ID do documento que deseja editar: ");
							idDocumentoEditar = leitor.nextInt();

							for (Documento documento : ListaDocumento) {
								if (documento.getIDDocumento() == idDocumentoEditar) {
									DocumentoEditar = documento;
									break;
								} else {
									System.out.println("ID não encontrado!");
									System.out.println("------------------------------------------------------------");
									System.out.println("************************************************************");
									System.out.println("");
								}
							}

							if (DocumentoEditar != null) {
								while (loopEdicaoDocumento != 0) {
									System.out.println("------------------------------------------------------------");
									System.out.println("Editar:");
									System.out.println("1 - Descrição   2 - URL  3 - Sair");
									respEdicao = leitor.nextInt();

									if (respEdicao == 1) {
										System.out.println("Nova Descrição: ");
										leitor.nextLine();
										String novaDescricao = leitor.nextLine();
										DocumentoEditar.setDescricao(novaDescricao);
									} else if (respEdicao == 2) {
										System.out.println("Nova URL: ");
										leitor.nextLine();
										String novaURL = leitor.nextLine();
										DocumentoEditar.setURL(novaURL);
									} else {
										System.out.println("Saindo da edição!");
										System.out.println(
												"------------------------------------------------------------");
										System.out.println(
												"************************************************************");
										System.out.println("");
										loopEdicaoDocumento = 0;
									}
								}
							}

						}
					}

					else if (resp == 6) {
						System.out.println("---------------------------VERSÃO---------------------------");
						int respVersao = 0;
						System.out.println("1 - Exibir Versão	2 - Criar uma nova Versão");
						respVersao = leitor.nextInt();

						if (respVersao == 1) {
							System.out.println("---------Lista de Versões---------");
							if (ListaVersaoDocumento.isEmpty()) {
								System.out.println("Lista de Versão vazia! :( ");
								System.out.println("------------------------------------");
								System.out.println("------------------------------------------------------------");
								System.out.println("************************************************************");
								System.out.println("");
							} else {
								for (VersaoDocumento versaodocumento : ListaVersaoDocumento) {
									versaodocumento.Exibedados();
									System.out.println("------------------------------------");
								}
							}

						} else {
							loopA = 1;
							while (loopA != 0) {
								while (true) {
									System.out.println(
											"Digite o ID do documento que deseja alterar a versão: (Digite 0 para sair)");
									int idDesejado = leitor.nextInt();

									if (idDesejado == 0) {
										System.out.println("Voltando para a Tela Inicial!");
										System.out.println(
												"------------------------------------------------------------");
										System.out.println(
												"************************************************************");
										System.out.println("");
										loopA = 0;
										break;
									}

									boolean idExiste = false;
									for (Documento documento : ListaDocumento) {
										if (documento.getIDDocumento() == idDesejado) {
											idExiste = true;

											leitor.nextLine();
											System.out.println("Responsável por Alteração: ");
											String ResponsavelAlteracao = leitor.nextLine();
											System.out.println("Data e hora da Alteração: ");
											String DataHoraAlteracao = leitor.nextLine();
											VersaoDocumento VD1 = new VersaoDocumento();
											VD1.PreencheDados(documento.getIDDocumento(), ResponsavelAlteracao,
													DataHoraAlteracao);
											ListaVersaoDocumento.add(VD1);
											System.out.println("Nova URL: ");
											String versaoURL = leitor.nextLine();

											documento.setURL(versaoURL);

											System.out.println("");
											System.out.println("Versão Lançada com sucesso! :)");
											System.out.println(
													"------------------------------------------------------------");
											System.out.println(
													"************************************************************");
											System.out.println("");
										}

										if (!idExiste) {
											System.out.println("Tente novamente ou digite 0 para sair.");
											System.out.println("");
										}
									}
								}
							}
						}
					}

					else if (resp == 7) {
						System.out.println("Voltando a tela inicial!");
						System.out.println("------------------------------------------------------------");
						System.out.println("************************************************************");
						System.out.println("");
						loopDocumento = 0;
					}

				}
			}

			if (respGerenciador == 3) {
				System.out.println("Fechado!");
				System.out.println("------------------------------------------------------------");
				System.out.println("************************************************************");
				System.out.println("");
				loopPrincipal = 0;
			}
		}
		leitor.close();
	}
}