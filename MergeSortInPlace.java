import java.util.Arrays;

public class MergeSortInPlace {

	public static void main(String[] args) {

		// testando a ordenação do array
		MergeSortInPlace m = new MergeSortInPlace();

		Integer[] a = { 1, 5, 9, 1, 3, 4, 5, 7, 8, 6, 1, 4, -5, 90, -40, 8 };

		m.sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {

			int middle = (leftIndex + rightIndex - 1) / 2;
			int rightPointer = middle + 1;

			// quebra o array de forma recursiva até que o leftIndex seja maior ou
			// igual ao rightIndex
			sort(array, leftIndex, middle);
			sort(array, rightPointer, rightIndex);

			// junta as duas partes do array
			merge(array, leftIndex, middle, rightPointer, rightIndex);

		}

	}

	public void merge(Integer[] array, int leftPointer, int middle, int rightPointer, int end) {

		if (array[middle].compareTo(array[rightPointer]) > 0) {

			while (middle >= leftPointer && end >= rightPointer) {

				// verifica se o elemento do leftPointer é maior ou igual ao elemento
				// do rightPointer
				if (array[rightPointer] >= array[leftPointer])
					leftPointer++;

				// A ideia aqui é ordenar o trecho entre o leftPointer e o rightPointer
				else {

					int aux = array[rightPointer];
					int i = rightPointer;

					while (i != leftPointer) {
						array[i] = array[i - 1];
						i--;
					}
					array[leftPointer] = aux;

					leftPointer++;
					middle++;
					rightPointer++;

				}

			}

		}

	}

}
