class Sorts {

  // bubble sort (Source: https://www.geeksforgeeks.org/bubble-sort/)
  public static void bubbleSort(int[] A) {
    int x = A.length;
    for (int i = 0; i < x - 1; i++)
      for (int j = 0; j < x - i - 1; j++)
        if (A[j] > A[j + 1]) {
          int temp = A[j];
          A[j] = A[j + 1];
          A[j + 1] = temp;
        }
  } // bubbleSort()

  // selection sort (Source: https://www.geeksforgeeks.org/selection-sort/)
  public static void selectionSort(int[] A) {
    int n = A.length;
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++)
        if (A[j] < A[min_idx])
          min_idx = j;
      int temp = A[min_idx];
      A[min_idx] = A[i];
      A[i] = temp;
    }
  }// selectionSort()

  // insertion sort (Source: https://www.geeksforgeeks.org/insertion-sort/)
  public static void insertionSort(int[] A) {
    int n = A.length;
    for (int i = 1; i < n; ++i) {
      int key = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > key) {
        A[j + 1] = A[j];
        j = j - 1;
      }
      A[j + 1] = key;
    }
  }// insertionSort()

  // mergeSort - front-end for kick-starting the recursive algorithm
  public static void mergeSort(int[] A) {
    int leftIdx = 0;
    int rightIdx = A.length - 1;
    mergeSortRecurse(A, leftIdx, rightIdx);
  }// mergeSort()

  private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) {
    if (leftIdx < rightIdx) {
      int midIdx = (leftIdx + rightIdx) / 2;
      mergeSortRecurse(A, leftIdx, midIdx);
      mergeSortRecurse(A, midIdx + 1, rightIdx);
      merge(A, leftIdx, midIdx, rightIdx);
    }
  }// mergeSortRecurse()

  private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) {
    int n = (rightIdx - leftIdx) + 1;
    int[] tempArr = new int[n];
    int ii = leftIdx;
    int jj = midIdx + 1;
    int kk = 0;
    while ((ii <= midIdx) && (jj <= rightIdx)) {
      if (A[ii] <= A[jj]) {
        tempArr[kk] = A[ii];
        ii++;
      } else {
        tempArr[kk] = A[jj];
        jj++;
      }
      kk++;
    }

    for (int i = ii; i < midIdx + 1; i++) {
      tempArr[kk] = A[i];
      kk++;
    }

    for (int j = jj; j < rightIdx + 1; j++) {
      tempArr[kk] = A[j];
      kk++;
    }

    for (int k = leftIdx; k < rightIdx + 1; k++) {
      A[k] = tempArr[k - leftIdx];
      kk++;
    }
  }// merge()

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSortL(int[] A) {
    int leftIdx = 0;
    int rightIdx = A.length - 1;
    quickSortRecurseL(A, leftIdx, rightIdx);
  }// quickSortL()

  private static void quickSortRecurseL(int[] A, int leftIdx, int rightIdx) {
    if (rightIdx > leftIdx) {
      int pivotIdx = leftIdx;
      int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
      quickSortRecurseL(A, leftIdx, newPivotIdx - 1);
      quickSortRecurseL(A, newPivotIdx + 1, rightIdx);
    }
  }// quickSortRecurseL()

  private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx) {
    int pivotVal = A[pivotIdx];
    A[pivotIdx] = A[rightIdx];
    A[rightIdx] = pivotVal;

    int currIdx = leftIdx;

    for (int i = leftIdx; i < rightIdx; i++) {
      if (A[i] < pivotVal) {
        int temp = A[i];
        A[i] = A[currIdx];
        A[currIdx] = temp;
        currIdx = currIdx + 1;
      }
    }

    int newPivIdx = currIdx;
    A[rightIdx] = A[newPivIdx];
    A[newPivIdx] = pivotVal;

    return newPivIdx;
  }// doPartitioning

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSortM3(int[] A) {
    int leftIdx = 0;
    int rightIdx = A.length - 1;
    quickSortRecurseM3(A, leftIdx, rightIdx);
  }// quickSortM3()

  private static void quickSortRecurseM3(int[] A, int leftIdx, int rightIdx) {
    if (rightIdx > leftIdx) {
      int pivotIdx = (leftIdx + rightIdx) / 2;
      int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
      quickSortRecurseM3(A, leftIdx, newPivotIdx - 1);
      quickSortRecurseM3(A, newPivotIdx + 1, rightIdx);
    }
  }// quickSortRecurseM3()

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSortR(int[] A) {
    int leftIdx = 0;
    int rightIdx = A.length - 1;
    quickSortRecurseR(A, leftIdx, rightIdx);
  }// quickSortM3()

  private static void quickSortRecurseR(int[] A, int leftIdx, int rightIdx) {
    if (rightIdx > leftIdx) {
      int pivotIdx = leftIdx + (int) (Math.random() * ((rightIdx - leftIdx) + 1));
      int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
      quickSortRecurseM3(A, leftIdx, newPivotIdx - 1);
      quickSortRecurseM3(A, newPivotIdx + 1, rightIdx);
    }
  }// quickSortRecurseM3()

}// end Sorts calss
