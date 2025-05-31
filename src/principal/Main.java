package principal;

import java.util.Scanner;

import model.MaxHeap;
import model.Task;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MaxHeap heap = new MaxHeap();
		System.out.println("=======================\nConfigurações iniciais\n-----------------------");
		System.out.println("Escolha um modo de visualização do Heap:\n1 - Prioridade\n2 - Descrição\n3 - Ambos");
		System.out.print(": ");
		int modo = sc.nextInt();
		heap.setModoVisualizacao(modo);
		System.out.println("-----------------------");

		while (true) {
			System.out.println("\n=====================");
			System.out.println(
					"1 - Adicionar tarefa\n2 - Concluir tarefa\n3 - Ver próxima\n4 - Ver todas as tarefas\n0 - Sair\n");
			System.out.print(": ");
			int op = sc.nextInt();

			if (op == 1) {
				System.out.print("Descrição: ");
				sc.nextLine();
				String descricao = sc.nextLine();
				System.out.print("Prioridade: ");
				int prioridade = sc.nextInt();
				heap.insert(new Task(descricao, prioridade));

			} else if (op == 2) {
				Task tarefaRemovida = heap.extractMax();
				System.out.println(tarefaRemovida == null ? "\nHeap vazio!"
						: "- Tarefa concluida/removida:\n* " + tarefaRemovida.getDescricao() + ", prioridade="
								+ tarefaRemovida.getPrioridade());

			} else if (op == 3) {
				Task raiz = heap.peek();
				System.out.println(raiz == null ? "\nHeap vazio!"
						: "- Tarefa prioritária:\n* " + raiz.getDescricao() + " (Prioridade: " + raiz.getPrioridade()
								+ ")");

			} else if (op == 4) {
				heap.showHeap();

			} else if (op == 0) {
				System.out.println("\nPrograma finalizado!");
				break;

			} else {
				System.out.println("\nEscolha uma opção válida!");
			}
		}
		sc.close();
	}
}
