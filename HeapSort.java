import java.util.Scanner;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Heap oluşturma (Rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            System.out.print("Heapify after building heap for i=" + i + ": ");
            printArray(arr);
        }

        // Birer birer eleman çıkarma ve heap'i yeniden düzenleme
        for (int i = n - 1; i > 0; i--) {
            // Mevcut kök (root) ile son elemanı değiştir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            System.out.print("Swapping root with element at index " + i + ": ");
            printArray(arr);

            // Azalan heap'i yeniden düzenle
            heapify(arr, i, 0);
            System.out.print("Heapify after removing element at index " + i + ": ");
            printArray(arr);
        }
    }

    // Alt ağacı heapify eder (index'i 'i' olan alt ağacı, 'n' öğelik bir array)
    void heapify(int arr[], int n, int i) {
        int largest = i; // Kök olarak başlangıç
        int left = 2 * i + 1; // Sol = 2*i + 1
        int right = 2 * i + 2; // Sağ = 2*i + 2

        // Sol çocuğun kökten daha büyük olup olmadığını kontrol et
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Sağ çocuğun kökten daha büyük olup olmadığını kontrol et
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // En büyük kök değilse, değiştir
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Affected subtree'yi heapify et
            heapify(arr, n, largest);
        }
    }

    // Diziyi ekrana yazdır
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Ana metod
    public static void main(String args[]) {
        // try-with-resources yapısı kullanılarak Scanner otomatik olarak kapatılır
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Dizinin uzunluğunu giriniz: ");
            int n = scanner.nextInt();

            int arr[] = new int[n];
            System.out.println("Dizinin elemanlarını giriniz:");

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            HeapSort ob = new HeapSort();
            System.out.println("Başlangıç dizisi:");
            printArray(arr);

            ob.sort(arr);

            System.out.println("Sıralanmış dizi:");
            printArray(arr);
        }
    }
}
