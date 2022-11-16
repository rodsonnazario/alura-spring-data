package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	private Boolean system = true;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de unidade trabalho deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome da unidade");
		String descricao = scanner.next();
		System.out.println("Digite o endereco");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id");
		Integer id = scanner.nextInt();
		System.out.println("Digite o nome da unidade");
		String descricao = scanner.next();
		System.out.println("Digite o endereco");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> unidadeTrabalho = unidadeTrabalhoRepository.findAll();
		unidadeTrabalho.forEach(System.out::println);
	}

	private void deletar(Scanner scanner) {
		System.out.println("Digite o id");
		Integer id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		
		System.out.println("Deletado");
	}
}