package myPackage;
public interface Sorting
{
    void sort(int[] array, boolean asc);
}

class InsertionSort implements Sorting
{

	@Override
	public void sort(int[] array, boolean asc) {
		for (int i = 1; i < array.length; ++i) {
			int key = array[i];
			int j = i - 1;
			if(asc) {
				while (j>=0 && array[j] > key) {
					array[j + 1] = array[j];
					j--;
				}
				array[j+1] = key;
			}
			else {
				while (j>=0 && array[j] < key) {
					array[j + 1] = array[j];
					j--;
				}
				array[j+1] = key;
			}
		}
	}
}

class SelectionSort implements Sorting {

	@Override
	public void sort(int[] array, boolean asc) {
        for (int i = 0; i < array.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < array.length; j++){  
                if (array[j] < array[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = array[index];   
            array[index] = array[i];  
            array[i] = smallerNumber;  
        }  
    }
}

class MergeSort implements Sorting{

	@Override
	public void sort(int[] array, boolean asc) {
		sortMerge(array, 0, array.length - 1);
	}
	void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays 
        int L[] = new int[n1];
        int R[] = new int[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        // Merge the temp arrays 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sortMerge(int arr[], int l, int r){
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
            // Sort first and second halves
            sortMerge(arr, l, m);
            sortMerge(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);  
        }
    }
}

class BubbleSort implements Sorting {
	@Override
	public void sort(int[] array, boolean asc) { 
        for (int i = 0; i < array.length-1; i++) 
            for (int j = 0; j < array.length-i-1; j++) 
                if (array[j] > array[j+1] && asc) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                } 
                else if(array[j] < array[j+1] && !asc){
                	// swap arr[j+1] and arr[j] 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp;
                }
		
	}
	
}