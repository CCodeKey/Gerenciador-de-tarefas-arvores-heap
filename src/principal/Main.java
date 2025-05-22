package principal;

import model.MaxHeap;
import model.Task;

public class Main {
	public static void main(String[] args) {
		MaxHeap max = new MaxHeap();
		
		Task tarefa1 = new Task("Ler um livro", 2);
		Task tarefa2 = new Task("Jogar videogame", 4);
		Task tarefa3 = new Task("Dentista", 5);
		Task tarefa4 = new Task("Compras", 2);
		Task tarefa5 = new Task("Ir ao Shopping", 3);

		max.insert(tarefa1);

		max.visualizarHeap();
		System.out.println();

		max.insert(tarefa2);

		max.visualizarHeap();
		System.out.println();

		max.insert(tarefa3);

		max.visualizarHeap();
		System.out.println();

		max.insert(tarefa4);

		max.visualizarHeap();

		System.out.println();
		max.insert(tarefa5);

		max.visualizarHeap();

		System.out.println();
		
//		System.out.println(max.peek());
	}

}
