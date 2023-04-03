package Program;

import Model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Service.*;

public class Test {
	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);

			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			ArrayList<Postagem> postagens = new ArrayList<Postagem>();

			Usuario cliente1 = new Cliente("12345678910", "Cliente 1");
			Usuario empresa1 = new Empresa("12345678901234", "Empresa 1", "Empresa 1");
			Postagem postagem1 = new Postagem("Amo muito minha mãezinha!", (Empresa) empresa1);
			((Empresa) empresa1).addPostagem(postagem1);
			usuarios.add(cliente1);
			usuarios.add(empresa1);
			postagens.add(postagem1);

			int opcao = -1;

			do {

				atualizarCalendario(usuarios);

				System.out.println("1 - Cadastrar Usuário");
				System.out.println("2 - Ver usuários");
				System.out.println("3 - Criar Postagem");
				System.out.println("4 - Ver feed");
				System.out.println("6 - Criar Evento");
				System.out.println("7 - Ver Calendário");
				System.out.println("0 - Sair");
				System.out.println("Escolha uma opção:");

				if (scanner.hasNextInt()) {
					opcao = Integer.parseInt(scanner.nextLine());
					System.out.println();

					switch (opcao) {
					case 0:
						System.out.println("Programa finalizado!");
						break;

					case 1:
						usuarios.add(cadastrarUsuario(scanner));
						break;

					case 2:
						verUsuarios(usuarios);

						break;

					case 3:
						postagens.add(criarPostagem(scanner, usuarios));
						break;

					case 4:
						verPostagens(scanner, postagens, usuarios);
						break;

					case 5:
						seguirEmpresa(scanner, usuarios);
						break;

					case 6:
						criarEvento(scanner, usuarios);
						break;

					case 7:
						verCalendario(scanner, usuarios);
						break;

					default:
						System.out.println("Opção inválida!\n");
					}
				} else {
					System.out.println("Entrada inválida. Digite um número inteiro.");
				}
				scanner.nextLine();
			} while (opcao != 0);

			System.out.println("Programa finalizado!");
			scanner.close();

		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static void seguirEmpresa(Scanner scanner, ArrayList<Usuario> usuarios) {

		try {
			Cliente cliente = (Cliente) escolherUsuario(scanner, usuarios);
			ArrayList<Empresa> empresas = new ArrayList<Empresa>();

			for (Usuario usuario : usuarios) {
				int i = 0;
				if (usuario instanceof Empresa) {
					System.out.println(++i + " - " + usuario.getNome());
					empresas.add((Empresa) usuario);
				}
			}
			System.out.println("Escolha uma empresa p/ seguir: ");
			int opcao = Integer.parseInt(scanner.nextLine());

			Empresa empresa = empresas.get(opcao - 1);

			cliente.addEmpresaInteresse(empresa);
			// empresa.addClienteInteresse(cliente);
		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static void atualizarCalendario(ArrayList<Usuario> usuarios) {

		try {
			for (Usuario usuario : usuarios) {
				if (usuario instanceof Cliente) {
					Calendario calendarioCliente = usuario.getCalendario();
					ArrayList<Evento> eventosCliente = calendarioCliente.getEvento();
					ArrayList<Empresa> empresas = ((Cliente) usuario).getEmpresaInteresse();
					for (Empresa empresa : empresas) {
						Calendario calendarioEmpresa = empresa.getCalendario();
						ArrayList<Evento> eventosEmpresa = calendarioEmpresa.getEvento();
						for (Evento eventoE : eventosEmpresa) {
							for (Evento eventoC : eventosCliente) {
								if (!(eventoE.equals(eventoC))) {
									calendarioCliente.addEvento(eventoE);
								}
							}
						}
					}
				}
			}

		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static void verCalendario(Scanner scanner, ArrayList<Usuario> usuarios) {

		try {
			Usuario usuario = escolherUsuario(scanner, usuarios);

			// Metodo de consultarCalendario
			usuario.consultarCalendario();
			// ...
		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static void criarEvento(Scanner scanner, ArrayList<Usuario> usuarios) {

		try {
			Usuario usuario = escolherUsuario(scanner, usuarios);
			if (usuario instanceof Empresa) {

				System.out.println("Qual o evento?");
				String nome = scanner.nextLine();
				System.out.println("Qual a data? (dd-mm-aaaa)");
				String dataString = scanner.nextLine();
				String[] dataArray = dataString.split("-");

				LocalDate data = LocalDate.of(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[1]),
						Integer.parseInt(dataArray[0]));

				Evento evento = new Evento(nome, data);

				Calendario calendario = usuario.getCalendario();
				calendario.addEvento(evento);
			} else {
				System.out.println("Usuário não tem permissão para visualizar/curtir postagem.");
				System.out.println();
			}

		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static void verUsuarios(ArrayList<Usuario> usuarios) {

		try {
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getNome());
			}

		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static void verPostagens(Scanner scanner, ArrayList<Postagem> postagens, ArrayList<Usuario> usuarios) {

		try {
			Usuario usuario = escolherUsuario(scanner, usuarios);
			if (usuario instanceof Cliente) {
				for (Postagem postagem : postagens) {
					int i = postagens.indexOf(postagem);
					System.out.println((i + 1) + " - " + postagem.getEmpresa().getNome());
					System.out.println(postagem.getTextPub());
					System.out.println("Curtidas: " + postagem.getCurtidas().size());
					System.out.println();
				}
				System.out.println();
				System.out.println("Selecione uma postagem para curtir: ");
				int opcao = Integer.parseInt(scanner.nextLine());
				System.out.println();

				Postagem postagem = postagens.get(opcao - 1);
				Curtida curtida = new Curtida(postagem, (Cliente) usuario);

				int index = postagens.indexOf(curtida);

				if (postagens.contains(curtida)) {
					postagens.remove(index);
				} else {
					postagem.addCurtida(curtida);
				}
			} else {
				((Empresa) usuario).mostrarFeed();
			}

		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
		}
	}

	private static Postagem criarPostagem(Scanner scanner, ArrayList<Usuario> usuarios) {

		try {
			Usuario usuario = escolherUsuario(scanner, usuarios);
			String texto;
			if (usuario instanceof Empresa) {
				System.out.println("Escolheu o usuário " + usuario.getNome());
				System.out.println();
				System.out.println("O que deseja publicar?");
				texto = scanner.nextLine();
				Postagem postagem = new Postagem(texto, (Empresa) usuario);
				((Empresa) usuario).addPostagem(postagem);
				return postagem;
			} else {
				System.out.println("Usuário não tem permissão para postar.");
				System.out.println();
				return null;
			}
		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
			return null;
		}

	}

	private static Usuario escolherUsuario(Scanner scanner, ArrayList<Usuario> usuarios) {

		try {
			System.out.println("Escolha um usuário: ");
			for (Usuario usuario : usuarios) {
				int i = usuarios.indexOf(usuario);
				System.out.println((i + 1) + " - " + usuario.getNome());
			}
			System.out.println();
			System.out.println("Qual usuário deseja utilizar?");
			int opcao = Integer.parseInt(scanner.nextLine());
			System.out.println();

			Usuario res = usuarios.get(opcao - 1);
			return res;

		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
			return null;
		}
	}

	private static Usuario cadastrarUsuario(Scanner scanner) {
		try {
			int opcao;

			System.out.println("1 - Cliente");
			System.out.println("2 - Empresa");
			System.out.println("Escolha o tipo de Usuário:");

			opcao = Integer.parseInt(scanner.nextLine());
			System.out.println();
			String nome;
			Usuario usuario = new Usuario();

			switch (opcao) {
			case 1:
				String cpf;
				System.out.println("Digite o CPF: ");
				cpf = scanner.nextLine();
				System.out.println("Digite o Nome: ");
				nome = scanner.nextLine();
				usuario = new Cliente(cpf, nome);

				break;

			case 2:
				String cnpj, razaoSocial;
				System.out.println("Digite o CNPJ: ");
				cnpj = scanner.nextLine();

				try {
					CNPJ_Service cnpj_Service = new CNPJ_Service();

					testAPI testapi = cnpj_Service.getStatusCNPJ(cnpj);

					razaoSocial = (testapi.getRAZAO_SOCIAL());
					nome = (testapi.getNome());

					Empresa empresa = new Empresa(cnpj, nome, razaoSocial);

					
					//Verificando se o CNPJ é ativo!
					if (empresa.verStatus().equals("ATIVA")) {

						usuario = new Empresa(cnpj, nome, razaoSocial);

					} else {

						System.out.println("Empresa Inativa!");

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Opção inválida!");
				System.out.println();
			}

			return usuario;
		}

		catch (Exception e) {
			System.out.println("Aconteceu um erro inesperado!");
			return null;
		}

	}
}