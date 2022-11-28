package mercadinho;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class main {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner ler = new Scanner(System.in);
		
		int escolhaMenuPrincipal = 0, escolhaSubMenu = 0, escolhaId = 0, idCliente = 0, idProduto = 0, idCategoria = 0, idItemPedido = 0, idPedido = 0, index = 0, estoque = 0;
		String nome, descricao;
		float preco;
		boolean encontrado = false;
		String[] nomeDaEscolha = {"Cliente", "Produto", "Categoria", "Pedido"};  
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		ArrayList<Categoria> listaCategoria = new ArrayList<>();
		ArrayList<Produto> listaProduto = new ArrayList<>();
		ArrayList<Pedido> listaPedido = new ArrayList<>();

		//popular arrays
		for(var x=0; x < 5; x++) {
			idCliente++;
			idCategoria++;
			idProduto++;
			
			listaCliente.add(x, new Cliente(idCliente, "a"+idCliente));
			listaCategoria.add(x, new Categoria(idCategoria, "a"+idCategoria, "desc"+idCategoria));
			listaProduto.add(x, new Produto(idProduto, "a"+idProduto, "desc"+idProduto, x, x, listaCategoria.get(x)));

		}
		
		while(true) {
			
			System.out.printf("\n              			    Mercadinho");
			System.out.printf("\n\n--------------------------------------------------------------------------------------");
			System.out.printf("\nDigite a opcao que deseja para (Exibir, Cadastrar, Editar ou Deletar) o item escolhido");
			System.out.printf("\n--------------------------------------------------------------------------------------\n");
			System.out.printf("\n	(1) Cliente.");
			System.out.printf("\n	(2) Produto.");
			System.out.printf("\n	(3) Categoria.");
			System.out.printf("\n	(4) Pedido.");
			System.out.printf("\n	(5) Sair.");
			System.out.printf("\n\n--------------------------------------------------------------------------------------\n");
			System.out.printf("\nDigite o numero desejado: ");
		
			escolhaMenuPrincipal = ler.nextInt(); //Escolha a opção que deseja
			
			if ( escolhaMenuPrincipal > 0 && escolhaMenuPrincipal <= 4 ) {
				
				// Escolha o que ira fazer com o produto escolhido
				
				while(true) {
					
					System.out.printf("\n\n------------------------------------------------------");
					System.out.printf("\n\n	(1) Exibir %ss.", nomeDaEscolha[escolhaMenuPrincipal - 1]);
					System.out.printf("\n	(2) Cadastrar %ss.", nomeDaEscolha[escolhaMenuPrincipal - 1]);
					System.out.printf("\n	(3) Editar %ss.", nomeDaEscolha[escolhaMenuPrincipal - 1]);
					System.out.printf("\n	(4) Deletar %ss.", nomeDaEscolha[escolhaMenuPrincipal - 1]);
					System.out.printf("\n	(5) Voltar para o menu principal.");
					System.out.printf("\n\n------------------------------------------------------\n");
					System.out.printf("\nDigite o numero desejado: ");
					
					escolhaSubMenu = ler.nextInt(); //Escolha a opção que deseja
					
					if( escolhaSubMenu > 0 && escolhaSubMenu <= 4) {
						
						switch (escolhaSubMenu) {
						
						//exibir
						case 1:
							
							switch (escolhaMenuPrincipal) {
							case 1: 
								
								if (listaCliente.size() == 0) {
									System.out.printf("Nao ha clientes cadastrados.");
									break;
								}
								for (Cliente c: listaCliente) {
									System.out.println(c.exibirDadosCliente());
								}
								
								break;
								
							case 2: 
							
								if (listaProduto.size() == 0) {
									System.out.printf("Nao ha Produtos cadastrados.");
									break;
								}
								for (Produto p: listaProduto) {
									System.out.println(p.exibirDadosProduto());
								}
								
								break;	
								
							case 3: 
								
								if (listaCategoria.size() == 0) {
									System.out.printf("Nao ha categorias cadastradas.");
									break;
								}
								for (Categoria c: listaCategoria) {
									System.out.println(c.exibirDadosCategoria());
								}
								
								
								break;
							case 4:
								
								if (listaPedido.size() == 0) {
									System.out.printf("Nao ha Pedidos cadastrados.");
									break;
								}				
								for (Pedido p: listaPedido) {
									System.out.printf("%s", p.exibirPedido());
								}
								
								break;
							}
							
							break;
							
							//cadastrar
						case 2:
							
							switch (escolhaMenuPrincipal) {
							case 1: 
								
								idCliente += 1;
								System.out.printf("\n\n	Insira o nome do cliente: ");
								nome = ler.next();
								Cliente cliente = new Cliente(idCliente, nome);
								listaCliente.add(cliente);
								
								break;
							case 2: 
								
								idProduto += 1;
								System.out.printf("\n\n	Insira o nome do produto: ");
								nome = ler.next();
								System.out.printf("\n\n	Insira a descricao do produto: ");
								descricao = ler.next();
								System.out.printf("\n\n	Insira a quantidade em estoque: ");
								estoque = ler.nextInt();
								System.out.printf("\n\n	Insira o preco do produto: ");
								preco = ler.nextFloat();
								System.out.printf("\n\n	Insira a categoria do produto (id da categoria): ");
								escolhaId = ler.nextInt();
								
								for(Categoria c: listaCategoria) {
									if(c.getId() == escolhaId) {
										encontrado = true;
										index = listaCategoria.indexOf(c);
										}
									}
								if (!encontrado) {
									System.out.printf("\n		Categoria nao encontrada.");
								}
								else {
									Produto produto = new Produto(idProduto, nome, descricao, estoque, preco, listaCategoria.get(index));
									listaProduto.add(produto);
								}
								encontrado = false;
								
								break;
							case 3: 

								idCategoria += 1;
								System.out.printf("\n\n	Insira o nome da categoria: ");
								nome = ler.next();
								System.out.printf("\n\n	Insira a descricao da categoria: ");
								descricao = ler.next();
								Categoria categoria = new Categoria(idCategoria, nome, descricao);
								listaCategoria.add(categoria);
								
								break;
								
							case 4: 
								int quantidade = 0;
								int escolhaMenuPedidos = 1;
								ArrayList<itemPedido> listaItemPedido = new ArrayList<>();
								boolean encontradoSalvar = false;
								
								do{
									System.out.printf("\n-----------------------------------------");
									System.out.printf("\n(1) Adicionar novos itens no pedido");
									System.out.printf("\n(2) Sair e salvar");
									System.out.printf("\n------------------------------------------\n Numero: ");
									escolhaMenuPedidos = ler.nextInt();
									
									if(escolhaMenuPedidos != 1) {
										if(listaItemPedido.size() > 0) {
											int escolhaSalvar = 1;
											do {
												System.out.printf("\n	Insira o id do cliente: ");
												escolhaId = ler.nextInt();
												for(Cliente c: listaCliente) {
													if(c.getId() == escolhaId) {
														idPedido++;
														listaPedido.add(new Pedido(idPedido, listaCliente.get(listaCliente.indexOf(c)), listaItemPedido));
														encontradoSalvar = true;
														escolhaSalvar = 2;
														escolhaMenuPedidos = 2;
														break;
													}
												}
												if (!encontradoSalvar) {
													System.out.printf("\nCliente NAO encontrado! ");
													System.out.printf("\n(1) Deseja tentar novamente. ");
													System.out.printf("\n(2) Sair sem salvar. ");
													escolhaSalvar = ler.nextInt();
													if (escolhaSalvar != 1) {
														escolhaMenuPedidos = 2;
													}
												}
												encontradoSalvar = false;
											}
											while(escolhaSalvar == 1);
										}
										break;
									}
									else {
										System.out.printf("\nId produto: ");
										escolhaId = ler.nextInt();
										
										for(Produto p: listaProduto) {
											if(p.getId() == escolhaId) {
												System.out.printf("\nQuantidade produto: ");
												quantidade = ler.nextInt();
												idItemPedido++;
												listaItemPedido.add(new itemPedido(idItemPedido, p, quantidade));
												encontrado = true;
												break;
											}
										}
										if (!encontrado) {
										System.out.printf("\n		Produto nao encontrado.");
										}

										encontrado = false;
										
									}
								}
								while(escolhaMenuPedidos == 1);

								break;
							}
							
							break;
						
							//editar
						case 3:
							
							switch (escolhaMenuPrincipal) {
							case 1: 

								System.out.printf("\n	Insira o id do cliente: ");
								escolhaId = ler.nextInt();
								for(Cliente c: listaCliente) {
									if(c.getId() == escolhaId) {
										System.out.printf("\n	Insira o nome do cliente: ");
										nome = ler.next();
										index = listaCliente.indexOf(c);
										Cliente newCliente = listaCliente.get(index);
										newCliente.setNome(nome);
										listaCliente.set(index, newCliente);
										System.out.printf("\n		Cliente Editado.");
										encontrado = true;
										break;
									}
								}
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								encontrado = false;
								break;
								
							case 2: 
								
								System.out.printf("\n	Insira o id do produto: ");
								escolhaId = ler.nextInt();
								boolean categoriaEncontrado = false;
								int categoriaIndex = 0;
								
								for(Produto p: listaProduto) {
									if(p.getId() == escolhaId) {
										
										System.out.printf("\n\n	Insira o nome do produto: ");
										nome = ler.next();
										System.out.printf("\n\n	Insira a descricao do produto: ");
										descricao = ler.next();
										System.out.printf("\n\n	Insira a quantidade em estoque: ");
										estoque = ler.nextInt();
										System.out.printf("\n\n	Insira o preco do produto: ");
										preco = ler.nextFloat();
										System.out.printf("\n\n	Insira a categoria do produto (id da categoria): ");
										escolhaId = ler.nextInt();
										encontrado = true;
										
										for(Categoria c: listaCategoria) {
											if(c.getId() == escolhaId) {
												categoriaEncontrado = true;
												categoriaIndex = listaCategoria.indexOf(c);
												}
											}
										
										if (!categoriaEncontrado) {
											System.out.printf("\n		Categoria nao encontrada.");
											break;
										}
										else {
											index = listaProduto.indexOf(p);
											Produto newProduto = new Produto(listaProduto.get(index).getId(), nome, descricao, estoque, preco, listaCategoria.get(categoriaIndex));
											listaProduto.set(index, newProduto);
											System.out.printf("\n		Produto Editado.");
											break;
										}
									}
								}
								
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
						
								encontrado = false;
																
								break;
							
							case 3: 

								System.out.printf("\n	Insira o id da categoria: ");
								escolhaId = ler.nextInt();
								for(Categoria c: listaCategoria) {
									if(c.getId() == escolhaId) {
										System.out.printf("\n	Insira o nome da categoria: ");
										nome = ler.next();
										System.out.printf("\n	Insira a descricao da categoria: ");
										descricao = ler.next();
										index = listaCategoria.indexOf(c);
										Categoria newCategoria = listaCategoria.get(index);
										newCategoria.setNome(nome);
										newCategoria.setDescricao(descricao);
										listaCategoria.set(index, newCategoria);
										System.out.printf("\n		Categoria Editada.");
										encontrado = true;
										break;
									}
								}
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								encontrado = false;
								
								break;
							case 4: 
								encontrado = false;
								System.out.printf("\n	Insira o id do pedido: ");
								escolhaId = ler.nextInt();
								for(Pedido lp: listaPedido) {
									if(lp.getId() == escolhaId) {
										encontrado = true;
										
										int quantidade = 0;
										int escolhaMenuPedidos = 1;
										ArrayList<itemPedido> listaItemPedido = lp.getListaProdutos();
										boolean encontradoSalvar = false, sair = false;
										
										do{
											System.out.printf("\n-----------------------------------------");
											System.out.printf("\n(1) Adicionar novos itens do pedido");
											System.out.printf("\n(2) Excluir itens do pedido");
											System.out.printf("\n(3) Sair e salvar");
											System.out.printf("\n------------------------------------------\n Numero: ");
											escolhaMenuPedidos = ler.nextInt();
												
											switch(escolhaMenuPedidos) 
											{
											case 1:
												boolean produtoEncontrado = false;
												System.out.printf("%s", lp.exibirPedido());
												System.out.printf("\nId produto: ");
												escolhaId = ler.nextInt();
												
												for(Produto p: listaProduto) {
													if(p.getId() == escolhaId) {
														System.out.printf("\nQuantidade produto: ");
														quantidade = ler.nextInt();
														idItemPedido++;
														listaItemPedido.add(new itemPedido(idItemPedido, listaProduto.get(escolhaId), quantidade));
														produtoEncontrado = true;
														break;
													}
												}
												if (!produtoEncontrado) {
													System.out.printf("\n		Produto nao encontrado.");			
												}
												
												produtoEncontrado = false;
												
												break;
											case 2:
												boolean pedidoEncontrado = false;
												System.out.printf("%s", lp.exibirPedido());
												System.out.printf("\n	Insira o id do item pedido: ");
												escolhaId = ler.nextInt();
												for(itemPedido ip: listaItemPedido) {
													if(ip.getId() == escolhaId) {
														pedidoEncontrado = true;
														listaItemPedido.remove(ip);
														System.out.printf("\n	Deletado com sucesso!");
														break;
													}
												}
												if (!encontrado) {
													System.out.printf("\n		item pedido Nao encontrado.");
												}
												pedidoEncontrado = false;
																							
												break;
											case 3:
												System.out.printf("\n	Salvo com sucesso!");
												if (listaItemPedido.size() == 0) {
													listaPedido.remove(listaPedido.indexOf(lp));
												}
												else {
													lp.setListaProdutos(listaItemPedido);
												}
												sair = true;
												break;
											default:
												sair = true;
												break;
											}
										}
										while(!sair);
										
										break;
									}
								}
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								
								encontrado = false;							
								
								break;
							}
							
							break;
						case 4:
							
							switch (escolhaMenuPrincipal) {
							case 1:
								boolean clienteHasPedidos = false;
								System.out.printf("\n	Insira o id do cliente: ");
								escolhaId = ler.nextInt();
								for(Cliente c: listaCliente) {
									if(c.getId() == escolhaId) {
										encontrado = true;
										for(Pedido p: listaPedido) {
											if(p.getCliente().getId() == escolhaId) {
												System.out.printf("\n	O cliente possui pedidos, exclua-os primeiro para poder excluir o cliente. ");
												clienteHasPedidos = true;
												break;
											}
										}
										
										if (!clienteHasPedidos) {
											listaCliente.remove(c);
											System.out.printf("\n		Cliente Removido.");
											break;
										}
										
									}
								}
								
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								clienteHasPedidos = false;
								encontrado = false;
								break;
							case 2:
								boolean produtoHasPedidos = false;
								encontrado = false;
								System.out.printf("\n	Insira o id do Produto: ");
								escolhaId = ler.nextInt();
								for(Produto p: listaProduto) {
									if(p.getId() == escolhaId) {
										encontrado = true;
										for(Pedido lp: listaPedido) {
											for(itemPedido ip: lp.getListaProdutos()) {
												if(ip.getProduto().getId() == escolhaId) {
													System.out.printf("\n	O Produto possui pedidos, exclua-os primeiro para poder excluir o cliente. ");
													produtoHasPedidos = true;
													break;
												}
											}
											if(produtoHasPedidos) break;
											
										}
										if (!produtoHasPedidos) {
											listaProduto.remove(p);
											System.out.printf("\n		Produto Removido.");
											break;
										}
										break;
									}
								}
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								
								break;
							case 3:
								
								System.out.printf("\n	Insira o id da categoria: ");
								escolhaId = ler.nextInt();
								boolean haCategoriaEmProduto = false;
								for(Categoria c: listaCategoria) {
									if(c.getId() == escolhaId) {
										encontrado = true;
										for(Produto p: listaProduto) {
											if(p.getCategoria().getId() == escolhaId) {
												haCategoriaEmProduto = true;
												break;
											}
										}
										if (!haCategoriaEmProduto) {
											listaCategoria.remove(c);
											System.out.printf("\n	Categoria removida com sucesso! ");
										}
										else {
											System.out.printf("\n	Algum produto possui essa categoria!\n	Edite esse produto ou o exclua. ");
										}
										haCategoriaEmProduto = false;
										break;
									}
								}
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								encontrado = false;
								break;
							case 4: 
								
								encontrado = false;
								System.out.printf("\n	Insira o id do pedido: ");
								escolhaId = ler.nextInt();
								for(Pedido p: listaPedido) {
									if(p.getId() == escolhaId) {
										encontrado = true;
										listaPedido.remove(p);
										System.out.printf("\n	Deletado com sucesso!");
										break;
									}
								}
								if (!encontrado) {
									System.out.printf("\n		Nao encontrado.");
								}
								encontrado = false;
								
								break;
							}
							
							break;
							
						default:
							break;
						}
						
					}
					
					else {break;}
					
				}
				
			}
			
			else {
				break;
			}
			
		}
		
		System.out.printf("\nObrigado por usar esse sistema.\nVolte sempre!");
		
	}

}
